/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asos.p1u1.cv2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

/**
 *
 * @author edu
 */
public class MyAspectBean {
    private int countedMsgCalls = 0;
    
        public void myBeforeAdvice(JoinPoint jp)  
    {
        System.out.println("\tmy before advice");
        System.out.println("\tMethod Signature: " + jp.getSignature());
    }

    /* vypise navratovu hodnotu  */
    public void myReturnAdvice(JoinPoint jp, Object result)
    {
        System.out.println("\tmy return advice");
        System.out.println("\tResult in advice: " + result);
        countedMsgCalls++;
    }

    /* zisti a vypise dobu vykonavania volanej metody */
    public Object myAroundAdvice(ProceedingJoinPoint call, String message) throws Throwable {
        System.out.println("\tmy around advice " + message);
        StopWatch clock = new StopWatch("\tProfiling");
        try {
            clock.start(call.toShortString());
            return call.proceed();
//  mozeme dokonca zmenit aj argumenty alebo navratovu hodnotu
//            Object[] par = {"ahoj"};
//            return call.proceed(par);
        } finally {
            clock.stop();
            System.out.println(clock.prettyPrint());
        }
    }
    
    public void printAfaterRunData(){
        System.out.println("Odporny skret janko " + countedMsgCalls);
    }
}
