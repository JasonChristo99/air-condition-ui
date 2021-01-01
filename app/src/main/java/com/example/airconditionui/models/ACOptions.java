package com.example.airconditionui.models;

/* Air condition Options model class */

// TODO definitely add more options here
public class ACOptions {
    private SpeedLevel fanSpeed;
    private OnOff ecoMode, power, timer, turboMode, swingAuto, sleepMode;
    private int temperature, timerMin, swingScale;
    private FunctionalityMode functionalityMode;


    // init all options with default values
    private ACOptions() {
        this.power = OnOff.OFF;
        this.fanSpeed = SpeedLevel.MEDIUM;
        this.ecoMode = OnOff.OFF;
        this.temperature = 24;
        this.functionalityMode = FunctionalityMode.COOL;
        this.timer = OnOff.OFF;
        this.timerMin = 0;
        this.swingAuto = OnOff.OFF;
        this.swingScale = 1;
        this.sleepMode = OnOff.OFF;
        this.turboMode = OnOff.OFF;
    }


    public static ACOptions getDefault() {
        return new ACOptions();
    }

    // Getters

    public SpeedLevel getFanSpeed() {
        return fanSpeed;
    }

    public OnOff getEcoMode() {
        return ecoMode;
    }

    public OnOff getPower() {
        return power;
    }

    public OnOff getTimer() {
        return timer;
    }

    public OnOff getTurboMode() {
        return turboMode;
    }

    public OnOff getSwingAuto() {
        return swingAuto;
    }

    public OnOff getSleepMode() {
        return sleepMode;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getTimerMin() {
        return timerMin;
    }

    public int getSwingScale() {
        return swingScale;
    }

    public FunctionalityMode getFunctionalityMode() {
        return functionalityMode;
    }

    // Setters

    public void setFanSpeed(SpeedLevel fanSpeed) {
        this.fanSpeed = fanSpeed;
    }

    public void setEcoMode(OnOff ecoMode) {
        this.ecoMode = ecoMode;
    }

    public void setPower(OnOff power) {
        this.power = power;
    }

    public void setTimer(OnOff timer) {
        this.timer = timer;
    }

    public void setTurboMode(OnOff turboMode) {
        this.turboMode = turboMode;
    }

    public void setSwingAuto(OnOff swingAuto) {
        this.swingAuto = swingAuto;
    }

    public void setSleepMode(OnOff sleepMode) {
        this.sleepMode = sleepMode;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void setTimerMin(int timerMin) {
        this.timerMin = timerMin;
    }

    public void setSwingScale(int swingScale) {
        this.swingScale = swingScale;
    }

    public void setFunctionalityMode(FunctionalityMode functionalityMode) {
        this.functionalityMode = functionalityMode;
    }

    @Override
    public String toString() {
        return "ACOptions{" +
                "fanSpeed=" + fanSpeed +
                ", ecoMode=" + ecoMode +
                ", power=" + power +
                ", timer=" + timer +
                ", turboMode=" + turboMode +
                ", swingAuto=" + swingAuto +
                ", sleepMode=" + sleepMode +
                ", temperature=" + temperature +
                ", timerMin=" + timerMin +
                ", swingScale=" + swingScale +
                ", functionalityMode=" + functionalityMode +
                '}';
    }
}

