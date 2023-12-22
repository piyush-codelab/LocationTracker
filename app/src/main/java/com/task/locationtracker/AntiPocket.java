package com.task.locationtracker;

import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import com.google.android.material.button.MaterialButton;

public class AntiPocket extends AppCompatActivity {
    public TextView ToolbarTitle;
    public MaterialButton activateBtn;
    public LinearLayout activateLayout;
    public ImageView back;
    public MaterialButton deactivateBtn;
    public LinearLayout deactivateLayout;
    public SwitchCompat flashLightAntiPocket;
    private LinearLayout rootView;
    Boolean state = false;
    public TextView textview02;
    public LinearLayout topLayout;
    public SwitchCompat vibrationAntiPocket;
    /* access modifiers changed from: private */
    public Vibrator vibrator;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_anti_pocket);
      activateBtn = (MaterialButton) findViewById(R.id.activateBtn);
      back = (ImageView) findViewById(R.id.back);
      flashLightAntiPocket = (SwitchCompat) findViewById(R.id.flashLightAntiPocket);
      vibrationAntiPocket = (SwitchCompat) findViewById(R.id.vibrationAntiPocket);
      vibrator = (Vibrator) getSystemService("vibrator");
      flashLightAntiPocket.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                   runFlashLight();
                }
            }
        });
      vibrationAntiPocket.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
               vibrator.vibrate(1000);
                Toast.makeText(AntiPocket.this, "vibrating", 0).show();
            }
        });
      back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
               onBackPressed();
            }
        });
      activateBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            }
        });
    }

    /* access modifiers changed from: private */
    public void runFlashLight() {
      flashLightAntiPocket.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!AntiPocket.this.state.booleanValue()) {
                    CameraManager cameraManager = (CameraManager)getSystemService("camera");
                    try {
                        cameraManager.setTorchMode(cameraManager.getCameraIdList()[0], true);
                       state = true;
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    CameraManager cameraManager2 = (CameraManager)getSystemService("camera");
                    try {
                        cameraManager2.setTorchMode(cameraManager2.getCameraIdList()[0], false);
                       state = false;
                    } catch (Exception e2) {
                        throw new RuntimeException(e2);
                    }
                }
            }
        });
    }

    public void onBackPressed() {
        super.onBackPressed();
    }
}
