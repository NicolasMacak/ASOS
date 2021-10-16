/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asos.p1u1.cv1;

/**
 *
 * @author edu
 */
public class MessageServiceMock implements MessageServiceIfc {
    
    @Override
    public String getMessage(){
        return "Tu je mock!";
    }
}
