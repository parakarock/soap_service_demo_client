package com.spring.nemo.soap_service_demo_client.custumValidate;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = CustumInputValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface custumInputIDValidate {
	String message() default "Invalid id number";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
