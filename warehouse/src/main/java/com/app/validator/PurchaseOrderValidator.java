package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.PurchaseOrder;
@Component
public class PurchaseOrderValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return PurchaseOrder.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		PurchaseOrder po=(PurchaseOrder)target;
		
		if(!Pattern.compile("[A-Z]{4,10}").matcher(po.getCode()).matches()) {
			errors.rejectValue("code", null, "please enter code only upper case that should be min=4 and maximum =10 characters");
		}
/*		if(po.getShipment().getCode()==null) {
			errors.rejectValue("shipment", null, "Please select shipment code");
		}
*//*		if(po.getVen().getCode()==null) {
			errors.rejectValue("ven", null, "Please select vendor code");
		}
	*/	/*if(po.getQa().isEmpty()) {
			errors.rejectValue("qa", null, "Please select one");
		}
*/	/*	if(!Pattern.compile("[A-Z0-9]{4}\\-[A-Z0-9]{4}\\-[A-Z0-9]{4}").matcher(po.getRefNum()).matches()) {
			errors.rejectValue("refNum", null, "Please enter uppercase letters and digits only");
		}
	*/	if(!Pattern.compile("^[a-zA-Z0-9.,\\s]*$").matcher(po.getDsc()).matches()) {
			errors.rejectValue("dsc", null, "Please enter discription...");
		}
}
}