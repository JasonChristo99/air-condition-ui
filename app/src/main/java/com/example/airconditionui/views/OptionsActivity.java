package com.example.airconditionui.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.airconditionui.utils.ACOptionsUtil;
import com.example.airconditionui.utils.AppPreferencesUtil;
import com.example.airconditionui.views.options.OptionEcoModeActivity;
import com.example.airconditionui.views.options.OptionModeActivity;
import com.example.airconditionui.views.options.OptionSwingActivity;
import com.example.airconditionui.views.options.OptionTimerActivity;
import com.example.airconditionui.R;
import com.example.airconditionui.views.options.OptionFanSpeedActivity;
import com.example.airconditionui.views.options.OptionSleepModeActivity;
import com.example.airconditionui.views.options.OptionTurboMode;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* This is the activity of the app in which more advanced options
 * are presented (like fan-speed etc.). Contains a recycler view */
public class OptionsActivity extends AppCompatActivity implements OptionsRecyclerViewAdapter.ItemClickListener, TextToSpeech.OnInitListener {

    RecyclerView optionsRecyclerView;
    OptionsRecyclerViewAdapter optionsRecyclerViewAdapter;
    Button backBtn;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        List<String> options = new ArrayList<>();
        options.add(getResources().getString(R.string.option_fan).toUpperCase());
        options.add(getResources().getString(R.string.option_timer).toUpperCase());
        options.add(getResources().getString(R.string.option_sleep).toUpperCase());
        options.add(getResources().getString(R.string.option_eco).toUpperCase());
        options.add(getResources().getString(R.string.option_mode).toUpperCase());
        options.add(getResources().getString(R.string.option_turbo).toUpperCase());
        options.add(getResources().getString(R.string.option_swing).toUpperCase());

        optionsRecyclerViewAdapter = new OptionsRecyclerViewAdapter(this, options);
        optionsRecyclerView = findViewById(R.id.optionsRecView);
        backBtn = findViewById(R.id.optBackButton);

        optionsRecyclerView.setAdapter(optionsRecyclerViewAdapter);
        optionsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        optionsRecyclerViewAdapter.setClickListener(this);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        tts = new TextToSpeech(this, this);
    }

    @Override
    public void onItemClick(View view, int position) {
        Intent intent = null;
        switch (position) {
            case 0:
                intent = new Intent(this, OptionFanSpeedActivity.class);
                break;
            case 1:
                intent = new Intent(this, OptionTimerActivity.class);
                break;
            case 2:
                intent = new Intent(this, OptionSleepModeActivity.class);
                break;
            case 3:
                intent = new Intent(this, OptionEcoModeActivity.class);
                break;
            case 4:
                intent = new Intent(this, OptionModeActivity.class);
                break;
            case 5:
                intent = new Intent(this, OptionTurboMode.class);
                break;
            case 6:
                intent = new Intent(this, OptionSwingActivity.class);
                break;
        }
        if (intent != null)
            startActivity(intent);
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

        String spokenMsg = "Επιλέξτε μία από τις διαθέσιμες λειτουργίες. "
                + getResources().getString(R.string.option_fan) + ", "
                + getResources().getString(R.string.option_timer) + ", "
                + getResources().getString(R.string.option_sleep) + ", "
                + getResources().getString(R.string.option_eco) + ", "
                + getResources().getString(R.string.option_mode) + ", "
                + getResources().getString(R.string.option_turbo) + ", "
                + getResources().getString(R.string.option_swing);
        ttsSpeak(spokenMsg, "select_option");
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
