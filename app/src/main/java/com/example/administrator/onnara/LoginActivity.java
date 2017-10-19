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
/*
 * LoginActivity Activity
 *
 * 기능
 *   1. 로그인 버튼 클릭시
 *      1-1. EditText에서 ID, PW 받아온후 node.js 서버로 넘겨줌
 *      1-2. node서버에서 ID, PW가 확인되면 MainActivity 호출 틀리면 토스트 메세지 출력
 *   2. 회원가입 버튼 클릭시
 *      2-1. JoinActivity 호출
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    EditText editText_ID;
    EditText editText_PW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btn_Join = (Button)findViewById(R.id.btn_Join);
        Button btn_Login = (Button)findViewById(R.id.btn_Login);

        editText_ID = (EditText)findViewById(R.id.onnara_ID_EditText);
        editText_PW = (EditText)findViewById(R.id.onnara_PW_EditText);

        btn_Join.setOnClickListener(this);
        btn_Login.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.btn_Login:
                InfoConfirm infoConfirm = new InfoConfirm(editText_ID.getText().toString(),editText_PW.getText().toString(),"3");
                try {
                    ProxyUp.upLoadConfirm(infoConfirm, new AsyncHttpResponseHandler() {
                        @Override
                        public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                            if (statusCode == 201) {
                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                intent.putExtra("writer",editText_ID.getText().toString());
                                startActivity(intent);
                            } else
                                Toast.makeText(LoginActivity.this, "아이디 비밀번호를 확인해주세요.", Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                            Log.i("uploadConfirm", "Status Code : " + statusCode);
                            Toast.makeText(LoginActivity.this, "로그인에 실패하였습니다.", Toast.LENGTH_LONG).show();
                        }
                    });
                }catch (Exception e)
                {
                    Toast.makeText(LoginActivity.this,"네트워크 연결이 불량합니다.",Toast.LENGTH_SHORT);
                }
                break;
            case R.id.btn_Join:
                Intent intent = new Intent(this,ConfirmActivity.class);
                startActivity(intent);
                break;
        }
    }
}
