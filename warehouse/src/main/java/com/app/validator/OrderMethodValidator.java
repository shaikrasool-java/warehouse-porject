package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.OrderMethod;
import com.app.service.IOrderMethodService;

@Component
public class OrderMethodValidator implements Validator{

	@Autowired
	private IOrderMethodService service;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return OrderMethod.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		OrderMethod om=(OrderMethod)target;
		
		if(om.getMode()==null||om.getMode().isEmpty()) {
			errors.rejectValue("mode", null, "Please select one mode");
		}
		
		if(!Pattern.compile("[A-Z]{4,10}").matcher(om.getCode()).matches()) {
 			errors.rejectValue("code", null, "Please enter the code");
		}
		else if(service.isOrderMethodCodeExist(om.getCode())){
			errors.rejectValue("code", null, "order code already exists, please choose other");
			
		}
		
		
		if("".equals(om.getMethod())) {
			errors.rejectValue("method", null, "Please select one method");
		}
		
		if("".equals(om.getDsc())) {
			errors.rejectValue("dsc", null, "Please enter Discription");
		}
		if(om.getAccept()==null||om.getAccept().isEmpty()) {
			errors.rejectValue("accept", null, "Please select");
		}
	}
	

}
