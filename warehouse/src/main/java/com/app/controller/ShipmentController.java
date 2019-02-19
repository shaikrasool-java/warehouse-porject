package com.app.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateOptimisticLockingFailureException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.ShipmentTypValidator;
import com.app.model.ShipmentType;
import com.app.service.IShipmentTypeService;
import com.app.view.ShipmentTypeExcelView;
import com.app.view.ShipmentTypePfView;

@Controller
@RequestMapping("/shipmenttype")
public class ShipmentController {

	@Autowired
	private IShipmentTypeService service;

	@Autowired
	private ShipmentTypValidator validator;
	
	//show registration page
	@RequestMapping("/reg")
	public String showShipment(ModelMap map) {
		map.addAttribute("shipment", new ShipmentType());
		return "ShipmentRegister";
	}
	//registration page
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
		public String saveShipment(@ModelAttribute("shipment") ShipmentType shipment, Errors errors,ModelMap map) {
	
		validator.validate(shipment, errors);
		
		if(!errors.hasErrors()) {
			
		Integer i=service.saveShipment(shipment);
		String msg="shipment '"+i+"' registered successfully";
		map.addAttribute("message", msg);
		map.addAttribute("shipment", new ShipmentType());
		}
		return "ShipmentRegister";
		}
	// get all shipments
	
	@RequestMapping("/all")
	public String showShipments(ModelMap map) {
		List<ShipmentType> ls=service.getAllShipments();
		map.addAttribute("shipment", ls);
		return "ShipmentTypeData";
	}
	//delete one record from shipment table based on id
	@RequestMapping("/delete")
	public String deleteShipment(@RequestParam("id") Integer id, ModelMap map) {
			String message=null;
		try {
		service.deleteShipment(id);
			message="success";
		}catch (HibernateOptimisticLockingFailureException e) {
			message="shipment is not found";
		}
		String msg="Shipment '"+id+"' deleted successfully";
		List<ShipmentType> ls=service.getAllShipments();
		map.addAttribute("message", msg);
		map.addAttribute("shipment", ls);
		return "ShipmentTypeData";
	}
	//show edit page
	@RequestMapping("/edit")
	public String editShipment(@RequestParam("id") Integer id, ModelMap map) {
	ShipmentType s=service.getOneShipment(id);
		map.addAttribute("shipment", s);
		return "ShipmentEdit";
	}

	//updatation page
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updateOrder(@ModelAttribute ShipmentType shipment, ModelMap map) {
		service.updateShipment(shipment);
		String msg="Order id'"+shipment.getId()+"' updated successfully";
		map.addAttribute("message", msg);
		List<ShipmentType> li=service.getAllShipments();
		map.addAttribute("shipment", li);
		return "ShipmentTypeData";
	}
//exporting to excel
	@RequestMapping("excel")
	public ModelAndView showExcel() {
		List<ShipmentType> ls=service.getAllShipments();
		ModelAndView m=new ModelAndView();
		m.setView(new ShipmentTypeExcelView());
		m.addObject("ls", ls);
		return m;
	}
	//exporting to pdf
	@RequestMapping("/pdf")
	public ModelAndView showPdf() {
		List<ShipmentType> ls=service.getAllShipments();
		ModelAndView m=new ModelAndView();
		m.setView(new ShipmentTypePfView());
		m.addObject("ls", ls);
		return m;
	}
	}
