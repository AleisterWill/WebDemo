/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ldn.repository;

import com.ldn.pojo.User;
import java.util.List;

/**
 *
 * @author three
 */
public interface UserRepository {
    boolean addUser(User user);
    List<User> getUsers(String username);
}
