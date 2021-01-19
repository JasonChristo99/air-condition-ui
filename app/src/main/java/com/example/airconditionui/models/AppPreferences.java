package com.example.airconditionui.models;

/* App Preferences model class */

public class AppPreferences {
    private boolean hideMoreOptions;
    private boolean textToSpeech;

    public AppPreferences(boolean hideMoreOptions, boolean textToSpeech) {
        this.hideMoreOptions = hideMoreOptions;
        this.textToSpeech = textToSpeech;
    }

    // init all preferences with default values
    private AppPreferences() {
        this.hideMoreOptions = false;
        this.textToSpeech = true;
    }

    public static AppPreferences getDefault() {
        return new AppPreferences();
    }


    public boolean isHideMoreOptions() {
        return hideMoreOptions;
    }

    public void setHideMoreOptions(boolean hideMoreOptions) {
        this.hideMoreOptions = hideMoreOptions;
    }

    public boolean isTextToSpeech() {
        return textToSpeech;
    }

    public void setTextToSpeech(boolean textToSpeech) {
        this.textToSpeech = textToSpeech;
    }

    @Override
    public String toString() {
        return "AppPreferences{" +
                "hideMoreOptions=" + hideMoreOptions +
                ", textToSpeech=" + textToSpeech +
                '}';
    }
}
