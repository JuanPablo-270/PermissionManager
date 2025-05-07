package com.sintergica.ai.permissionmanager.v5.entities;

import java.util.UUID;

public class User {

        private String name;
        private UUID ID;

        public User() {
        }

        public User(String name, UUID ID) {
            this.name = name;
            this.ID = ID;
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
    }