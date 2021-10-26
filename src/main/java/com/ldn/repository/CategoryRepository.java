/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ldn.repository;

import com.ldn.pojo.Category;
import java.util.List;

/**
 *
 * @author three
 */
public interface CategoryRepository {
    public List<Category> getCategories();
}
