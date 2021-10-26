/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ldn.controllers;

import com.ldn.pojo.Category;
import com.ldn.pojo.User;
import com.ldn.service.CategoryService;
import com.ldn.service.ProductService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author three
 */
@Controller
@ControllerAdvice
public class HomeController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;
    
    @ModelAttribute
    public void commonAttr(Model model) {
        model.addAttribute("categories", this.categoryService.getCategories());
    }
    @RequestMapping("/")
    @Transactional
    public String index(Model model, @RequestParam(required = false) Map<String, String> params) {
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("page", page);
        model.addAttribute("products", this.productService.getProducts(params.getOrDefault("kw", ""), page));
        model.addAttribute("counter", this.productService.countProducts());
//         s.close();
        
        
        
//        String firstName = params.get("first_name");
//        String lastName = params.get("last_name");
//        if (firstName != null && lastName != null)
//            model.addAttribute("name", String.format("%s %s", firstName, lastName));
//        else
//            model.addAttribute("name", "Aleister");
//        model.addAttribute("user", new User());
//        List<User> users = new ArrayList<>();
//        users.add(new User("Dai Nghia", "Le"));
//        users.add(new User("Ocbu", "Chuu"));
//        model.addAttribute("users", users);
        return "index";
    }
    
    @RequestMapping("/hello/{name}")
    public String hello(Model model, @PathVariable(value = "name") String name) {
        model.addAttribute("message", "Your Majesty, Lord " + name);
        return "hello";
    }
    
    @RequestMapping(path = "/hello-post", method = RequestMethod.POST)
    public String show(Model model, @ModelAttribute(value = "user") User user) {
//        model.addAttribute("fullName", user.getfName() + " " + user.getlName());
        return "index";
    }
    
    @RequestMapping(path = "/test")
    public String testRedirect(Model model) {
        model.addAttribute("testMsg", "FROM INDEX: Redirect processing...");
        
        return "forward:/hello/Stupid";
    }
    
    @RequestMapping(path = "/cart")
    public String cart(Model model) {
        
        return "cart";
    }
}
