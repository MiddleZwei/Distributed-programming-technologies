package utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateComparator {

    public static boolean areDatesEqual(Date one, Date two) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(one).equals(dateFormat.format(two));
    }


}
