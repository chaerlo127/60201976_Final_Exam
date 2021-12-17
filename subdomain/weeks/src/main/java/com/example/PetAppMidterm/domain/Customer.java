package com.example.PetAppMidterm.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//entity 생성
@Entity
@Table //@Table 이 있어야 에러 없이 run 가능
public class Customer {
    //Customer의 ID
     /*Getter & Setter*/
    @Id
    String id;
        

    //가독성을 높이기 위해, address안에 있는 값을 밖으로 빼도 되지만, 안에 넣어두고 가독성이 좋게 두는 @Embedded 실행
    //directory 혹은, tree structure와 비슷한 의미
     /*Getter & Setter*/
    @Embedded
    Address address;


        public String getId() {
            return id;
        }
        public void setId(String id) {
        this.id = id;
        }

        public Address getAddress() {
            return address;
        }
        public void setAddress(Address address) {
            this.address = address;
        }
    

    

    
}
