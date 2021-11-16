/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ldn.pojo;

import java.math.BigDecimal;

/**
 *
 * @author three
 */
public class Cart {
    private int productId;
    private String name;
    private BigDecimal price;
    private int amount;

    /**
     * @return the productId
     */
    public int getProductId() {
        return productId;
    }

    /**
     * @param productId the productId to set
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * @return the countItems
     */
    public int getAmount() {
        return amount;
    }

    /**
     * @param amount the countItems to set
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }
}
