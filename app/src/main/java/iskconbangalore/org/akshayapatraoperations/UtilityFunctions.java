package iskconbangalore.org.akshayapatraoperations;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Created by i308830 on 1/10/18.
 */

public class UtilityFunctions {



public static String getDate()
{
    SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
    Date now = new Date();
    String strDate = sdfDate.format(now);
    return strDate;

}

public static String getTime()
{

    String time = "";
    SimpleDateFormat currentTime = new SimpleDateFormat(" HH:mm:ss");
    Date now = new Date();
    String formattedDate = currentTime.format(now);
    return formattedDate;

}

}
