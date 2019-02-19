package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.hibernate5.HibernateObjectRetrievalFailureException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Item;
import com.app.model.ItemValidator;
import com.app.model.OrderMethod;
import com.app.model.Uom;
import com.app.model.WhUserType;
import com.app.service.IOrderMethodService;
import com.app.service.IUomService;
import com.app.service.IWhUserTypeService;
import com.app.service.ItemService;

@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemService service;

	@Autowired
	private IUomService uomservice;

	@Autowired
	private IOrderMethodService omservice;

	@Autowired
	private IWhUserTypeService whService;


	/*	@Autowired
	private ItemValidator validator;
	 */	

	@RequestMapping("/reg")
	public String showPage(ModelMap map) {
		//uom 
		List<Uom> uom=uomservice.getAll();
		map.addAttribute("uoms", uom);

		//ordermethod for sales
		List<OrderMethod> sales=omservice.getOrderMethodsByMode("sale");
		map.addAttribute("sales", sales);

		//ordermethod for purchase
		List<OrderMethod> pruchases=omservice.getOrderMethodsByMode("purchase");
		map.addAttribute("purchases", pruchases);

		//whusertype for vendors
		List<WhUserType> vendors=whService.getWhUserTypeByType("vendor");
		map.addAttribute("vendors", vendors);

		//whusertype for customer
		List<WhUserType> customers=whService.getWhUserTypeByType("customer");
		map.addAttribute("customers", customers);

		//item 
		map.addAttribute("it", new Item());
		return "ItemRegister";
	}

	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String saveItem(@ModelAttribute("it") Item it,Errors errors, ModelMap map) {

		String message=null;
		/*	validator.validate(it, errors);


		if(!errors.hasErrors()) {
		 */		
		//ordermethod for sales
		List<OrderMethod> sales=omservice.getOrderMethodsByMode("sale");
		map.addAttribute("sales", sales);

		//ordermethod for purchase
		List<OrderMethod> pruchases=omservice.getOrderMethodsByMode("purchase");
		map.addAttribute("purchases", pruchases);


		List<Uom> uoms=uomservice.getAll();
		map.addAttribute("uoms", uoms);

		//whusertype for vendors
		List<WhUserType> vendors=whService.getWhUserTypeByType("vendor");
		map.addAttribute("vendors", vendors);

		//whusertype for customer
		List<WhUserType> customers=whService.getWhUserTypeByType("customer");
		map.addAttribute("customers", customers);
		try {
		Integer i=service.saveItem(it);
		String msg="Item '"+i+"' saved successfully";
			message="success";
		}
		catch (DataIntegrityViolationException e) {
			message="Item code already exists...";
		}
		map.addAttribute("message", message);
		map.addAttribute("it", new Item());

		/*		}
		 */
		return "ItemRegister";
	}

	@RequestMapping("/all")
	public String gelALl(ModelMap map) {
		List<Item> li=service.getAllItems();
		map.addAttribute("list", li);
		return "ItemData";
	}
	@RequestMapping("/delete")
	public String deleteItem(@RequestParam("id")Integer id, ModelMap map) {

		String message=null;
		try {
			service.deleteItem(id);
			message="success";
		}catch (HibernateObjectRetrievalFailureException e) {
			message="item not found";
		}
		String msg="Item '"+id+"' deleted successfully....";
		List<Item> li=service.getAllItems();
		map.addAttribute("message", msg);
		map.addAttribute("list", li);
		return "ItemData";
	}
	@RequestMapping("/edit")
	public String editItem(@RequestParam("id")Integer id,ModelMap map) {
		List<Uom> lu=uomservice.getAll();
		map.addAttribute("uoms", lu);

		//ordermethod for sales
		List<OrderMethod> sales=omservice.getOrderMethodsByMode("sale");
		map.addAttribute("sales", sales);

		//ordermethod for purchase
		List<OrderMethod> pruchases=omservice.getOrderMethodsByMode("purchase");
		map.addAttribute("purchases", pruchases);

		//whusertype for vendors
		List<WhUserType> vendors=whService.getWhUserTypeByType("vendor");
		map.addAttribute("vendors", vendors);

		//whusertype for customer
		List<WhUserType> customers=whService.getWhUserTypeByType("customer");
		map.addAttribute("customers", customers);


		Item i=service.getOneItem(id);
		map.addAttribute("list", i);
		return "ItemEdit";
	}
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updateItem(@ModelAttribute("item") Item item, ModelMap map) {
		service.updateItem(item);
		String msg="Item '"+item.getId()+"' updated Successfully...";
		List<Item> lis=service.getAllItems();
		map.addAttribute("message", msg);
		map.addAttribute("list", lis);
		return "ItemData";
	}
}

