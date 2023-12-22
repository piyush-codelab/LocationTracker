package com.task.locationtracker.fragments;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.task.locationtracker.AntiPocket;
import com.task.locationtracker.NearByPlace;
import com.task.locationtracker.R;
import com.task.locationtracker.RingActivity;

public class FragmentMore extends Fragment {
    private Sensor accelerometer;
    public CardView antiPocket;
    private boolean isMotionDetectionStarted = false;
    public ConstraintLayout layout01;
    private MediaPlayer mediaPlayer;
    public CardView nearByPlaces;
    public CardView ringPhone;
    private SensorManager sensorManager;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_more, viewGroup, false);
        ((CardView) inflate.findViewById(R.id.ringPhone)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FragmentMore.this.startActivity(new Intent(FragmentMore.this.getContext(), RingActivity.class));
            }
        });
        ((CardView) inflate.findViewById(R.id.antiPocket)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FragmentMore.this.startActivity(new Intent(FragmentMore.this.getActivity(), AntiPocket.class));
            }
        });
        ((CardView) inflate.findViewById(R.id.nearByPlaces)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FragmentMore.this.startActivity(new Intent(FragmentMore.this.getActivity(), NearByPlace.class));
            }
        });
        return inflate;
    }
}
