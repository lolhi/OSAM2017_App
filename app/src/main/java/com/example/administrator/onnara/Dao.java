package com.example.administrator.onnara;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Dao
{
    private Context context;
    private SQLiteDatabase database;


    public Dao(Context context) {
        this.context = context;

        database = context.openOrCreateDatabase("OnnaraLocalDATA.db", SQLiteDatabase.CREATE_IF_NECESSARY, null);

        try {
            String sql = "CREATE TABLE IF NOT EXISTS android_onnara_unitname (ID integer primary key autoincrement,"
                    + "                                                       Mapkey text not null,"
                    + "                                                       Name text not null);";
            database.execSQL(sql);

        } catch (Exception e) {
            Log.e("TEST", "CREATE TABLE FAILED! -" + e);
            e.printStackTrace();
        }
    }

    public void insertJsonData(String jsonData)
    {
        //JSON으로 데이터를 파싱할 때 사용할 임시 변수
        int id;
        String mapKey;
        String name;


        try
        {
            JSONArray jArr = new JSONArray(jsonData);

            for(int i = 0; i < jArr.length(); i++)
            {
                JSONObject jObj = jArr.getJSONObject(i);

                id = jObj.getInt("Number");
                mapKey  = jObj.getString("Mapkey");
                name = jObj.getString("Name");

                Log.i("TEST", "Id : " + id + " Mapkey : " + mapKey +" Name : " + name);

                String sql = "INSERT INTO android_onnara_unitname(ID,Mapkey,Name)"
                        + " VALUES(" + id + ", '"+ mapKey+"', '"+ name + "');";
                try
                {
                    database.execSQL(sql);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }


            }
        }
        catch(JSONException e)
        {
            Log.e("TEST", "JSON ERROR! -" + e);
            e.printStackTrace();
        }
    }

    public ArrayList<String> getUnitNameList(String mapkey)
    {
        ArrayList<String> unitNameList = new ArrayList<String>();

        String name;

        String sql = "SELECT * FROM android_onnara_unitname WHERE Mapkey = " +"\'" + mapkey + "\'" + ";";
        Cursor cursor = database.rawQuery(sql, null);

        while ( cursor.moveToNext())
        {
            name = cursor.getString(2);
            unitNameList.add(name);
        }
        cursor.close();
        return unitNameList;
    }

}
