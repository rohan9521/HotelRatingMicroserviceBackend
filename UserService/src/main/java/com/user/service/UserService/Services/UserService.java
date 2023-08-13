package com.user.service.UserService.Services;

import com.user.service.UserService.Entities.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService{
	User saveUser(User user);
	
	List<User> getAllUser();

	User getUser(String userId);

	User findUserByUserName(String userName);
	
	//TODO
	//userupdate
	//userdelete
}