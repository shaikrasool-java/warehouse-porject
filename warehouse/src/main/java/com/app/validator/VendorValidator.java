package com.app.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.Vendor;

@Component
public class VendorValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Vendor.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

			
			Vendor ven=(Vendor)target;
			if("".equals(ven.getVenName())) {
				errors.rejectValue("venName", null, "please enter vendor name");
			}
			
			if(ven.getVenCode()==null||ven.getVenCode().isEmpty()) {
				errors.rejectValue("venCode", null, "Please select one");
			}
			
			if(ven.getVenDesg()==null||ven.getVenDesg().isEmpty()) {
				errors.rejectValue("venDesg", null, "Please select");
			}
			if(ven.getVenPreserve().isEmpty()) {
				errors.rejectValue("venPreserve", null, "Please select at least one");
			}
			
		
	}

}
