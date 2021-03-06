package com.example.airconditionui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.airconditionui.models.OnOff;
import com.example.airconditionui.utils.ACOptionsUtil;
import com.example.airconditionui.utils.AppPreferencesUtil;
import com.example.airconditionui.views.MainActivity;
import com.example.airconditionui.views.dialogs.PowerOnDialog;

import java.util.Locale;

/* The first activity from where we can start the AC device */
public class StartActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    Button powerOnBtn, exitBtn;
    TextToSpeech tts;

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

        // speak out welcome message (if preference is enabled)
        tts = new TextToSpeech(this, this);
    }


    private void onExitPressed() {

        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        //Yes button clicked
                        onDestroy();
                        System.exit(0);
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        //No button clicked
                        break;
                }
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Είστε σίγουροι ότι θέλετε να τερματίσετε την εφαρμογή;").setPositiveButton("Ναι", dialogClickListener)
                .setNegativeButton("Όχι", dialogClickListener).show();
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

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            int result = tts.setLanguage(Locale.forLanguageTag("el"));
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS_LOG", "Lang not supported");
            }
        } else {
            Log.e("TTS_LOG", "Init failed");
        }
        Log.e("TTS_LOG", "Init success");

        ttsSpeak(getResources().getString(R.string.welcome_and_power_on_message), "welcome_message");

    }


    void ttsSpeak(String s, String id) {
        if (AppPreferencesUtil.getInstance(this).isTextToSpeech())
            tts.speak(s, TextToSpeech.QUEUE_FLUSH, null, id);
    }

    @Override
    protected void onPause() {
        if (tts != null) {
            tts.stop();
        }
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }

        super.onDestroy();
    }
}
