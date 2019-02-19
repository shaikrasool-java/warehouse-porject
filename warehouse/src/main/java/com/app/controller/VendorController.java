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

import com.app.model.Vendor;
import com.app.service.IVendorService;
import com.app.validator.VendorValidator;
import com.app.view.VendorExcelView;
import com.app.view.VendorPdfView;

@Controller
@RequestMapping("/vendor")
public class VendorController {
	@Autowired
	private IVendorService service;

	@Autowired
	private VendorValidator validator;
	
	//showing registration page
	@RequestMapping("/reg")
	public String showPage(ModelMap map) {
		map.addAttribute("ven", new Vendor());
		return "VendorRegistration";
	}
	//saving registration data
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String saveData(@ModelAttribute("ven") Vendor ven,Errors errors, ModelMap map) {
		
		validator.validate(ven, errors);
		if(!errors.hasErrors()) {
			
		Integer i=service.saveVendor(ven);
		String msg="Vendor '"+i+"' saved successfully";
		map.addAttribute("message", msg);
		//clearing data and returning to same registration page
		map.addAttribute("ven", new Vendor());
		}
		return "VendorRegistration";
	}
	//fetching all the data from data base
	@RequestMapping("/all")
	public String getAll(ModelMap map) {
		List<Vendor> lv=service.getAllVendors();
		map.addAttribute("list", lv);
		return "VendorData";
	}
	
	
	
	//deleting record from database
	@RequestMapping("/delete")
	public String deleteVendor(@RequestParam("id")Integer id,ModelMap map) {
		
		String message=null;
		try{
		service.deleteVendor(id);
		message="success";;
		}catch (HibernateOptimisticLockingFailureException e) {
			message="vendor not found";
		}
		String msg="Vendor '"+id+"' deleted successfully....";
		map.addAttribute("message", msg);
		List<Vendor> lv=service.getAllVendors();
		map.addAttribute("list",lv);
		return "VendorData";
	}
	
	//editing vendor details
	@RequestMapping("/edit")
	public String editPage(@RequestParam("id")Integer id,ModelMap map) {
		Vendor v=service.getOneVendor(id);
		map.addAttribute("ven", v);
		return "VendorEdit";
	}
	
	//updating vendor record
	@RequestMapping(value="/update", method=RequestMethod.POST)
	 public String updateVendor(@ModelAttribute Vendor ven, ModelMap map) {
		service.updateVendor(ven);
		String msg="Vendor Record '"+ven.getId()+"' updated successfully..........";
		map.addAttribute("message", msg);
		List<Vendor> lv=service.getAllVendors();
		map.addAttribute("list", lv);
		 return "VendorData";
	 }
	//exporting data to excel sheet
	@RequestMapping("/excel")
	public ModelAndView showExcel() {
		List<Vendor> lv=service.getAllVendors();
		ModelAndView m=new ModelAndView();
		m.setView(new VendorExcelView());
		m.addObject("lv", lv);
		return m;
	}
	//exporting data to pdf document
	@RequestMapping("/pdf")
	public ModelAndView showPdf() {
		List<Vendor> lv=service.getAllVendors();
		ModelAndView m=new ModelAndView();
		m.setView(new VendorPdfView());
		m.addObject("lv", lv);
		return m;
	}
	
}
