package main.java.fields;

import main.java.models.Models;

public class ForeignKey extends Field {
    private Class<? extends Models> relatedModel;

    public ForeignKey(String name, Class<? extends Models> relatedModel) {
        super(name);
        this.relatedModel = relatedModel;
    }

    public Class<? extends Models> getRelatedModel() {
        return relatedModel;
    }
}