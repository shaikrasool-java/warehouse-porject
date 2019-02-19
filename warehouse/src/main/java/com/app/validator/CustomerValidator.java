package com.app.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.Customer;

@Component
public class CustomerValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {

		return Customer.class.equals(clazz);
	
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Customer cust=(Customer)target;
		if("".equals(cust.getCustName())) {
			errors.rejectValue("custName", null, "Please enter the name");
		}
		if("".equals(cust.getCustCode())) {
			errors.rejectValue("custCode", null, "Please enter the code");
		}
		if("".equals(cust.getCustEmail())) {
			errors.rejectValue("custEmail", null, "Please enter the email id");
		}
		if("".equals(cust.getCustContact())) {
			errors.rejectValue("custContact", null, "Please enter the contact no");
		}
		if(cust.getCustAddr()==null||cust.getCustAddr().isEmpty()) {
			errors.rejectValue("custAddr", null, "please enter the address");
		}
		
		if(cust.getCustLocs()==null||cust.getCustLocs().isEmpty()) {
			errors.rejectValue("custLocs", null, "Please select the location");
		}
		if(cust.getCustEnabled()==null||cust.getCustEnabled().isEmpty()) {
			errors.rejectValue("custEnabled", null, "Please select one");
		}
	}
	
	

}
