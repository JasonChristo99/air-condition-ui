package com.example.airconditionui.views;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.airconditionui.R;
import com.example.airconditionui.models.OnOff;
import com.example.airconditionui.utils.ACOptionsUtil;
import com.example.airconditionui.utils.AppPreferencesUtil;
import com.example.airconditionui.views.dialogs.PowerOffDialog;

import java.util.Locale;

/* This is the main activity of the AC UI application
 * from where we can increase/lower the temperature etc. */

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    TextView temperatureText;
    ImageButton increaseTempBtn, decreaseTempBtn;
    Button powerOffBtn, moreOptionsBtn;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        temperatureText = findViewById(R.id.temperatureText);
        increaseTempBtn = findViewById(R.id.increaseTempBtn);
        decreaseTempBtn = findViewById(R.id.decreaseTempBtn);
        powerOffBtn = findViewById(R.id.powerOffBtn);

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

        moreOptionsBtn = findViewById(R.id.moreOptionsBtn);
        moreOptionsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moreOptionsPressed();
            }
        });

        tts = new TextToSpeech(this, this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (AppPreferencesUtil.getInstance(this).isHideMoreOptions())
            moreOptionsBtn.setVisibility(View.INVISIBLE);
        else moreOptionsBtn.setVisibility(View.VISIBLE);
    }

    private void moreOptionsPressed() {
        Intent intent = new Intent(this, OptionsActivity.class);
        startActivity(intent);
    }

    private void powerOffPressed() {

        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        //Yes button clicked
                        powerOff();
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        //No button clicked
                        break;
                }
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Είστε σίγουροι ότι θέλετε να απενεργοποιήσετε το κλιματιστικό;").setPositiveButton("Ναι", dialogClickListener)
                .setNegativeButton("Όχι", dialogClickListener).show();


    }

    private void powerOff() {
        // show dummy progress bar/dialog
        final PowerOffDialog powerOffDialog = new PowerOffDialog(MainActivity.this);
        powerOffDialog.startDialog();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                powerOffDialog.dismissDialog();
                // change screen
                ACOptionsUtil.getInstance(MainActivity.this).setPower(OnOff.OFF);
                finish();
            }
        }, 1500); // milliseconds delay
    }

    @Override
    public void onBackPressed() {
        powerOffPressed();
//        super.onBackPressed();
    }

    private void decreaseTempPressed() {
        if (ACOptionsUtil.getInstance(this).getTemperature() > 18) {
            ACOptionsUtil.getInstance(this).setTemperature(ACOptionsUtil.getInstance(this).getTemperature() - 1);
            updateTemperatureText();
        }
    }

    private void increaseTempPressed() {
        if (ACOptionsUtil.getInstance(this).getTemperature() < 30) {
            ACOptionsUtil.getInstance(this).setTemperature(ACOptionsUtil.getInstance(this).getTemperature() + 1);
            updateTemperatureText();
        }
    }

    private void updateTemperatureText() {
        temperatureText.setText(ACOptionsUtil.getInstance(this).getTemperature() + "°");

        if (tts != null)
            ttsSpeak("Η θερμοκρασία βρίσκεται στους " + ACOptionsUtil.getInstance(this).getTemperature() + " βαθμούς κελσίου.", "temperature");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.preferencesΜenu) {
            navigateToPreferences();
        } else if (id == R.id.deviceInfoMenu) {
            showDeviceInfoBox();
        }

        return super.onOptionsItemSelected(item);
    }

    private void navigateToPreferences() {
        Intent intent = new Intent(this, AppPreferencesActivity.class);
        startActivity(intent);
    }

    void showDeviceInfoBox() {
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle(getResources().getString(R.string.device_info_menu));
        alertDialog.setMessage(getResources().getString(R.string.device_info));
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
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

        ttsSpeak("Η θερμοκρασία βρίσκεται στους " + ACOptionsUtil.getInstance(this).getTemperature() + " βαθμούς κελσίου.", "temperature");
    }

    void ttsSpeak(String s, String id) {
        if (AppPreferencesUtil.getInstance(this).isTextToSpeech())
            tts.speak(s, TextToSpeech.QUEUE_FLUSH, null, id);
    }

    @Override
    protected void onPause() {
        Log.e("MAIN", "Main Activity Paused");
        if (tts != null) {
            tts.stop();
        }
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        Log.e("MAIN", "Main Activity Destroyed");
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }

        super.onDestroy();
    }
}
