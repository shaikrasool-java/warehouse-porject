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

import com.app.model.PurchaseOrder;
import com.app.service.IPurchaseOrderService;
import com.app.validator.PurchaseOrderValidator;

@RestController
@RequestMapping("/rest/purchase")
public class PurchaseRestController {

	@Autowired
	private IPurchaseOrderService service;

	@Autowired
	private PurchaseOrderValidator validator;


	ResponseEntity<?> message=null;
	ResponseEntity<String> msg=null;



	@GetMapping("/all")
	public ResponseEntity<?> getAll(){

		List<PurchaseOrder> list=service.getAllOrders();
		if(list==null||list.isEmpty()) {
			message=new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		else {
			message=new ResponseEntity<List<PurchaseOrder>>(list,HttpStatus.OK);
		}
		return message;
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getOnePorder(@PathVariable("id") Integer id){

		PurchaseOrder order=service.getOneOrder(id);
		if(order==null) {
			message=new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		else {
			message=new ResponseEntity<PurchaseOrder>(order,HttpStatus.OK);
		}
		return message;
	}


	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteOrder(@PathVariable("id")Integer id){

		try {
			service.deleteOrder(id);
			msg=new ResponseEntity<String>("deleted successfully...", HttpStatus.OK);
		}catch (Exception e) {

			msg=new ResponseEntity<String>("isnt deleted successfully...", HttpStatus.BAD_REQUEST);
		}
		return msg;
	}

	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody PurchaseOrder order, Errors errors){

		validator.validate(order, errors);

		try {

			if(!errors.hasErrors()) {
				msg=new ResponseEntity<String>("order saved", HttpStatus.OK);
			}else {
				msg=new ResponseEntity<String>("order not saved validations applied", HttpStatus.BAD_REQUEST);
			}
		}catch (Exception e) {
			msg=new ResponseEntity<String>("order not saved", HttpStatus.BAD_REQUEST);
		}
		return msg;
	}

	@PutMapping("/update")
	public ResponseEntity<String> updateOrder(@RequestBody PurchaseOrder po, Errors errors){

		validator.validate(po, errors);

		try {
			service.updateOrder(po);
			if(!errors.hasErrors()) {
				msg=new ResponseEntity<String>("order updated", HttpStatus.OK);
			}else {
				msg=new ResponseEntity<String>("order not updated validations applied", HttpStatus.BAD_REQUEST);
			}
		}catch (Exception e) {
			msg=new ResponseEntity<String>("order not updated", HttpStatus.BAD_REQUEST);
		}
		return msg;
	}
}
