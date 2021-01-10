package Class9;

import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Date_Complete {
    @Test
    public void DateComplete() throws InterruptedException {
        /*
            Date
            Calendar
         */


        Date now = new Date();  // current timestamp
        System.out.println(now);

        // Thread.sleep(5000);

        // Date now2 = new Date();
        // System.out.println(now2);

        // to extract the fields from the date object in specific format
        // return type of format method is String
        SimpleDateFormat df = new SimpleDateFormat("dd-MMMM yyyy HH/hh:mm:ss:SS a z");
        /**
         *  current date -> 6 -> "d" -> 6
         *  current date -> 6 -> "dd" -> 06
         *
         *  current date -> 16 -> "d" -> 16
         *  current date -> 16 -> "dd" -> 16
         */
        String date = df.format(now);
        System.out.println(date);

        /**
         * MM - month in number (01, 02, ... etc)
         * MMM - month in abbreviation (Jan, Feb, ...)
         * MMMM - Full month name
         */

        // convert String into Date object OR convert String into Date
        String myDate = "Mar 31, 2020";
        SimpleDateFormat makeDate = new SimpleDateFormat("MMM dd, yyyy");
        Date convertedDate = null;
        try {
            convertedDate = makeDate.parse(myDate);    // create Date using String
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(convertedDate);  // March 31, 2020

        boolean isEqual = now.equals(convertedDate);    // false
        boolean isAfter = now.after(convertedDate);   // true
        boolean isBefore = now.before(convertedDate);  // false

        System.out.println(isEqual);
        System.out.println(isAfter);
        System.out.println(isBefore);

        /**
         * Calendar
         */

        Calendar cal = Calendar.getInstance();
        System.out.println(cal);
        Date dateObject = cal.getTime();
        System.out.println(dateObject);

        // create Calendar Instance using Date object (convertedDate)
        // cal.setTime(convertedDate);
        // System.out.println(cal.getTime());

        // Add days etc
        cal.add(Calendar.DATE, -5);
        System.out.println(cal.getTime());

        cal.add(Calendar.MONTH, 4);
        System.out.println(cal.getTime());

    }
}
