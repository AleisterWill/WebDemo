/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ldn.controllers;

import com.ldn.Utils.Utils;
import com.ldn.pojo.Cart;
import com.ldn.pojo.Product;
import com.ldn.service.ProductService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author three
 */
@RestController
public class ApiCartController {
    @Autowired
    private ProductService productService;
    
    @GetMapping("/api/products")
    public ResponseEntity<List<Product>> listProducts() {
        List<Product> products = this.productService.getProducts("", 1);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    
    @GetMapping(value = "/api/cart/{productId}")
    public ResponseEntity<Integer> cart(@PathVariable(value = "productId") Integer productId,
            HttpSession session) {
        Map<Integer, Cart> cart = (Map<Integer, Cart>) session.getAttribute("cart");
        if (cart == null) {
            cart = new HashMap<>();
        }
        
        if (cart.containsKey(productId) == true) { // Item existed in cart
            Cart c = cart.get(productId);
            c.setAmount(c.getAmount() + 1);
        } else {
            Product p = this.productService.getProductById(productId);
            Cart c = new Cart();
            c.setProductId(p.getId());
            c.setName(p.getName());
            c.setPrice(p.getPrice());
            c.setAmount(1);
            
            cart.put(productId, c);
        }
        
        session.setAttribute("cart", cart);
        System.out.println("========= CART = " + Utils.cartItemsAmount(cart));
        return new ResponseEntity<>(Utils.cartItemsAmount(cart), HttpStatus.OK);
    }
}
