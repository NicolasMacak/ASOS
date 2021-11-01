package com.asos.cv4.resources;

import com.asos.cv4.Jedlo;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author 
 */
@Singleton
@Path("javaee8")
public class JavaEE8Resource {
    
   
    Map<Integer, Jedlo> jedla = new HashMap<>();
    
    public JavaEE8Resource(){
        jedla.put(1, new Jedlo("Halusky", "To najlepsie co doma mame", 3.7D));
        jedla.put(2, new Jedlo("Kokotia hlava", "To najlepsie co doma mame", 1.7D));
    }
    
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("food")
    public String ping(){
        return "jozko";//jedla.get(1);
    }
}
