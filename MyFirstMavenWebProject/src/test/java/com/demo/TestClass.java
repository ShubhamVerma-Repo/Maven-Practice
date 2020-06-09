package com.demo;

import org.junit.*;

import com.demo.MySecondServlet;

import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.*;

public class TestClass 
{
	double getData=MySecondServlet.Add(4, 5);
	
	
	@Test	
	@Ignore
	public void TestCase1()
	{		
		assertEquals(11,MySecondServlet.Add(5,6));
		
		//assertThat(11,is(getData));
	}
	
	
	@Test
	@Ignore
	public void TestCase2()
	{
		assertEquals(11, MySecondServlet.Calculate(22, 12, 2));
		
		//assertEquals(10.0, MySecondServlet.Calculate(22, 12, 3));
		
	}

}
