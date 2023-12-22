package com.task.locationtracker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;
import com.task.locationtracker.service.WhistleDetectionService;

public class ClapActivity extends AppCompatActivity {
    MaterialButton activateBtn;
    LinearLayout activateLayout;
    ImageView back;
    MaterialButton deactivateBtn;
    LinearLayout deactivateLayout;
    private BroadcastReceiver receiver;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_clap);
       deactivateLayout = (LinearLayout) findViewById(R.id.deactivateLayout);
       activateLayout = (LinearLayout) findViewById(R.id.activateLayout);
       activateBtn = (MaterialButton) findViewById(R.id.activateBtn);
       deactivateBtn = (MaterialButton) findViewById(R.id.deactivateBtn);
        ImageView imageView = (ImageView) findViewById(R.id.back);
       back = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
               onBackPressed();
            }
        });
       activateBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
               updateButtonColor();
            }
        });
       receiver = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
            }
        };
        registerReceiver(this.receiver, new IntentFilter("WHISTLE_SERVICE_COMPLETE"));
       deactivateBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
               stopService(new Intent(ClapActivity.this, WhistleDetectionService.class));
            }
        });
    }

    /* access modifiers changed from: private */
    public void updateButtonColor() {
       deactivateLayout.setVisibility(0);
       activateLayout.setVisibility(8);
        startWhistleService();
    }

    private void startWhistleService() {
        startService(new Intent(this, WhistleDetectionService.class));
    }

    public void onBackPressed() {
        super.onBackPressed();
    }
}
