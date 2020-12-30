package com.example.airconditionui.models;

/* Air condition Options model class */

// TODO definitely add more options here
public class ACOptions {
    private SpeedLevel fanSpeed;
    private OnOff ecoMode;

    public ACOptions(SpeedLevel fanSpeed, OnOff ecoMode) {
        this.fanSpeed = fanSpeed;
        this.ecoMode = ecoMode;
    }

    // init all options with default values
    public ACOptions() {
        this.fanSpeed = SpeedLevel.MEDIUM;
        this.ecoMode = OnOff.OFF;
    }

    public SpeedLevel getFanSpeed() {
        return fanSpeed;
    }

    public void setFanSpeed(SpeedLevel fanSpeed) {
        this.fanSpeed = fanSpeed;
    }

    public OnOff getEcoMode() {
        return ecoMode;
    }

    public void setEcoMode(OnOff ecoMode) {
        this.ecoMode = ecoMode;
    }

    // TODO add the remaining getters and setters
}

enum SpeedLevel {
    LOW,
    MEDIUM,
    HIGH
}

enum OnOff {
    ON,
    OFF
}
