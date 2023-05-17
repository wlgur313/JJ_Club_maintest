package com.example.jj_club;

import com.google.gson.annotations.SerializedName;

public class EmailVerificationRequest {
    @SerializedName("email")
    private String email;

    @SerializedName("verificationCode")
    private String verificationCode;

//////////////////// 이메일 인증 부분 수정 아마도 필요할 듯.
    // SignUpRequest에 있는 걸 가져왔다.
    public EmailVerificationRequest ( String email, String verificationCode ) {
        this.email = email;
        this.verificationCode = verificationCode;
    }


    // Getter methods
    public String getEmail() {
        return email;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    // Setter methods
    public void setEmail(String email) {
        this.email = email;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

}
