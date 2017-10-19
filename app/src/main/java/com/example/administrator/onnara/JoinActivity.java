package com.example.administrator.onnara;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.conn.ConnectTimeoutException;

/*
 * JoinActivity class
 *
 * 기능
 *
 * 1. ID, PW 입력 중복  확인 버튼을 누르면 서버로 보내 중복된 ID가 있는지 확인 후 없으면 ok 있으면 no
 * 2. spinner 사용 하여 부대 선택
 * 3. 가입 버튼을 통해 서버에 저장
 */

public class JoinActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText_Id;
    EditText editText_Pw;
    EditText editText_ConfirmPw;
    EditText editText_unitName;
    EditText editText_Name;
    TextView textView_Unit_Search;
    TextView textView_CheckPw;

    Boolean checkValue = false;

    final int REQUEST_CODE = 1234;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        Button btn_Check = (Button)findViewById(R.id.btn_Check);
        Button btn_Search = (Button)findViewById(R.id.search_Btn);
        Button btn_Join = (Button)findViewById(R.id.joinActvity_join_btn);

        editText_Id =(EditText)findViewById(R.id.id_EditText);
        editText_Pw =(EditText)findViewById(R.id.pw_EditText);
        editText_ConfirmPw = (EditText)findViewById(R.id.pw_Confirm_EditText);
        editText_unitName = (EditText)findViewById(R.id.unitName_EditText);
        editText_Name = (EditText)findViewById(R.id.name_EditText);

        editText_ConfirmPw.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(editText_Pw.getText().toString().equals(editText_ConfirmPw.getText().toString()))
                    textView_CheckPw.setText("비밀번호가 일치 합니다.");
                else
                    textView_CheckPw.setText("비밀번호가 다릅니다. 다시 한번 확인해주세요.");
            }
        });

        textView_Unit_Search = (TextView)findViewById(R.id.unit_name_TextView);
        textView_CheckPw = (TextView)findViewById(R.id.checkPassword_TextView);

        btn_Check.setOnClickListener(this);
        btn_Search.setOnClickListener(this);
        btn_Join.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btn_Check:
                if(editText_Id.toString().equals(""))
                    Toast.makeText(getApplicationContext(), "아이디를 입력해주세요.", Toast.LENGTH_SHORT).show();
                else {
                    InfoCheckId id = new InfoCheckId(editText_Id.getText().toString());
                    ProxyUp.upLoadCheck(id,
                            new AsyncHttpResponseHandler() {
                                @Override
                                public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                                    if (statusCode == 201) {
                                        Toast.makeText(JoinActivity.this, "중복된 아이디가 있습니다.", Toast.LENGTH_SHORT).show();
                                        checkValue = false;
                                    } else if (statusCode == 204) {
                                        Toast.makeText(JoinActivity.this, "사용 가능한 아이디 입니다.", Toast.LENGTH_SHORT).show();
                                        checkValue = true;
                                    }
                                }

                                @Override
                                public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                                    Toast.makeText(JoinActivity.this, "네트워크 연결이 불량합니다.", Toast.LENGTH_SHORT);
                                    Log.e("DB", String.valueOf(error instanceof ConnectTimeoutException));
                                }
                            });
                }
                break;
            case R.id.search_Btn:
                Intent intent = new Intent(JoinActivity.this,SearchActivity.class);
                startActivityForResult(intent,REQUEST_CODE);
                break;
            case R.id.joinActvity_join_btn:
                if(checkValue) {
                    InfoPerson info = new InfoPerson(editText_Id.getText().toString(), editText_Pw.getText().toString(), textView_Unit_Search.getText().toString() + editText_unitName.getText().toString(), editText_Name.getText().toString());
                    ProxyUp.upLoadRegister(info, new AsyncHttpResponseHandler() {
                        @Override
                        public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                            Toast.makeText(JoinActivity.this, "회원가입 성공", Toast.LENGTH_LONG);

                        }

                        @Override
                        public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                            Toast.makeText(JoinActivity.this, "회원가입 실패", Toast.LENGTH_LONG);
                            Log.e("DB", String.valueOf(error instanceof ConnectTimeoutException));

                        }
                    });
                    finish();
                }
                else
                {
                    Toast.makeText(JoinActivity.this,"회원가입에 실패했습니다.\n 사유 : 중복된 아이디 사용",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(requestCode == REQUEST_CODE)
        {
            if(resultCode == RESULT_OK)
                textView_Unit_Search.setText(data.getExtras().getString("unit_name"));
            else
                Toast.makeText(JoinActivity.this,"부대명을 찾지 못했습니다.",Toast.LENGTH_SHORT);
        }
        else
            super.onActivityResult(requestCode, resultCode, data);
    }

}
