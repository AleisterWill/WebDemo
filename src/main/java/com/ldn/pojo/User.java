/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ldn.pojo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author three
 */
@Entity
@Table(name = "user")
public class User implements Serializable{
    private static String ADMIN = "ROLE_ADMIN";
    private static String USER = "ROLE_USER";
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    
    @Column(name = "first_name")
    @NotNull(message = "{user.firstName.nullErr}")
    private String firstName;
    
    
    @Column(name = "last_name")
    @NotNull(message = "{user.lastName.nullErr}")
    private String lastName;
    
    @NotNull(message = "{user.password.lenErr}")
    private String email;
    
    private String phone;
    
    @NotNull(message = "{user.username.nullErr}")
    @Size(min = 4, max = 25, message = "{user.username.lenErr}")
    private String username;
    
    @NotNull(message = "{user.password.nullErr}")
    @Size(min = 8, message = "{user.password.lenErr}")
    private String password;
    
    @Transient
    private String confirmPW; // ->Use for register.jsp
    
    private boolean active;
    
    @Column(name = "user_role")
    private String userRole;

    /**
     * @return the ADMIN
     */
    public static String getADMIN() {
        return ADMIN;
    }

    /**
     * @return the USER
     */
    public static String getUSER() {
        return USER;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the confirmPW
     */
    public String getConfirmPW() {
        return confirmPW;
    }

    /**
     * @param confirmPW the confirmPW to set
     */
    public void setConfirmPW(String confirmPW) {
        this.confirmPW = confirmPW;
    }

    /**
     * @return the active
     */
    public boolean isActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * @return the userRole
     */
    public String getUserRole() {
        return userRole;
    }

    /**
     * @param userRole the userRole to set
     */
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
