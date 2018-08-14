package com.zjl.crawler;

/**
 * App Entry
 * @author panda fang
 * @date 2017-08-24
 * @version 1.0
 */
public class App 
{
    public static void main( String[] args )
    {
    	Spider spider = new Spider("D://meizi");
    	for(int i = 5573; i <= 5576; i++) {
    		spider.run(i);
    	}
    	
    }

}
