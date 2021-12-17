package com.example.PetAppMidterm.domain;


import javax.persistence.Embeddable;

//상위 class에는 @Embedded
//하위 클래스에는 @Embeddable
@Embeddable
public class Address {
    //customer -> address안에 Country, Address attribute 값 생성
    String country;
    String address;
        //Getter & Setter
        public String getCountry() {
            return this.country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getAddress() {
            return this.address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

    
    
}
