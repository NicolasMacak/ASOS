/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

/**
 *
 * @author edu
 */
public class Jedlo {
    private String nazov;
    private Double cena;
    private String description;

    public Jedlo() {
    }
    

    public Jedlo(String nazov, Double cena, String description) {
        this.nazov = nazov;
        this.cena = cena;
        this.description = description;
    }

    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
