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

import com.app.model.OrderMethod;
import com.app.service.IOrderMethodService;
import com.app.validator.OrderMethodValidator;

@RestController
@RequestMapping("/rest/ordermethod")
public class OrderMethodRestController {

	@Autowired
	private IOrderMethodService service;
	@Autowired
	private OrderMethodValidator validator;
	
	@GetMapping("/all")
	public ResponseEntity<?> getAll(){


		ResponseEntity<?> message=null;

		List<OrderMethod> order=service.getAllOrders();

		if(order == null || order.isEmpty()) {
			message=new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		else {
			message=new ResponseEntity<List<OrderMethod>>(order, HttpStatus.OK);
		}
		return message;
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<?> getOneOrder(@PathVariable("id") Integer id){

		ResponseEntity<?> message=null;
		OrderMethod order=service.getOneOrder(id);

		if(order==null) {
			message=new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		else {

			message=new ResponseEntity<OrderMethod>(order, HttpStatus.OK);
		}
		return message;
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteOrderMethod(@PathVariable Integer id){

		ResponseEntity<String> message=null;

		try {
			service.deleteOrder(id);
			message=new ResponseEntity<String>("Record delete successfully...", HttpStatus.OK);
		}
		catch (Exception e) {
			message=new ResponseEntity<String>("record not found", HttpStatus.BAD_REQUEST);

		}
		return message;
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody OrderMethod order, Errors errors){
		
		ResponseEntity<String> message=null;
		
		validator.validate(order, errors);
		
		try {
			if(!errors.hasErrors()) {
				Integer i=service.saveOrder(order);
				message=new ResponseEntity<String>("order is saved successfully", HttpStatus.OK);
			}
			else {
				message=new ResponseEntity<String>("order is not saved", HttpStatus.BAD_REQUEST);
			}
		
		}catch (Exception e) {

		message=new ResponseEntity<String>("order not saved", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return message;
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateOrder(@RequestBody OrderMethod order){
		
		ResponseEntity<String> message=null;
		
		try {
			service.updateOrder(order);
			
			message=new ResponseEntity<String>("order method is updated", HttpStatus.OK);
			
			
		}catch (Exception e) {

			message=new ResponseEntity<String>("order method is not updated", HttpStatus.BAD_REQUEST);
		}
		
		return message;
	}
	}
