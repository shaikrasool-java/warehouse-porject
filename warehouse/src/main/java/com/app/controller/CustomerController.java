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

import com.app.model.Customer;
import com.app.service.ICustomerService;
import com.app.validator.CustomerValidator;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerValidator custvalidator;


	@Autowired
	private ICustomerService service;

	@RequestMapping("/reg")
	public String showPage(ModelMap map) {
		map.addAttribute("cust", new Customer());
		return "CustomerRegister";
	}

	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String showPage(@ModelAttribute("cust") Customer cust,Errors errors,ModelMap map) {

		custvalidator.validate(cust, errors);

		if(!errors.hasErrors()) {

			Integer i=service.saveCustomer(cust);
			String msg="Customer '"+i+"' saved successfully........";
			map.addAttribute("message", msg);
			map.addAttribute("cust", new Customer());
		}
		return"CustomerRegister";
	}
	@RequestMapping("/all")
	public String gelAll(ModelMap map) {
		List<Customer> lc=service.getAllCusts();
		map.addAttribute("list", lc);
		return "CustomerData";
	}


	@RequestMapping("/delete")
	public String deleteCust(@RequestParam("cId") Integer cId, ModelMap map) {
		String message=null;
		try {
			service.deleteCustomer(cId);
			message="success";
		}catch (HibernateOptimisticLockingFailureException e) {
			message="not found";

		}
		List<Customer> lc=service.getAllCusts();
		String msg="Customer"+cId+"' delete successfully";
		map.addAttribute("message", msg);
		map.addAttribute("list", lc);
		return "CustomerData";
	}

	@RequestMapping("/edit")
	public String editCust(@RequestParam("cId")Integer cId, ModelMap map) {
		Customer cust=service.getOneCustomer(cId);
		map.addAttribute("cust", cust);
		return "CustomerEdit";
	}

	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updateCust(@ModelAttribute("cust") Customer cust, ModelMap map) {
		service.updateCustomer(cust);
		String msg="Customer '"+cust.getcId()+"' updated successfully......";
		List<Customer> lc=service.getAllCusts();
		map.addAttribute("message", msg);
		map.addAttribute("list", lc);
		return "CustomerData";
	}
}
