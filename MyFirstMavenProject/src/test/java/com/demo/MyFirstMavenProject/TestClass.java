package com.iris.MyFirstMavenProject;

import org.junit.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class TestClass
{
	
	
	@Test
	public void TestCase1()
	{
		String str = "shubham";
		
		assertEquals("shubham",str);
		
		System.out.println("");
	}
	
	
	public static void main(String[]args)
	{
		 Result result = JUnitCore.runClasses(TestClass.class);
		 
		 for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	      }
			
	      System.out.println(result.wasSuccessful());
		 
	}
	

}



