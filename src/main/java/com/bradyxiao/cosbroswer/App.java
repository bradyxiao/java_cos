package com.bradyxiao.cosbroswer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Hello world!
 *
 */
public class App 
{

    static Log log = LogFactory.getFactory().getInstance(App.class);
    
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
      
        log.error("error");
        log.info("info");
        log.debug("debug");
    }
}
