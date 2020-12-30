package com.example.airconditionui.utils;

/* Get and modify the AC options from here
 * SharedPreferences and Gson will be used */

import android.content.Context;
import android.content.SharedPreferences;

import com.example.airconditionui.models.ACOptions;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class ACOptionsUtil {
    private static ACOptionsUtil instance;
    private SharedPreferences sharedPreferences;
    private static final String AC_OPTIONS_KEY = "AC_OPTIONS";

    private ACOptionsUtil(Context context) {
        sharedPreferences = context.getSharedPreferences("ac_options_db", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();

        if (getACOptions() == null) {
            editor.putString(AC_OPTIONS_KEY, gson.toJson(new ACOptions()));
            editor.commit();
        }
    }


    public static ACOptionsUtil getInstance(Context context) {
        if (instance != null) {
            return instance;
        } else {
            instance = new ACOptionsUtil(context);
            return instance;
        }
    }

    private ACOptions getACOptions() {
        Gson gson = new Gson();
        Type type = new TypeToken<ACOptions>() {
        }.getType();
        ACOptions acOptions = gson.fromJson(sharedPreferences.getString(AC_OPTIONS_KEY, null), type);
        return acOptions;
    }

    private String getACOptionByKey(ACOptionKey acOptionKey) {
        ACOptions acOptions = getACOptions();
        switch (acOptionKey) {
            case ECO_MODE:
                return String.valueOf(acOptions.getEcoMode());
            case FAN_SPEED:
                return String.valueOf(acOptions.getFanSpeed());
            // TODO add the remaining cases here
            default:
                return null;
        }
    }

    public void setACOptionByKey() {
        // TODO
    }
}

