////////////////////로그인 페이지///////////////////
package com.example.jj_club;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.jj_club.databinding.ActivityMainBinding;

// 로그인 페이지

public
class MainActivity extends AppCompatActivity {

    @Override
    protected
    void onCreate ( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ////////////////////////로그인 > 회원가입 페이지(이메일 인증)로 이동 Start ///////////////////////

        // 로그인 페이지(activity_main.xml)에 있는 '회원가입하러가기' 텍스트 클릭 시
        // RegisterActivity(회원가입 페이지)로 이동
        TextView txtRegister = (TextView) findViewById(R.id.registerTextButton);
        txtRegister.setOnClickListener(new View.OnClickListener() {
            public void onClick( View view) {
                Intent intent = new Intent(MainActivity.this , RegisterActivity.class);
                startActivity(intent);

            }
        });

        ////////////////////////로그인 > 회원가입 페이지(이메일 인증)로 이동 END ///////////////////////

    }

}