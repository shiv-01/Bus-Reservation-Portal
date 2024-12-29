package com.cg.bus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bus.Users;
import com.cg.bus.service.UserService;


@RestController
@CrossOrigin(origins="http://localhost:4200")
public class UserController {

	@Autowired UserService userservice;
	
	@RequestMapping(value="/getallusers",method=RequestMethod.GET)
	public java.util.List<Users> getAllUsers(){
		return userservice.viewAllUsers();
	}
	
	 @RequestMapping(value = "/adduser", method=RequestMethod.POST)
	 public String addUser(@RequestBody Users user) {
		 return userservice.addUser(user);
	 }
	 
	 @RequestMapping(value = "/getuserbyid/{userloginid}",method=RequestMethod.GET)
	 public Users getUser(@PathVariable("userloginid")int userloginid) {
	 	return userservice.viewUser(userloginid);
	 }
	 
	 
	 @RequestMapping(value = "/upduser", method=RequestMethod.PUT)
	 public String updateUser(@RequestBody Users user) {
		 return userservice.updateUser(user);
	 }
}
