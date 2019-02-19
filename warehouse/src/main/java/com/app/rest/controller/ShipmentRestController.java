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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.OrderMethod;
import com.app.model.ShipmentTypValidator;
import com.app.model.ShipmentType;
import com.app.service.IShipmentTypeService;

@RestController
@RequestMapping("/rest/shipment")
public class ShipmentRestController {

	@Autowired
	private IShipmentTypeService service;
	
	@Autowired
	private ShipmentTypValidator validator;
	
	ResponseEntity<?> message=null;
	ResponseEntity<String> msg=null;
	
	@GetMapping("/all")
	public ResponseEntity<?> getAll(){
		
	List<ShipmentType> shipment=service.getAllShipments();
	
	if(shipment==null||shipment.isEmpty()) {
		message=new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	else {
		message=new ResponseEntity<List<ShipmentType>>(shipment,HttpStatus.OK);
	}
		return message;
	}
	
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getOneShipment(@PathVariable("id") Integer id){
	
			ShipmentType shipment=service.getOneShipment(id);
			
		if(shipment==null) {
			message=new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		else {
			message=new ResponseEntity<ShipmentType>(shipment,HttpStatus.OK);
		}
		
	return message;
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id){
		
			try {
				
				service.deleteShipment(id);
				msg=new ResponseEntity<String>("shipment deleted successfully..", HttpStatus.OK);
			}catch (Exception e) {
				msg=new ResponseEntity<String>("shipment is not deleted", HttpStatus.BAD_REQUEST);
			
			}
		return msg;
	}
	
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody ShipmentType shipment, Errors errors){
	
		try {
			if(!errors.hasErrors()) {
				Integer i=service.saveShipment(shipment);
				msg=new ResponseEntity<String>("Shipment created",HttpStatus.OK);
			}else {
				msg=new ResponseEntity<String>("shipment not created validations applied", HttpStatus.BAD_REQUEST);
			}
		}catch (Exception e) {
			// TODO: handle exception
			msg=new ResponseEntity<String>("shipment not created", HttpStatus.BAD_REQUEST);
		}
	return msg;
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<String> updateOrder(@RequestBody ShipmentType shipment, Errors errors){
		try {
			if(!errors.hasErrors()) {
				service.updateShipment(shipment);
				msg=new ResponseEntity<String>("shipment updated....", HttpStatus.OK);
			}else {
				msg=new ResponseEntity<String>("Shipment not updated validations appplies", HttpStatus.BAD_REQUEST);
			}
		}catch (Exception e) {
			msg=new ResponseEntity<String>("shipment not updated", HttpStatus.BAD_REQUEST);
		}
		return msg;
	}
}


