package com.example.PetAppMidterm.domain;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

//entity 생성
@Table
@Entity
public class CartItem {

    //CartItem의 ID
    @Id
    @GeneratedValue
    Long id;

    //customer entity 와 relationship : many to one
    @ManyToOne
    Customer customer;


    //uri로 backend의 coredomain에서 clothes(pants, shirts) 정보 얻어올 것임
    String clothe;

        //Getter & Setter
        public String getClothe() {
            return clothe;
        }
        public void setClothe(String clothe) {
            this.clothe = clothe;
        }


    //가독성을 높이기 위해, address안에 있는 값을 밖으로 빼도 되지만, 안에 넣어두고 가독성이 좋게 두는 @Embedded 실행        
    @Embedded
    Payment payment;

    /*Getter & Setter
    protected: 같은 package 안에 잇는 class만 접근이 가능하도록 함*/
        public Long getId() {
            return id;
        }
        public void setId(Long id) {
            this.id = id;
        }
        public Customer getCustomer() {
            return customer;
        }
        public void setCustomer(Customer customer) {
            this.customer = customer;
        }
        public Payment getPayment() {
            return payment;
        }
        public void setPayment(Payment payment) {
            this.payment = payment;
        }



    
    
}
