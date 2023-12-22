package com.task.locationtracker;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class RouteFinder extends AppCompatActivity {
    ImageView back;
    CardView cardFindRoute;
    private EditText destLatEditText;
    private EditText destLngEditText;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_route_finder);
       destLatEditText = (EditText) findViewById(R.id.destLatEditText);
       destLngEditText = (EditText) findViewById(R.id.destLngEditText);
       cardFindRoute = (CardView) findViewById(R.id.cardFindRoute);
        ImageView imageView = (ImageView) findViewById(R.id.back);
       back = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                RouteFinder.this.onBackPressed();
            }
        });
       cardFindRoute.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                RouteFinder.this.startNavigation();
            }
        });
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    /* access modifiers changed from: private */
    public void startNavigation() {
        String obj =destLatEditText.getText().toString();
        String obj2 =destLngEditText.getText().toString();
        if (obj.isEmpty() || obj2.isEmpty()) {
           destLatEditText.setError("Enter destination latitude");
           destLngEditText.setError("Enter destination longitude");
            return;
        }
        String copyValueOf = String.copyValueOf(obj.toCharArray());
        String copyValueOf2 = String.copyValueOf(obj2.toCharArray());
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("google.navigation:q=" + copyValueOf + "," + copyValueOf2 + "&mode=d"));
        intent.setPackage("com.google.android.apps.maps");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://www.google.com/maps/dir/?api=1&destination=" + copyValueOf + "," + copyValueOf2)));
        }
    }
}
