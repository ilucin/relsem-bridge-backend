package com.etk.manager;

/**
 * Created by mladen on 11/9/13.
 */
public class User {
    private String username;

    public User(String username) {
        this.username = username;
    }


    @Override
    public boolean equals(Object obj) {
        if(obj instanceof User) {
            if(((User)obj).getUsername().equals(this.username)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.username.hashCode();
    }

    public String getUsername() {
        return username;
    }
}
