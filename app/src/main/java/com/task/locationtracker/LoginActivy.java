package com.task.locationtracker;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;

public class LoginActivy extends AppCompatActivity {
    private static final String KEY_LOGGED_IN = "loggedIn";
    private static final String PREFS_FILENAME = "com.example.myapp.prefs";
    ImageView buttonLogin;
    GoogleSignInClient gsc;
    GoogleSignInOptions gso;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_login_activy);
        this.buttonLogin = (ImageView) findViewById(R.id.buttonLogin);
        GoogleSignInOptions build = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        this.gso = build;
        this.gsc = GoogleSignIn.getClient((Activity) this, build);
        this.buttonLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                LoginActivy.this.SignIn();
                LoginActivy.this.markLoggedIn();
            }
        });
    }

    /* access modifiers changed from: private */
    public void markLoggedIn() {
        SharedPreferences.Editor edit = getSharedPreferences(PREFS_FILENAME, 0).edit();
        edit.putBoolean(KEY_LOGGED_IN, true);
        edit.apply();
    }

    /* access modifiers changed from: private */
    public void SignIn() {
        startActivityForResult(this.gsc.getSignInIntent(), 100);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100) {
            try {
                GoogleSignIn.getSignedInAccountFromIntent(intent).getResult(ApiException.class);
                HomeActivity();
            } catch (ApiException e) {
                e.printStackTrace();
                Log.e("ContentValues", "Google Sign-In failed: " + i);
                Toast.makeText(this, "Error", 0).show();
            }
        }
    }

    private void HomeActivity() {
        finish();
        startActivity(new Intent(getApplicationContext(), DashboardActivity.class));
    }
}
