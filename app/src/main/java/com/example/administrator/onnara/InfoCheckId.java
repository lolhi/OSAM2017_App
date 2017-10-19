package com.example.administrator.onnara;

public class InfoCheckId
{
    private String id;
    private String key;

    public InfoCheckId(String id) {
        this.id = id;
        this.key = "2";
    }

    public InfoCheckId(String id, String key) {
        this.id = id;
        this.key = key;
    }

    public String getId() {
        return id;
    }

    public String getKey() {
        return key;
    }
}
