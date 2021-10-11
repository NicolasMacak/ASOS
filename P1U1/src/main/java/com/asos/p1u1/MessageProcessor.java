/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asos.p1u1;

import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author edu
 */
public class MessageProcessor {
    
    private MessageServiceIfc messageService;
    // odrazene from P1U1
        @Autowired
        public void setMessageService(MessageServiceIfc messageService) { //setter tu musi byt je pouzity by autowire
        this.messageService = messageService;
    }
    
    public void processMessage(){
        System.out.println(messageService.getMessage());
    }
}
