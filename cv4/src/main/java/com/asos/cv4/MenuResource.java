/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asos.cv4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.inject.Singleton;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;

/**
 * REST Web Service
 *
 * @author edu
 */
@Path("menu")
@Singleton
public class MenuResource {

    Map<Integer, Jedlo> jedla = new HashMap<>();
    List<Jedlo> objednaneJedla = new ArrayList<>();
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of FoodResource
     */
    public MenuResource() {
        jedla.put(1, new Jedlo("Halusky", "To najlepsie co doma mame", 3.7D));
        jedla.put(2, new Jedlo("Kokotia hlava", "To najlepsie co doma mame", 1.7D));
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getMenu(){
        String toReturn = "";
        Set<Integer> jedlaKeys = jedla.keySet();
        for(Integer jedloKey : jedlaKeys){
            toReturn += " " + jedla.get(jedloKey).getTitle();
        }
        
        return toReturn;
    }
    
    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String test(){
        return "Jozko";
    }
    
    @GET
    @Path("/meal/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Jedlo getJedlo(@PathParam("id") Integer index) {
//        Integer index = id;
//        return jedla.get(id);
        if(jedla.containsKey(index)){
            return jedla.get(index);
        } else {
            return new Jedlo();
        }
        
    }

    /**
     * Retrieves representation of an instance of com.asos.cv4.MenuResource
     * @param index
     * @return an instance of java.lang.String
     */
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/meal/{id}")
    public String getXml(@PathParam("id") Integer index) {
        if(jedla.containsKey(index)){
//            Jedlo mealToRemove = jedla.get(index);
            jedla.remove(index);
            return "new map "+ jedla;
        } 
        return "No such meal";
    }

    @POST
    @Path("/meal")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Jedlo addJedlo(Jedlo jedlo) {
        Integer newIndex = jedla.keySet().size()+1;
        jedla.put(newIndex, jedlo);
        
        return jedla.get(newIndex);
    }

    @PUT
    @Path("/meal/{id}")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Jedlo modfiyJedlo(Jedlo jedlo, @PathParam("id") Integer index) {
        if(jedla.containsKey(index)){
            jedla.put(index, jedlo);
            return jedla.get(index);
        }
        
        return new Jedlo();
    }
    
    @POST
    @Path("/order/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String orderJedlo(@PathParam("id") Integer index) {
        if(jedla.containsKey(index)){
            Jedlo objednaneJedlo = jedla.get(index);
            objednaneJedla.add(objednaneJedlo);
            return objednaneJedlo.getTitle()+" bolo objednane";
        }
        
        return "No such food";
    }
    
    @GET
    @Path("/order")
    @Produces(MediaType.TEXT_PLAIN)
    public Integer orderJedlo() {
        return objednaneJedla.size();
    }
}
