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

import com.app.model.Vendor;
import com.app.service.IVendorService;
import com.app.validator.VendorValidator;

@RestController
@RequestMapping("/rest/vendor")
public class VendorRestController {

	@Autowired
	private IVendorService service;
	
	@Autowired
	private VendorValidator validator;
	
	@GetMapping("/all")
	public ResponseEntity<?> getAll(){
		
		
		ResponseEntity<?> message=null;
		
		List<Vendor> ven=service.getAllVendors();
		
		if(ven==null||ven.isEmpty()) {
			message=new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
		}else {
			message=new ResponseEntity<List<Vendor>>(ven, HttpStatus.OK);
		}
		
		return  message;
	}
	
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getVendor(@PathVariable Integer id){
		
		ResponseEntity<?> message=null;
		
		Vendor ven=service.getOneVendor(id);
		
		if(ven==null) {
			message=new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		else {
			message=new ResponseEntity<>(ven, HttpStatus.OK);
		}
		
		return message;
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteVendor(@PathVariable Integer id){
		
		ResponseEntity<String> message=null;
		
		try {
			
			service.deleteVendor(id);
			message=new ResponseEntity<String>("vendor deleted", HttpStatus.OK);
			
		}catch (Exception e) {
			message=new ResponseEntity<String>(" vendor is'"+id+"' not found",HttpStatus.BAD_REQUEST);
		}
		
		return message;
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> saveVendor(@RequestBody Vendor ven, Errors errors){
		
		ResponseEntity<String> message=null;

		validator.validate(ven, errors);
		
		
		
		try {
		
			if(!errors.hasErrors())
			{			Integer id=service.saveVendor(ven);
			message=new ResponseEntity<>("Vendor '"+id+"' saved successfully..", HttpStatus.OK);
			}
			else {
				message=new ResponseEntity<String>("vendor isn't saved successfully from spring validation", HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}catch (Exception e) {

			message=new ResponseEntity<String>("vendor isn't saved successfully", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return message;
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateVendor(@RequestBody Vendor ven, Errors errors){

		validator.validate(ven, errors);
		
		ResponseEntity<String> message=null;
		
		try {
			if(!errors.hasErrors()) {
				service.updateVendor(ven);
				message=new ResponseEntity<String>("vendor '"+ven.getId()+"' updated successfully", HttpStatus.OK);
			}
			else {
				message=new ResponseEntity<String>("vendor '"+ven.getId()+"'not updated checking validations", HttpStatus.BAD_REQUEST);
			}
		}catch (Exception e) {
			message=new ResponseEntity<String>("vendor '"+ven.getId()+"' not updated", HttpStatus.BAD_REQUEST);
		}
		return message;
	}
}

