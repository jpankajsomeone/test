import java.util.*;
import java.text.*;

public class Example {
    public static void main(String[] args) {
        String str_date = "07 26 2011"; // Get this from the user
        SimpleDateFormat format = new SimpleDateFormat("MM dd yyyy");
        GregorianCalendar cal = new GregorianCalendar();
        Date date = new Date();
        try {
            date = format.parse(str_date);
        } catch(ParseException e) { /* Handle Parse errors */ }
 
        cal.setTime(date);
 
        System.out.println(cal.get(GregorianCalendar.DAY_OF_WEEK));
    }
}               
