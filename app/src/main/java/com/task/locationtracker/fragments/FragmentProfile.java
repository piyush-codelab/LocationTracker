package com.task.locationtracker.fragments;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.task.locationtracker.R;
import com.task.locationtracker.SplashScreen;

public class FragmentProfile extends Fragment {
    private static final String KEY_LOGGED_IN = "loggedIn";
    private static final String PREFS_FILENAME = "com.example.myapp.prefs";
    Button deleteAccount;
    TextView email;
    GoogleSignInClient gsc;
    GoogleSignInOptions gso;
    Button logout;
    TextView name;
    TextView wel;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_profile, viewGroup, false);
        this.name = (TextView) inflate.findViewById(R.id.name);
        this.email = (TextView) inflate.findViewById(R.id.email);
        this.logout = (Button) inflate.findViewById(R.id.logout);
        this.deleteAccount = (Button) inflate.findViewById(R.id.deleteAccount);
        this.gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        this.gsc = GoogleSignIn.getClient(getContext(), this.gso);
        GoogleSignInAccount lastSignedInAccount = GoogleSignIn.getLastSignedInAccount(getContext());
        if (lastSignedInAccount != null) {
            String displayName = lastSignedInAccount.getDisplayName();
            String email2 = lastSignedInAccount.getEmail();
            this.name.setText(displayName);
            this.email.setText(email2);
        }
        this.logout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FragmentProfile.this.Signout();
                FragmentProfile.this.markLoggedOut();
            }
        });
        this.deleteAccount.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FragmentProfile.this.DeleteAccount();
            }
        });
        return inflate;
    }

    /* access modifiers changed from: private */
    public void DeleteAccount() {
        this.gsc.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
            public void onComplete(Task<Void> task) {
                FragmentProfile.this.showAlertDialog1();
            }
        });
    }

    /* access modifiers changed from: private */
    public void showAlertDialog1() {
        new AlertDialog.Builder(getContext()).setTitle("DELETE ACCOUNT").setMessage("Are you sure want to DELETE out ?").setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                FragmentProfile.this.startActivity(new Intent(FragmentProfile.this.getContext(), SplashScreen.class));
                dialogInterface.dismiss();
            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).show();
    }

    /* access modifiers changed from: private */
    public void Signout() {
        this.gsc.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
            public void onComplete(Task<Void> task) {
                FragmentProfile.this.showAlertDialog();
            }
        });
    }

    /* access modifiers changed from: private */
    public void showAlertDialog() {
        new AlertDialog.Builder(getContext()).setTitle("Sign-Out").setMessage("Are you sure want to sign out ?").setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                FragmentProfile.this.startActivity(new Intent(FragmentProfile.this.getContext(), SplashScreen.class));
                dialogInterface.dismiss();
            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).show();
    }

    /* access modifiers changed from: private */
    public void markLoggedOut() {
        SharedPreferences.Editor edit = getContext().getSharedPreferences(PREFS_FILENAME, 0).edit();
        edit.putBoolean(KEY_LOGGED_IN, false);
        edit.apply();
    }
}
