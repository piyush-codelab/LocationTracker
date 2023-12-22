package com.task.locationtracker.fragments;

import android.content.Intent;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import com.task.locationtracker.EraseActivity;
import com.task.locationtracker.MapsActivity;
import com.task.locationtracker.R;
import com.task.locationtracker.RouteFinder;

public class HomeFragment extends Fragment {
    CardView erasePhone;
    CardView flashLight;
    CardView locationCardView;
    CardView lockPhone;
    CardView routeFinder;
    Boolean state = false;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_homefragment, viewGroup, false);
        this.lockPhone = (CardView) inflate.findViewById(R.id.lockPhone);
        this.routeFinder = (CardView) inflate.findViewById(R.id.routeFinder);
        this.locationCardView = (CardView) inflate.findViewById(R.id.locationCardView);
        this.flashLight = (CardView) inflate.findViewById(R.id.flashLight);
        this.erasePhone = (CardView) inflate.findViewById(R.id.erasePhone);
        this.flashLight.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!HomeFragment.this.state.booleanValue()) {
                    CameraManager cameraManager = (CameraManager) HomeFragment.this.requireActivity().getSystemService("camera");
                    try {
                        cameraManager.setTorchMode(cameraManager.getCameraIdList()[0], true);
                        HomeFragment.this.state = true;
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    CameraManager cameraManager2 = (CameraManager) HomeFragment.this.requireActivity().getSystemService("camera");
                    try {
                        cameraManager2.setTorchMode(cameraManager2.getCameraIdList()[0], false);
                        HomeFragment.this.state = false;
                    } catch (Exception e2) {
                        throw new RuntimeException(e2);
                    }
                }
            }
        });
        this.erasePhone.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                HomeFragment.this.startActivity(new Intent(HomeFragment.this.getContext(), EraseActivity.class));
            }
        });
        this.routeFinder.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                HomeFragment.this.startActivity(new Intent(HomeFragment.this.getActivity(), RouteFinder.class));
            }
        });
        this.lockPhone.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                HomeFragment.this.openSecuritySettings();
            }
        });
        this.locationCardView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                HomeFragment.this.startActivity(new Intent(HomeFragment.this.getActivity(), MapsActivity.class));
            }
        });
        return inflate;
    }

    /* access modifiers changed from: private */
    public void openSecuritySettings() {
        startActivity(new Intent("android.settings.SECURITY_SETTINGS"));
    }
}
