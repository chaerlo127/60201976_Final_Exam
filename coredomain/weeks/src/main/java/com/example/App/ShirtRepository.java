package com.example.App;


import com.example.App.domain.Shirt;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//Shirts database
//CrudRepository 사용
@Repository
public interface ShirtRepository extends CrudRepository<Shirt, Long>{//Repository Pattern Interface

}
