
////////////////////회원가입 2 페이지 ///////////////////
// 닉네임, 전화번호, 비밀번호 입력 페이지

package com.example.jj_club;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public
class Register_2_Activity extends AppCompatActivity {

    @Override
    protected
    void onCreate ( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        // 회원가입2 페이지(activity_register2.xml)에 있는 '회원가입' 버튼 클릭 시
        // 메인 페이지(MainPageActivity.java) 페이지로 이동

        // 1) 회원가입 페이지: 이메일 인증 페이지
        // 2) 회원가입 2 페이지: 닉네임, 비번, 전화번호 입력 페이지

        /////////////////// 입력 내용 서버로 전송 //////////////////////
        Button button = (Button) findViewById(R.id.btn_register_2);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick( View view) {
                Intent intent = new Intent(Register_2_Activity.this , MainPageActivity.class);
                startActivity(intent);

            }
        });

    }

}
