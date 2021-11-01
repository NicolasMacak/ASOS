/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asos.cv4;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author edu
 */
@XmlRootElement(name="jedlo")
public class Jedlo {
    
    private String title;
    private String description;
    private double price;
    
     public Jedlo() {
    }

    public Jedlo(String title, String description, double price) {
        this.title = title;
        this.description = description;
        this.price = price;
    }
    
    

    @XmlElement(name="nazov")
    public String getTitle() {
        return title;
    }

    @XmlElement(name="popis")
    public String getDescription() {
        return description;
    }

    @XmlElement(name="cena")
    public double getPrice() {
        return price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
    
}
