package com.cg.bus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bus.Users;
import com.cg.bus.exception.UserAlreadyExistException;
import com.cg.bus.exception.UserNotFoundException;
import com.cg.bus.repository.IUserRepository;
@Service
public class UserService implements IUserService {

	@Autowired IUserRepository userrepo;
	
	@Override
	public String addUser(Users user) {
		Optional<Users> us = userrepo.findById(user.getUserLoginId());
		if(us.isPresent()) {
			throw new UserAlreadyExistException("User with this "+user.getUserLoginId()+" user id is already exist");
		}
		else {
		userrepo.save(user);
		return "User record added successfully";
		}
	}

	@Override
	public String updateUser(Users user){
		Optional<Users> us = userrepo.findById(user.getUserLoginId());
		if(us.isPresent()) {
			userrepo.save(user);
			return "User record updated successfully";		
			}
		else {
			throw new UserNotFoundException("This user is not found");
		}
	}


	@Override
	public Users viewUser(int userid) {
		Optional<Users> user = userrepo.findById(userid);
		if(user.isPresent())
		{
			return userrepo.findById(userid).get();
		}
		else {
			throw new UserNotFoundException("User of this "+userid+" user id is not found");
		}
		
	}

	@Override
	public List<Users> viewAllUsers() {
		return userrepo.findAll();
	}

}
