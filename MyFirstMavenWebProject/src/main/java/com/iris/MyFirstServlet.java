package com.iris;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import java.util.*;


/**
 * Servlet implementation class MyFirstServlet
 */


@WebServlet("/firstServlet")

@MultipartConfig

public class MyFirstServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyFirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out= response.getWriter();
		
		
		//---------------	GET FILE EXTENSION	----------------------
		
		String s = "/var/www.dir/file.tar.gz";
		String file = s.substring(s.lastIndexOf("/"));
		String extension = file.substring(file.indexOf(".")); 
			
		out.println(extension);
		
		//------------------------------------------------------------
		
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
		
		/*request.getRequestDispatcher("/second.jsp").forward(request, response);*/
		request.getRequestDispatcher("/second.jsp").include(request, response);
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		PrintWriter out= response.getWriter();
		
		
		//------------------	GET FILE NAME	------------------------
		
		//String description = request.getParameter("description"); // Retrieves <input type="text" name="description">
	    Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
	    String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
	    //InputStream fileContent = filePart.getInputStream();
		
	    out.println("<br/>");
	    out.println("<br/>");
	    
		out.println(" file name :  "+fileName);
		
		out.println("<br/>");
		out.println("<br/>");

		//------------------	GET FILE EXTENSION	------------------------

		//String s = "/var/www.dir/file.tar.gz";
		//String file = fileName.substring(fileName.lastIndexOf("/"));
		//String extension = fileName.substring(fileName.indexOf(".")); 
		
		String extension = fileName.substring(fileName.lastIndexOf("."));
		
		out.println("<br/>");
		
		out.println("file extension :   "+extension);
		
		
		//-------------------------------------------------------------------		
		
		
		
		String abc = getSubmittedFileName(filePart);
		
		System.out.println(abc);
		
		
		
	}
	
	
	//------------------	GET FILE ACTUAL NAME	------------------------
	
	private static String getSubmittedFileName(Part part) {

		System.out.println(part);

		for (String cd : part.getHeader("content-disposition").split(";")) {
			if (cd.trim().startsWith("filename")) {
				System.out.println(cd);
				String fileName = cd.substring(cd.indexOf('=') + 2).trim();
				System.out.println(fileName);
				String newone = fileName.substring(0, fileName.lastIndexOf('"')).replace("\\", "\\\\");
				System.out.println(newone);
				return fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1); // MSIE fix.																												
			}
		}
		return null;
	}
}


//------------------	GET FILE ACTUAL NAME	------------------------

/*public static String getSubmittedFileName(Part part) {
	for (String cd : part.getHeader("content-disposition").split(";")) {
		if (cd.trim().startsWith("filename")) {
			String fileName = cd.substring(cd.indexOf('=') + 2);
			return fileName.substring(0, fileName.lastIndexOf('"')).replace("\\", "\\\\");
		}
	}
	return "";
}*/




