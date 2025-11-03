package com;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.service.UserService;

public class UserServiceTest {
	
	UserService userService;
	
	@BeforeEach
	void init() {
		userService=new UserService();
	}
	
	@Test
	public void testAddAndExistUser() {
		userService.addUser("Vinay"); 
		assertTrue(userService.userExists("Vinay"));
	}
	/*
	 This is a common test case for both the method: addUser and userExists
	 Behavior of addUser method is to add user which is action but in Junit test we should have both action and verification.
	 Similarly userExists check user is available or not which is verification, but in test case action is mandate to verify.
	 So both method will have same test case.
	 In addUser we have edge case in case of null which is handled below.
	 */
	//Edge case handle
	@Test
	public void testAddUserWithNull() {
		assertThrows(IllegalArgumentException.class, () -> userService.addUser(null));
	}
	
	@Test
	public void getAllUserTest() {
		//do action by creating a dummy user
		userService.addUser("Vinay");
		userService.addUser("Aman");
		List<String> users=userService.getAllUsers();
		assertEquals(2,users.size());
		assertTrue(users.contains("Vinay"));
		assertTrue(users.contains("Aman"));
	}
	
}
