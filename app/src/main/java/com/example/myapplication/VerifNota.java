package com.example.myapplication;

public class VerifNota {
    private boolean isBlue,isGreen,isOrange;
    public VerifNota(boolean isBlue,boolean isGreen,boolean isOrange){
        this.isBlue=isBlue;
        this.isGreen=isGreen;
        this.isOrange=isOrange;
    }

    public boolean isBlue() {
        return isBlue;
    }

    public void setBlue(boolean blue) {
        isBlue = blue;
    }

    public boolean isGreen() {
        return isGreen;
    }

    public void setGreen(boolean green) {
        isGreen = green;
    }

    public boolean isOrange() {
        return isOrange;
    }

    public void setOrange(boolean orange) {
        isOrange = orange;
    }
}
