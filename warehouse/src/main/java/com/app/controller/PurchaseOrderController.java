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

import com.app.model.PurchaseOrder;
import com.app.model.ShipmentType;
import com.app.model.WhUserType;
import com.app.service.IPurchaseOrderService;
import com.app.service.IShipmentTypeService;
import com.app.service.IWhUserTypeService;
import com.app.validator.PurchaseOrderValidator;

@Controller
@RequestMapping("/purchase")
public class PurchaseOrderController {
	@Autowired
	private IPurchaseOrderService service;

	@Autowired
	private IShipmentTypeService shipService;

	@Autowired
	private IWhUserTypeService whService;


	@Autowired
	private PurchaseOrderValidator validator;


	@RequestMapping("/reg")
	public String showPage(ModelMap map) {
		List<ShipmentType> lst=shipService.getShipmentsByEnabled("YES");
		map.addAttribute("shipment", lst);

		List<WhUserType> vendors=whService.getWhUserTypeByType("vendor");
		map.addAttribute("vendors", vendors);

		map.addAttribute("po", new PurchaseOrder());
		return "PurchaseOrderRegister";
	}

	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String saveOrder(@ModelAttribute("po") PurchaseOrder po,Errors errors, ModelMap map) {

		validator.validate(po, errors);

		if(!errors.hasErrors()) {

			Integer i=service.saveOrder(po);
			String msg="Puchase Order '"+i+"' saved successfully....";
			map.addAttribute("message", msg);


			List<ShipmentType> lst=shipService.getShipmentsByEnabled("YES");
			map.addAttribute("shipment", lst);

			List<WhUserType> vendors=whService.getWhUserTypeByType("vendor");
			map.addAttribute("vendors", vendors);
			//map.addAttribute("po", new PurchaseOrder());
		}

		List<ShipmentType> lst=shipService.getShipmentsByEnabled("YES");
		map.addAttribute("shipment", lst);

		List<WhUserType> vendors=whService.getWhUserTypeByType("vendor");
		map.addAttribute("vendors", vendors);

		return "PurchaseOrderRegister";
	}

	@RequestMapping("/all")
	public String showAll(ModelMap map) {

		List<PurchaseOrder> lpo=service.getAllOrders();

		map.addAttribute("list", lpo);

		return "PurchaseOrderData";
	}

	@RequestMapping("/delete")
	public String deleteOrder(@RequestParam("id")Integer id, ModelMap map) {
		String message=null;
		try {
			service.deleteOrder(id);
			message="success";
		}catch (HibernateOptimisticLockingFailureException e) {
			message="purchase order not found";
		}
		List<PurchaseOrder> lpo=service.getAllOrders();
		String msg="Purchase Order '"+id+"' deleted successfully";


		map.addAttribute("message", msg);
		map.addAttribute("list", lpo);

		return "PurchaseOrderData";
	}




	@RequestMapping("/edit")
	public String editPage(@RequestParam("id")Integer id, ModelMap map) {

		PurchaseOrder por=service.getOneOrder(id);

		List<ShipmentType> shipments=shipService.getShipmentsByEnabled("YES");
		map.addAttribute("shipment", shipments);

		List<WhUserType> vendors=whService.getWhUserTypeByType("vendor");
		map.addAttribute("vendors", vendors);

		map.addAttribute("po", por);

		return "PurchaseOrderEdit";
	}

	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updateOrder(@ModelAttribute("po")PurchaseOrder po, ModelMap map) {
		service.updateOrder(po);
		List<PurchaseOrder> lpo=service.getAllOrders();
		String msg="Purchase Order '"+po.getId()+"' updated successfully.....";
		map.addAttribute("message", msg);
		map.addAttribute("list", lpo);
		return "PurchaseOrderData";
	}

}
