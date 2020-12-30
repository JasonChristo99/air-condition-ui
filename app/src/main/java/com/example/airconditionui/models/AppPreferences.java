package com.example.airconditionui.models;

/* App Preferences model class */

// TODO maybe add more preferences here
public class AppPreferences {
    private int fontSize;
    private boolean voiceCommands;

    public AppPreferences(int fontSize, boolean voiceCommands) {
        this.fontSize = fontSize;
        this.voiceCommands = voiceCommands;
    }

    // init all preferences with default values
    public AppPreferences() {
        this.fontSize = 20;
        this.voiceCommands = false;
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

    // TODO add the remaining getters and setters
}
