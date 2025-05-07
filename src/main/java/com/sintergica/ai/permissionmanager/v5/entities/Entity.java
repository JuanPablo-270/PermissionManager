package com.sintergica.ai.permissionmanager.v5.entities;


import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public abstract class Entity {
    private String name;
    private UUID ID;
    private final Map<UUID, Integer> permissions = new HashMap<>();

    public Entity() {
    }

    public Entity(String name, UUID ID) {
        this.name = name;
        this.ID = ID;
    }
    
    public Entity(String name) {
        this.name = name;
        this.ID = UUID.randomUUID() ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getID() {
        return ID;
    }

    public void setID(UUID ID) {
        this.ID = ID;
    }

    public Map<UUID, Integer> getPermissions() {
        return permissions;
    }

    public void setPermissions(Map<UUID, Integer> permissions) {
        this.permissions.clear();
        this.permissions.putAll(permissions);
    }
}