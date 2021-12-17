package com.example.App;


import com.example.App.domain.Clothe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@SpringBootApplication
@RestController
@EnableAspectJAutoProxy

public class Application {


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	


	//ClothesRepository 사용하기 위해 정의
	@Autowired
	ClothesRepository clothesRepository;


	//API method PUT, path= localhost:8080/clothes/{clothesId}/large
	@RequestMapping(method = RequestMethod.PUT, path="clothes/{clothesId}/large")
	public String large(@PathVariable(value = "clothesId") Long clothesId){

		//CrudRepository 내장되어 있는 method findByID 사용
		Clothe clothe = clothesRepository.findById(clothesId).get();
		clothe.large();//addbutton 증가 method
		clothesRepository.save(clothe); //database에 저장
		return "large size 추가 되었습니다.";

	}

	//API method PUT, path= localhost:8080/clothes/{clothesId}/small
	@RequestMapping(method = RequestMethod.PUT, path="clothes/{clothesId}/small")
	public String small(@PathVariable(value = "clothesId") Long clothesId){

		//CrudRepository 내장되어 있는 method findByID 사용
		Clothe clothe = clothesRepository.findById(clothesId).get();
		clothe.small();//addbutton 감소 method
		clothesRepository.save(clothe); //database에 저장
		return "medium size 추가 되었습니다.";

	}

	//API method PUT, path = localhost:8080/clothes/{clothesId}/like
	@RequestMapping(method = RequestMethod.PUT, path="clothes/{clothesId}/like")
	public String like(@PathVariable(value = "clothesId") Long clothesId){

	
		//CrudRepository 내장되어 있는 method findByID 사용
		Clothe clothe = clothesRepository.findById(clothesId).get();
		clothe.like(); //likebutton 추가 method
		clothesRepository.save(clothe);//database에 저장
		return "좋아요가 추가되었습니다.";
	
	}


	//API method PUT, path = localhost:8080/pants/{clothesId}/like
	@RequestMapping(method = RequestMethod.PUT, path="pants/{clothesId}/like")
	public String PantsLike(@PathVariable(value = "clothesId") Long clothesId){
		return like(clothesId); // application class 의 like method 사용
	
	}

	//API method PUT, path = localhost:8080/shirts/{clothesId}/like
	@RequestMapping(method = RequestMethod.PUT, path="shirts/{clothesId}/like")
	public String ShirtsLike(@PathVariable(value = "clothesId") Long clothesId){
		return like(clothesId);// application class 의 like method 사용
	
	}

	//API method PUT, path = localhost:8080/pants/{clothesId}/large
	@RequestMapping(method = RequestMethod.PUT, path="pants/{clothesId}/large")
	public String largePants(@PathVariable(value = "clothesId") Long clothesId){
		return large(clothesId);// application class 의 large method 사용

	}

	//API method PUT, path = localhost:8080/shirts/{clothesId}/large
	@RequestMapping(method = RequestMethod.PUT, path="shirts/{clothesId}/large")
	public String largeShirts(@PathVariable(value = "clothesId") Long clothesId){
		return large(clothesId);// application class 의 large method 사용

	}



	//API method PUT, path = localhost:8080/pants/{clothesId}/small
	@RequestMapping(method = RequestMethod.PUT, path="pants/{clothesId}/small")
	public String mediumPants(@PathVariable(value = "clothesId") Long clothesId){
		return small(clothesId);// application class 의 small method 사용

	}


	//API method PUT, path = localhost:8080/shirts/{clothesId}/small
	@RequestMapping(method = RequestMethod.PUT, path="shirts/{clothesId}/small")
	public String mediumShirts(@PathVariable(value = "clothesId") Long clothesId){
		return small(clothesId);// application class 의 small method 사용

	}
}

