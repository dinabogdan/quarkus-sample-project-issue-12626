package org.acme.resteasy;

import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.container.DynamicFeature;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.Provider;

@Provider
@ApplicationScoped
public class ExampleProvider implements DynamicFeature {

    @Inject
    FruitRepository fruitRepository;

    @Override
    public void configure(ResourceInfo resourceInfo, FeatureContext featureContext) {
        Fruit fruit = new Fruit(UUID.randomUUID().toString(), "Provided fruit");
        fruitRepository.saveNew(fruit);
    }
}
