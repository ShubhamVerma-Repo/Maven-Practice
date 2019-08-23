package com.iris.MyFirstMavenProject;

import java.io.FileReader;
import java.util.*;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        System.out.println( "Hello World!" );
        

    	List<String> stringList = new ArrayList<String>();
    	
    	stringList.add("shubham");
    	stringList.add("verma");
    	
    	System.out.println(stringList);
    	
    	String abc = " :00 AM";
    	abc.split(":");
        
    	
    	
    	
    	
    	
    	FileReader fr=new FileReader("E:/Code Repository/MyFirstMavenProject/src/main/java/com/iris/MyFirstMavenProject/DB.properties");
    	Properties p=new Properties();
    	p.load(fr);
    	
    	
    	System.out.println("property one : " +p.getProperty("DRIVER"));
    	System.out.println("property one : " +p.getProperty("CONNECTION_URL"));
    	System.out.println("property one : " +p.getProperty("USERNAME"));
    	System.out.println("property one : " +p.getProperty("PASSWORD"));
    	
    	
    	
    	
    }
}
