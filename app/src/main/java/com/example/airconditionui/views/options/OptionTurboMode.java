package com.example.airconditionui.views.options;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.airconditionui.R;
import com.example.airconditionui.models.OnOff;
import com.example.airconditionui.utils.ACOptionsUtil;

public class OptionTurboMode extends AppCompatActivity {

    Button onBtn, offBtn, backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_turbo_mode);
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
                setTurboModeOnPressed();
                updateButtons();
            }
        });
        offBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTurboModeOffPressed();
                updateButtons();
            }
        });
    }

    public void setTurboModeOnPressed() {
        ACOptionsUtil.getInstance(this).setTurboMode(OnOff.ON);
    }

    public void setTurboModeOffPressed() {
        ACOptionsUtil.getInstance(this).setTurboMode(OnOff.OFF);
    }

    public void updateButtons() {
        if (ACOptionsUtil.getInstance(this).getTurboMode() == OnOff.ON) {
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
