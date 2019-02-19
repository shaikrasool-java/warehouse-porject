package com.app.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;

@RestController
@RequestMapping("/rest/whusertype")
public class WhUserTypeRestController {

	@Autowired
	private IWhUserTypeService service;
	
	

	
	@RequestMapping("/all")
	public ResponseEntity<?> getAll(){
		
		ResponseEntity<?> message=null;
		List<WhUserType> wuser=service.getALlUsers();
		if(wuser==null||wuser.isEmpty()) {
			message=new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
		}else {
			message=new ResponseEntity<List<WhUserType>>(wuser, HttpStatus.OK);
		}
		
		return message;
	}
	
	@RequestMapping("/get/{id}")
	public ResponseEntity<?> getOneUser(@PathVariable Integer id){
		
		ResponseEntity<?> message=null;
		WhUserType wuser=service.getOneUser(id);
		

		if(wuser==null) {
			message=new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		else {
			message=new ResponseEntity<>(wuser, HttpStatus.OK);
		}
		return message;
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Integer id){
		
		ResponseEntity<String> message=null;
		
	
		try {
			service.deleteUser(id);
			message=new ResponseEntity<String>("User '"+id+"' deleted successfullu", HttpStatus.OK);
			
		}catch (Exception e) {

			message=new ResponseEntity<String>("User not deleted", HttpStatus.BAD_REQUEST);
		}
		return message;
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> saveUser(@RequestBody WhUserType wuser){
		
		ResponseEntity<String> message=null;
		
		try {
			Integer id=service.saveUser(wuser);
			message=new ResponseEntity<String>("User '"+id+"' saved successfully...", HttpStatus.OK);
		}catch (Exception e) {
			message=new ResponseEntity<String>("User not saved", HttpStatus.BAD_REQUEST);
		}
		return message;
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateUser(@RequestBody WhUserType wuser){
		
		ResponseEntity<String> message=null;
		
		try {
			
			service.updateUser(wuser);
			message=new ResponseEntity<String>("User '"+wuser.getId()+"' updated successfully", HttpStatus.OK);
		}catch (Exception e) {
			
			message=new ResponseEntity<String>("User not found", HttpStatus.BAD_REQUEST);
		
		}
		return  message;
	}
	
}
