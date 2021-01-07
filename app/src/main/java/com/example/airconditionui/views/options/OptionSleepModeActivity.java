package com.example.airconditionui.views.options;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.airconditionui.R;
import com.example.airconditionui.models.OnOff;
import com.example.airconditionui.utils.ACOptionsUtil;

/* This activity presents options for the sleep-mode functionality */

public class OptionSleepModeActivity extends AppCompatActivity {
    Button onBtn, offBtn, backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_sleep_mode);
        onBtn = findViewById(R.id.onBtn);
        offBtn = findViewById(R.id.offBtn);
        backBtn = findViewById(R.id.optBackButton);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        updateButtons();

        onBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setEcoModeOnPressed();
                updateButtons();
            }
        });
        offBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setEcoModeOffPressed();
                updateButtons();
            }
        });

    }

    public void setEcoModeOnPressed() {
        ACOptionsUtil.getInstance(this).setSleepMode(OnOff.ON);
    }

    public void setEcoModeOffPressed() {
        ACOptionsUtil.getInstance(this).setSleepMode(OnOff.OFF);
    }

    public void updateButtons() {
        if (ACOptionsUtil.getInstance(this).getSleepMode() == OnOff.ON) {
            onBtn.setBackgroundColor(0xFF03A9F4);
            offBtn.setBackgroundColor(0xFFFFFFFF);

            onBtn.setTextColor(0xFFFFFFFF);
            offBtn.setTextColor(0xFF000000);
        } else {
            onBtn.setBackgroundColor(0xFFFFFFFF);
            offBtn.setBackgroundColor(0xFF03A9F4);

            onBtn.setTextColor(0xFF000000);
            offBtn.setTextColor(0xFFFFFFFF);
        }
    }
}
