package com.sintergica.ai.permissionmanager.v2;


import java.util.EnumMap;
import java.util.EnumSet;

/**
 * @author Panther
 * 
 * 
 */
public class User {
    private String name;
    private String email;
    private String password;
    
    private final EnumMap<Permission, EnumMap<Scope, EnumSet<Scope>>> grants;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.grants = new EnumMap(Permission.class);
    }

    /* Getters & Seters */
    
    /* Getters */
    public String getName() { return name; }

    public String getEmail() { return email; }

    public String getPassword() { return password; }

    /* Setters */
    public void setName(String name) { this.name = name; }

    public void setEmail(String email) { this.email = email; }

    public void setPassword(String password) { this.password = password; }
    
    public EnumMap<Permission, EnumMap<Scope, EnumSet<Scope>>> getGrants() { return grants; }
    
    /* Custom Methods */
    public String toStringGrants() { return grants.toString(); }
    
    /**
     * 
     * @author Panther
     * @param permission
     * @param scopes 
     */
    public void addGrant(Permission permission, EnumMap<Scope,EnumSet<Scope>> scopes) {
        grants.put(permission, scopes);
    }

    /**
     * 
     * @author Panther
     * @param permission
     * @param scope
     * @param subScope 
     */
    public void addGrant(Permission permission, Scope scope, Scope subScope) {
        if(grants.containsKey(permission)){
            if(grants.get(permission).containsKey(scope)){
                grants.get(permission).get(scope).add(subScope);
            }else{
                grants.get(permission).put(scope, EnumSet.of(subScope));
            }
        }else{
            EnumMap<Scope,EnumSet<Scope>> scopesMap = new EnumMap<>(Scope.class);
            
            scopesMap.put(scope, EnumSet.of(subScope));
            
            grants.put(permission,scopesMap);
        }
    }

    /**
     * 
     * @author Panther
     * @param permission
     * @param scope
     * @param subScope 
     */
    public void addGrant(Permission permission, EnumSet<Scope> scopes, EnumSet<Scope> subScopes) {
        if(grants.containsKey(permission)){
            EnumMap<Scope, EnumSet<Scope>> scopesMap = new EnumMap<>(Scope.class);
            for (Scope scope : scopes) {
                scopesMap.put(scope, subScopes);
            }
            grants.get(permission).putAll(scopesMap);
        }else{
            EnumMap<Scope, EnumSet<Scope>> scopesMap = new EnumMap<>(Scope.class);
            for (Scope scope : scopes) {
                scopesMap.put(scope, subScopes);
            }
            grants.put(permission, scopesMap);
        }
    }
    
    /* Overrided Methods */

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", grants=" + grants +
                '}';
    }
}