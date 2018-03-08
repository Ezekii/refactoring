package br.com.dxc.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.text.MaskFormatter;

import org.apache.commons.lang.StringUtils;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;

public abstract class MaskUtils {

	private static final String PATTERN_HORA_MINUTO = "HH:mm";
	private static final String PATTERN_CNPJ = "##.###.###/####-##";
	private static final String PATTERN_CPF = "###.###.###-##";
	private static final String PATTERN_CEP = "#####-###";
	private static final String PATTERN_NUMERO_CONTRATO = "(\\d{7})(\\d{4})(\\d{6})(\\d{1})";
	private static final String PATTERN_NUMERO_CONTRATO_FORMATADO = "$1-$2.$3-$4";
	private static final String PATTERN_TELEFONE_0800 = "(\\d{4})(\\d{3})(\\d{4})";
	private static final String PATTERN_TELEFONE_0800_FORMATADO = "$1-$2-$3";
	private static final String PATTERN_TELEFONE_7_DIGITOS = "(\\d{3})(\\d{4})";
	private static final String PATTERN_TELEFONE_7_DIGITOS_FORMATADO = "$1-$2";
	private static final String PATTERN_TELEFONE_8_DIGITOS = "(\\d{4})(\\d{4})";
	private static final String PATTERN_TELEFONE_8_DIGITOS_FORMATADO = "$1-$2";
	private static final String PATTERN_TELEFONE_9_DIGITOS = "(\\d{2})(\\d{3})(\\d{4})";
	private static final String PATTERN_TELEFONE_9_DIGITOS_FORMATADO = "($1)$2-$3";
	private static final String PATTERN_TELEFONE_10_DIGITOS = "(\\d{2})(\\d{4})(\\d{4})";
	private static final String PATTERN_TELEFONE_10_DIGITOS_FORMATADO = "($1)$2-$3";
	private static final String PATTERN_TELEFONE_11_DIGITOS = "(\\d{2})(\\d{5})(\\d{4})";
	private static final String PATTERN_TELEFONE_11_DIGITOS_FORMATADO = "($1)$2-$3";	
	private static final SimpleDateFormat SDF_DATA = new SimpleDateFormat("dd/MM/yyyy");
	private static final SimpleDateFormat SDF_DATA_HORA = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	private static final DecimalFormatSymbols DFS_REAL = new DecimalFormatSymbols(new Locale("pt", "BR"));
	private static final DecimalFormat DF_MONETARIO_REAL = new DecimalFormat("#,##0.00", MaskUtils.DFS_REAL);

	public static String formatData(final Date value) {
		if (value == null) {
			return null;
		}
		return MaskUtils.SDF_DATA.format(value);
	}

	public static String formatDataHora(final Date value) {
		if (value == null) {
			return null;
		}
		return MaskUtils.SDF_DATA_HORA.format(value);
	}

	public static String formatData(final LocalDate value) {
		if (value == null) {
			return null;
		}
		return MaskUtils.SDF_DATA.format(value.toDate());
	}

	public static String formatData(final LocalDateTime value) {
		if (value == null) {
			return null;
		}
		return MaskUtils.SDF_DATA.format(value.toDate());
	}

	public static String formatDataHora(final LocalDate value) {
		if (value == null) {
			return null;
		}
		return MaskUtils.SDF_DATA_HORA.format(value.toDate());
	}

	public static String formatHora(final LocalTime value) {
		if (value == null) {
			return null;
		}
		return value.toString(MaskUtils.PATTERN_HORA_MINUTO);
	}

	public static String formatHora(final LocalDateTime value) {
		if (value == null) {
			return null;
		}
		return value.toString(MaskUtils.PATTERN_HORA_MINUTO);
	}

	public static String formatMonetario(final BigDecimal value) {
		if (value == null) {
			return null;
		}
		return MaskUtils.DF_MONETARIO_REAL.format(value);
	}

	public static String formatCEP(final Integer value) {
		if (value == null) {
			return null;
		}
		return format(MaskUtils.PATTERN_CEP, value);
	}

	public static String formatCPF(final String value) {
		if (value == null) {
			return null;
		}
		return format(MaskUtils.PATTERN_CPF, value);
	}

	public static String formatCNPJ(final String value) {
		if (value == null) {
			return null;
		}
		return format(MaskUtils.PATTERN_CNPJ, value);
	}

	public static String formatCpfCnpj(final String value) {
		if (value == null) {
			return null;
		}
		return (value.length() > 11) ? formatCNPJ(value) : formatCPF(value);
	}

	private static String format(final String pattern, final Object value) {
		if (value == null) {
			return null;
		}
		try {
			final MaskFormatter mask = new MaskFormatter(pattern);
			mask.setValueContainsLiteralCharacters(false);
			return mask.valueToString(value);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

	public static String formataNumeroContratoEmprestimo(String numeroContrato) {
		String numeroContratoFormatado = null;

		if (StringUtils.isBlank(numeroContrato)) {
			return "";
		}

		if (numeroContrato.length() == 18) {
			Pattern pattern = Pattern.compile(MaskUtils.PATTERN_NUMERO_CONTRATO);
			Matcher matcher = pattern.matcher(numeroContrato);
			numeroContratoFormatado = matcher.replaceAll(MaskUtils.PATTERN_NUMERO_CONTRATO_FORMATADO);
		}
		return numeroContratoFormatado;
	}

	public static String formata0800(String numero) {
		Pattern pattern = Pattern.compile(MaskUtils.PATTERN_TELEFONE_0800);
		Matcher matcher = pattern.matcher(numero);

		return matcher.replaceAll(MaskUtils.PATTERN_TELEFONE_0800_FORMATADO);
	}

	public static String FormataTelefone(String numero) {

		if (numero != null) {
			int nrDigitos = numero.trim().length();

			Pattern pattern = null;
			Matcher matcher = null;

			switch (nrDigitos) {

			case 7:
				// Caso seja 999-9999
				pattern = Pattern.compile(MaskUtils.PATTERN_TELEFONE_7_DIGITOS);
				matcher = pattern.matcher(numero);

				return matcher.replaceAll(MaskUtils.PATTERN_TELEFONE_7_DIGITOS_FORMATADO);

			case 8:
				// Caso seja 9999-9999
				pattern = Pattern.compile(MaskUtils.PATTERN_TELEFONE_8_DIGITOS);
				matcher = pattern.matcher(numero);

				return matcher.replaceAll(MaskUtils.PATTERN_TELEFONE_8_DIGITOS_FORMATADO);

			case 9:
				// Caso seja (99)999-9999
				pattern = Pattern.compile(MaskUtils.PATTERN_TELEFONE_9_DIGITOS);
				matcher = pattern.matcher(numero);

				return matcher.replaceAll(MaskUtils.PATTERN_TELEFONE_9_DIGITOS_FORMATADO);

			case 10:
				// Caso seja (999)9999-9999
				pattern = Pattern.compile(MaskUtils.PATTERN_TELEFONE_10_DIGITOS);
				matcher = pattern.matcher(numero);

				return matcher.replaceAll(MaskUtils.PATTERN_TELEFONE_10_DIGITOS_FORMATADO);

			case 11:
				// Caso seja (99)99999-9999
				pattern = Pattern.compile(MaskUtils.PATTERN_TELEFONE_11_DIGITOS);
				matcher = pattern.matcher(numero);

				return matcher.replaceAll(MaskUtils.PATTERN_TELEFONE_11_DIGITOS_FORMATADO);
			}
		}

		return "";
	}

}
