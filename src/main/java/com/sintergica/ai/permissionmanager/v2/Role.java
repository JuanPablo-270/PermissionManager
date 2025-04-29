package com.sintergica.ai.permissionmanager.v2;

public enum Role {
    SUPER_ADMIN(0, "super_admin", "Super Admin"),
    ADMIN(1, "admin", "Admin"),
    OWNER(2, "owner", "Owner"),
    USER(3, "user", "User"),
    GUEST(4, "guest", "Guest");

    private final int id;
    private final String name;
    private final String displayName;
    private final String description;

    Role(int id, String name, String displayName) {
        this.id = id;
        this.name = name;
        this.displayName = displayName;
        this.description = "Role: " + displayName;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDisplayName() {
        return displayName;
    }
    public String getDescription() {
        return description;
    }
    public static Role fromId(int id) {
        for (Role role : Role.values()) {
            if (role.getId() == id) {
                return role;
            }
        }
        return null; // or throw an exception
    }
    public static Role fromName(String name) {
        for (Role role : Role.values()) {
            if (role.getName().equalsIgnoreCase(name)) {
                return role;
            }
        }
        return null; // or throw an exception
    }
}