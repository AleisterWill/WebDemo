/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ldn.service.impl;

import com.ldn.pojo.User;
import com.ldn.repository.UserRepository;
import com.ldn.service.UserService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author three
 */
@Service("userDetailsService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    @Override
    public boolean addUser(User user) {
        /// Hash Pw
        String pw = user.getPassword();
        user.setPassword(this.passwordEncoder.encode(pw));
        user.setUserRole(User.getUSER());
        //
        return this.userRepository.addUser(user);
    }

    @Override
    public List<User> getUsers(String username) {
        return this.userRepository.getUsers(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<User> users = this.getUsers(username);
        if(users.isEmpty())
            throw new UsernameNotFoundException("User not found!");
        User user = users.get(0);
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(user.getUserRole()));
        
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }
    
}
