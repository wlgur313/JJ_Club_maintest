package com.example.jj_club;


// ApiService 파일에 대한 설명
// - 서버와 통신하기 위한 API 인터페이스 파일
// - 서버의 엔드포인트와 통신을 정의

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginInterface {

    @FormUrlEncoded
    @POST("/api/v1/auth/login") // 로그인:  API 엔드포인트가 들어가는 자리다.
    Call<LoginResponse> login(
            @Field("email") String email,
            @Field("password") String password
    );
}


//    @POST("login")
//    Call<LoginResponse> loginUser(@Body LoginRequest loginRequest);
//}

