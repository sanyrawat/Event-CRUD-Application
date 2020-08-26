package com.crudApp;

import com.crudApp.Users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudApp.repository.UserRepository;

@Service
public class EventService {
	@Autowired
	private UserRepository userRepository;
	
	public Users add(String name,String address,String city,String state,String country,Long pcode) {
		return userRepository.save(new Users(name,address,city,state,country,pcode));
	}
	
	public List<Users>getall(){
		return userRepository.findAll();
	}
	public Users getByName(String name) {
		return userRepository.findByName(name);
	}
	public Users update(String name,String address,String city,String state,String country,Long pcode) {
		Users u=userRepository.findByName(name);
		u.setAddress(address);
		u.setCity(city);
		u.setState(state);
		u.setCountry(country);
		u.setPcode(pcode);
		return userRepository.save(u);
	}
	public void deleteall() {
		userRepository.deleteAll();
	}
	public void delete(String name) {
		Users u=userRepository.findByName(name);
		userRepository.delete(u);
	}
}
