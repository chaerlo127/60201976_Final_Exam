package com.example.App;


import com.example.App.domain.Clothe;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//Clothes database
//CrudRepository 사용
@Repository
public interface ClothesRepository extends CrudRepository<Clothe, Long>{//Repository Pattern Interface

}
