package org.acme.resteasy;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/resteasy/fruits")
public class ExampleResource {


    @Inject
    private FruitRepository fruitRepository;

    @GET
    @Path("{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Fruit getFruitById(@PathParam("id") final String id) {
        return fruitRepository.getById(id);
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public List<Fruit> getAll() {
        return fruitRepository.getAll();
    }

    @POST
    public void produce() {
        Fruit fruit1 = new Fruit("1", "Apple");
        Fruit fruit2 = new Fruit("2", "Orange");

        fruitRepository.saveNew(fruit1);
        fruitRepository.saveNew(fruit2);

    }
}