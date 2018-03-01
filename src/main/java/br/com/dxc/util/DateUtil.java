package br.com.dxc.util;

import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Classe Responsável em tratar Data.
 * 
 * @author robson
 *
 */
public class DateUtil {

	private static final String formatoData = "dd/MM/yyyy";

	private static final String formatoDataSemBarra = "ddMMyyyy";

	private static final String formatoHora = "HH:mm:ss";

	private static final String formatoDiaCompleto = "dd/MM/yyyy ' - ' HH:mm:ss";

	private static final String formatoAnoInverso = "yyyyMMddHHmmss";

	private static final String formatoAnoInversoMilisegundos = "yyyyMMddHHmmssSSSSSS";

	private static final String formatoDataSimples = "ddMMyy";

	private static final String formatoDataInverso = "yyyyMMdd";

	private static final String formatoAnoMes = "yyyy-MM";

	private static final String formatoExtenso = "d MMMM, yyyy";

	/**
	 * Retorna a data atual com a hora zerada.
	 * 
	 * @return
	 */
	public static LocalDateTime getDate() {
		return LocalDateTime.now();
	}

	/**
	 * Retorna a data de 01/01/1901.
	 * 
	 * @return
	 */
	public static LocalDate getInitialDate() {

		return new LocalDate(1901, 1, 1);
	}

	/**
	 * Retorna a data de 31/12/2050.
	 * 
	 * @return
	 */
	public static LocalDate getFinalDate() {

		return new LocalDate(2050, 12, 31);
	}

	/**
	 * Retorna a data e hora atual
	 * 
	 * @return
	 */
	public static LocalDateTime getDateTime() {
		return new LocalDateTime();
	}

	/**
	 * Retorna a data atual no formato dd/MM/yyyy
	 * 
	 * @return
	 */
	public static String getDateAsString() {
		DateTimeFormatter format = DateTimeFormat.forPattern(formatoData);
		return format.print(new LocalDate().now());
	}

	/**
	 * Retorna a data atual no formato ddMMyyyy
	 * 
	 * @param date
	 * @return
	 */
	public static String getDateAsString(LocalDate date) {
		DateTimeFormatter format = DateTimeFormat.forPattern(formatoDataSemBarra);
		return format.print(date);
	}

	/**
	 * Retorna a data e hora atual no forma dd/MM/yyyy - HH:mm:ss.
	 * 
	 * @return
	 */
	public static String getDateHourAsString() {
		DateTimeFormatter format = DateTimeFormat.forPattern(formatoDiaCompleto);
		return format.print(new LocalDateTime().now());
	}

	/**
	 * Retorna a data atual com base na string passada (ddmmyyyy), que deve estar no
	 * formato dd/MM/yyyy
	 * 
	 * @param date
	 * @return
	 */
	public static synchronized LocalDate parse(String date) {
		DateTimeFormatter format = DateTimeFormat.forPattern(formatoData);
		return LocalDate.parse(date, format);
	}

	/**
	 * Retorna a data atual com base na string passada (yyyyMMddHHmmss), que deve
	 * estar no formato dd/MM/yyyy
	 * 
	 * @param dateHour
	 * @return
	 */
	public static synchronized LocalDate parseDateHour(String dateHour) {
		if (dateHour.length() == 14) {
			DateTimeFormatter format = DateTimeFormat.forPattern(formatoAnoInverso);

			return LocalDate.parse(dateHour, format);
		} else {
			DateTimeFormatter format = DateTimeFormat.forPattern(formatoDataSimples);

			return LocalDate.parse(dateHour, format);
		}
	}

	/**
	 * Retorna a data atual com base na string passada
	 *
	 * @param dateHour
	 * @param pattern
	 * @return
	 */
	public static LocalDate parseDateHour(String dateHour, String pattern) {

		DateTimeFormatter format = DateTimeFormat.forPattern(pattern);

		return LocalDate.parse(dateHour, format);
	}

	/**
	 * Retorna a data no formato dd/MM/yyyy
	 * 
	 * @param date
	 * @return
	 */
	public static String format(LocalDate date) {
		return format(date, formatoData);
	}

	/**
	 * Retorna a data no formato informado
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String format(LocalDate date, String format) {
		DateTimeFormatter dtFormatter = DateTimeFormat.forPattern(format);
		return dtFormatter.print(date);
	}

	/**
	 * Retorna a data no formato de pattern
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String formatDateHour(LocalDate date, String format) {
		DateTimeFormatter dtFormatter = DateTimeFormat.forPattern(format);
		return dtFormatter.print(date);
	}

	/**
	 * Retorna a data no formato dd/MM/yyyy.
	 * 
	 * @param date
	 * @return
	 */
	public static LocalDate formatDate(String date) {
		DateTimeFormatter dtFormatter = DateTimeFormat.forPattern(formatoData);

		return LocalDate.parse(date, dtFormatter);
	}

	/**
	 * Retorna a data no formato HH:mm:ss
	 * 
	 * @param date
	 * @return
	 */
	public static String formatHour(LocalDate date) {
		DateTimeFormatter dtFormatter = DateTimeFormat.forPattern(formatoHora);

		return dtFormatter.print(date);
	}

	/**
	 * Retorna a data e a hora no forma dd/MM/yyyy - HH:mm:ss.
	 * 
	 * @param date
	 * @return
	 */
	public static String formatDateHour(LocalDate date) {
		DateTimeFormatter dtFormatter = DateTimeFormat.forPattern(formatoDiaCompleto);

		return dtFormatter.print(date);
	}

	/**
	 * Retorna a data e a hora no forma yyyyMMddHHmmss
	 * 
	 * @param date
	 * @return
	 */
	public static String formatDateHourInverse(LocalDate date) {
		DateTimeFormatter dtFormatter = DateTimeFormat.forPattern(formatoAnoInverso);

		return dtFormatter.print(date);
	}

	public static String formatDateHourInverseMilisegundos(LocalDate date) {
		DateTimeFormatter dtFormatter = DateTimeFormat.forPattern(formatoAnoInversoMilisegundos);

		return dtFormatter.print(date);
	}

	/**
	 * Adiciona dias em uma data e retorna o resultado como String.
	 * 
	 * @param date
	 * @param days
	 * @return
	 */
	public static synchronized String addDaysReturnString(LocalDate date, int days) {
		DateTimeFormatter dtFormatter = DateTimeFormat.forPattern(formatoAnoInversoMilisegundos);

		return dtFormatter.print(date.plusDays(days));
	}

	/**
	 * Adiciona dias em uma data e retorna o resultado como Date.
	 * 
	 * @param date
	 * @param days
	 * @return
	 */
	public static synchronized LocalDate addDays(LocalDate date, int days) {

		return date.plusDays(days);
	}

	/**
	 * Subtrai dias em uma data e retorna o resultado como String.
	 * 
	 * @param date
	 * @param days
	 * @return
	 */
	public static synchronized String subtractDaysReturnString(LocalDate date, int days) {
		DateTimeFormatter dtFormatter = DateTimeFormat.forPattern(formatoAnoMes);

		return dtFormatter.print(date.plusDays(-days));
	}

	/**
	 * Subtrai dias em uma data e retorna o resultado como LocalDate.
	 * 
	 * @param date
	 * @param days
	 * @return
	 */
	public static synchronized LocalDate subtractDays(LocalDate date, int days) {
		return date.plusDays(-days);
	}

	/**
	 * Remover anos de uma data retornando uma nova data.
	 * 
	 * @param date
	 * @param years
	 * @return
	 */
	public static synchronized LocalDate subtractYear(LocalDate date, int years) {
		return date.plusYears(-years);
	}

	/**
	 * Adiciona dias em uma data, não ultrapassando o ano da data. Exemplos:
	 * 10/12/2005 + 5 = 15/12/2005, 10/12/2005 + 30 = 31/12/2005
	 * 
	 * @param date
	 * @param days
	 * @return
	 */
	public static synchronized String addDaysLimitYear(LocalDate date, int days) {
		DateTimeFormatter dtFormatter = DateTimeFormat.forPattern(formatoData);
		Integer year = date.getYear();
		String result = dtFormatter.print(date.plusDays(-days));

		if (!result.endsWith(year.toString())) {
			return "31/12/" + year;
		}

		return result;
	}

	/**
	 * Método responsável em retornar o ano de uma data
	 * 
	 * @param date
	 * @return
	 */
	public static int getYear(LocalDate date) {
		return date.getYear();
	}

	/**
	 * Método responsável em retornar o dia de uma data
	 * 
	 * @param date
	 * @return
	 */
	public static int getDay(LocalDate date) {
		return date.getDayOfWeek();
	}

	/**
	 * Método responsável em retornar o dia de uma data
	 * 
	 * @param date
	 * @return
	 */
	public static int getMonth(LocalDate date) {
		return date.getDayOfMonth();
	}

	/**
	 * Método responsável em retornar o nome do mês
	 * 
	 * @param date
	 * @return String
	 */
	public static String getMonthExt(LocalDate date) {

		return date.monthOfYear().getName();
	}

	/**
	 * Método responsável por verificar se uma data (date) é posterior à outra
	 * (dataBase).
	 * 
	 * @param date
	 * @param baseDate
	 * @return
	 */
	public static boolean isAfter(String date, String baseDate) {
		DateTimeFormatter dtFormatter = DateTimeFormat.forPattern(formatoData);
		LocalDate data = LocalDate.parse(date, dtFormatter);
		LocalDate baseData = LocalDate.parse(baseDate, dtFormatter);

		return data.isAfter(baseData);
	}

	/**
	 * Método responsável por verificar se uma data (data) é não ultrapassa a outra
	 * (dataBase), em X (limite) dias.
	 * 
	 * @param date
	 * @param baseDate
	 * @param limit
	 * @return
	 */
	public static boolean isInsideRange(String date, String baseDate, int limit) {
		DateTimeFormatter dtFormatter = DateTimeFormat.forPattern(formatoData);
		LocalDate data = LocalDate.parse(date, dtFormatter);
		LocalDate baseData = LocalDate.parse(baseDate, dtFormatter);

		return data.isAfter(baseData.plusDays(limit));
	}

	/**
	 * Método responsável por verificar se uma data (data) é não ultrapassa a outra
	 * (dataBase), em X (limite) dias.
	 * 
	 * @param date
	 * @param baseDate
	 * @param limit
	 * @return
	 */
	public static synchronized boolean isInsideRange(LocalDate date, LocalDate baseDate, int limit) {

		return date.isAfter(baseDate.plusDays(limit));
	}

	/**
	 * Método responsável por verificar se uma data (data) é anterior à outra
	 * (database).
	 * 
	 * @param date
	 * @param baseDate
	 * @return
	 */
	public static synchronized boolean isBefore(LocalDate date, LocalDate baseDate) {

		return date.isBefore(baseDate);
	}

	/**
	 * Método responsável por verificar se uma data (data) é posterior à outra
	 * (dataBase).
	 * 
	 * @param date
	 * @param baseDate
	 * @return
	 * 
	 * @throws
	 */
	public static boolean isEqual(LocalDate date, LocalDate baseDate) {

		return date.isEqual(baseDate);
	}

	/**
	 * Método responsável por verificar se a data é igual a data atual.
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isToday(String date) {

		DateTimeFormatter dtFormatter = DateTimeFormat.forPattern(formatoData);
		LocalDate data = LocalDate.parse(date, dtFormatter);

		return LocalDate.now().isEqual(data);
	}

	/**
	 * Método responsável por retornar a quantidade de dias entre 2 datas.
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static synchronized long getDaysBetween(LocalDate date1, LocalDate date2) {

		return Days.daysBetween(date1, date2).getDays();
	}

	/**
	 * Método responsável por verificar se a data é igual a data atual.
	 * 
	 * @param date
	 * @return 
	 */
	public static boolean isToday(LocalDate date) {
		return LocalDate.now().isEqual(date);
	}

	// public static synchronized java.sql.Date StringToDate_SQL(String data) {
	//
	// Calendar calendario = Calendar.getInstance();
	//
	// try {
	// String[] resul = null;
	// resul = data.split("/");
	// calendario.set(Integer.parseInt(resul[2]),
	// Integer.parseInt(resul[1]) - 1, Integer.parseInt(resul[0]));
	// } catch (Exception e) {
	// // FS#10200 - A exceção não está sendo logada, para evitar a
	// // poluição do log
	// log.warn("Erro ao tentar converter Data: " + data);
	// }
	//
	// return (new java.sql.Date(calendario.getTime().getTime()));
	// }
	//
	// public static java.sql.Date DateToDate_SQL(Date data) {
	// return (new java.sql.Date(data.getTime()));
	// }

	/**
	 * Verifica se dois campos "hora" são iguais ou se o primeiro é maior que o
	 * segundo.
	 * 
	 * @param hour
	 * @param date
	 * @return
	 */
	public static synchronized boolean verificaHorasMaior(LocalTime hour, LocalDateTime date) {

		LocalTime hour2 = date.toLocalTime();

		if (hour.isAfter(hour2)) {
			return true;
		}

		return false;
	}

	/**
	 * Verifica se duas datas sao iguais apenas pelo dia, mês e ano e não pelas
	 * horas, minutos e segundos.
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static synchronized boolean verificaDatasIguais(LocalDateTime date1, LocalDateTime date2) {

		return date1.toLocalDate().equals(date2.toLocalDate());
	}

	/**
	 * Adiciona hora a uma data
	 * 
	 * @param hour
	 * @param date
	 * @return
	 */
	public static synchronized LocalDateTime addHour(LocalTime hour, LocalDate date) {

		return date.toLocalDateTime(hour);
	}

	/**
	 * @param date
	 * @return
	 */
	public static synchronized String getWeekDayFromDate(LocalDate date) {

		return date.dayOfWeek().getAsText();
	}

	/**
	 * Valida se a data informada é válida.
	 * 
	 * @param date
	 * @return
	 */
	public static synchronized boolean isDateValid(String date) {
		DateTimeFormatter dtFormatter = DateTimeFormat.forPattern(formatoData);
		try {
			LocalDate.parse(date, dtFormatter);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Retorna o ultimo dia do mes
	 *
	 * @param date
	 * @return
	 */
	public static synchronized Integer getLastDayOfMonth(LocalDate date) {

		return date.dayOfMonth().getMaximumValue();
	}

	/**
	 * Método para resgatar a hora atual do sistema.
	 * 
	 * @return
	 */
	public static synchronized LocalTime horaAtualSistema() {

		return LocalTime.now();
	}

	/**
	 * Método para resgatar a hora de uma data.
	 * 
	 * @param date
	 * @return
	 */
	public static synchronized LocalTime getHoraDeUmaData(LocalDateTime date) {
		return date.toLocalTime();
	}

	/**
	 * Método responsável em retornar a data por extenso.
	 * 
	 * @param date
	 * @return
	 */
	public static synchronized String getDataExtenso(LocalDate date) {
		DateTimeFormatter dtFormatter = DateTimeFormat.forPattern(formatoExtenso);
		return date.toString(dtFormatter);
	}

	/**
	 * Retorna a data no formato ddMMyy
	 * 
	 * @param date
	 * @return
	 */
	public static String getDateDDMMYY(LocalDate date) {
		DateTimeFormatter dtFormatter = DateTimeFormat.forPattern(formatoDataSimples);
		return dtFormatter.print(date);
	}

	/**
	 * Retorna a data no formato yyyyMMdd
	 * 
	 * @param date
	 * @return
	 */
	public static String getDateYYYYMMDD(LocalDate date) {
		DateTimeFormatter dtFormatter = DateTimeFormat.forPattern(formatoDataInverso);
		return dtFormatter.print(date);
	}

	/**
	 * Método responsável em setar a hora atual em uma data.
	 * 
	 * @param date
	 * @return
	 */
	public static synchronized LocalDateTime setarHoraAtualEmData(LocalDate date) {

		return date.toLocalDateTime(LocalTime.now());
	}

	/**
	 * Retorna a data no formato yyyy-MM
	 * 
	 * @param date
	 * @return
	 */
	public static String getDateYYYYMM(LocalDate date) {
		DateTimeFormatter format = DateTimeFormat.forPattern(formatoAnoMes);
		return format.print(date);
	}
}