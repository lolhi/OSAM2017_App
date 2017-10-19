package com.example.administrator.onnara;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.conn.ConnectTimeoutException;

/*
 * Confirm Activity
 *
 * 기능
 *
 * 1. 인증 버튼 클릭시
 *    1-1. EditText 에서 id,pw받아 서버로 넘겨줌
 *    1-2. 서버에서 군번과 pw 조회 맞으면 joinActivity 호출 틀리면 토스트 메세지
 *
 */

public class ConfirmActivity extends AppCompatActivity implements View.OnClickListener{

    EditText editText_Id;
    EditText editText_Pw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        editText_Id = (EditText)findViewById(R.id.confirm_Id_EditText);
        editText_Pw = (EditText)findViewById(R.id.pw_Confirm_EditText);

        Button confirm_Btn = (Button)findViewById(R.id.btn_Confirm);
        confirm_Btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        InfoConfirm infoConfirm = new InfoConfirm(editText_Id.getText().toString(), editText_Pw.getText().toString());
        ProxyUp.upLoadConfirm(infoConfirm,
                new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        if (statusCode == 201) {
                            Intent intent = new Intent(ConfirmActivity.this, JoinActivity.class);
                            startActivity(intent);
                            finish();
                        } else
                            Toast.makeText(ConfirmActivity.this, "인증에 실패하였습니다.\n아이디와 비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                        Toast.makeText(ConfirmActivity.this, "네트워크 에러가 발생했습니다.", Toast.LENGTH_SHORT).show();
                        Log.e("DB", String.valueOf(error instanceof ConnectTimeoutException));
                    }
                });
    }
}
