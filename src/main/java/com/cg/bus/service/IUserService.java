package com.cg.bus.service;

import java.util.List;

import com.cg.bus.Users;


public interface IUserService {

	public String addUser(Users user);
	public String updateUser(Users user);
	public Users viewUser(int userid);
	public List<Users> viewAllUsers();
}
