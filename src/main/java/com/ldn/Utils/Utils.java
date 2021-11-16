/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ldn.Utils;

import com.ldn.pojo.Cart;
import java.util.Map;

/**
 *
 * @author three
 */
public class Utils {
    public static int cartItemsAmount(Map<Integer, Cart> cart) {
        int amount = 0;
        if (cart != null) {
            for (Cart c : cart.values())
                amount += c.getAmount();
        }
        return amount;
    }
}
