package com.example.airconditionui.views.options;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.airconditionui.R;
import com.example.airconditionui.models.FunctionalityMode;
import com.example.airconditionui.models.SpeedLevel;
import com.example.airconditionui.utils.ACOptionsUtil;

public class OptionModeActivity extends AppCompatActivity {
    Button backBtn, coolBtn, heatBtn, dryBtn, feelBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_mode);
        backBtn = findViewById(R.id.optBackButton);
        coolBtn = findViewById(R.id.coolBtn);
        heatBtn = findViewById(R.id.heatBtn);
        dryBtn = findViewById(R.id.dryBtn);
        feelBtn = findViewById(R.id.feelBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        updateButtons();
        coolBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCoolModePressed();
            }
        });
        heatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setHeatModePressed();
            }
        });
        dryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDryModePressed();
            }
        });
        feelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFeelModePressed();
            }
        });
    }


    public void setCoolModePressed(){
        ACOptionsUtil.getInstance(this).setFunctionalityMode(FunctionalityMode.COOL);
        updateButtons();
    }
    public void setHeatModePressed(){
        ACOptionsUtil.getInstance(this).setFunctionalityMode(FunctionalityMode.HEAT);
        updateButtons();
    }
    public void setDryModePressed(){
        ACOptionsUtil.getInstance(this).setFunctionalityMode(FunctionalityMode.DRY);
        updateButtons();
    }
    public void setFeelModePressed(){
        ACOptionsUtil.getInstance(this).setFunctionalityMode(FunctionalityMode.FEEL);
        updateButtons();
    }


    public void updateButtons(){
        if(ACOptionsUtil.getInstance(this).getFunctionalityMode() == FunctionalityMode.COOL){
            coolBtn.setBackgroundColor(0xFF03A9F4);
            heatBtn.setBackgroundColor(0xFFFFFFFF);
            dryBtn.setBackgroundColor(0xFFFFFFFF);
            feelBtn.setBackgroundColor(0xFFFFFFFF);

            coolBtn.setTextColor(0xFFFFFFFF);
            heatBtn.setTextColor(0xFF000000);
            dryBtn.setTextColor(0xFF000000);
            feelBtn.setTextColor(0xFF000000);
        }else if (ACOptionsUtil.getInstance(this).getFunctionalityMode() == FunctionalityMode.HEAT){
            coolBtn.setBackgroundColor(0xFFFFFFFF);
            heatBtn.setBackgroundColor(0xFF03A9F4);
            dryBtn.setBackgroundColor(0xFFFFFFFF);
            feelBtn.setBackgroundColor(0xFFFFFFFF);

            coolBtn.setTextColor(0xFF000000);
            heatBtn.setTextColor(0xFFFFFFFF);
            dryBtn.setTextColor(0xFF000000);
            feelBtn.setTextColor(0xFF000000);
        }else if (ACOptionsUtil.getInstance(this).getFunctionalityMode() == FunctionalityMode.DRY){
            coolBtn.setBackgroundColor(0xFFFFFFFF);
            heatBtn.setBackgroundColor(0xFFFFFFFF);
            dryBtn.setBackgroundColor(0xFF03A9F4);
            feelBtn.setBackgroundColor(0xFFFFFFFF);

            coolBtn.setTextColor(0xFF000000);
            heatBtn.setTextColor(0xFF000000);
            dryBtn.setTextColor(0xFFFFFFFF);
            feelBtn.setTextColor(0xFF000000);
        }else if (ACOptionsUtil.getInstance(this).getFunctionalityMode() == FunctionalityMode.FEEL){
            coolBtn.setBackgroundColor(0xFFFFFFFF);
            heatBtn.setBackgroundColor(0xFFFFFFFF);
            dryBtn.setBackgroundColor(0xFFFFFFFF);
            feelBtn.setBackgroundColor(0xFF03A9F4);

            coolBtn.setTextColor(0xFF000000);
            heatBtn.setTextColor(0xFF000000);
            dryBtn.setTextColor(0xFF000000);
            feelBtn.setTextColor(0xFFFFFFFF);
        }
    }
}
