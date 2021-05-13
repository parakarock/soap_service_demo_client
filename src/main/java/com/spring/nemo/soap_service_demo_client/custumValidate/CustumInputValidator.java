package com.spring.nemo.soap_service_demo_client.custumValidate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustumInputValidator implements 
ConstraintValidator<custumInputIDValidate, Integer>{

	@Override
    public void initialize(custumInputIDValidate value) {
    }
	
	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		if(value == 5)
			return false;
		return true;
//		return value != null && value.matches("[0-9]+");
	
		       
	}

}
