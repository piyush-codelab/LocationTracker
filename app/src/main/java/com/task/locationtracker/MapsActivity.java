package com.task.locationtracker;

import android.location.Location;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.media3.common.C;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.task.locationtracker.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private static final int Request_code = 101;
    private ActivityMapsBinding binding;
    private FusedLocationProviderClient fusedLocationProviderClient;
    /* access modifiers changed from: private */
    public double lang;
    /* access modifiers changed from: private */
    public double lat;
    /* access modifiers changed from: private */
    public GoogleMap mMap;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityMapsBinding inflate = ActivityMapsBinding.inflate(getLayoutInflater());
        this.binding = inflate;
        setContentView((View) inflate.getRoot());
        this.fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(getApplicationContext());
        ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMapAsync(this);
    }

    public void onMapReady(GoogleMap googleMap) {
        this.mMap = googleMap;
        getCurrentLocation();
    }

    private void getCurrentLocation() {
        if (ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0 || ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            new LocationRequest();
            LocationRequest create = LocationRequest.create();
            create.setInterval(60000);
            create.setPriority(100);
            create.setFastestInterval(C.DEFAULT_SEEK_BACK_INCREMENT_MS);
            this.fusedLocationProviderClient.requestLocationUpdates(create, (LocationCallback) new LocationCallback() {
                public void onLocationResult(LocationResult locationResult) {
                    Toast.makeText(MapsActivity.this, "location result is =" + locationResult, 0).show();
                    if (locationResult == null) {
                        Toast.makeText(MapsActivity.this.getApplicationContext(), "current locaion is null", 0).show();
                    }
                    for (Location location : locationResult.getLocations()) {
                        if (location != null) {
                            Toast.makeText(MapsActivity.this, "current location is ", 0).show();
                        }
                    }
                }
            }, (Looper) null);
            this.fusedLocationProviderClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
                public void onSuccess(Location location) {
                    if (location != null) {
                        double unused = MapsActivity.this.lat = location.getLatitude();
                        double unused2 = MapsActivity.this.lang = location.getLongitude();
                        LatLng latLng = new LatLng(MapsActivity.this.lat, MapsActivity.this.lang);
                      mMap.addMarker(new MarkerOptions().position(latLng).title("current location"));
                      mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                      mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15.0f));
                    }
                }
            });
            return;
        }
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 101);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (iArr.length > 0 && iArr[0] == 0) {
            getCurrentLocation();
        }
    }
}
