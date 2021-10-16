/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asos.p1u1;

import com.asos.p1u1.cv2.MessageConsumerIfc;

/**
 *
 * @author edu
 */
public class MessageProcessor {
    private MessageServiceIfc messageService;
    private MessageConsumerIfc consumer;
    
    public MessageProcessor(MessageServiceIfc messageService, MessageConsumerIfc consumer){
        this.messageService = messageService;
        this.consumer = consumer;
    }
    
    public void processMessage(){
        consumer.putMessage(messageService.getMessage());
    }
}
