/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ldn.validator;

import com.ldn.pojo.Product;
import java.util.Set;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintViolation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author three
 */
@Component
public class WebAppValidator implements Validator{
    private Set<Validator> springValidator;
    
    @Autowired
    private javax.validation.Validator beanValidator;

    @Override
    public boolean supports(Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Set<ConstraintViolation<Object>> beans = this.beanValidator.validate(o);
        
        for (ConstraintViolation<Object> obj : beans) {
            errors.rejectValue(obj.getPropertyPath().toString(), obj.getMessageTemplate(), obj.getMessage());
        }
        for (Validator v : this.springValidator)
            v.validate(o, errors);
    }

    /**
     * @param springValidator the springValidator to set
     */
    public void setSpringValidator(Set<Validator> springValidator) {
        this.springValidator = springValidator;
    }
    
}
