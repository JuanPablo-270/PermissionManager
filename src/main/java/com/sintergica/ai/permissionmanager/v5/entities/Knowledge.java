package com.sintergica.ai.permissionmanager.v5.entities;

public class Knowledge extends Entity {
    private String description;

    public Knowledge() {
    }

    public Knowledge(String name, String description) {
        super(name);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}