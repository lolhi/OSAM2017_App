package com.example.administrator.onnara;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
        editText_Pw = (EditText)findViewById(R.id.confirm_Pw_EditText);

        Button confirm_Btn = (Button)findViewById(R.id.btn_Confirm);
        confirm_Btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        //node 서버로 넘겨서 성공인지 실패인지
        //editText_Pw.toString();
        //editText_Id.toString();
        if(true)
        {
            Intent intent = new Intent(this, JoinActivity.class);
            startActivity(intent);
        }
        else //실패
            Toast.makeText(ConfirmActivity.this,"인증에 실패하였습니다.\n 아이디와 비밀번호를 확인해주세요.",Toast.LENGTH_SHORT).show();
    }
}
