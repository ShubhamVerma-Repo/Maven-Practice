package com.iris;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class MySecondServlet
 */


@WebServlet("/secondServlet")

public class MySecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MySecondServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out=response.getWriter();
		
		out.println("<br>");
		out.println("<br>");
		
		
		
		out.println("this is my path");
		out.println("<br>");
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
				
		out.println("<br>");
		out.println("<br>");
		out.println("hello Servlet");
		out.println("<br>");
		out.println("<br>");
		out.println("<a href=second.jsp>Second Jsp Page</a>");
		
		out.println("<br>");
		out.println("<br>");

    	List<String> stringList = new ArrayList<String>();
    	
    	stringList.add("shubham");
    	stringList.add("verma");
    	
    	out.println(stringList);
    	
    	out.println("<br/>");
		
		
		/*using requestDispatcher to go to next jsp page/servlet*/
		
		//request.getRequestDispatcher("/second.jsp").forward(request, response);
		//request.getRequestDispatcher("/second.jsp").include(request, response);

		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		//doGet(request, response);
	
		
		int firstNo = Integer.parseInt(request.getParameter("first")) ;		
		int secondNo = Integer.parseInt(request.getParameter("second")) ;
		int operation = Integer.parseInt(request.getParameter("operation")) ;
				
		int abc=Add(firstNo,secondNo);
		
		double result=Calculate(firstNo, secondNo, operation);
		
		System.out.println("addition is : "+abc);
		
		System.out.println("output is : "+result);
		
	}

	
	/*public int AddDemo()
	{
		int result=
	}*/
	
	public static int Add(int x,int y) 
	{
		int c=x+y;		
		return c;
	}
	
	
	public static int Calculate(int x,int y,int z)
	{
		int c=0;
		
		switch (z) 
		{
		case 1:
			c=x+y;
			break;

		case 2:
			c=x-y;
			break;
			
		case 3:
			c=x*y;
			break;
		case 4:
			c=x/y;
			break;
		default:
			break;
		}
		
		return c;
	}
	
	
	
	

}
