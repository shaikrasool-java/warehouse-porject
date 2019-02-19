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

import com.app.model.Uom;
import com.app.service.IUomService;
import com.app.validator.UomValidator;

@RestController
@RequestMapping("/rest/uom")
public class UomRestController {

	@Autowired
	private IUomService service;

	@Autowired
	private UomValidator validator;

	@GetMapping("/all")
	public ResponseEntity<?> getAll(){

		ResponseEntity<?> message=null;


		List<Uom> uoms=service.getAll();

		if(uoms==null ||uoms.isEmpty()) {
			message=new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		else {
			message=new ResponseEntity<List<Uom>>(uoms, HttpStatus.OK);
		}
		return message;
	}

	//get one by id
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getOne(@PathVariable Integer id){

		ResponseEntity<?> message=null;

		Uom uom=service.getOne(id);

		if(uom==null) {
			message=new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		else {
			message=new ResponseEntity<Uom>(uom, HttpStatus.OK);		
		}

		return message;
	}


	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteUom(@PathVariable Integer id){

		ResponseEntity<String> message=null;

		try {
			service.deletUom(id);
			message=new ResponseEntity<String>("deleted succcessfulllllly....", HttpStatus.OK);
		}catch (Exception e) {

			message=new ResponseEntity<String>("data not found", HttpStatus.BAD_REQUEST);
		}

		return message;
	}
	@PostMapping("/save")
	public ResponseEntity<String> saveUom(@RequestBody Uom uom, Errors errors){
		validator.validate(uom, errors);
		ResponseEntity<String> message=null;
		try {
			if(!errors.hasErrors()) {
				Integer id=service.saveUom(uom);
				message=new ResponseEntity<String>("Uom '"+uom.getId()+"' saved successfully", HttpStatus.OK);
			}
			else {
				message=new ResponseEntity<String>("Uom bad Request", HttpStatus.BAD_REQUEST);
			}
		}catch (Exception e) {
			message=new ResponseEntity<String>("uom is saved", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return message;
	}
	@PutMapping("/update")
	public ResponseEntity<String> updateUom(@RequestBody Uom uom,Errors errors){
		
		validator.validate(uom, errors);
		ResponseEntity<String> message=null;
		try {
			if(!errors.hasErrors()) {
			service.updateUom(uom);
			message=new ResponseEntity<String>("Uom '"+uom.getId()+"' updated successfullu", HttpStatus.OK);
			}
			else {
				message=new ResponseEntity<String>("Uom isn't found", HttpStatus.BAD_REQUEST);
			}
		}catch (Exception e) {
			message=new ResponseEntity<String>("uom is not found", HttpStatus.BAD_REQUEST);
		}
		return message;
	}
	
	
}
