<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<h2>Hello World!</h2>
<br>
<br>

I am First.jsp		(CUSTOMISED)


<br><br>

<form action="secondServlet" method="post"">


Enter First No. : <input type="text" name="first"><br>
Enter Second No. : <input type="text" name="second"><br>

Select the Operation : 
<select name="operation">
	<option value="1">ADD</option>
	<option value="2">SUBTRACT</option>
	<option value="3">MULTIPLY</option>
	<option value="4">DIVIDE</option>
</select> 

<input type="submit" value="Add">

</form>



<br><br>

<br><br>
Click the below link to go to MySecondServlet
<br>

<a href="secondServlet">Click On Me</a>

<br>
<br>
<br>
<br>


<br><br>

<br><br>
Click the below link to go to INDEX FILE
<br>

<a href="index.jsp">INDEX FILE</a>


</body>
</html>