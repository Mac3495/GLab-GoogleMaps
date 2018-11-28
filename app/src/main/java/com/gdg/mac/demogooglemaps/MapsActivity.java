package com.gdg.mac.demogooglemaps;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Marker m1, m2, m3, m4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);



    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-16.5012931, -68.1335255);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15));



        LatLng latLng1 = new LatLng(-16.5048825, -68.1304174);
        LatLng latLng2 = new LatLng(-16.5160369, -68.1287711);
        LatLng latLng3 = new LatLng(-16.5305552, -68.1092709);
        LatLng latLng4 = new LatLng(-16.50234, -68.13259);



        m1 = mMap.addMarker(new MarkerOptions().position(latLng1).title("Umsa").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
        m2 = mMap.addMarker(new MarkerOptions().position(latLng2).title("Sopocachi").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
        m3 = mMap.addMarker(new MarkerOptions().position(latLng3).title("Obrajes").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        m4 = mMap.addMarker(new MarkerOptions().position(latLng4).title("Prado").icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher1)));

        PolylineOptions polylineOptions = new PolylineOptions();
        polylineOptions.add(latLng1);
        polylineOptions.add(latLng2);
        polylineOptions.add(latLng3);

        Polyline polyline = mMap.addPolyline(polylineOptions);



        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {

                Toast.makeText(getApplicationContext(), marker.getTitle(), Toast.LENGTH_SHORT).show();

                switch (marker.getTitle()){
                    case "Umsa":
                        Toast.makeText(getApplicationContext(), marker.getTitle(), Toast.LENGTH_SHORT).show();
                        break;
                }

                return false;
            }
        });
    }

}








