package com.example.jj_club;

import com.google.gson.annotations.SerializedName;

/* 이 클래스는 서버의 회원가입 응답을 나타내며,
status와 message라는 멤버 변수를 가지고 있습니다.
status는 회원가입 상태를 나타내는 문자열이고, message는 서버로부터 받은 메시지를 나타냅니다.

이제 이 코드를 사용하여 Retrofit을 통해 서버로부터 받은 회원가입 응답을 처리할 수 있습니다.*/

public class SignUpResponse {

    @SerializedName("status")
    private String status;

    @SerializedName("message")
    private String message;

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}


