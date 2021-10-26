/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ldn.service;

import com.ldn.pojo.Product;
import java.util.List;

/**
 *
 * @author three
 */
public interface ProductService {
    public List<Product> getProducts(String kw, int page);
    public boolean addOrUpdate(Product product);
    public long countProducts();
}
