package com.example.airconditionui.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.airconditionui.R;
import com.example.airconditionui.models.OnOff;
import com.example.airconditionui.utils.ACOptionsUtil;

/* This is the main activity of the AC UI application
 * from where we can increase/lower the temperature etc. */

public class MainActivity extends AppCompatActivity {

    TextView temperatureText;
    Button increaseTempBtn, decreaseTempBtn, powerOffBtn, moreOptionsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        temperatureText = findViewById(R.id.temperatureText);
        increaseTempBtn = findViewById(R.id.increaseTempBtn);
        decreaseTempBtn = findViewById(R.id.decreaseTempBtn);
        powerOffBtn = findViewById(R.id.powerOffBtn);
        moreOptionsBtn = findViewById(R.id.moreOptionsBtn);

        updateTemperatureText();

        increaseTempBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increaseTempPressed();
            }
        });

        decreaseTempBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decreaseTempPressed();
            }
        });

        powerOffBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                powerOffPressed();
            }
        });

        moreOptionsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moreOptionsPressed();
            }
        });
    }

    private void moreOptionsPressed() {
        Intent intent = new Intent(this, OptionsActivity.class);
        startActivity(intent);
    }

    private void powerOffPressed() {
        ACOptionsUtil.getInstance(this).setPower(OnOff.OFF);
        finish();
    }

    private void decreaseTempPressed() {
        ACOptionsUtil.getInstance(this).setTemperature(ACOptionsUtil.getInstance(this).getTemperature() - 1);
        updateTemperatureText();
    }

    private void increaseTempPressed() {
        ACOptionsUtil.getInstance(this).setTemperature(ACOptionsUtil.getInstance(this).getTemperature() + 1);
        updateTemperatureText();
    }

    private void updateTemperatureText() {
        temperatureText.setText(ACOptionsUtil.getInstance(this).getTemperature() + " Βαθμοί");
    }
}
