/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Singleton;
import javax.jws.Oneway;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author edu
 */
@Singleton
@WebService(serviceName = "Jedalen")
public class Jedalen {
    
    List<Jedlo> menu = new ArrayList<>();
    
    public Jedalen() {
        menu.add(new Jedlo("Baklzan", 2.5D, "Fuj vec"));
        menu.add(new Jedlo("Palacinky", 3D, "Mnam vec"));
    }
    

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hellaaaao " + txt + " !";
    }
    
    @WebMethod
    public String helloaa(String txt) {
        return "Hellaaaao " + txt + " !";
    }
    
    @WebMethod
    public void pridajJedlo(String nazov, Double cena, String description) {
        menu.add(new Jedlo(nazov, cena, description));
    }
    
    @WebMethod
    @Oneway
    public void ostranJedlo(int index) {
        menu.remove(index);
    }
    
    @WebMethod
    public String getMenu(){
        String toReturn="";
        for(Jedlo jedlo: menu){
            toReturn +=  jedlo.getNazov() + ", ";
        }
        return toReturn;
    }
}
