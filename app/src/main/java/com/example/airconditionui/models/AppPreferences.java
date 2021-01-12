package com.example.airconditionui.models;

/* App Preferences model class */

// TODO maybe add more preferences here
public class AppPreferences {
    private int fontSize;
    private boolean voiceCommands;
    private boolean textToSpeech;

    public AppPreferences(int fontSize, boolean voiceCommands, boolean textToSpeech) {
        this.fontSize = fontSize;
        this.voiceCommands = voiceCommands;
        this.textToSpeech = textToSpeech;
    }

    // init all preferences with default values
    private AppPreferences() {
        this.fontSize = 20;
        this.voiceCommands = false;
        this.textToSpeech = true;
    }

    public static AppPreferences getDefault() {
        return new AppPreferences();
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public boolean isVoiceCommands() {
        return voiceCommands;
    }

    public void setVoiceCommands(boolean voiceCommands) {
        this.voiceCommands = voiceCommands;
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
                "fontSize=" + fontSize +
                ", voiceCommands=" + voiceCommands +
                ", textToSpeech=" + textToSpeech +
                '}';
    }
}
