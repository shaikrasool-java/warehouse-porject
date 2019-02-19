package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.hibernate5.HibernateOptimisticLockingFailureException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;
import com.app.view.WhUserTypeExcelView;
import com.app.view.WhUserTypePdfView;

@Controller
@RequestMapping("/whusertype")
public class WhUserTypeController {

	@Autowired
	private IWhUserTypeService service;
	
	@RequestMapping("/reg")
	public String showPage(ModelMap map) {
		map.addAttribute("wuser", new WhUserType());
		return "WhUserTypeRegister";
	}
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String saveUser(@ModelAttribute WhUserType wuser, ModelMap map) {
		String message=null;
		try {
		Integer i=service.saveUser(wuser);
		String msg="user '"+i+"' saved successfully";
		message="success";
		}catch (DataIntegrityViolationException e) {
			message="whuser code is alredy used, please use another one...";
		}
		map.addAttribute("message", message);
		map.addAttribute("wuser", new WhUserType());
		return "WhUserTypeRegister";
	}
//show all users
	@RequestMapping("/all")
	public String showAll(ModelMap map) {
		List<WhUserType> li=service.getALlUsers();
		map.addAttribute("wuser", li);
		return "WhUserTypeData";
	}
	//delete one record through id
	@RequestMapping("/delete")
	public String deleteUser(@RequestParam("id") Integer id, ModelMap map) {
		String message=null;
		try {
		service.deleteUser(id);
		message="success";
		}catch (HibernateOptimisticLockingFailureException e) {
			message="user not found";
		}
		String msg="user '"+id+"' deleted successfully";
		List<WhUserType> lw=service.getALlUsers();
		map.addAttribute("message", msg);
		map.addAttribute("wuser", lw);
		return "WhUserTypeData";
	}
	//showing edit page of user
	@RequestMapping("/edit")
	public String editUser(@RequestParam("id")Integer id, ModelMap map) {
		WhUserType w=service.getOneUser(id);
		map.addAttribute("wuser", w);
		return "WhUserTypeEdit";
	}
	
	//update user by on click
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updateUser(@ModelAttribute WhUserType wuser, ModelMap map) {
		service.updateUser(wuser);
		String msg="user '"+wuser.getId()+"' updated";
		map.addAttribute("message", msg);
		List<WhUserType> lw=service.getALlUsers();
		map.addAttribute("wuser", lw);
		return "WhUserTypeData";
	}
	//export to excel
	@RequestMapping("/excel")
	public ModelAndView showExcel() {
		List<WhUserType> lw=service.getALlUsers();
		ModelAndView m=new ModelAndView();
		m.setView(new WhUserTypeExcelView());
		m.addObject("lw", lw);
		return m;
	}
	
//exporting to pdf
	@RequestMapping("/pdf")
	public ModelAndView showPdf() {
		List<WhUserType> lw=service.getALlUsers();
		ModelAndView m=new ModelAndView();
		m.setView(new WhUserTypePdfView());
		m.addObject("lw", lw);
		return m;
		
		
	}
	
}
