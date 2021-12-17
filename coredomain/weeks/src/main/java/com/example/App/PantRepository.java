package com.example.App;


import com.example.App.domain.Pant;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//Pants database
//CrudRepository 사용
@Repository
public interface PantRepository extends CrudRepository<Pant, Long>{//Repository Pattern Interface
    
}
