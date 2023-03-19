package com.example.login;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.example.login.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.login.databinding.ActivityMapsBinding;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    ArrayList<LatLng>arrayList = new ArrayList<LatLng>();
    LatLng currLoc = new LatLng(-6.222558, 106.649024);
    LatLng livingworld = new LatLng(-6.243690, 106.654113);
    LatLng alamsutera = new LatLng(-6.221847, 106.654777);
    LatLng pik = new LatLng(-6.090759, 106.744608);
    LatLng puri = new LatLng(-6.187219, 106.739072);
    LatLng centralpark = new LatLng(-6.176849, 106.789827);
    LatLng aeonmall = new LatLng(-6.304942, 106.644360);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        arrayList.add(currLoc);
        arrayList.add(livingworld);
        arrayList.add(alamsutera);
        arrayList.add(pik);
        arrayList.add(puri);
        arrayList.add(centralpark);
        arrayList.add(aeonmall);

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
        for (int i=0; i<arrayList.size(); i++){
            mMap.addMarker(new MarkerOptions().position(arrayList.get(i)).title("Rewaste"));
            mMap.animateCamera(CameraUpdateFactory.zoomTo(15.0f));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(arrayList.get(i)));
        }

    }
}