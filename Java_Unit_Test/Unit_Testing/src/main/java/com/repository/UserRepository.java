package com.repository;

import com.model.User;

public interface UserRepository {
	User findByName(String name);
    void save(User user);
}
