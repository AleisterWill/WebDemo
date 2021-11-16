/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ldn.repository.impl;

import com.ldn.pojo.Product;
import com.ldn.repository.ProductRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author three
 */
@Repository
@Transactional
public class ProductRepositoryImpl implements ProductRepository {
    @Autowired
    public LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Product> getProducts(String kw, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Product> query = builder.createQuery(Product.class);
        Root root = query.from(Product.class);
        query = query.select(root); ////// SELECT *
        
        if(!kw.isEmpty() && kw != null) {
            Predicate p = builder.like(root.get("name").as(String.class), String.format("%%%s%%", kw));
            query = query.where(p);
        }
        
        Query qu = session.createQuery(query);
        
        int max = 6; // 6 items in 1 page
        qu.setMaxResults(max);
        qu.setFirstResult((page - 1)*max );
        
        return qu.getResultList();
    }

    @Override
    public boolean addOrUpdate(Product product) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(product);
            return true;
        } catch (Exception e) {
            System.err.println("== ADD PRODUCT == ERROR" + e.getMessage());
            e.printStackTrace();
        }
        return false;
        
    }

    @Override
    public long countProducts() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object> query = builder.createQuery(Object.class);
        Root root = query.from(Product.class);
        
        query = query.select(builder.count(root));
        Query qu = session.createQuery(query);
        
        return (long) qu.getSingleResult() ;
    }

    @Override
    public Product getProductById(int productId) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        return session.get(Product.class, productId);
    }
    
}
