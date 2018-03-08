package br.com.dxc.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.stream.IntStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.dxc.constant.AlgoritmoCriptografia;
import br.com.dxc.exception.ApplicationBusinessExceptionCode;
import br.com.dxc.exception.ApplicationValidatorException;

/**
 * Classe respons�vel em travalhar com Arquivos.
 * 
 * @author Helder Pereira Barb�s
 */
public class FileUtil {

	private static Logger logger = LoggerFactory.getLogger(FileUtil.class);

	/**
	 * Respons�vel em retornar a lista de diret�rio que contem em uma pasta.<br>
	 * 
	 * @param diretorioRaiz
	 *            Caminho inicial do diret�rio
	 * @return Lista de Diretorio. Retorna null caso n�o seja encontrada nenhum
	 *         arquivo
	 */
	public static File[] ListarDiretorios(String diretorioRaiz) {

		java.io.File diretorio = new java.io.File(diretorioRaiz);

		File[] arquivos = diretorio.listFiles(new java.io.FileFilter() {
			public boolean accept(File dir) {
				return dir.isDirectory(); // porque somente s�o desejados
				// diret�rios , e n�o arquivos
			}
		});

		return arquivos;
	}

	/**
	 * Respons�vel em retornar a lista de arquivos que contem em uma pasta. N�o
	 * lista os arquivos ocultos.
	 * 
	 * @param diretorioRaiz
	 *            Caminho inicial do diret�rio
	 * @return Lista de Arquivos. Retorna null caso n�o seja encontrada nenhum
	 *         arquivo.
	 */
	public static File[] ListarArquivos(String diretorioRaiz) {

		java.io.File diretorio = new java.io.File(diretorioRaiz);

		File[] arquivos = diretorio.listFiles(new java.io.FileFilter() {
			public boolean accept(File file) {
				return file.isFile() && !file.isHidden(); // porque somente
				// s�o desejados
				// arquivos, e n�o
				// diret�rios
			}
		});

		return arquivos;
	}

	/**
	 * Respons�vel em retornar a lista de arquivos que contem em uma pasta. N�o
	 * lista os arquivos ocultos.
	 * 
	 * @param diretorioRaiz
	 *            Caminho inicial do diret�rio
	 * @param extensao
	 *            extens�o do arquivo. N�o precisa colocar o .
	 * @return Lista de Diretorio. Retorna null caso n�o seja encontrada nenhum
	 *         arquivo.
	 */
	public static File[] ListarArquivos(String diretorioRaiz, String extensao) {

		java.io.File diretorio = new java.io.File(diretorioRaiz);

		File[] arquivos = diretorio.listFiles(new FileFilter(extensao));

		return arquivos;
	}

	/**
	 * Esse m�todo � utilizado para pegar o conte�do de um arquivo.
	 * 
	 * @param nomeArquivoCompleto
	 * @return conte�do do arquivo.
	 * @throws IOException
	 */
	public static String resgatarDadosArquivo(String nomeArquivoCompleto) throws IOException {

		RandomAccessFile file = new RandomAccessFile(new File(nomeArquivoCompleto), "r");

		StringBuilder dadosArquivo = new StringBuilder();
		String linhaArquivo = null;
		while ((linhaArquivo = file.readLine()) != null) {
			dadosArquivo.append(linhaArquivo);
		}

		file.close();

		return dadosArquivo.toString();
	}

	public static void ziparArrayDeArquivos(String arquivoZIP, File[] ArrayDeArquivos)
			throws FileNotFoundException, IOException {

		byte[] buf = new byte[1024];

		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(arquivoZIP));

		IntStream.range(0, ArrayDeArquivos.length).forEach(arquivo -> {
			try {
				FileInputStream in = new FileInputStream(ArrayDeArquivos[arquivo]);
				// gerar uma entrada sem pastas, utiliza apenas o nome do arquivo,
				// semo caminho completo
				out.putNextEntry(new ZipEntry(ArrayDeArquivos[arquivo].getName()));
	
				int len;
	
				while ((len = in.read(buf)) > 0) {
						out.write(buf, 0, len);
				}
				out.closeEntry();
				in.close();
			} catch (IOException e) {
				logger.error("CRESOL_ERROR_FILE_UTIL:", e);
				throw new ApplicationValidatorException(ApplicationBusinessExceptionCode.CRESOL_ERROR_FILE_UTIL, e);
			}
		});

		out.close();
	}

	/**
	 * M�todo respons�vel em calcular o hash de um determinado arquivo. Esse calculo
	 * � feito baseado no tipo de algoritmo passado por parametro.
	 * 
	 * @param nomeCompletoArquivo
	 * @param algoritmo
	 * @return
	 * @throws ApplicationValidatorException
	 * @throws NoSuchAlgorithmException
	 * @throws IOException
	 */
	public static String calcularHashArquivo(String nomeCompletoArquivo, AlgoritmoCriptografia algoritmo)
			throws ApplicationValidatorException {

		try {
			MessageDigest sha = MessageDigest.getInstance(algoritmo.getTipoCriptografia());

			FileInputStream fis = new FileInputStream(new File(nomeCompletoArquivo));

			byte[] dataBytes = new byte[1024];

			int nread = 0;
			while ((nread = fis.read(dataBytes)) != -1) {
				sha.update(dataBytes, 0, nread);
			}
			;

			byte[] b = sha.digest();

			StringBuffer sb = new StringBuffer();

			IntStream.range(0, b.length).forEach(i -> {
				sb.append(Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1));
			});

			fis.close();

			return sb.toString();
		} catch (Exception e) {
			logger.error("CRESOL_ERROR_FILE_UTIL:", e);
			throw new ApplicationValidatorException(ApplicationBusinessExceptionCode.CRESOL_ERROR_FILE_UTIL, e);
		}
	}

	/**
	 * M�todo respons�vel em retornar os bytes de um determinado arquivo.
	 * 
	 * @param nomeCompletoArquivo
	 * @return
	 * @throws IOException
	 */
	public static byte[] getBytesFile(String nomeCompletoArquivo) throws ApplicationValidatorException {

		try {
			FileInputStream fis = new FileInputStream(new File(nomeCompletoArquivo));

			return IOUtils.toByteArray(fis);
		} catch (IOException e) {
			logger.error("CRESOL_ERROR_FILE_UTIL:", e);
			throw new ApplicationValidatorException(ApplicationBusinessExceptionCode.CRESOL_ERROR_FILE_UTIL, e);
		}
	}

	/**
	 * Copia o conteudo do arquivo origem gerando um novo arquivo com o nome e pasta
	 * do arquivo destino.
	 * 
	 * @param arquivoOrigem
	 * @param arquivoDestino
	 * @throws ApplicationValidatorException
	 */
	public static void copiarArquivo(File arquivoOrigem, File arquivoDestino) throws ApplicationValidatorException {
		try {
			if (arquivoDestino.exists()) {
				arquivoDestino.delete();
			}

			FileChannel sourceChannel = null;
			FileChannel destinationChannel = null;

			try {
				sourceChannel = new FileInputStream(arquivoOrigem).getChannel();
				destinationChannel = new FileOutputStream(arquivoDestino).getChannel();
				sourceChannel.transferTo(0, sourceChannel.size(), destinationChannel);
			} finally {
				if (sourceChannel != null && sourceChannel.isOpen()) {
					sourceChannel.close();
				}
				if (destinationChannel != null && destinationChannel.isOpen()) {
					destinationChannel.close();
				}
			}
		} catch (IOException e) {
			logger.error("CRESOL_ERROR_FILE_UTIL:", e);
			throw new ApplicationValidatorException(ApplicationBusinessExceptionCode.CRESOL_ERROR_FILE_UTIL, e);
		}
	}
}

/**
 * Classe para Filtro de arquivo
 * 
 */
class FileFilter implements java.io.FileFilter {

	private String extension;

	public FileFilter(String extension) {
		this.extension = extension.toLowerCase();
	}

	public boolean accept(File file) {

		boolean ok = true;

		if (!StringUtils.isBlank(extension)) {
			return ok &= file.getName().toLowerCase().endsWith("." + extension);
		}

		return file.isFile() && !file.isHidden();
	}

	/**
	 * Respons�vel em retornar a lista de relatorios contidos em uma pasta. N�o
	 * lista os arquivos ocultos.
	 * 
	 * @param diretorioRaiz
	 *            Caminho inicial do diret�rio
	 * @param extensao
	 *            extens�o do arquivo. N�o precisa colocar o .
	 * @return Lista de Diretorio. Retorna null caso n�o seja encontrada nenhum
	 *         arquivo.
	 */
	public static File[] ListarArquivosRelatorios(String diretorioRaiz) {

		java.io.File diretorio = new java.io.File(diretorioRaiz);

		File[] arquivos = diretorio.listFiles();

		return arquivos;
	}
}