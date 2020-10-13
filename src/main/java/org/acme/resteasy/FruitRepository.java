package org.acme.resteasy;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class FruitRepository {

    @Inject
    private EntityManager em;

    @Transactional
    public void saveNew(Fruit fruit) {
        em.persist(fruit);
    }

    @Transactional
    public Fruit getById(String id) {
        return em.find(Fruit.class, id);
    }

    @Transactional
    public List<Fruit> getAll() {
        return em.createQuery("from Fruit").getResultList();
    }

}
