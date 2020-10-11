package com.example.myapplication;

public class VerifNota {
    private boolean tapNota;
    public VerifNota(Boolean tapNota){
        this.tapNota=tapNota;

    }

    public boolean isTapNota() {
        return tapNota;
    }

    public void setTapNota(boolean tapNota) {
        this.tapNota = tapNota;
    }
}
