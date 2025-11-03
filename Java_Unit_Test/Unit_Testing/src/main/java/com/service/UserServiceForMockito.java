package com.service;

import com.model.User;
import com.repository.UserRepository;

public class UserServiceForMockito {
	
	private final UserRepository repo;

    public UserServiceForMockito(UserRepository repo) {
        this.repo = repo;
    }

    public boolean userExists(String name) {
        return repo.findByName(name) != null;
    }

    public void registerUser(String name) {
        if (repo.findByName(name) == null) {
            repo.save(new User(name));
        }
    }
}
