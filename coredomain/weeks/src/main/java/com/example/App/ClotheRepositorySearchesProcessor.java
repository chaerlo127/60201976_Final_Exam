package com.example.App;

import com.example.App.domain.Clothe;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class ClotheRepositorySearchesProcessor implements RepresentationModelProcessor<EntityModel<Clothe>>{

  //url로 search 가능하도록 선언해주는 것임
    @Override
    public EntityModel<Clothe> process(EntityModel<Clothe> model) {
        //localhost:8080/pants/large
        //localhost:8080/shirts/large
        model.add(Link.of(model.getRequiredLink("self").getHref() + "/large").withRel("large"));
        //localhost:8080/pants/small
        //localhost:8080/shirts/small
        model.add(Link.of(model.getRequiredLink("self").getHref() + "/small").withRel("small"));
        model.add(Link.of(model.getRequiredLink("self").getHref() + "/like").withRel("like"));
        return model;
    }
    
}
