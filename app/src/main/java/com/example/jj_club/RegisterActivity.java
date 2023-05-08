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

        // 회원가입 페이지(activity_register.xml)에 있는 '회원가입' 버튼 클릭 시
        // 메인(홈)페이지로 이동
        /////////////////// 회원가입 스크립트 만들어야 함//////////////////////
        Button button = (Button) findViewById(R.id.btn_register);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick( View view) {
                Intent intent = new Intent(RegisterActivity.this , MainPageActivity.class);
                startActivity(intent);

            }
        });

    }

}


