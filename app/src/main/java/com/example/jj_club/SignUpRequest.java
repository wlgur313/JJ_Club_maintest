package com.example.jj_club;

import com.google.gson.annotations.SerializedName;

public class SignUpRequest {

    @SerializedName("name")
    private String name;

    @SerializedName("phoneNumber")
    private String phoneNumber;

    @SerializedName("password")
    private String password;

    public SignUpRequest(String name, String phoneNumber, String password) {
//        this.email = email;
//        this.verificationCode = verificationCode;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }



    public String getName() {
        return name;
    }

    public String getPhone() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    // Setter methods


    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phoneNumber = phoneNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

//    Getter 메서드는 각 필드의 값을 반환하고, Setter 메서드는 각 필드에 값을 설정합니다.
//
//    Getter 메서드는 필드 값을 반환하기 위해 사용됩니다.
//    Setter 메서드는 외부에서 필드 값을 설정하기 위해 사용됩니다.
//    이러한 Getter와 Setter 메서드를 정의함으로써 SignUpRequest 클래스의 인스턴스에서 필드 값을 읽고 설정할 수 있습니다.

