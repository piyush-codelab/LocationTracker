package com.task.locationtracker;

import android.content.Intent;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;
import com.task.locationtracker.service.WhistleDetectionService;

public class WhistleActivity extends AppCompatActivity {
    private static final int REQUEST_RECORD_AUDIO_PERMISSION = 200;
    MaterialButton activateBtn;
    LinearLayout activateLayout;
    ImageView back;
    MaterialButton deactivateBtn;
    LinearLayout deactivateLayout;
    private MediaRecorder mediaRecorder;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_whistle);
        activateBtn = (MaterialButton) findViewById(R.id.activateBtn);
        activateLayout = (LinearLayout) findViewById(R.id.activateLayout);
        deactivateBtn = (MaterialButton) findViewById(R.id.deactivateBtn);
        deactivateLayout = (LinearLayout) findViewById(R.id.deactivateLayout);
        ImageView imageView = (ImageView) findViewById(R.id.back);
        back = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
              onBackPressed();
            }
        });
        activateBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
              deactivateLayout.setVisibility(0);
              activateLayout.setVisibility(8);
              startService(new Intent(WhistleActivity.this, WhistleDetectionService.class));
            }
        });
        deactivateBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
              stopService(new Intent(WhistleActivity.this, WhistleDetectionService.class));
            }
        });
    }

    public void onBackPressed() {
        super.onBackPressed();
    }
}
