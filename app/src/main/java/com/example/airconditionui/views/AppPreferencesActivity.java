package com.example.airconditionui.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.example.airconditionui.R;
import com.example.airconditionui.models.AppPreferences;
import com.example.airconditionui.utils.AppPreferencesUtil;

/* This activity presents the application preferences (gear icon) */

public class AppPreferencesActivity extends AppCompatActivity {

    Switch ttsSwitch;

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
    }

}
