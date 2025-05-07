package com.sintergica.ai.permissionmanager.v5.entities;

public class Model extends Entity {
    private String description;
    private String type;

    public Model() {
    }

    public Model(String name, String description, String type) {
        super(name);
        this.description = description;
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}