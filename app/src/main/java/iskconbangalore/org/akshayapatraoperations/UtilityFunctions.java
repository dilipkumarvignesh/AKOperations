package iskconbangalore.org.akshayapatraoperations;

import android.app.ProgressDialog;
import android.content.Context;

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

    SimpleDateFormat currentTime = new SimpleDateFormat(" HH:mm:ss");
    Date now = new Date();
    String formattedDate = currentTime.format(now);
    return formattedDate;

}

public static void showLoader(Context ctxt)
{


    ProgressDialog progress = new ProgressDialog(ctxt);
    progress.setTitle("Loading");
    progress.setMessage("Wait while loading...");
    progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
    progress.show();
}


}
