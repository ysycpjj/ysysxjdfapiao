package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


/**
 * Created by QQ on 2016/4/14.
 */
public class DateUtils extends org.apache.commons.lang.time.DateUtils{

    public static Date stringToDate(String dateStr){
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            return null;
        }
        return date;
    }

    public static Date stringToDate(String time,String format){
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.US);
        try {
            date = sdf.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String dateToString(Date date,String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String rs  = sdf.format(date);
        return rs;
    }


    public static String dateToString(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String rs  = sdf.format(date);
        return rs;
    }

    public static String formatDate(String stringFormat,String stringDate,SimpleDateFormat format){
        Date date = stringToDate(stringDate, stringFormat);
        return format.format(date);
    }


    public static String  getTimeBefore (String endTime,String dateRanges) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date endDate = simpleDateFormat.parse(endTime);//selectQuery.getString(endtime)
        Calendar calender = Calendar.getInstance();
        calender.setTime(endDate);
        if(dateRanges.contains("month"))
            calender.add(Calendar.MONTH, -1 * Integer.parseInt(dateRanges.split("m")[0]));
        else if(dateRanges.contains("year"))
            calender.add(Calendar.YEAR, -1 * Integer.parseInt(dateRanges.split("y")[0]));
        else if(dateRanges.contains("day"))
            calender.add(Calendar.DATE, -1 * Integer.parseInt(dateRanges.split("d")[0]));
        else if(dateRanges.contains("hour"))
            calender.add(Calendar.HOUR, -1 * Integer.parseInt(dateRanges.split("h")[0]));
        else if(dateRanges.contains("minute"))
            calender.add(Calendar.MINUTE, -1 * Integer.parseInt(dateRanges.split("m")[0]));
        else if(dateRanges.contains("second"))
            calender.add(Calendar.SECOND, -1 * Integer.parseInt(dateRanges.split("s")[0]));

        System.out.println("-----------" + calender.getTime().toString());
        String beginDateTime=simpleDateFormat.format(calender.getTime());
        System.out.println("==============" + simpleDateFormat.format(calender.getTime()));
//        return calender.getTime().toString();
        return beginDateTime;
    }



    public static String  getTimeAfter (String endTime,String dateRanges) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date endDate = simpleDateFormat.parse(endTime);//selectQuery.getString(endtime)
        Calendar calender = Calendar.getInstance();
        calender.setTime(endDate);
        if(dateRanges.contains("month"))
            calender.add(Calendar.MONTH, 1 * Integer.parseInt(dateRanges.split("m")[0]));
        else if(dateRanges.contains("year"))
            calender.add(Calendar.YEAR, 1 * Integer.parseInt(dateRanges.split("y")[0]));
        else if(dateRanges.contains("day"))
            calender.add(Calendar.DATE, 1 * Integer.parseInt(dateRanges.split("d")[0]));
        else if(dateRanges.contains("hour"))
            calender.add(Calendar.HOUR, 1 * Integer.parseInt(dateRanges.split("h")[0]));
        else if(dateRanges.contains("minute"))
            calender.add(Calendar.MINUTE, 1 * Integer.parseInt(dateRanges.split("m")[0]));
        else if(dateRanges.contains("second"))
            calender.add(Calendar.SECOND, 1 * Integer.parseInt(dateRanges.split("s")[0]));

        System.out.println("-----------" + calender.getTime().toString());
        String beginDateTime=simpleDateFormat.format(calender.getTime());
        System.out.println("==============" + simpleDateFormat.format(calender.getTime()));
        return beginDateTime;
    }

    public static String calculateStartDate(String endTime,String calculateOffset,boolean before ){
        String startDate = null;
        try {
            if(before){
                startDate = getTimeBefore(endTime, calculateOffset);
            }else{
                startDate = getTimeAfter(endTime, calculateOffset);
            }
            System.out.println("startDate is :" + startDate);
        } catch (ParseException e) {
            System.out.println("parse Error");
        }
        System.out.println("startDate is :" + startDate);
        return startDate;
    }

}
