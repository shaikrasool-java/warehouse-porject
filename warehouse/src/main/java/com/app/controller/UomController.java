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

import com.app.model.Uom;
import com.app.service.IUomService;
import com.app.validator.UomValidator;
import com.app.view.UomExcelView;
import com.app.view.UomPdfView;

@Controller
@RequestMapping("/uom")
public class UomController {

	@Autowired
	private IUomService service;


	@Autowired
	private UomValidator validator;

	//01.show page
	@RequestMapping("/reg")
	public String showUom(ModelMap map) {
		map.addAttribute("uom", new Uom());
		return "UomRegister";
	}
	//02.on click submit to store the data
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String saveUom(@ModelAttribute Uom uom,Errors errors, ModelMap map) {

		validator.validate(uom, errors);

		if(!errors.hasErrors()) {

			Integer id=service.saveUom(uom);
			String msg="Uom '"+id+"' saved successfully";
			map.addAttribute("message", msg);
			//clear from data
			map.addAttribute("uom", new Uom());
		}
		return "UomRegister";

	}
	//03.get data from database to UI
	@RequestMapping("/all")
	public String show(ModelMap map) {
		List<Uom> u=service.getAll();
		map.addAttribute("list", u);
		return "UomData";
	}

	//04. delete one record from database
	@RequestMapping("/delete")
	public String deleteUom(@RequestParam("id") Integer id,ModelMap map) {

		String msg=null;
		String msge=null;
		try{
			if(service.isUomConnectedWithItem(id)) {
				msge="UOm can't be deleted";
			}else {
				service.deletUom(id);

				msg="Success";
			}


		}catch (HibernateOptimisticLockingFailureException e) {
			msge="uom cant be deleted";
			msg=("not found");
		}



		String message="Uom '"+id+"' Deleted";
		List<Uom> u=service.getAll();
		map.addAttribute("message", msg);
		map.addAttribute("list", u);
		map.addAttribute("msg", msg);
		map.addAttribute("msge", msge);
		return "UomData";
	}
	//05.show edit page
	@RequestMapping("/edit")
	public String showEdit(@RequestParam("id") Integer id, ModelMap map) {
		Uom u=service.getOne(id);
		map.addAttribute("uom", u);
		return "UomEdit";
	}

	//06.updation page
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String doUpdate(@ModelAttribute Uom uom, ModelMap map) {
		service.updateUom(uom);
		String msg="Uom '"+uom.getId()+"' updated successfully";
		map.addAttribute("message", msg);
		List<Uom> u=service.getAll();
		map.addAttribute("list", u);
		return "UomData";
	}

	//07 export to excel 
	@RequestMapping("/excel")
	public ModelAndView showExcel() {
		List<Uom> lu=service.getAll();
		ModelAndView m=new ModelAndView();
		//view details
		m.setView(new UomExcelView());
		//add object
		m.addObject("lu", lu);
		return m;
	}
	@RequestMapping("/pdf")
	public ModelAndView showPdf() {
		List<Uom> lu=service.getAll();
		ModelAndView m=new ModelAndView();
		m.setView(new UomPdfView());
		m.addObject("lu", lu);
		return m;
	}

}
