package com.kawal.learnlocation;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;

    private static final LatLng HAZUR_SAHIB = new LatLng(19.1528647,77.3164334);
    private static final LatLng DAMDAMA_SAHIB = new LatLng(29.9869579,75.0764301);
    private static final LatLng KESGARH_SAHIB = new LatLng(31.2351695,76.4967487);
    private static final LatLng PATNA_SAHIB = new LatLng(25.5962087,85.2278972);

    private Marker mHazurSahib;
    private Marker mDamdamaSahib;
    private Marker mKesgarhSahib;
    private Marker mPatnaSahib;

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

        List<Marker> markerList = new ArrayList<>();
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

        mHazurSahib = mMap.addMarker(new MarkerOptions().position(HAZUR_SAHIB).title("Hazur Sahib"));
        mHazurSahib.setTag(0);
        markerList.add(mHazurSahib);

        mDamdamaSahib = mMap.addMarker(new MarkerOptions().position(DAMDAMA_SAHIB).title("Damdama Sahib").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
        mHazurSahib.setTag(0);
        markerList.add(mDamdamaSahib);

        mKesgarhSahib = mMap.addMarker(new MarkerOptions().position(KESGARH_SAHIB).title("Kesgarh Sahib").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        mHazurSahib.setTag(0);
        markerList.add(mKesgarhSahib);

        mPatnaSahib = mMap.addMarker(new MarkerOptions().position(PATNA_SAHIB).title("Patna Sahib").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        mHazurSahib.setTag(0);
        markerList.add(mPatnaSahib);
        mMap.setOnMarkerClickListener(this);

        for (Marker m : markerList){
            Log.d("Marker:",m.getTitle());
            LatLng latLng = new LatLng(m.getPosition().latitude, m.getPosition().longitude);
            mMap.addMarker(new MarkerOptions().position(latLng));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,8));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,10));

        }



        // Add a marker in Sydney and move the camera
//        LatLng GoldenTemple = new LatLng(31.6123364,74.8851261);
//        LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(GoldenTemple).title("Marker in Golden Temple")
//        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));         //Change the color of marker
//
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(GoldenTemple));
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    @Override
    public boolean onMarkerClick(Marker marker) {

        Integer clickCount = (Integer) marker.getTag();
        if (clickCount != null){
            clickCount = clickCount+1;
            marker.setTag(clickCount);
//            Toast.makeText(this,marker.getTitle()+ "has been clicked",+clickCount+ "times"+ Toast.LENGTH_SHORT).show();

        }
        
        return false;
    }
}
