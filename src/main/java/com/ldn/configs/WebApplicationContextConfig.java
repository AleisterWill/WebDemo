/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ldn.configs;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.ldn.formatter.CategoryFormatter;
import com.ldn.validator.ProductNameValidator;
import com.ldn.validator.WebAppValidator;
import java.util.HashSet;
import java.util.Set;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 *
 * @author three
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {
        "com.ldn.controllers",
        "com.ldn.repository",
        "com.ldn.service",
        "com.ldn.validator"
})
@EnableTransactionManagement
public class WebApplicationContextConfig implements WebMvcConfigurer{

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**")
                .addResourceLocations("/resources/css/");
        registry.addResourceHandler("/images/**")
                .addResourceLocations("/resources/images/");
    }

    @Override
    public Validator getValidator() {
        return validator(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new CategoryFormatter());
    }
    
    ////////////   VALIDATORS GO HERE /////////////
    @Bean
    public WebAppValidator productValidator() {
        Set<Validator> springValidators = new HashSet<>();
        //// ADD VALIDATORS HERE ////
        springValidators.add(new ProductNameValidator());
        
        /////////////////////////////
        WebAppValidator v = new WebAppValidator();
        v.setSpringValidator(springValidators);
        
        return v;
    }
    
//    @Bean
//    public WebAppValidator userValidator() {
//        Set<Validator> springValidators = new HashSet<>();
//        //// ADD VALIDATORS HERE ////
//        springValidators.add(new UserValidator());
//        /////////////////////////////
//        WebAppValidator v = new WebAppValidator();
//        v.setSpringValidator(springValidators);
//        
//        return v;
//    }
//    //////////// ///////////////// /////////////
    
    @Bean
    public LocalValidatorFactoryBean validator() {
        LocalValidatorFactoryBean v = new LocalValidatorFactoryBean();
        v.setValidationMessageSource(messageSource());
        
        return v;
    }
    
    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        
        return resolver;
    }
    
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource src = new ResourceBundleMessageSource();
        src.setBasename("messages");
        return src;
    }
    
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("UTF-8");
        
        return resolver;
    }
    
    
}
