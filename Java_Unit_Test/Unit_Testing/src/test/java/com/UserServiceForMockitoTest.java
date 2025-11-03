package com;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.model.User;
import com.repository.UserRepository;
import com.service.UserServiceForMockito;

@ExtendWith(MockitoExtension.class)
public class UserServiceForMockitoTest {
	
	//Tells Mockito to create a mock object of type UserRepository. This is not a real implementation — it's a fake that can be controlled by stubbing.
	@Mock
	UserRepository userRepository; 
	
	
	//Tells Mockito to inject the above mock (userRepository) into the UserService object.
	//That means when service.userExists() calls repo.findByName(...), it will call the mock, not real logic.		
	@InjectMocks
	UserServiceForMockito userService;
	
	
	@Test
    void testUserExistsWhenUserFound() {
		
		//Stubbing: you're saying “If someone calls repo.findByName("Alice"), return a new User("Alice") instead of doing actual DB logic.”
        when(userRepository.findByName("Vinay")).thenReturn(new User("Vinay"));
        
        //Calls your real service method. Internally, it will call repo.findByName("Alice"), which is mocked above.
        boolean exist=userService.userExists("Vinay");
        
        //Asserts that the result from the service is true.
        assertTrue(exist);
        
        
        //Optional: Verifies that findByName("Alice") was actually called during the test.
        verify(userRepository).findByName("Vinay");
        
    }
	
	@Test
    void testRegisterUserWhenUserNotFound() {
        when(userRepository.findByName("Bob")).thenReturn(null);

        userService.registerUser("Bob");

        verify(userRepository).save(any(User.class));
    }

    @Test
    void testRegisterUserWhenUserAlreadyExists() {
        when(userRepository.findByName("Bob")).thenReturn(new User("Bob"));

        userService.registerUser("Bob");

        verify(userRepository, never()).save(any());
    }
}
