package com.example.airconditionui.views.options;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.airconditionui.R;
import com.example.airconditionui.models.SpeedLevel;
import com.example.airconditionui.utils.ACOptionsUtil;

/* This activity presents options for the fan-speed functionality */
public class OptionFanSpeedActivity extends AppCompatActivity {
    Button backBtn, lowBtn, midBtn, highBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_fan_speed);
        backBtn = findViewById(R.id.optBackButton);
        lowBtn = findViewById(R.id.lowBtn);
        midBtn = findViewById(R.id.midBtn);
        highBtn = findViewById(R.id.highBtn);
        updateButtons();


        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        lowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLowFanSpeedPressed();
            }
        });

        midBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setMidFanSpeedPressed();
            }
        });

        highBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setHighFanSpeedPressed();
            }
        });

    }

    private void updateButtons(){
        if(ACOptionsUtil.getInstance(this).getFanSpeed() == SpeedLevel.LOW){
            lowBtn.setBackgroundColor(0xFF03A9F4);
            midBtn.setBackgroundColor(0xFFFFFFFF);
            highBtn.setBackgroundColor(0xFFFFFFFF);

            lowBtn.setTextColor(0xFFFFFFFF);
            midBtn.setTextColor(0xFF000000);
            highBtn.setTextColor(0xFF000000);
        }else if (ACOptionsUtil.getInstance(this).getFanSpeed() == SpeedLevel.MEDIUM){
            lowBtn.setBackgroundColor(0xFFFFFFFF);
            midBtn.setBackgroundColor(0xFF03A9F4);
            highBtn.setBackgroundColor(0xFFFFFFFF);

            lowBtn.setTextColor(0xFF000000);
            midBtn.setTextColor(0xFFFFFFFF);
            highBtn.setTextColor(0xFF000000);
        }else if(ACOptionsUtil.getInstance(this).getFanSpeed() == SpeedLevel.HIGH){
            lowBtn.setBackgroundColor(0xFFFFFFFF);
            midBtn.setBackgroundColor(0xFFFFFFFF);
            highBtn.setBackgroundColor(0xFF03A9F4);

            lowBtn.setTextColor(0xFF000000);
            midBtn.setTextColor(0xFF000000);
            highBtn.setTextColor(0xFFFFFFFF);
        }
    }

    private void setLowFanSpeedPressed(){
        ACOptionsUtil.getInstance(this).setFanSpeed(SpeedLevel.LOW);
        updateButtons();
    }
    private void setMidFanSpeedPressed(){
        ACOptionsUtil.getInstance(this).setFanSpeed(SpeedLevel.MEDIUM);
        updateButtons();
    }
    private void setHighFanSpeedPressed(){
        ACOptionsUtil.getInstance(this).setFanSpeed(SpeedLevel.HIGH);
        updateButtons();
    }
}
