package com.task.locationtracker;

import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

public class NearByPlace extends AppCompatActivity {
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;
    ImageView back;
    ImageView busStop;
    private FusedLocationProviderClient fusedLocationClient;
    ImageView imageAirport;
    ImageView imageAtm;
    ImageView imageBank;
    ImageView imageCafe;
    ImageView imageGym;
    ImageView imageHospital;
    ImageView imageMeuseum;
    ImageView imageMosque;
    ImageView imagePark;
    ImageView imagePolice;
    ImageView imagePump;
    ImageView imageResturant;
    ImageView imageSaloon;
    ImageView imageSchool;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_near_by_place);
        this.imageAtm = (ImageView) findViewById(R.id.imageAtm);
        this.imageAirport = (ImageView) findViewById(R.id.imageAirport);
        this.imageBank = (ImageView) findViewById(R.id.imageBank);
        this.busStop = (ImageView) findViewById(R.id.busStop);
        this.imageCafe = (ImageView) findViewById(R.id.imageCafe);
        this.imageGym = (ImageView) findViewById(R.id.imageGym);
        this.imageHospital = (ImageView) findViewById(R.id.imageHospital);
        this.imageMeuseum = (ImageView) findViewById(R.id.imageMeuseum);
        this.imageMosque = (ImageView) findViewById(R.id.imageMosque);
        this.imagePolice = (ImageView) findViewById(R.id.imagePolice);
        this.imagePump = (ImageView) findViewById(R.id.imagePump);
        this.imagePark = (ImageView) findViewById(R.id.imagePark);
        this.imageResturant = (ImageView) findViewById(R.id.imageResturant);
        this.imageSchool = (ImageView) findViewById(R.id.imageSchool);
        this.imageSaloon = (ImageView) findViewById(R.id.imageSaloon);
        this.back = (ImageView) findViewById(R.id.back);
        this.fusedLocationClient = LocationServices.getFusedLocationProviderClient((Activity) this);
        this.back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                NearByPlace.this.onBackPressed();
            }
        });
        this.imageAtm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:0,0?q=ATM"));
                intent.setPackage("com.google.android.apps.maps");
                if (intent.resolveActivity(NearByPlace.this.getPackageManager()) != null) {
                    NearByPlace.this.startActivity(intent);
                    return;
                }
                NearByPlace.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.google.com/maps/search/nearby+places")));
            }
        });
        this.imageAirport.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:0,0?q=airport"));
                intent.setPackage("com.google.android.apps.maps");
                if (intent.resolveActivity(NearByPlace.this.getPackageManager()) != null) {
                    NearByPlace.this.startActivity(intent);
                    return;
                }
                NearByPlace.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.google.com/maps/search/nearby+places")));
            }
        });
        this.imageBank.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:0,0?q=banks"));
                intent.setPackage("com.google.android.apps.maps");
                if (intent.resolveActivity(NearByPlace.this.getPackageManager()) != null) {
                    NearByPlace.this.startActivity(intent);
                    return;
                }
                NearByPlace.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.google.com/maps/search/nearby+places")));
            }
        });
        this.busStop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:0,0?q=bus+stops"));
                intent.setPackage("com.google.android.apps.maps");
                if (intent.resolveActivity(NearByPlace.this.getPackageManager()) != null) {
                    NearByPlace.this.startActivity(intent);
                    return;
                }
                NearByPlace.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.google.com/maps/search/nearby+places")));
            }
        });
        this.imageCafe.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:0,0?q=cafe"));
                intent.setPackage("com.google.android.apps.maps");
                if (intent.resolveActivity(NearByPlace.this.getPackageManager()) != null) {
                    NearByPlace.this.startActivity(intent);
                    return;
                }
                NearByPlace.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.google.com/maps/search/nearby+places")));
            }
        });
        this.imageGym.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:0,0?q=gyms"));
                intent.setPackage("com.google.android.apps.maps");
                if (intent.resolveActivity(NearByPlace.this.getPackageManager()) != null) {
                    NearByPlace.this.startActivity(intent);
                    return;
                }
                NearByPlace.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.google.com/maps/search/nearby+places")));
            }
        });
        this.imageHospital.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:0,0?q=hospitals"));
                intent.setPackage("com.google.android.apps.maps");
                if (intent.resolveActivity(NearByPlace.this.getPackageManager()) != null) {
                    NearByPlace.this.startActivity(intent);
                    return;
                }
                NearByPlace.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.google.com/maps/search/nearby+places")));
            }
        });
        this.imageMeuseum.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:0,0?q=museum"));
                intent.setPackage("com.google.android.apps.maps");
                if (intent.resolveActivity(NearByPlace.this.getPackageManager()) != null) {
                    NearByPlace.this.startActivity(intent);
                    return;
                }
                NearByPlace.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.google.com/maps/search/nearby+places")));
            }
        });
        this.imageMosque.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:0,0?q=mosque"));
                intent.setPackage("com.google.android.apps.maps");
                if (intent.resolveActivity(NearByPlace.this.getPackageManager()) != null) {
                    NearByPlace.this.startActivity(intent);
                    return;
                }
                NearByPlace.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.google.com/maps/search/nearby+places")));
            }
        });
        this.imagePolice.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:0,0?q=police+station"));
                intent.setPackage("com.google.android.apps.maps");
                if (intent.resolveActivity(NearByPlace.this.getPackageManager()) != null) {
                    NearByPlace.this.startActivity(intent);
                    return;
                }
                NearByPlace.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.google.com/maps/search/nearby+places")));
            }
        });
        this.imagePump.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:0,0?q=gas+station"));
                intent.setPackage("com.google.android.apps.maps");
                if (intent.resolveActivity(NearByPlace.this.getPackageManager()) != null) {
                    NearByPlace.this.startActivity(intent);
                    return;
                }
                NearByPlace.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.google.com/maps/search/nearby+places")));
            }
        });
        this.imagePark.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:0,0?q=park"));
                intent.setPackage("com.google.android.apps.maps");
                if (intent.resolveActivity(NearByPlace.this.getPackageManager()) != null) {
                    NearByPlace.this.startActivity(intent);
                    return;
                }
                NearByPlace.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.google.com/maps/search/nearby+places")));
            }
        });
        this.imageResturant.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:0,0?q=restaurant"));
                intent.setPackage("com.google.android.apps.maps");
                if (intent.resolveActivity(NearByPlace.this.getPackageManager()) != null) {
                    NearByPlace.this.startActivity(intent);
                    return;
                }
                NearByPlace.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.google.com/maps/search/nearby+places")));
            }
        });
        this.imageSchool.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:0,0?q=schools"));
                intent.setPackage("com.google.android.apps.maps");
                if (intent.resolveActivity(NearByPlace.this.getPackageManager()) != null) {
                    NearByPlace.this.startActivity(intent);
                    return;
                }
                NearByPlace.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.google.com/maps/search/nearby+places")));
            }
        });
        this.imageSaloon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:0,0?q=salon"));
                intent.setPackage("com.google.android.apps.maps");
                if (intent.resolveActivity(NearByPlace.this.getPackageManager()) != null) {
                    NearByPlace.this.startActivity(intent);
                    return;
                }
                NearByPlace.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.google.com/maps/search/nearby+places")));
            }
        });
    }

    private boolean checkLocationPermission() {
        return ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0;
    }

    private void requestLocationPermission() {
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 1);
    }

    private void getLastKnownLocation() {
        if (ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0 || ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            this.fusedLocationClient.getLastLocation().addOnSuccessListener((Activity) this, new OnSuccessListener<Location>() {
                public void onSuccess(Location location) {
                    if (location != null) {
                        double latitude = location.getLatitude();
                        NearByPlace.this.showToast("Current Location: " + latitude + ", " + location.getLongitude());
                        return;
                    }
                    NearByPlace.this.showToast("Location not available");
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void showToast(String str) {
        Toast.makeText(this, str, 0).show();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i != 1) {
            return;
        }
        if (iArr.length <= 0 || iArr[0] != 0) {
            showToast("Location permission denied");
        } else {
            getLastKnownLocation();
        }
    }

    private final void openMap(String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:0,0?q=" + str));
        intent.setPackage("com.google.android.apps.maps");
        try {
            startActivity(intent);
        } catch (Exception unused) {
            System.out.println("Not Found");
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
    }
}
