//index.html-  
  
<!DOCTYPE html>  
<html>  
<head>  
<meta charset="UTF-8">  
<title>Insert title here</title>  
</head>  <body>  
  
  
<form action="index.jsp" method="get">  
<label for="numberInput">Enter a number:</label>  
<input type="number" id="numberInput" name="numberInput">  
<button type="submit">Submit</button>  </form>  
  
  
</body>  
</htm l>   
//index.jsp-  
  
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<!DOCTYPE html>  
<html> 
<head>  
<meta charset="UTF-8">  
<title>Insert title here</title>  
</head>  
<body>  
  
<h1>Welcome to JSP</h1>  
  
<br>  
  
  
<%  
  
String n=request.getParameter("numberInput"); int no=Integer.parseInt(n); out.println("Number Entered Is :"+no); out.println("<br> <br>"); out.println("Cube Of a Number is : "+no*no*no);   
%>  
  
</body>  
</html>  
