package br.com.dxc.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;

import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Classe respons�vel em criar um arquivo xls.
 * 
 * Esta planilha pode ter quantas abas e quantos campos forem necess�rios.
 * 
 * @author Lucas Rocha.
 */
public class XlsUtil {

	private static Logger log = LoggerFactory.getLogger(XlsUtil.class);

	private List<XlsBean> listDados;

	private String nomeArquivoXls;

	public static final String EXTENSAO = ".xls";

	//TODO ver o caminho com o Evandro, antes era pego do AppConfig.getCaminhoTemplates()
	public static final String CAMINHO_TEMPLATES = "caminho/template";

	private Workbook workbook;

	private String nomeAquivoSalvo;

	private boolean escreverDadosPlanilha;

	/**
	 * Método construtor de um arquivo xls. Os campos dentro da lista de dados que é
	 * recebida no construtor devem estar na mesma ordem que vão ser apresentados na
	 * planilha. Se a planilha contiver mais de uma aba, é necessário incluir esta
	 * sub lista na mesma ordem que devem ser apresentados na nova aba. Esta sub
	 * lista deve ser adicionada na mesma ordem das abas.
	 * 
	 * @param listDados
	 * @param nomeArquivo
	 *            nome do arquivo com o layout da planilha.
	 * @param nomeArquivoSalvo
	 *            nome que o arquivo deve ser salvo.
	 * @throws Exception
	 */
	public XlsUtil(List<XlsBean> listDados, String nomeArquivo, String nomeArquivoSalvo) throws Exception {
		this.listDados = listDados;
		this.nomeArquivoXls = nomeArquivo;
		this.nomeAquivoSalvo = nomeArquivoSalvo;
		this.escreverDadosPlanilha = true;
		this.geraArquivo();
	}

	/**
	 * Método construtor de um arquivo xls. Os campos dentro da lista de dados que é
	 * recebida no construtor devem estar na mesma ordem que vão ser apresentados na
	 * planilha. Se a planilha contiver mais de uma aba, é necessário incluir esta
	 * sub lista na mesma ordem que devem ser apresentados na nova aba. Esta sub
	 * lista deve ser adicionada na mesma ordem das abas.
	 * 
	 * @param listDados
	 * @param nomeArquivo
	 *            nome do arquivo com o layout da planilha.
	 * @param nomeArquivoSalvo
	 *            nome que o arquivo deve ser salvo.
	 * @param escreverDadosPlanilha
	 * @throws Exception
	 */
	public XlsUtil(List<XlsBean> listDados, String nomeArquivo, String nomeArquivoSalvo, boolean escreverDadosPlanilha)
			throws Exception {
		this.listDados = listDados;
		this.nomeArquivoXls = nomeArquivo;
		this.nomeAquivoSalvo = nomeArquivoSalvo;
		this.escreverDadosPlanilha = escreverDadosPlanilha;
		this.geraArquivo();
	}

	/**
	 * M�todo respons�vel por gerar o arquivo.
	 * 
	 * @throws Exception
	 */
	private void geraArquivo() throws Exception {

		this.abreArquivo();

		if (escreverDadosPlanilha) {
			this.escreveDadosPlanilha();
		}

		FileOutputStream fileOut = new FileOutputStream(nomeAquivoSalvo + EXTENSAO);

		this.workbook.write(fileOut);

		fileOut.close();

		log.debug("Planilha salva. ");
	}

	/**
	 * M�todo respons�vel em abrir o arquivo.
	 * 
	 * @throws Exception
	 */
	private void abreArquivo() throws Exception {

		// Abrir o arquivo XLS
		InputStream inp;

		try {
			inp = new FileInputStream(CAMINHO_TEMPLATES + this.nomeArquivoXls + EXTENSAO);
			this.workbook = WorkbookFactory.create(inp);
			log.debug("Planilha encontrada e aberta ");
		} catch (Exception e) {
			log.error("ERRO_COLMEIA_INESPERADO: ", e);
			throw e;
		}
	}

	/**
	 * M�todo respons�vel em escrever dados na planilha e validar se a mesma tem
	 * mais de uma aba ou n�o.
	 */
	private void escreveDadosPlanilha() {

		log.debug("Abrindo a planilha Plan1. ");

		List<XlsBean> listSheet = new ArrayList<XlsBean>(this.workbook.getNumberOfSheets());

		listDados.stream().forEach(beanXls -> {
			// se o objeto for uma lista para as demais abas do arquivo xls.
			if (beanXls.getDado() instanceof Collection) {
				listSheet.add(beanXls);
			} else {
				this.alterarCelulaComValor(this.workbook.getSheetAt(0), beanXls);
			}
		});

		int numeroSheets = this.workbook.getNumberOfSheets();
		// se o arquivo tiver mais de uma aba, escreve os dados na respectiva
		// aba.
		if (numeroSheets > 1) {
			IntStream.range(1, numeroSheets).forEach(contSheet -> {
				log.debug("Abrindo aba:" + (contSheet + 1));

				XlsBean beanXls = listSheet.get(contSheet - 1);
				List<XlsBean> listXlsBean = (List<XlsBean>) beanXls.getDado();

				listXlsBean.stream().forEach(campoPlanilha -> {
					this.alterarCelulaComValor(this.workbook.getSheetAt(contSheet), campoPlanilha);
				});
			});
		}
	}

	/**
	 * Escreve o dado na linha respectiva do arquivo e formata a coluna de acordo
	 * com o tipo do campo.
	 * 
	 * @param planilha,
	 *            aba que esta sendo manipulada.
	 * 
	 * @param indiceLinha,
	 *            indice da linha que esta recebendo o valor.
	 * 
	 * @param beanXls
	 *            objeto contendo o dado a ser inserido na planilha e o
	 *            celula(coluna) que o mesmo deve ser inserido.
	 * 
	 */
	private void alterarCelulaComValor(Sheet planilha, XlsBean beanXls) {
		log.debug("Alterando linha da planilha, " + beanXls.getLinhaArquivo());

		Row safraIni = planilha.getRow(beanXls.getLinhaArquivo() - 1);

		if (safraIni == null) {
			planilha.createRow(beanXls.getLinhaArquivo() - 1);
			safraIni = planilha.getRow(beanXls.getLinhaArquivo() - 1);
		}

		Cell celula = safraIni.getCell(beanXls.getCelulaArquivo());

		if (celula == null) {
			celula = safraIni.createCell(beanXls.getCelulaArquivo());
		}

		if (beanXls.getDado() instanceof String) {
			celula.setCellType(Cell.CELL_TYPE_STRING);
			celula.setCellValue(new HSSFRichTextString((String) beanXls.getDado()));
		} else if (beanXls.getDado() instanceof Integer) {
			Integer dadoValor = (Integer) beanXls.getDado();
			celula.setCellType(Cell.CELL_TYPE_NUMERIC);

			if (dadoValor == null) {
				celula.setCellValue(0);
			} else {
				celula.setCellValue(Double.parseDouble(dadoValor.toString()));
			}
		} else if (beanXls.getDado() instanceof BigInteger) {
			BigInteger dadoValor = (BigInteger) beanXls.getDado();
			celula.setCellType(Cell.CELL_TYPE_NUMERIC);

			if (dadoValor == null) {
				celula.setCellValue(0);
			} else {
				celula.setCellValue(Double.parseDouble(dadoValor.toString()));
			}
		} else if (beanXls.getDado() instanceof Date) {
			Date dadoValor = (Date) beanXls.getDado();
			celula.setCellType(Cell.CELL_TYPE_STRING);

			if (dadoValor == null) {
				celula.setCellValue(0);
			} else {
				celula.setCellValue(dadoValor);
			}
		} else if (beanXls.getDado() instanceof BigDecimal) {
			BigDecimal dadoValor = (BigDecimal) beanXls.getDado();
			celula.setCellType(Cell.CELL_TYPE_NUMERIC);

			if (dadoValor == null) {
				celula.setCellValue(0);
			} else {
				celula.setCellValue(new Double(dadoValor.toString()));
			}
		} else {
			if (beanXls.getDado() == null) {
				return;
			}
			celula.setCellValue(beanXls.getDado().toString());
		}
	}
}