package com.example.jj_club;

import com.google.gson.annotations.SerializedName;

// 서버로부터 받은 데이터를 정의해 준다.


public class LoginResponse {
    @SerializedName("success")
    private boolean success;

    public boolean isSuccess() {
        return success;
    }
}

//public class LoginResponse {
//    private String token;
//    private String message;
//
//    public String getToken() {
//        return token;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//}
