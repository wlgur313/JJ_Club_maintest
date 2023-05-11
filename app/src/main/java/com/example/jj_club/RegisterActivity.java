package com.example.jj_club;

////////////////////회원가입 페이지///////////////////
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public
class RegisterActivity extends AppCompatActivity {

    @Override
    protected
    void onCreate ( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // 회원가입 페이지(activity_register.xml)에 있는 '확인' 버튼 클릭 시
        // 회원가입2(Register_2_Activity) 페이지로 이동

        // 1) 회원가입 페이지: 이메일 인증 페이지
        // 2) 회원가입 2 페이지: 닉네임, 비번, 전화번호 입력 페이지

        /////////////////// 회원가입 스크립트 만들어야 함//////////////////////
        Button button = (Button) findViewById(R.id.btn_register_check);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick( View view) {
                Intent intent = new Intent(RegisterActivity.this , Register_2_Activity.class);
                startActivity(intent);

            }
        });

    }

}


