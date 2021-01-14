package com.example.airconditionui.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.example.airconditionui.R;
import com.example.airconditionui.utils.AppPreferencesUtil;

/* This activity presents the application preferences (gear icon) */

public class AppPreferencesActivity extends AppCompatActivity {

    Switch ttsSwitch, hideMoreSwitch;
    Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_preferences);

        ttsSwitch = findViewById(R.id.prefTTSSwitch);
        ttsSwitch.setChecked(AppPreferencesUtil.getInstance(this).isTextToSpeech());
        ttsSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                AppPreferencesUtil.getInstance(AppPreferencesActivity.this).setTextToSpeech(isChecked);
            }
        });

        hideMoreSwitch = findViewById(R.id.prefHideMoreSwitch);
        hideMoreSwitch.setChecked(AppPreferencesUtil.getInstance(this).isHideMoreOptions());
        hideMoreSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                AppPreferencesUtil.getInstance(AppPreferencesActivity.this).setHideMoreOptions(isChecked);
            }
        });

        backBtn = findViewById(R.id.prefBackButton);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

}
