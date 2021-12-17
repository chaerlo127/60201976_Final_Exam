package com.example.App.domain;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.App.AddLike;

//entity 생성
@Table
@Entity
//column 상세 설명
@DiscriminatorColumn(
    discriminatorType = DiscriminatorType.STRING,//string 값
    name = "pet_type",//Dog or Cat
    columnDefinition = "CHAR(5)" //character 5
)

public abstract class Clothe implements AddLike {   //Entity, Domain class(전문성, 주요한 객체들, 환경이 변해도 영향을 받지 않는 class)
    //나머지는 구현 class
    //Add like interface class 참조


    
   // Clothe ID
    @Id @GeneratedValue
    Long id;
    //받아오는 것은 가능하지만, ID를 변경하는 것은 불가능하므로, Setter는 제외하고, Getter만 가능하게 한다.
    public Long getId() {
        return id;
    }



    //name -> Clothe name, Getter & Setter
    String name;
        public String getName() {
            return name;
        }


        //name은 null 값이면 안됨, sql ex> name varchar2(5) not null,
        public void setName(String name) {
            if(name == null)  throw new IllegalArgumentException("이름은 꼭 들어가야 합니다.");
            this.name = name;
        }

    //Getter & Setter, type
    String type;
        public String getType() {
            return type;
        }


        public void setType(String type) {
            this.type = type;
        }




    //addbutton 부분 추가 -> 옷의 개수 추가 되는 것
    private int addbutton =0;//addbutton attribute 추가
        public int getAddbutton() {//getter
            return addbutton;
        }
        protected void setAddbutton(int addbutton) {//setter
            if(Math.abs(this.addbutton - addbutton) <11){// 오류문 설정
                this.addbutton = addbutton;
            }
            else {
                throw new IllegalArgumentException("appearance change is too big");//크면 오류문 return
            }
        }

        private int likebutton = 0;//apperance attribute 추가
        public int getLikebutton() {//getter
            return likebutton;
        }

        
        protected void setLikebutton(int likebutton) {//setter
            if(Math.abs(this.likebutton - likebutton) <11){// 오류문 설정
                this.likebutton = likebutton;
            }
            else {
                throw new IllegalArgumentException("Energy change is too big");//크면 오류문 return
            }
        }

    //옷 개수 2 증가 -> frontend에 ui로 보이게 됨
    public void large(){
        addbutton +=1;
    }


    //옷개수 1 감소 -> frontend에 ui로 보이게 됨
    public void small(){
        addbutton -=1;
        if(this.addbutton < 0){
            throw new IllegalArgumentException("add change is too small");
        }
    }

  
   

   
    @Override
    public String toString(){
        return "<a href='./" + this.getClass().getSimpleName().toLowerCase()+"'"+">" +this.getClass().getSimpleName() + "</a>";
    }
}
