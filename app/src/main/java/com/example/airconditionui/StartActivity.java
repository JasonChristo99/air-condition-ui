package com.example.airconditionui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import com.example.airconditionui.models.OnOff;
import com.example.airconditionui.utils.ACOptionsUtil;
import com.example.airconditionui.views.MainActivity;
import com.example.airconditionui.views.dialogs.PowerOnDialog;

/* The first activity from where we can start the AC device */
public class StartActivity extends AppCompatActivity {

    Button powerOnBtn, exitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        powerOnBtn = findViewById(R.id.powerOnBtn);
        exitBtn = findViewById(R.id.exitBtn);

        powerOnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPowerOnPressed();
            }
        });

        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onExitPressed();
            }
        });
    }

    private void onExitPressed() {
        // TODO message "Are you sure you want to exit?"
        finish();
        System.exit(0);
    }

    private void onPowerOnPressed() {
        // power the device on
        ACOptionsUtil.getInstance(this).setPower(OnOff.ON);
        // show dummy progress bar
        final PowerOnDialog powerOnDialog = new PowerOnDialog(this);
        powerOnDialog.startDialog();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                powerOnDialog.dismissDialog();
                // change screen
                Intent intent = new Intent(StartActivity.this, MainActivity.class);
                startActivity(intent);
            }
        }, 1500); // milliseconds delay
    }
}
