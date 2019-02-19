package com.app.model;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ShipmentTypValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return ShipmentType.class.equals(clazz) ;
	}

	@Override
	public void validate(Object target, Errors errors) {

		ShipmentType shipment=(ShipmentType)target;
		
		if(shipment.getMode()==null||shipment.getMode().isEmpty()) {
			errors.rejectValue("mode", null, "Please select Mode");
		}
		
		if("".equals(shipment.getCode())){
			errors.rejectValue("code", null, "Please enter code");
		}
		if(shipment.getEnabled()==null||shipment.getEnabled().isEmpty()) {
			errors.rejectValue("enabled", null, "Please select one");
		}
		if(shipment.getDsc()==null||shipment.getDsc().isEmpty()) {
			errors.rejectValue("enabled", null, "Please enter something");
		}
		
		
		
		
	}

}
