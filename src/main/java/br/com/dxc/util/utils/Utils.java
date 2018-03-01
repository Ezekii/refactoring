package br.com.dxc.util.utils;

import java.math.BigDecimal;
import java.sql.Time;
import java.text.DecimalFormat;
import java.text.Normalizer;
import java.text.NumberFormat;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import br.com.caelum.stella.validation.CNPJValidator;
import br.com.caelum.stella.validation.CPFValidator;

public class Utils {

	public static final char ESPACO = ' ';

	public static final char ZERO = '0';

	private static final String[] listaCodigosFormatacao = new String[] { "\\r\\n", "\\n", "\\r", "\\t" };

	private static final String[] listaCaracteresEspeciais = new String[] { "&", "¨", "´", "¸", "\"", "«", "»", "º",
			"ª", "­­­­­¯", "\\|", ">", "<", "-", "÷", "/", "%", "}", "]", "=", "\\$", "\\$", "#", "@", "!", ",", ";",
			":", "\\.", "\\{", "\\[", "\\(", "\\)", "\\+", "\\?", "\\*", "_", "'", "°" };

	private static Logger log = LoggerFactory.getLogger(Utils.class);

	private static String MASK_NUMERO_COM_SINAL = "[[^-*0-9]]";

	/**
	 * Responsável em tratar conversão de String para Integer. Quando a String for
	 * em branco será retornado null.
	 * 
	 * @param valor
	 * @return valor
	 */
	public static Integer stringParaInteger(String valor) {
		return StringUtils.isEmpty(valor) ? null : new Integer(valor);
	}

	/**
	 * Responsável em tratar conversão de Integer para String. Quando o Integer for
	 * null será retornado "".
	 * 
	 * @param valor
	 * @return valor
	 */
	public static String integerParaString(Integer valor) {
		return (valor == null) ? "" : valor.toString();
	}

	/**
	 * 
	 * 
	 * Método responsável em receber uma String no formato 555,00 e converter para
	 * double;
	 * 
	 * @param valor
	 * @return valor
	 */
	public static BigDecimal realParaBigDecimal(String valor) {
		return Utils.realParaBigDecimal(valor, 2);
	}

	/**
	 * Método responsável em receber uma String no formato 555,00 e converter para
	 * double;
	 * 
	 * @param valor
	 *            Valor
	 * @param scale
	 *            Quantidade de casas decimais
	 * @return valor
	 */
	public static BigDecimal realParaBigDecimal(String valor, int scale) {
		try {
			// Não foi fetio com NumberFormat pois não suporta valores
			// 99.999.999.999.999,999999
			if (StringUtils.isEmpty(valor)) {
				NumberFormat format = DecimalFormat.getInstance(Locale.getDefault());
				char separadorDecimal = ((DecimalFormat) format).getDecimalFormatSymbols().getDecimalSeparator();
				char separadorGrupo = ((DecimalFormat) format).getDecimalFormatSymbols().getGroupingSeparator();

				String tmp1 = valor.replaceAll("\\" + separadorGrupo, "");
				tmp1 = tmp1.replaceAll("\\" + separadorDecimal, "\\.");
				BigDecimal bd = new BigDecimal(tmp1);

				return bd.setScale(scale, BigDecimal.ROUND_HALF_DOWN);
			}
		} catch (NumberFormatException e) {
			// FS#11554 - A exceção não está sendo logada, para evitar a
			// poluição do log
			log.warn("Não foi possivel converter de real para bigdecimal: " + valor);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Método responsável em receber um Double e colocar no formato 999.999,99
	 * 
	 * @param valor
	 * @param casaDecimal
	 * @return valor valor
	 */
	public static String bigDecimalParaReal(BigDecimal valor, int casaDecimal) {

		if (valor == null) {
			return "";
		}

		NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		return numberFormat.format(valor.setScale(casaDecimal));
	}

	/**
	 * Metodo responsavel em remover os zeros a esquerda de uma string.
	 * 
	 * @param valor
	 * @return
	 */
	public static String removeZerosEsquerda(String valor) {
		if (valor != null) {
			valor = valor.replaceFirst("^0+(?!$)", "");
		}
		return valor;
	}

	/**
	 * Método responsável em receber um Double e colocar no formato 999,999.99
	 * 
	 * Caso específico com separação com . (ponto). Utiliza formatação própria.
	 * 
	 * @param valor
	 * @return valor
	 */
	public static String doubleParaPercentagem(double valor) {

		NumberFormat nf = NumberFormat.getNumberInstance(new Locale("en", "US"));

		DecimalFormat df = (DecimalFormat) nf;
		df.applyPattern("###,##0.00");

		return df.format(valor);

	}

	/**
	 * Remove os valores não númericos do parâmetro informado e retorna apenas os
	 * números do valor.
	 * 
	 * @param valor
	 * @return valor
	 */
	public static String removeFormatacaoNumero(String valor) {
		return valor.replaceAll("\\D", "");
	}

	/**
	 * Remove os valores não númericos do parâmetro com DV e retorna apenas os
	 * números do valor sem o DV.
	 * 
	 * @param numeroContaComDV
	 * @return Long
	 */
	public static Long removeFormatacaoNumeroContaCorrente(String numeroContaComDV) {
		// deve remover a formatacao ja sem o dv devido a possibilidade do dv
		// ser uma string. Exemplo DV(X). Pode receber como parametro somente o
		// dv sendo necessario validar o campo apos remocao do mesmo
		String numeroContaSemDV = StringUtils.isEmpty(numeroContaComDV) ? null
				: removeFormatacaoNumero(numeroContaComDV.substring(0, numeroContaComDV.length() - 1));

		// retorna ja convertido para long para evitar excessao de conversao de
		// tipos
		return StringUtils.isEmpty(numeroContaSemDV) ? null : Long.parseLong(numeroContaSemDV);
	}

	/**
	 * Completa com espaços a direita.
	 * 
	 * @param tamanhoTotal
	 * @param campo
	 * @return String formatada
	 */
	public static String completaEspacosDireita(int tamanhoTotal, String campo) {
		return completaCharDireita(tamanhoTotal, campo, ESPACO);
	}

	/**
	 * Completa com o caracter informado a direita e a esquerda até centralizar o
	 * texto.
	 * 
	 * @param tamanhoTotal
	 *            Tamanho total do texto
	 * @param campo
	 *            valor
	 * @param caracter
	 *            caracter a ser completado
	 * @return String formatada
	 */
	public static String completaCharCentralizar(int tamanhoTotal, String campo, char caracter) {

		StringBuffer sb = new StringBuffer(campo);

		int iFim = ((tamanhoTotal - campo.length()) / 2);

		for (int i = 0; i < iFim; i++) {
			sb.insert(0, caracter);
		}

		iFim = (tamanhoTotal - sb.length());

		for (int i = 0; i < iFim; i++) {
			sb.insert(sb.length(), caracter);
		}

		return sb.toString();
	}

	/**
	 * Completa com o caracter informado a direita.
	 * 
	 * @param tamanhoTotal
	 *            Tamanho total do texto
	 * @param campo
	 *            valor
	 * @param caracter
	 *            caracter a ser completado
	 * @return String formatada
	 */
	public static String completaCharDireita(int tamanhoTotal, String campo, char caracter) {

		int tamanho = tamanhoTotal - campo.length();

		String result = "";

		for (int i = 0; i < tamanho; i++) {
			result = caracter + result;
		}

		result = subtitui(campo) + result;

		return result;
	}

	/**
	 * Completa com espaços a esquerda.
	 * 
	 * @param tamanhoTotal
	 *            Tamanho total do texto
	 * @param campo
	 *            valor
	 * @return String formatada
	 */
	public static String completaEspacosEsquerda(int tamanhoTotal, String campo) {
		return completaCharEsquerda(tamanhoTotal, campo, ' ');
	}

	/**
	 * Completa com o caracter informado a esquerda.
	 * 
	 * @param tamanhoTotal
	 *            Tamanho total do texto
	 * @param campo
	 *            valor
	 * @param caracter
	 *            caracter a ser completado
	 * @return String formatada
	 */
	public static String completaCharEsquerda(int tamanhoTotal, String campo, char caracter) {

		int tamanho = tamanhoTotal - campo.toString().length();

		StringBuilder result = new StringBuilder();

		for (int i = 0; i < tamanho; i++) {
			result.insert(0, caracter);
		}

		result.append(campo.toString());

		return result.toString();
	}

	/**
	 * Completa com zeros a esquerda.
	 * 
	 * @param tamanhoTotal
	 * @param campo
	 * @return String formatada
	 */
	public static String completaZerosEsquerda(Long tamanhoTotal, Number campo) {

		long tamanho = tamanhoTotal - campo.toString().length();

		StringBuilder result = new StringBuilder();

		for (int i = 0; i < tamanho; i++) {
			result.insert(0, ZERO);
		}

		result.append(campo.toString());

		return result.toString();
	}

	/**
	 * Completa com zeros a esquerda.
	 * 
	 * @param tamanhoTotal
	 * @param campo
	 * @return String formatada
	 */
	public static String completaZerosEsquerda(int tamanhoTotal, Number campo) {

		int tamanho = tamanhoTotal - campo.toString().length();

		StringBuilder result = new StringBuilder();

		for (int i = 0; i < tamanho; i++) {
			result.insert(0, ZERO);
		}

		result.append(campo.toString());

		return result.toString();
	}

	/**
	 * Completa com zeros a esquerda.
	 * 
	 * @param tamanhoTotal
	 * @param campo
	 * @return String formatada
	 */
	public static String completaZerosEsquerda(int tamanhoTotal, String campo) {
		int tamanho = tamanhoTotal - campo.length();

		StringBuilder result = new StringBuilder();

		for (int i = 0; i < tamanho; i++) {
			result.insert(0, ZERO);
		}

		result.append(campo.toString());

		return result.toString();
	}

	/**
	 * Completa com zeros a direita.
	 * 
	 * @param tamanhoTotal
	 * @param campo
	 * @return String formatada
	 */
	public static String completaZerosDireita(int tamanhoTotal, Number campo) {

		return completaZerosDireita(tamanhoTotal, campo.toString());
	}

	/**
	 * Completa com zeros a direita.
	 * 
	 * @param tamanhoTotal
	 * @param campo
	 * @return String formatada
	 */
	public static String completaZerosDireita(int tamanhoTotal, String campo) {

		long tamanho = tamanhoTotal - campo.length();

		String result = "";

		for (int i = 0; i < tamanho; i++) {
			result = result + ZERO;
		}

		result = campo + result;

		return result;
	}

	public static String subtitui(String campo) {
		return campo == null ? "" : campo;
	}

	public static boolean validarCPF(Number cpf) {

		if (StringUtils.isEmpty(cpf.toString()) && new CPFValidator().invalidMessagesFor(cpf.toString()).size() > 0) {
			return false;
		}

		return true;
	}

	public static boolean validarCNPJ(Number cnpj) {

		if (StringUtils.isEmpty(cnpj.toString())
				&& new CNPJValidator().invalidMessagesFor(cnpj.toString()).size() > 0) {
			return false;
		}

		return true;
	}

	private static boolean isSameCharacter(String s) {

		if (s != null && s.length() > 0) {

			char first = s.charAt(0);

			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) != first) {
					return false;
				}
			}

			return true;
		}

		return false;
	}

	public static BigDecimal timeToBigDecimal(Time time) {
		try {
			return new BigDecimal(time.getTime() / 1000.0 / 60.0 / 60.0
					+ (GregorianCalendar.getInstance().getTimeZone().getRawOffset() / 1000.0 / 60.0 / 60.0));

		} catch (Exception e) {
			e.printStackTrace();

			return null;
		}
	}

	public static Time bigDecimalToTime(BigDecimal cargaHoraria) {
		try {
			Double result = cargaHoraria.doubleValue() - cargaHoraria.intValue();
			Double minutos = result.doubleValue() * 60;
			Integer hora = cargaHoraria.intValue();
			return Time.valueOf(hora.toString() + ":" + minutos.toString() + ":00");

		} catch (Exception e) {
			e.printStackTrace();

			return null;
		}
	}

	public static String ListaParaSeparadoVirgula(Collection lista, String atributo) throws Exception {

		StringBuffer sb = new StringBuffer();

		for (Object obj : lista) {

			//TODO não baixa dependencia
//			Object resul = Reflexao.invocaGetAninhado(obj, atributo);

			if (sb.length() > 0) {
				sb.append(",");
			}
			
			//TODO não baixa dependencia ali de cima
//			sb.append((resul == null) ? "" : resul.toString());
		}

		return sb.toString();
	}

	public static String incrementaString(String texto, int quantidadeIncremento) {

		if (!StringUtils.isEmpty(texto.toLowerCase())) {

			char[] textoArr = texto.toLowerCase().toCharArray();

			int quantidadeIncrementada = 0;

			for (int i = textoArr.length - 1; i >= 0; i--) {
				if (quantidadeIncrementada == quantidadeIncremento) {
					break;
				}
				int sobra = quantidadeIncremento - quantidadeIncrementada;
				for (int j = 1; j <= sobra; j++) {
					if (((int) textoArr[i]) == 122) {
						break;
					} else {
						textoArr[i] += 1;
						quantidadeIncrementada += 1;
					}

				}
			}

			int i = 0;
			String tmp = "";

			while (i < textoArr.length) {
				tmp += textoArr[i];
				i++;
			}

			texto = tmp;
		}

		return texto;
	}

	public static String removeAcentuacao(String texto) {
		return Normalizer.normalize(texto, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	}

	public static String removeCaracteresEspeciais(String texto, String textoSubstituto) {
		for (String caracterEspecial : listaCaracteresEspeciais) {
			texto = texto.replaceAll(caracterEspecial, textoSubstituto == null ? "" : textoSubstituto);
		}
		return texto;
	}

	public static String removeAcentuacaoECaracteresEspeciais(String texto, String textoSubstituto) {

		texto = removeAcentuacao(texto);

		texto = removeCaracteresEspeciais(texto, textoSubstituto);

		return texto;
	}

	public static String removeFormatacaoTexto(String texto, String textoSubstituto) {
		for (String codigoFormatacao : listaCodigosFormatacao) {
			texto = texto.replaceAll(codigoFormatacao, textoSubstituto == null ? "" : textoSubstituto);
		}
		return texto;
	}

	public static String removerFormatacaoNumeroComSinal(String valor) {
		return valor.replaceAll(MASK_NUMERO_COM_SINAL, "");
	}
	
}