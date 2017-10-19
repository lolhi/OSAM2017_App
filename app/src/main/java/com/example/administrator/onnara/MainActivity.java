package com.example.administrator.onnara;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    ArrayList<Article> articleList;
    ListView listView_Article;
    private static AsyncHttpClient client = new AsyncHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_write = (Button)findViewById(R.id.write_btn);
        Button btn_refresh = (Button)findViewById(R.id.refresh_btn);

        listView_Article = (ListView)findViewById(R.id.article_listview);

        btn_refresh.setOnClickListener(this);
        btn_write.setOnClickListener(this);
    }


    @Override
    public void onClick(View v)
    {

        switch(v.getId()) {
            case R.id.write_btn:
                Intent intent = new Intent(MainActivity.this,ArticleWrite.class);
                intent.putExtra("writer",getIntent().getStringExtra("writer"));
                startActivity(intent);
                break;
            case R.id.refresh_btn:

                client.get(ProxyUp.getUrl() + "articles", new AsyncHttpResponseHandler()
                {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        if(statusCode == 201)
                        {
                            String jsonData = new String(responseBody);
                            DaoForArticle dao = new DaoForArticle(getApplicationContext());
                            dao.insertJsonData(jsonData);

                            articleList = dao.getArticleList("장용주");
                            Log.i("SQL","start arradapter");

                            CustomAdapter arrAdapter = new CustomAdapter(MainActivity.this, R.layout.custom_list_row, articleList);
                            listView_Article.setAdapter(arrAdapter);
                            articleList = null;
                        }

                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                        Toast.makeText(MainActivity.this,"네트워크가 불안정 합니다.",Toast.LENGTH_SHORT).show();
                    }
                });
                break;
        }

    }
}
