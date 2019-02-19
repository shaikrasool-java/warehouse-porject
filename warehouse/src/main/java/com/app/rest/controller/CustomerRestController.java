package com.app.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Customer;
import com.app.service.ICustomerService;
import com.app.validator.CustomerValidator;
@RestController
@RequestMapping("/rest/customer")
public class CustomerRestController {
	
	@Autowired
	private ICustomerService service;

	@Autowired
	private CustomerValidator validator;
	
	
	ResponseEntity<?> message=null;
	ResponseEntity<String> msg=null;
	
	
	@GetMapping("/all")
	public ResponseEntity<?> getAll(){
		
		
		List<Customer> cust=service.getAllCusts();
		
		if(cust==null||cust.isEmpty()) {
			message=new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		else {
			message=new ResponseEntity<List<Customer>>(cust,HttpStatus.OK);
		}
		return message;
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getOneCust(@PathVariable("id") Integer cId){
		
		Customer cust=service.getOneCustomer(cId);
		if(cust==null) {
			message=new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		else {
			message=new ResponseEntity<Customer>(cust,HttpStatus.OK);
		}
		
		return message;
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("id") Integer cId){
		
		try {
			service.deleteCustomer(cId);
			msg=new ResponseEntity<String>("Customer '"+cId+"' deleted successfully", HttpStatus.OK);
			
		}catch (Exception e) {
			msg=new ResponseEntity<String>("customer not found", HttpStatus.BAD_REQUEST);
		}
		return msg;
	}
	@PostMapping("/save")
	public ResponseEntity<String> saveCustomer(@RequestBody Customer cust, Errors errors){
		
		validator.validate(cust, errors);
		try {
			if(!errors.hasErrors()) {
				service.saveCustomer(cust);
				msg =new ResponseEntity<String>("customer created successfully", HttpStatus.OK); 
			}
			else {
				msg=new ResponseEntity<String>("customer validations applied", HttpStatus.BAD_REQUEST);
			}
		}catch (Exception e) {
			msg=new ResponseEntity<String>("customer not created", HttpStatus.BAD_REQUEST);
				
		
		}
		return msg;
	}
	@PutMapping("/update")
	public ResponseEntity<String> updateOrder(@RequestBody Customer cust,Errors errors){
		
		try {
			if(!errors.hasErrors()) {
				service.updateCustomer(cust);
				msg=new ResponseEntity<String>("updated customer", HttpStatus.OK);
			}else {
				msg=new ResponseEntity<String>("customer not updated, validations applied", HttpStatus.BAD_REQUEST);
			}
		}catch (Exception e) {
			msg=new ResponseEntity<String>("customer not updated", HttpStatus.BAD_REQUEST);
		}
		
		
		return msg;
	}
}
