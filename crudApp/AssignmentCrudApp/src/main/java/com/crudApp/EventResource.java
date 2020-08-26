package com.crudApp;

import org.springframework.web.bind.annotation.*;

import com.crudApp.repository.UserRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
@CrossOrigin(origins="http://localhost:3000")
@RestController
public class EventResource {
	 @Autowired
	 //private UserRepository repository;
	 private EventService eventService;
	   // private Users user;

	    @RequestMapping("/adduser")
	    @ResponseStatus(HttpStatus.CREATED)
	    public String add(@RequestParam String name,@RequestParam String address,@RequestParam String city,@RequestParam String state,@RequestParam String country,@RequestParam Long pcode) {
	    	//repository.save(user);
	    	//return "Added User with name : " + user.getName();
	    	
	    	Users u = eventService.add(name, address,city, state, country, pcode);
	    	return u.toString();
	    }
	    
	 /*   @GetMapping("/findUsers")
	    public List<Users> getUsers(){
	    	return repository.findAll();
	    }*/
	    @RequestMapping("/find")
	    public Users getUser(@RequestParam String name) {
	    	return eventService.getByName(name);
	    }
	    @RequestMapping("/findAll")
	    public List<Users> getAll(){
	    	return eventService.getall();
	    }
	    
	    @RequestMapping("/update")
	    public String update(@RequestParam String name,@RequestParam String address,@RequestParam String city,@RequestParam String state,@RequestParam String country,@RequestParam Long pcode) {
	    Users u = eventService.update(name, address,city, state, country, pcode);
	    return u.toString();
	    }	
	    
	    @RequestMapping("/delete")
	    public String delete(@RequestParam String name) {
	    	eventService.delete(name);
	    	return "Deleted : "+name;
	    }
	    @RequestMapping("/deleteAll")
	    public String deleteAll(){
	    	eventService.deleteall();
	    	return "Deleted All Records";
	    }
	   /* @GetMapping("/findUsers/{id}")
	    public Optional<Users> getUsers(@PathVariable String id){
	    	return repository.findById(id);
	    }
	    
	    @DeleteMapping("delete/{id}")
	    public String deleteUser (@PathVariable String id) {
	    	 repository.deleteById(id);
	    	 return "User deleted with name : "  +id;
	    }*/
	   /* 
	    @GetMapping(value="/user")
	    @CrossOrigin
	    public Users getUserData() {
	        user.setName("sany rawat");
	        user.setAddress("Azamgarh");
	        user.setState("Uttar Pradesh");
	        user.setCity("Azamgarh");
	        user.setPcode(276137);
	        return user;
	    }*/
	

}
