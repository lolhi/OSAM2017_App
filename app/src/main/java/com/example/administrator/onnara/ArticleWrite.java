package com.example.administrator.onnara;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

public class ArticleWrite extends AppCompatActivity implements View.OnClickListener{

    private EditText title_EditText;
    private EditText content_EditText;
    private EditText sendNames_EditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_write);

        title_EditText = (EditText)findViewById(R.id.editText_Title);
        content_EditText = (EditText)findViewById(R.id.editText_Content);
        sendNames_EditText= (EditText)findViewById(R.id.editText_sendNames) ;

        Button upload_Btn = (Button)findViewById(R.id.btn_upload);
        upload_Btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        Article article = new Article(title_EditText.getText().toString(),getIntent().getStringExtra("writer"),content_EditText.getText().toString(),sendNames_EditText.getText().toString());
        ProxyUp.upLoadArticle(article, new AsyncHttpResponseHandler()
        {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Toast.makeText(ArticleWrite.this,sendNames_EditText.getText().toString() + "에게 보냈습니다.",Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });

    }
}
