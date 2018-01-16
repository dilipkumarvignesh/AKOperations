package iskconbangalore.org.akshayapatraoperations;

import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements LocationListener,View.OnClickListener {

    ArrayList<SchoolData> schools = new ArrayList<>();
    ArrayAdapter<String> spinnerAdapter;
    private LocationManager locationManager;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // dbOperations.writeDate();
        dbOperations dbO = new dbOperations();

//        ArrayList<String> list = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.Routes)));
//        spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
//        // spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(spinnerAdapter);

        next = (Button)findViewById(R.id.next);
        next.setOnClickListener(this);
     //   getRouteData();
      //  Log.d("info", "RouteData" + routes);


    }

    @Override
    public void onClick(View view){
        switch (view.getId()) {
            case R.id.next:
            {
                Spinner RouteSpinner = (Spinner) findViewById(R.id.RouteSpinner);
                Spinner LocationSpinner = (Spinner) findViewById(R.id.Locationspinner);
                String RouteValue = RouteSpinner.getSelectedItem().toString();
                String LocationValue = LocationSpinner.getSelectedItem().toString();

                goToDeliveryActivity(RouteValue,LocationValue);
            }


        }
    }

    public void goToDeliveryActivity(String RouteValue,String LocationValue)
    {
        Intent k = new Intent(getApplicationContext(),DelActivity.class);
        k.putExtra("Route",RouteValue);
        k.putExtra("Location",LocationValue);
        startActivity(k);

    }

    private boolean isLocationEnabled() {
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) ||
                locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
    }

//    private void showAlert() {
//        final AlertDialog.Builder dialog = new AlertDialog.Builder(this);
//        dialog.setTitle("Enable Location")
//                .setMessage("Your Locations Settings is set to 'Off'.\nPlease Enable Location to " +
//                        "use this app")
//                .setPositiveButton("Location Settings", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
//                        Intent myIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
//                        startActivity(myIntent);
//                    }
//                })
//                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface paramDialogInterface, int paramInt) {
//                    }
//                });
//        dialog.show();
//    }

    @Override
    public void onLocationChanged(Location location) {

        String msg = "New Latitude: " + location.getLatitude()
                + "New Longitude: " + location.getLongitude();

        Toast.makeText(getBaseContext(), msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onProviderDisabled(String provider) {

        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        startActivity(intent);
        Toast.makeText(getBaseContext(), "Gps is turned off!! ",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onProviderEnabled(String provider) {

        Toast.makeText(getBaseContext(), "Gps is turned on!! ",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        // TODO Auto-generated method stub

    }



}