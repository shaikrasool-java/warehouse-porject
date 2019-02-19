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
	
	import com.app.model.OrderMethod;
	import com.app.service.IOrderMethodService;
	import com.app.validator.OrderMethodValidator;
	import com.app.view.OrderMethodExcelView;
	import com.app.view.OrderMethodPdfView;
	
	@Controller
	@RequestMapping("/ordermethod")
	public class OrderController {
	
		@Autowired
		private IOrderMethodService service;
	
		@Autowired
		private OrderMethodValidator validator;
		
		//show page
	
		@RequestMapping("/reg")
		public String showOrder(ModelMap map) {
			map.addAttribute("order", new OrderMethod());
			return "OrderRegister";
		}
	
		//on click submit 
		@RequestMapping(value="/insert", method=RequestMethod.POST)
		public String saveOrder(@ModelAttribute("order") OrderMethod order, Errors errors, ModelMap map)
		{
			validator.validate(order, errors);
			if(!errors.hasErrors()) {
			Integer i=service.saveOrder(order);
			String msg="OrderMethod '"+i+"' saved successfully";
			map.addAttribute("message", msg);
			map.addAttribute("order", new OrderMethod());
			}
			
			return "OrderRegister";
		}
	
		//get data from database to UI
		@RequestMapping("/all")
		public  String showPage(ModelMap map) {
			List<OrderMethod> om=service.getAllOrders();
			map.addAttribute("list", om);
			return "OrderData";
		}
	
		//delete record based on id
		@RequestMapping("/delete")
		public String deletOrder(@RequestParam("id") Integer id,ModelMap map) {
			
			String message=null;
			try {
			service.deleteOrder(id);
			message="success";
			}catch (HibernateOptimisticLockingFailureException e) {

				message="order not found";
			}
			String msg="Order Id '"+id+"' deleted successfully";
			List<OrderMethod> ol=service.getAllOrders();
			map.addAttribute("message", msg);
			map.addAttribute("list", ol);
			return "OrderData";
		}
		
		
		
		
		//show edit page
		@RequestMapping("/edit")
		public String editOrder(@RequestParam("id") Integer id, ModelMap map) {
			OrderMethod o=service.getOneOrder(id);
			map.addAttribute("order", o);
			return "OrderEdit";
		}
	
		//updatation page
		@RequestMapping(value="/update", method=RequestMethod.POST)
		public String updateOrder(@ModelAttribute OrderMethod order, ModelMap map) {
			service.updateOrder(order);
			String msg="Order id'"+order.getId()+"' updated successfully";
			List<OrderMethod> li=service.getAllOrders();
			map.addAttribute("list", li);
			map.addAttribute("message", msg);
			return "OrderData";
		}
	//exporting to excel
		@RequestMapping("excel")
		public ModelAndView showExcel() {
			
			List<OrderMethod> oms=service.getAllOrders();
			
			ModelAndView m=new ModelAndView();
		
			m.setView(new OrderMethodExcelView());
			m.addObject("oms", oms);
			return m;
		}
		//exporting to pdf
		
		@RequestMapping("/pdf")
		public ModelAndView showPdf() {
			List<OrderMethod> lo=service.getAllOrders();
			ModelAndView m=new ModelAndView();
			m.setView(new OrderMethodPdfView());
			m.addObject("lo", lo);
			return m;
		}

		
	}
