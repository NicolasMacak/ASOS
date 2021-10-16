/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asos.p1u1;

import com.asos.p1u1.cv1.MessageProcessor;
import com.asos.p1u1.cv2.MyAspectBean;
import com.asos.p1u1.cv2.MyOperationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author edu
 */
public class P1U1 {
    public static void main(String[] args) {
                ApplicationContext context
                = new ClassPathXmlApplicationContext(new String[]{"beans.xml"});

        MessageProcessor mp = context.getBean("processor", MessageProcessor.class);
        mp.processMessage();
//        MyOperationBean bean = (MyOperationBean) context.getBean("opBean");
//        System.out.println("----------calling m...");
//        bean.m();
//        System.out.println("----------calling k...");
//        bean.k();
//        System.out.println("----------calling msg...");
//        bean.msg("hello");
    }
}
