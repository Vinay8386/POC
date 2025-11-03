package com.service;

import java.util.ArrayList;
import java.util.List;

public class UserService {
	
	private List<String> users = new ArrayList<>();

    public void addUser(String name) {
        if (name == null) throw new IllegalArgumentException("Name cannot be null");
        users.add(name);
    }

    public boolean userExists(String name) {
        return users.contains(name);
    }

    public List<String> getAllUsers() {
        return new ArrayList<>(users); 
    }
}
