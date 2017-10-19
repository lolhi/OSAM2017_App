package com.example.administrator.onnara;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.conn.ConnectTimeoutException;

public class FirstActivity extends AppCompatActivity {

    private static AsyncHttpClient client = new AsyncHttpClient();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_first);

        client.get(ProxyUp.getUrl() + "unitnamedb", new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String jsonData = new String(responseBody);
                Log.i("TEST", "jsonData : " + jsonData);

                Dao dao = new Dao(getApplicationContext());
                dao.insertJsonData(jsonData);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.e("DB", String.valueOf(error instanceof ConnectTimeoutException));
                Toast.makeText(FirstActivity.this, "네트워크 연결이 불량합니다.", Toast.LENGTH_SHORT).show();

            }
        });
        Intent intent = new Intent(FirstActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}
