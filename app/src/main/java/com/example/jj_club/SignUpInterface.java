package com.example.jj_club;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

// ApiService 파일에 대한 설명
// - 서버와 통신하기 위한 API 인터페이스 파일
// - 서버의 엔드포인트와 통신을 정의

public interface SignUpInterface {

    @FormUrlEncoded
    @POST("/api/v1/auth/signup")
    Call<Void> signUp(
            @Field("name") String name, //@Field는 POST로 서버에 값을 보낼 때 붙여야 하는 어노테이션이다.
            @Field("phone") String phone,
            @Field("password") String password
//            @Field("password_check") String password_check
    );

}


//public interface SignUpApi {
//    @POST("signup")
//    Call<Void> signUp(@Body SignUpRequest request);
//}
