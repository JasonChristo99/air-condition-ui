package com.example.airconditionui.utils;

/* Get and modify the AC options from here
 * SharedPreferences and Gson will be used */

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.airconditionui.models.ACOptions;
import com.example.airconditionui.models.FunctionalityMode;
import com.example.airconditionui.models.OnOff;
import com.example.airconditionui.models.SpeedLevel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class ACOptionsUtil {
    private static ACOptionsUtil instance;
    private SharedPreferences sharedPreferences;
    private static final String AC_OPTIONS_KEY = "AC_OPTIONS_OBJ";

//    private static final String POWER = "POWER";
//    private static final String TEMPERATURE = "TEMPERATURE";
//    private static final String FAN_SPEED = "FAN_SPEED";
//    private static final String TIMER = "TIMER";
//    private static final String TIMER_MIN = "TIMER_MIN";
//    private static final String SLEEP_MODE = "SLEEP_MODE";
//    private static final String ECO_MODE = "ECO_MODE";
//    private static final String FUNCTIONALITY_MODE = "FUNCTIONALITY_MODE";
//    private static final String TURBO_MODE = "TURBO_MODE";
//    private static final String SWING_AUTO = "SWING_AUTO";
//    private static final String SWING_SCALE = "SWING_SCALE";

    private ACOptionsUtil(Context context) {
        sharedPreferences = context.getSharedPreferences("ac_options_db", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();

        if (getACOptions() == null) {
            ACOptions defaultACOptions = ACOptions.getDefault();
            editor.putString(AC_OPTIONS_KEY, gson.toJson(ACOptions.getDefault()));
            editor.apply(); // or commit
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

    // General purpose getters

    private ACOptions getACOptions() {
        Gson gson = new Gson();
        Type type = new TypeToken<ACOptions>() {
        }.getType();
        ACOptions acOptions = gson.fromJson(sharedPreferences.getString(AC_OPTIONS_KEY, null), type);
        Log.d("GET_AC_OPTIONS", String.valueOf(acOptions));
        return acOptions;
    }

    private String getACOptionByKey(ACOptionKey acOptionKey) {
        ACOptions acOptions = getACOptions();
        switch (acOptionKey) {
            case TEMPERATURE:
                return String.valueOf(acOptions.getTemperature());
            case ECO_MODE:
                return String.valueOf(acOptions.getEcoMode());
            case FAN_SPEED:
                return String.valueOf(acOptions.getFanSpeed());
            case POWER:
                return String.valueOf(acOptions.getPower());
            case TIMER:
                return String.valueOf(acOptions.getTimer());
            case TIMER_MIN:
                return String.valueOf(acOptions.getTimerMin());
            case SLEEP_MODE:
                return String.valueOf(acOptions.getSleepMode());
            case SWING_AUTO:
                return String.valueOf(acOptions.getSwingAuto());
            case TURBO_MODE:
                return String.valueOf(acOptions.getTurboMode());
            case SWING_SCALE:
                return String.valueOf(acOptions.getSwingScale());
            case FUNCTIONALITY_MODE:
                return String.valueOf(acOptions.getFunctionalityMode());
            default:
                return null;
        }
    }

    // Specific getters

    public SpeedLevel getFanSpeed() {
        return getACOptions().getFanSpeed();
    }

    public OnOff getEcoMode() {
        return getACOptions().getEcoMode();
    }

    public OnOff getPower() {
        return getACOptions().getPower();
    }

    public OnOff getTimer() {
        return getACOptions().getTimer();
    }

    public OnOff getTurboMode() {
        return getACOptions().getTurboMode();
    }

    public OnOff getSwingAuto() {
        return getACOptions().getSwingAuto();
    }

    public OnOff getSleepMode() {
        return getACOptions().getSleepMode();
    }

    public int getTemperature() {
        return getACOptions().getTemperature();
    }

    public int getTimerMin() {
        return getACOptions().getTimerMin();
    }

    public int getSwingScale() {
        return getACOptions().getSwingScale();
    }

    public FunctionalityMode getFunctionalityMode() {
        return getACOptions().getFunctionalityMode();
    }

    // General purpose Setters
    private void setBinaryACOptionByKey(ACOptionKey acOptionKey, OnOff value) {
        ACOptions acOptions = getACOptions();
        switch (acOptionKey) {
            case POWER:
                acOptions.setPower(value);
                break;
            case ECO_MODE:
                acOptions.setEcoMode(value);
                break;
            case SLEEP_MODE:
                acOptions.setSleepMode(value);
                break;
            case TIMER:
                acOptions.setTimer(value);
                break;
            case TURBO_MODE:
                acOptions.setTurboMode(value);
                break;
            case SWING_AUTO:
                acOptions.setSwingAuto(value);
                break;
        }
        Gson gson = new Gson();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(AC_OPTIONS_KEY);
        editor.putString(AC_OPTIONS_KEY, gson.toJson(acOptions));
        editor.apply();
    }

    private void setNumericACOptionByKey(ACOptionKey acOptionKey, int value) {
        ACOptions acOptions = getACOptions();
        switch (acOptionKey) {
            case TEMPERATURE:
                acOptions.setTemperature(value);
                break;
            case TIMER_MIN:
                acOptions.setTimerMin(value);
                break;
            case SWING_SCALE:
                acOptions.setSwingScale(value);
                break;
        }
        Gson gson = new Gson();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(AC_OPTIONS_KEY);
        editor.putString(AC_OPTIONS_KEY, gson.toJson(acOptions));
        editor.apply();
    }

    // Specific Setters
    public void setFunctionalityMode(FunctionalityMode value) {
        ACOptions acOptions = getACOptions();
        acOptions.setFunctionalityMode(value);
        Gson gson = new Gson();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(AC_OPTIONS_KEY);
        editor.putString(AC_OPTIONS_KEY, gson.toJson(acOptions));
        editor.apply();
    }

    public void setFanSpeed(SpeedLevel value) {
        ACOptions acOptions = getACOptions();
        acOptions.setFanSpeed(value);
        Gson gson = new Gson();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(AC_OPTIONS_KEY);
        editor.putString(AC_OPTIONS_KEY, gson.toJson(acOptions));
        editor.apply();
    }

    public void setEcoMode(OnOff value) {
        setBinaryACOptionByKey(ACOptionKey.ECO_MODE, value);
    }

    public void setPower(OnOff value) {
        setBinaryACOptionByKey(ACOptionKey.POWER, value);
    }

    public void setTimer(OnOff value) {
        setBinaryACOptionByKey(ACOptionKey.TIMER, value);
    }

    public void setTurboMode(OnOff value) {
        setBinaryACOptionByKey(ACOptionKey.TURBO_MODE, value);
    }

    public void setSwingAuto(OnOff value) {
        setBinaryACOptionByKey(ACOptionKey.SWING_AUTO, value);
    }

    public void setSleepMode(OnOff value) {
        setBinaryACOptionByKey(ACOptionKey.SLEEP_MODE, value);
    }

    public void setTemperature(int value) {
        setNumericACOptionByKey(ACOptionKey.TEMPERATURE, value);
    }

    public void setTimerMin(int value) {
        setNumericACOptionByKey(ACOptionKey.TIMER_MIN, value);
    }

    public void setSwingScale(int value) {
        setNumericACOptionByKey(ACOptionKey.SWING_SCALE, value);
    }

}

