package com.example.administrator.onnara;

public class InfoConfirm
{
    private String onnaraID;
    private String onnaraPW;
    private String key;

    public InfoConfirm(String onnaraID, String onnaraPW) {
        this.onnaraID = onnaraID;
        this.onnaraPW = onnaraPW;
        this.key = "1";
    }

    public InfoConfirm(String onnaraID, String onnaraPW, String key) {
        this.onnaraID = onnaraID;
        this.onnaraPW = onnaraPW;
        this.key = key;
    }



    public String getOnnaraID() {
        return onnaraID;
    }

    public String getOnnaraPW() {
        return onnaraPW;
    }

    public String getKey() {
        return key;
    }
}
