/**
 * 
 */
package edu.neu.csye6200.util;

/**
 * @author pnakave
 *
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class ConversionUtil {

	public static int StringToInt(String s) {
		int i = 0;
		try {
			i = Integer.valueOf(s);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		return i;
	}

	public static Date StringToDate(String s) {
		Date d = null;
		try {
			d = new SimpleDateFormat("dd/MM/yyyy").parse(s);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}

	public static LocalDate StringToLocalDate(String dateString) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate = LocalDate.parse(dateString, formatter);
		return localDate;
	}

	public static int DateToAge(Date d) {
		Calendar todayDate = new GregorianCalendar();
		Calendar bday = new GregorianCalendar();
		bday.setTime(d);
		int yearsInBetween = todayDate.get(Calendar.YEAR) - bday.get(Calendar.YEAR);
		int monthsDiff = todayDate.get(Calendar.MONTH) - bday.get(Calendar.MONTH);
		int ageInMonths = yearsInBetween * 12 + monthsDiff;

		return ageInMonths;
	}
	
	public static int getAgeFromDOB(LocalDate dob) {
		LocalDate currentDate = LocalDate.now();
		return 12 * (int) ChronoUnit.YEARS.between(dob, currentDate);   // returning months
	}

	public static String DateToString(Date d) {
		String date = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).format(d);
		return date;
	}

}
