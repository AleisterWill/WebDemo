/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ldn.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author three
 */
@Entity
@Table(name = "product")
public class Product implements Serializable{

    /**
     * @return the pFile
     */
    public MultipartFile getpFile() {
        return pFile;
    }

    /**
     * @param pFile the pFile to set
     */
    public void setpFile(MultipartFile pFile) {
        this.pFile = pFile;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Size(min = 5, max = 100, message = "{product.name.lenErr}")
    private String name;
    
    private String description;
    
    @NotNull(message = "{product.price.nullErr}")
    @Min(value = 10000, message = "{product.price.minValueErr}")
    private BigDecimal price;
    
    private String image;
    
    @Column(name = "created_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date createdDate;
    
    private boolean active;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
//    @NotNull(message = "{product.category.nullErr}")
    @JsonIgnore
    private Category category;
    
    @ManyToMany
    @JoinTable(
            name = "prod_manu",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "manufacturer_id")
    )
    @JsonIgnore
    private Set<Manufacturer> manufacturers;
    
    @Transient
    private MultipartFile pFile;

    
    
    
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
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
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
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return the createdDate
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * @param createdDate the createdDate to set
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
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
     * @return the category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * @return the manufacturers
     */
    public Set<Manufacturer> getManufacturers() {
        return manufacturers;
    }

    /**
     * @param manufacturers the manufacturers to set
     */
    public void setManufacturers(Set<Manufacturer> manufacturers) {
        this.manufacturers = manufacturers;
    }
}
