package com.task.locationtracker.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.google.android.material.button.MaterialButton;
import com.task.locationtracker.ClapActivity;
import com.task.locationtracker.R;
import com.task.locationtracker.WhistleActivity;

public class OfflineFragment extends Fragment {
    MaterialButton clap;
    MaterialButton whistle;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_offline, viewGroup, false);
        this.whistle = (MaterialButton) inflate.findViewById(R.id.whistle);
        MaterialButton materialButton = (MaterialButton) inflate.findViewById(R.id.clap);
        this.clap = materialButton;
        materialButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                OfflineFragment.this.startActivity(new Intent(OfflineFragment.this.getActivity(), ClapActivity.class));
            }
        });
        this.whistle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                OfflineFragment.this.startActivity(new Intent(OfflineFragment.this.getActivity(), WhistleActivity.class));
            }
        });
        return inflate;
    }
}
