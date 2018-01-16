package iskconbangalore.org.akshayapatraoperations;

import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by i308830 on 1/6/18.
 */

public class dbOperations {

    private DatabaseReference mDatabase;
    List<SchoolData> routes = new ArrayList<>();


    public void getSchoolData(String locationData)
    {
        DatabaseReference routes = FirebaseDatabase.getInstance().getReference(locationData);
    }
    public void writeRouteData()
    {
//        DatabaseReference routes = FirebaseDatabase.getInstance().getReference("");
//        RouteData route1 = new RouteData("1","ABC");
//        String key = routes.push().getKey();
//        routes.child(key).setValue(route1);

    }

    public static void writeDate(String Route,String School,String data)
    {
        String toDate = UtilityFunctions.getDate();
        String time = UtilityFunctions.getTime();
        Log.d("info","TimeValue:"+time);
        DatabaseReference todayDateNode = FirebaseDatabase.getInstance().getReference(toDate);
        todayDateNode.child(Route).child(School).setValue(new DeliveryOperation("12.433",time));

    }

}
