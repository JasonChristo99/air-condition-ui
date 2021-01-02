package com.example.airconditionui.utils;

/* Get and modify the App Preferences from here
 * SharedPreferences and Gson will be used */

import android.content.Context;
import android.content.SharedPreferences;

import com.example.airconditionui.models.ACOptions;
import com.example.airconditionui.models.AppPreferences;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class AppPreferencesUtil {
    private static AppPreferencesUtil instance;
    private SharedPreferences sharedPreferences;
    private static final String APP_PREFERENCES_KEY = "APP_PREFERENCES_OBJ";

    private AppPreferencesUtil(Context context) {
        sharedPreferences = context.getSharedPreferences("app_preferences_db", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();

        if (getAppPreferences() == null) {
            editor.putString(APP_PREFERENCES_KEY, gson.toJson(AppPreferences.getDefault()));
            editor.apply();
        }
    }

    private AppPreferences getAppPreferences() {
        Gson gson = new Gson();
        Type type = new TypeToken<AppPreferences>() {
        }.getType();
        AppPreferences appPreferences = gson.fromJson(sharedPreferences.getString(APP_PREFERENCES_KEY, null), type);
        return appPreferences;
    }

    public static AppPreferencesUtil getInstance(Context context) {
        if (instance != null) {
            return instance;
        } else {
            instance = new AppPreferencesUtil(context);
            return instance;
        }
    }

    private String getAppPreferenceByKey(AppPreferenceKey appPreferenceKey) {
        AppPreferences appPreferences = getAppPreferences();
        switch (appPreferenceKey) {
            case FONT_SIZE:
                return String.valueOf(appPreferences.getFontSize());
            case VOICE_COMMANDS:
                return String.valueOf(appPreferences.isVoiceCommands());
            // TODO add the remaining cases here
            default:
                return null;
        }
    }

    // Getters
    public int getFontSize() {
        return getAppPreferences().getFontSize();
    }

    public boolean isVoiceCommands() {
        return getAppPreferences().isVoiceCommands();
    }

    // Setters

    public void setFontSize(int value) {
        AppPreferences appPreferences = getAppPreferences();
        appPreferences.setFontSize(value);
        Gson gson = new Gson();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(APP_PREFERENCES_KEY);
        editor.putString(APP_PREFERENCES_KEY, gson.toJson(appPreferences));
        editor.apply();
    }

    public void setVoiceCommands(boolean value) {
        AppPreferences appPreferences = getAppPreferences();
        appPreferences.setVoiceCommands(value);
        Gson gson = new Gson();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(APP_PREFERENCES_KEY);
        editor.putString(APP_PREFERENCES_KEY, gson.toJson(appPreferences));
        editor.apply();
    }

}
