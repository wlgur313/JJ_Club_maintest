package com.example.jj_club;

import static com.example.jj_club.R.id.nameEditText;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.jj_club.SignUpRequest;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignUpActivity extends AppCompatActivity {
    private EditText nameEditText;
    private EditText phoneNumberEditText;
    private EditText passwordEditText;
    private EditText confirmPasswordEditText;
    private Button signUpButton;

    private SignUpInterface signUpApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // Retrofit 인스턴스 생성
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://example.com/api/") // 실제 서버 URL로 변경해야 함
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // API 인스턴스 생성
        signUpApi = retrofit.create(SignUpInterface.class);

        nameEditText = findViewById(R.id.nameEditText);
        phoneNumberEditText = findViewById(R.id.phoneNumberEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        confirmPasswordEditText = findViewById(R.id.confirmPasswordEditText);
        signUpButton = findViewById(R.id.signUpButton);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString().trim();
                String phoneNumber = phoneNumberEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString();
                String confirmPassword = confirmPasswordEditText.getText().toString();

                boolean hasError = false;

                if (name.isEmpty()) {
                    nameEditText.setHintTextColor(Color.RED);
                    hasError = true;
                }

                if (phoneNumber.isEmpty()) {
                    phoneNumberEditText.setHintTextColor(Color.RED);
                    hasError = true;
                }

                if (password.isEmpty()) {
                    passwordEditText.setHintTextColor(Color.RED);
                    hasError = true;
                }

                if (confirmPassword.isEmpty()) {
                    confirmPasswordEditText.setHintTextColor(Color.RED);
                    hasError = true;
                }

                if (hasError) {
                    // 입력되지 않은 항목이 있을 경우 Toast 메시지 표시
                    Toast.makeText(SignUpActivity.this, "입력을 해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.equals(confirmPassword)) {
                    // Retrofit을 사용하여 회원가입 정보 전송
                    signUp(name, phoneNumber, password);
                } else {
                    // 비밀번호가 일치하지 않을 경우 Toast 메시지 표시
                    Toast.makeText(SignUpActivity.this, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    private void signUp(String name, String phoneNumber, String password) { // 회원가입 정보를 서버로 전송하고, 서버의 응답에 따라 적절한 Toast 메시지를 표시
        Call<Void> call = signUpApi.signUp(name, phoneNumber, password);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    // 회원가입 성공 시 Toast 메시지 표시 및 MainActivity로 이동
                    Toast.makeText(SignUpActivity.this, "회원가입이 완료되었습니다.", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SignUpActivity.this, MainActivity.class));
                    finish();
                } else {
                    // 회원가입 실패 시 Toast 메시지 표시
                    Toast.makeText(SignUpActivity.this, "회원가입에 실패하였습니다.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                // 네트워크 오류 시 Toast 메시지 표시
                Toast.makeText(SignUpActivity.this, "네트워크 오류가 발생했습니다.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}




//package com.example.jj_club;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//
//public
//class SignUpActivity extends AppCompatActivity {
//
//    @Override
//    protected
//    void onCreate ( Bundle savedInstanceState ) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_sign_up);
//        // 회원가입 페이지에 있는 '회원가입' 버튼 클릭 시
//        // 메인 페이지(MainPageActivity.java) 페이지로 이동
//
//        // 1) 회원가입 페이지: 이메일 인증 페이지
//        // 2) 회원가입 2 페이지: 닉네임, 비번, 전화번호 입력 페이지
//
//        /////////////////// 입력 내용 서버로 전송 //////////////////////
//        Button button = (Button) findViewById(R.id.btn_register_2);
//        button.setOnClickListener(new View.OnClickListener() {
//            public void onClick( View view) {
//                Intent intent = new Intent(SignUpActivity.this , MainPageActivity.class);
//                startActivity(intent);
//
//            }
//        });
//
//    }
//
//}
