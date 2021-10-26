/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ldn.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.ldn.pojo.Product;
import com.ldn.service.ProductService;
import com.ldn.validator.ProductNameValidator;
import com.ldn.validator.WebAppValidator;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author three
 */
@Controller
public class ProductsController {
    @Autowired
    private WebAppValidator productValidator;
    @Autowired
    private ProductService productService;
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setValidator(productValidator);
    }
    
    @GetMapping("/admin/products")
    public String list(Model model) {
        model.addAttribute("product", new Product());
        
        return "product";
    }
    
    @PostMapping("/admin/products")
    public String upload(Model model, @ModelAttribute(value = "product") @Valid Product product,
            BindingResult result) {
        if (!result.hasErrors()) {
            if (this.productService.addOrUpdate(product) == true) {
                return "redirect:/admin/products";
            }
            else
                model.addAttribute("errMsg", "Something went wrong!");
        }
        return "product";
    }
}
