package com.task.locationtracker;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.auth.api.signin.GoogleSignIn;

public class SplashScreen extends AppCompatActivity {
    private static final String PREFS_FILENAME = "com.example.myapp.prefs";

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_splash_screen);
        new Thread() {
            public void run() {
                try {
                    sleep(2000);
                    SplashScreen.this.checkUserAuthentication();
                } catch (Exception unused) {
                }
            }
        }.start();
    }

    /* access modifiers changed from: private */
    public void checkUserAuthentication() {
        if (GoogleSignIn.getLastSignedInAccount(this) != null) {
            startMainActivity();
        } else {
            startLoginActivity();
        }
        finish();
    }

    private void startLoginActivity() {
        startActivity(new Intent(this, LoginActivy.class));
    }

    private void startMainActivity() {
        startActivity(new Intent(this, DashboardActivity.class));
    }
}
