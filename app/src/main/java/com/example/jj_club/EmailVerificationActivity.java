package com.example.jj_club;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/* 사용자로부터 이메일을 입력받는 Acitity
*
*
* EmailVerificationActivity에서 사용자가 이메일을 입력하고,
* 이메일 인증번호를 요청하는 버튼(sendVerificationButton)을 클릭하면,
* EmailVerificationManager의 sendVerificationEmail 메서드를 호출하여 이메일 인증번호를 요청합니다.

  인증번호 확인 버튼을 클릭하면, EmailVerificationManager의 completeRegistration 메서드를 호출하여
  서버로 인증번호를 전송하고 회원가입 프로세스를 완료합니다.

* */

public class EmailVerificationActivity extends AppCompatActivity {


    private EditText emailEditText; // 이메일 입력란
    private Button sendVerificationButton; // 이메일 '인증' 버튼
    private EditText verificationCodeEditText; // 인증코드 입력란
    private Button verifyButton; //확인 버튼

    private EmailVerificationManager emailVerificationManager;

    @SuppressLint("MissingInflatedId")
    @Override
    protected
    void onCreate ( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_verification);

        emailEditText = findViewById(R.id.editText_email);
        sendVerificationButton = findViewById(R.id.button_send_verification);
        verificationCodeEditText = findViewById(R.id.editText_verification_code);
        verifyButton = findViewById(R.id.button_verify);

        emailVerificationManager = new EmailVerificationManager(this);


        // '인증' 버튼 클릭 시 수행 코드
        sendVerificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public
            void onClick ( View v ) {
                String email = emailEditText.getText().toString().trim();
                if (TextUtils.isEmpty(email)) {
                    emailEditText.setHintTextColor(Color.RED); // EditText의 hint 글씨색을 빨강색으로 변경
                    Toast.makeText(EmailVerificationActivity.this, "이메일을 입력하세요.", Toast.LENGTH_SHORT).show();
                } else {
                    emailEditText.setHintTextColor(Color.GRAY); // EditText의 hint 글씨색을 기본 색상으로 변경
                    verificationCodeEditText.setVisibility(View.VISIBLE);
                    verifyButton.setVisibility(View.VISIBLE);
                    emailVerificationManager.sendVerificationEmail(email);
                }
            }
        });

        // '확인' 버튼 클릭 시 수행 코드
        verifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public
            void onClick ( View v ) {
                String email = emailEditText.getText().toString().trim();
                String verificationCode = verificationCodeEditText.getText().toString().trim();

                boolean isEmailEmpty = TextUtils.isEmpty(email);
                boolean isVerificationCodeEmpty = TextUtils.isEmpty(verificationCode);

                if (isEmailEmpty && isVerificationCodeEmpty) {
                    emailEditText.setHintTextColor(Color.RED);
                    verificationCodeEditText.setHintTextColor(Color.RED);
                    Toast.makeText(EmailVerificationActivity.this, "이메일과 인증 코드를 입력하세요.", Toast.LENGTH_SHORT).show();
                } else if (isEmailEmpty) {
                    emailEditText.setHintTextColor(Color.RED);
                    Toast.makeText(EmailVerificationActivity.this, "이메일을 입력하세요.", Toast.LENGTH_SHORT).show();
                } else if (isVerificationCodeEmpty) {
                    verificationCodeEditText.setHintTextColor(Color.RED);
                    Toast.makeText(EmailVerificationActivity.this, "인증 번호를 입력하세요.", Toast.LENGTH_SHORT).show();
                } else {
                    emailEditText.setHintTextColor(Color.RED);
                    verificationCodeEditText.setHintTextColor(Color.RED);
                    emailVerificationManager.sendVerificationEmail(email);
                    verificationCodeEditText.setVisibility(View.VISIBLE);
                    verifyButton.setVisibility(View.VISIBLE);
                }
            }
        });
    }

}
//
//
//    @Override
//    protected
//    void onCreate ( Bundle savedInstanceState ) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_email_verification);

//
//
//        // 회원가입 페이지(activity_register.xml)에 있는 '확인' 버튼 클릭 시
//        // 회원가입2(Register_2_Activity) 페이지로 이동
//
//        // 1) 회원가입 페이지: 이메일 인증 페이지
//        // 2) 회원가입 2 페이지: 닉네임, 비번, 전화번호 입력 페이지
//
//        /////////////////// 회원가입 스크립트 만들어야 함//////////////////////
//        Button button = (Button) findViewById(R.id.btn_register_check);
//        button.setOnClickListener(new View.OnClickListener() {
//            public void onClick( View view) {
//                Intent intent = new Intent(EmailVerificationActivity.this , Register_2_Activity.class);
//                startActivity(intent);
//
//            }
//        });
//
//
//    }
//}