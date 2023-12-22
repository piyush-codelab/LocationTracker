package com.task.locationtracker;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.button.MaterialButton;

public class EraseActivity extends AppCompatActivity {
    ImageView back;
    MaterialButton serviceBtn;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_erase);
       serviceBtn = (MaterialButton) findViewById(R.id.serviceBtn);
       back = (ImageView) findViewById(R.id.back);
       serviceBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EraseActivity.this.showAlertDialog();
            }
        });
       back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EraseActivity.this.onBackPressed();
            }
        });
    }

    /* access modifiers changed from: private */
    public void showAlertDialog() {
        View inflate = getLayoutInflater().inflate(R.layout.dlg_erase_dev, (ViewGroup) null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(inflate);
        final AlertDialog create = builder.create();
        ((Button) inflate.findViewById(R.id.enable)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                create.dismiss();
            }
        });
        ((Button) inflate.findViewById(R.id.cancel)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                create.dismiss();
            }
        });
        create.show();
    }

    public void onBackPressed() {
        super.onBackPressed();
    }
}
