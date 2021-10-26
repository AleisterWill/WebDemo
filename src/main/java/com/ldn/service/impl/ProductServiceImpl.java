/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ldn.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.ldn.pojo.Product;
import com.ldn.repository.ProductRepository;
import com.ldn.service.ProductService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author three
 */
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private Cloudinary cloudinary;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getProducts(String kw, int page) {
        return this.productRepository.getProducts(kw, page);
    }

    @Override
    public boolean addOrUpdate(Product product) {
        try {
            Map r = this.cloudinary.uploader().upload(product.getpFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
            product.setImage((String) r.get("secure_url"));
            return this.productRepository.addOrUpdate(product);
        } catch (IOException ex) {
            System.err.println("=== ADD PRODUCT ===" + ex.getMessage());
        }
        return false;
    }

    @Override
    public long countProducts() {
        return this.productRepository.countProducts();
    }
}
