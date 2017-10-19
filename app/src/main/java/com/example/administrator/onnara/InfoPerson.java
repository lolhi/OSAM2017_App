package com.example.administrator.onnara;

public class InfoPerson
{
    private String id;
    private String pw;
    private String unitName;
    private String name;

    public InfoPerson(String id, String pw, String unitName, String name) {
        this.id = id;
        this.pw = pw;
        this.unitName = unitName;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getPw() {
        return pw;
    }

    public String getUnitName() {
        return unitName;
    }

    public String getName() {
        return name;
    }
}
