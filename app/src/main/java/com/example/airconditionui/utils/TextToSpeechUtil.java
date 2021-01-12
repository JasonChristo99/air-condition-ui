package com.example.airconditionui.utils;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.util.Log;

import java.util.Locale;

// TODO not working
public class TextToSpeechUtil {
//    private static TextToSpeechUtil instance;
//    private TextToSpeech textToSpeech;
//    private static Context context;
//
//    private TextToSpeechUtil(final Context context) {
//        TextToSpeechUtil.context = context;
//        textToSpeech = new TextToSpeech(context, new TextToSpeech.OnInitListener() {
//            @Override
//            public void onInit(int status) {
//                if (status == TextToSpeech.SUCCESS) {
//                    int result = textToSpeech.setLanguage(Locale.forLanguageTag("el"));
//
//                    if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
//                        Log.e("TTS_LOG", "Lang not supported");
//                    }
//
//                } else {
//                    Log.e("TTS_LOG", "Init failed");
//                }
//            }
//        });
//    }
//
//    public static TextToSpeechUtil getInstance(Context context) {
//        if (instance == null) {
//            Log.e("TTS_LOG", "1");
//            instance = new TextToSpeechUtil(context);
//            return instance;
//        } else if (context != TextToSpeechUtil.context) {
//            Log.e("TTS_LOG", "2");
//            instance = new TextToSpeechUtil(context);
//            return instance;
//        } else {
//            Log.e("TTS_LOG", "3");
//            return instance;
//
//        }
//    }
//
//    public void speak(String text) {
//        if (textToSpeech != null && AppPreferencesUtil.getInstance(context).isTextToSpeech()) {
//            Log.e("TTS_LOG", "Spoke : " + text);
//            textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);
//        } else {
//            Log.e("TTS_LOG", "NUll or !TTS");
//
//        }
//    }
//
//    public void stop() {
//        if (textToSpeech != null) {
//            textToSpeech.stop();
//            textToSpeech.shutdown();
//        }
//    }
}
