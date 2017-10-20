package com.example.administrator.onnara;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DaoForArticle {
    private Context context;
    private SQLiteDatabase database;

    public DaoForArticle(Context context) {
        this.context = context;

        database = context.openOrCreateDatabase("OnnaraLocalDATA.db", SQLiteDatabase.CREATE_IF_NECESSARY, null);

        try {
            String sql = "CREATE TABLE IF NOT EXISTS Articles   (ID integer primary key autoincrement,"
                    + "                                          Title text not null,"
                    + "                                          WriterName text not null,"
                    + "                                          Content text not null,"
                    + "                                          SendName text not null);";
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
        String title;
        String writer;
        String content;
        String sendName;

        try
        {
            JSONArray jArr = new JSONArray(jsonData);

            for(int i = 0; i < jArr.length(); i++)
            {
                JSONObject jObj = jArr.getJSONObject(i);

                id = jObj.getInt("Id");
                title = jObj.getString("Title");
                writer  = jObj.getString("Writer");
                content = jObj.getString("Content");
                sendName = jObj.getString("SendName");

                String sql = "INSERT INTO Articles (ID, Title, WriterName, Content, SendName)"
                        + " VALUES(" + id + ", '" + title + "', '"+ writer+ "', '"+ content + "', '" + sendName +"');";
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

    public ArrayList<Article> getArticleList(String myName)
    {
        ArrayList<Article> articleList = new ArrayList<Article>();
        String title;
        String writer;
        String content;
        String sendName;

        String sql = "SELECT * FROM Articles WHERE SendName LIKE " + "\'%" + myName + "\'" + " OR " + "SendName LIKE " + "\'" + myName + "%\'" + " OR " + "SendName LIKE " + "\'%" + myName + "%\';";
        Log.i("SQL",sql);
        Cursor cursor = database.rawQuery(sql, null);
        int i = 0;

        while ( cursor.moveToNext())
        {
            title = cursor.getString(1);
            writer = cursor.getString(2);
            content = cursor.getString(3);
            sendName = cursor.getString(4);
            articleList.add(new Article(title, writer,content, sendName));
        }
        cursor.close();
        return articleList;
    }
}
