package com.example.airconditionui.views;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.example.airconditionui.R;
import com.example.airconditionui.models.ACOptions;
import com.example.airconditionui.models.AppPreferences;
import com.example.airconditionui.utils.ACOptionsUtil;
import com.example.airconditionui.utils.AppPreferencesUtil;

/* This activity presents the application preferences (gear icon) */

public class AppPreferencesActivity extends AppCompatActivity {

    Switch ttsSwitch, hideMoreSwitch;
    Button backBtn, resetDefault;

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

        resetDefault = findViewById(R.id.resetDefault);
        resetDefault.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onResetDefaultPressed();
            }
        });
    }

    private void onResetDefaultPressed() {
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        //Yes button clicked
                        ACOptionsUtil.getInstance(AppPreferencesActivity.this).resetDefaultPreferences();
                        AppPreferencesUtil.getInstance(AppPreferencesActivity.this).resetDefaultPreferences();
                        Toast.makeText(AppPreferencesActivity.this, "Έγινε επαναφορά των ρυθμίσεων στις αρχικές.", Toast.LENGTH_SHORT).show();
                        finish();
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        //No button clicked
                        break;
                }
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Είστε σίγουροι ότι θέλετε να επαναφέρετε τις ρυθμίσεις της εφαρμογής; " +
                "Αυτή η επιλογή θα αντικαταστήσει όλες τις αλλαγές που έχετε πραγματοποιήσει " +
                "έως τώρα με τις αρχικές επιλογές.").setPositiveButton("Ναι", dialogClickListener)
                .setNegativeButton("Όχι", dialogClickListener).show();
    }

}
