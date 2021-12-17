package com.example.App.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


//Clothe name Pant으로 @DiscriminatorColumn
//entity 생성
@Entity
@DiscriminatorValue("pant")
public class Pant extends Clothe{ 


    //Clothe을 상속한다


    //setType 명시
    public Pant(){
        setType("Pant");
    }
    //Clothe의 method override 후 재정의
    @Override
    public void large() {
        super.large();
        setAddbutton(getAddbutton()+1); //기존의 getAddbutton 추가와 별개로 하나 더 추가
    }

    //Clothe의 method override 후 재정의
    @Override
    public String like() {
        setLikebutton(getLikebutton()+1);
        return "좋아요가 추가되었습니다.";
    }
    
}
