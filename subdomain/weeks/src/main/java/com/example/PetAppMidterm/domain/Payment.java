package com.example.PetAppMidterm.domain;

import javax.persistence.Embeddable;

//상위 class에는 @Embedded
//하위 클래스에는 @Embeddable
@Embeddable
public class Payment {
    //CartItem -> Payment안에 method, status attribute 값 생성
    String method; //결제 방법 attribute
    String status; //결제 상태 attribute

    //Getter & Setter
    public String getMethod() {
        return method;
    }
    public void setMethod(String method) {
        this.method = method;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    
    
}
