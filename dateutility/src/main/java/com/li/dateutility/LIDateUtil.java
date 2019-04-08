package com.li.dateutility;

import android.text.format.DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class LIDateUtil {

    public final static int SUNDAY = 1;
    public final static int MONDAY = 2;
    public final static int TUESDAY = 3;
    public final static int WEDNESDAY = 4;
    public final static int THURSDAY = 5;
    public final static int FRIDAY = 6;
    public final static int SATURDAY = 7;

    public final static int JANUARY = 0;
    public final static int FEBRUARY = 1;
    public final static int MARCH = 2;
    public final static int APRIL = 3;
    public final static int MAY = 4;
    public final static int JUNE = 5;
    public final static int JULY = 6;
    public final static int AUGUST = 7;
    public final static int SEPTEMBER = 8;
    public final static int OCTOBER = 9;
    public final static int NOVEMBER = 10;
    public final static int DECEMBER = 11;

    public final static int GREATER = 109;
    public final static int LESSER = 108;
    public final static int EQUALS = 107;

    public static final String DEFAULT_UTC_FORMAT = "dd/MM/yyyy HH:mm:ss";
    public static final String TIME_24 = "HH:mm:ss";
    public static final String TIME_12 = "hh:mm:ss";
    private static final String TAG = "LIDateUtil";


    public static Calendar getCalender(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(date.getTime());
        return c;

    }

    public static int getCurrentYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    public static int getCurrentMonth() {
        return Calendar.getInstance().get(Calendar.MONTH);
    }

    public static int getCurrentDay() {
        return Calendar.getInstance().get(Calendar.DATE);
    }

    public static int getDayOfWeek(Date date) {
        Calendar c1 = Calendar.getInstance();
        c1.setTimeInMillis(date.getTime());
        return c1.get(Calendar.DAY_OF_WEEK);
    }

    public static int getMonthFromDate(Date d) {
        Calendar c = getCalender(d);
        return c.get(Calendar.MONTH);
    }

    public static int getYearFromDate(Date d) {
        Calendar c = getCalender(d);
        return c.get(Calendar.YEAR);
    }

    public static int getDayFromDate(Date d) {
        Calendar c = getCalender(d);
        return c.get(Calendar.DATE);
    }

    public static String getTimeFromDate(Date d) {
        return getStringFromDate(d,TIME_24);
    }

    public static String getWeekDayFromDate(Date d) {
        return getStringFromDate(d,"EEEE");
    }

    public static Date getDateFromString(String stringDate, String format) {
        SimpleDateFormat input = new SimpleDateFormat(format);
        Date d = null;
        Calendar calendar = null;
        try {
            d = input.parse(stringDate);
            calendar = Calendar.getInstance();
            calendar.setTime(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return calendar.getTime();

    }

    public static String getStringFromDate(Date date, String format) {
        return DateFormat.format(format, date).toString();
    }

    public static long getTimeStampFromDate(Date date){
        return date.getTime();
    }


    public static Date getDateFromTimeStamp(long milliSeconds) {
        // Create a calendar object that will convert the date and time value in milliseconds to date.
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        return calendar.getTime();
    }

    public static String getStringFromTimeStamp(long milliSeconds, String dateFormat) {
        // Create a DateFormatter object for displaying date in specified format.
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);

        // Create a calendar object that will convert the date and time value in milliseconds to date.
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        return formatter.format(calendar.getTime());
    }

    public static int getAge(Date d) {
        Calendar dob = getCalender(d);
        Calendar today = Calendar.getInstance();



        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

        if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }


        return age;
    }


    public static int compareDates(Date date1, Date date2) {
        if (date1 != null && date2 != null) {
            int retVal = date1.compareTo(date2);

            if (retVal > 0)
                return GREATER; // date1 is greatet than date2
            else if (retVal == 0) // both dates r equal
                return EQUALS;

        }
        return LESSER; // date1 is less than date2
    }

    public static int compareDates(String d1, String d2, String format) {
        Date date1 = getDateFromString(d1, format);
        Date date2 = getDateFromString(d2,format);
        if (date1 != null && date2 != null) {
            int retVal = date1.compareTo(date2);

            if (retVal > 0)
                return GREATER; // date1 is greatet than date2
            else if (retVal == 0) // both dates r equal
                return EQUALS;

        }
        return LESSER; // date1 is less than date2
    }

    public static int getDifferenceBetweenTwoDatesInDays(Date fromDate, Date toDate) {
        return Math.abs((int) ((toDate.getTime() - fromDate.getTime()) / (1000 * 60 * 60 * 24)));
    }

    public static int getDifferenceBetweenTwoDatesInMonths(Date fromDate, Date toDate) {
        return Math.abs((int) ((toDate.getTime() - fromDate.getTime()) / (1000 * 60 * 60 * 24)/30));
    }
    public static int getDifferenceBetweenTwoDatesInYears(Date fromDate, Date toDate) {
        return Math.abs((int) getYearFromDate(toDate)-getYearFromDate(fromDate));
    }

    public static int getDifferenceBetweenTwoDatesInHours(Date fromDate, Date toDate) {
        return Math.abs((int) ((toDate.getTime() - fromDate.getTime()) / (1000 * 60 * 60)));

    }


    public static int getDifferenceBetweenTwoDatesInMinutes(Date fromDate, Date toDate) {
        return Math.abs((int) ((toDate.getTime() - fromDate.getTime()) / (1000 * 60)));
    }

    public static int getDifferenceBetweenTwoDatesInSeconds(Date fromDate, Date toDate) {
        return Math.abs((int) ((toDate.getTime() - fromDate.getTime()) / (1000)));
    }


    public static Date addNumberOfSecondsToDate(Date date, int seconds) {
        Calendar calendar = getCalender(date);
        calendar.add(Calendar.SECOND, seconds);
        return calendar.getTime();
    }

    public static Date addNumberOfMinutesToDate(Date date, int minutes) {
        Calendar calendar = getCalender(date);
        calendar.add(Calendar.MINUTE, minutes);
        return calendar.getTime();
    }

    public static Date addNumberOfHoursToDate(Date date, int hour) {
        Calendar calendar = getCalender(date);
        calendar.add(Calendar.HOUR, hour);
        return calendar.getTime();
    }

    public static Date addNumberOfDaysToDate(Date date, int noOfDays) {
        Calendar c = getCalender(date);
        c.add(Calendar.DATE, noOfDays);
        return c.getTime();
    }

    public static Date addNumberOfMonthsToDate(Date date, int month) {
        Calendar calendar = getCalender(date);
        calendar.add(Calendar.MONTH, month);
        return calendar.getTime();
    }

    public static Date addNumberOfYearsToDate(Date date, int year) {
        Calendar calendar = getCalender(date);
        calendar.add(Calendar.YEAR, year);
        return calendar.getTime();
    }

    public static Date addYMDMHS(Date date, int year, int month, int days, int hours, int minutes, int seconds) {
        Calendar calendar = getCalender(date);
        calendar.add(Calendar.YEAR, year);
        calendar.add(Calendar.MONTH, month);
        calendar.add(Calendar.DATE, days);
        calendar.add(Calendar.HOUR, hours);
        calendar.add(Calendar.MINUTE, minutes);
        calendar.add(Calendar.SECOND, seconds);
        return calendar.getTime();
    }


    public static Date subtractNumberOfSecondsFromDate(Date date, int seconds) {
        Calendar calendar = getCalender(date);
        calendar.add(Calendar.SECOND, -seconds);
        return calendar.getTime();
    }

    public static Date subtractNumberOfMinutesToDate(Date date, int minutes) {
        Calendar calendar = getCalender(date);
        calendar.add(Calendar.MINUTE, -minutes);
        return calendar.getTime();
    }

    public static Date subtractNumberOfHoursToDate(Date date, int hour) {
        Calendar calendar = getCalender(date);
        calendar.add(Calendar.HOUR, -hour);
        return calendar.getTime();
    }

    public static Date subtractNumberOfDaysToDate(Date date, int noOfDays) {
        Calendar c = getCalender(date);
        c.add(Calendar.DATE, -noOfDays);
        return c.getTime();
    }

    public static Date subtractNumberOfMonthsToDate(Date date, int month) {
        Calendar calendar = getCalender(date);
        calendar.add(Calendar.MONTH, -month);
        return calendar.getTime();
    }

    public static Date subtractNumberOfYearsToDate(Date date, int year) {
        Calendar calendar = getCalender(date);
        calendar.add(Calendar.YEAR, -year);
        return calendar.getTime();
    }

    public static Date subtractYMDMHS(Date date, int year, int month, int days, int hours, int minutes, int seconds) {
        Calendar calendar = getCalender(date);
        calendar.add(Calendar.YEAR, -year);
        calendar.add(Calendar.MONTH, -month);
        calendar.add(Calendar.DATE, -days);
        calendar.add(Calendar.HOUR, -hours);
        calendar.add(Calendar.MINUTE, -minutes);
        calendar.add(Calendar.SECOND, -seconds);
        return calendar.getTime();
    }


    public static Date getDate(int dayOfMonth, int month, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DATE, dayOfMonth);
        return calendar.getTime();
    }


    public static boolean isWeakend(Date date) {
        Calendar c = getCalender(date);
        if (c.get(Calendar.DAY_OF_WEEK) == SUNDAY || c.get(Calendar.DAY_OF_WEEK) == SATURDAY)
            return true;
        else return false;
    }




    public static String getFormatedDateFromString(String inputDate,String inputDateFormat,String outPutDateFormat){
        Date d = getDateFromString(inputDate,inputDateFormat);
        return getStringFromDate(d,outPutDateFormat);
    }



    public static String convertUTCTimeToLocal(String datesToConvert, String inputFormat, String outputFormat) {
        String dateToReturn = datesToConvert;

        SimpleDateFormat sdf = new SimpleDateFormat(inputFormat);
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));

        Date gmt = null;

        SimpleDateFormat sdfOutPutToSend = new SimpleDateFormat(outputFormat);
        sdfOutPutToSend.setTimeZone(TimeZone.getDefault());

        try {
            gmt = sdf.parse(datesToConvert);
            dateToReturn = sdfOutPutToSend.format(gmt);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateToReturn;
    }

    public static Date convertUTCTimeToLocal(String datesToConvert, String inputFormat) {
        String dateToReturn = datesToConvert;

        SimpleDateFormat sdf = new SimpleDateFormat(inputFormat);
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));

        Date gmt = null;

        SimpleDateFormat sdfOutPutToSend = new SimpleDateFormat(inputFormat);
        sdfOutPutToSend.setTimeZone(TimeZone.getDefault());

        try {
            gmt = sdf.parse(datesToConvert);
            dateToReturn = sdfOutPutToSend.format(gmt);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return getDateFromString(dateToReturn, inputFormat);
    }

    public static String convertLocalTimeToUTC(String dateFormat, String datesToConvert) {

        String dateToReturn = datesToConvert;
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        sdf.setTimeZone(TimeZone.getDefault());
        Date gmt = null;

        SimpleDateFormat sdfOutPutToSend = new SimpleDateFormat(dateFormat);
        sdfOutPutToSend.setTimeZone(TimeZone.getTimeZone("UTC"));

        try {
            gmt = sdf.parse(datesToConvert);
            dateToReturn = sdfOutPutToSend.format(gmt);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateToReturn;
    }

    public static String convertLocalTimeToUTC(Date datesToConvert, String outPutFormat) {

        SimpleDateFormat sdfOutPutToSend = new SimpleDateFormat(outPutFormat);
        sdfOutPutToSend.setTimeZone(TimeZone.getTimeZone("UTC"));
        return sdfOutPutToSend.format(datesToConvert);
    }


    public static int getDiffrenceOfDaysBetweenDates(Date fromDate, Date toDate) {
        return Math.abs((int) ((toDate.getTime() - fromDate.getTime()) / (1000 * 60 * 60 * 24)));
    }

    public static int getDiffrenceOfHourBetweenDates(Date fromDate, Date toDate) {
        return Math.abs((int) ((toDate.getTime() - fromDate.getTime()) / (1000 * 60 * 60)));

    }



    public static TimeZone getCurrentTimezone() {
        return TimeZone.getDefault();
    }

    public static String getDefaultTimeZoneId() {
        return TimeZone.getDefault().getID();
    }

    public static TimeZone getTimeZoneById(String id) {
        return TimeZone.getTimeZone(id);
    }


    public static boolean isToday(Date date) {
        Calendar calendar = getCalender(date);
        Calendar today = Calendar.getInstance();

        return (calendar.get(Calendar.YEAR) == today.get(Calendar.YEAR) &&
                calendar.get(Calendar.MONTH) == today.get(Calendar.MONTH) &&
                calendar.get(Calendar.DATE) == today.get(Calendar.DATE));

    }



}

