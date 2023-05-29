<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
<form action="register" method="post">
<h1>login</h1>
<label>Username</label>
<input type="text" name="username">
<br><br>
<label> Email ID</label>
<input type="email" name="email">
<br><br>
<label>Country</label>
<input type="text" name="country">
<br><br>
<label></label>
<label>Password</label>
<input type="Password" name="password">
<br><br>
<input type="submit" value="Register"><br/>
</form>
</body>
</html>
import java.io.IOException; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
/**
* Servlet implementation class register
*/
@WebServlet("/register") 
public class register extends HttpServlet { 
private static final long serialVersionUID = 1L; 
/**
* @see HttpServlet#HttpServlet()
*/
public register() { 
super(); 
// TODO Auto-generated constructor stub
} 
protected void doPost(HttpServletRequest request, HttpServletResponse response) 
throws ServletException, IOException { 
// TODO Auto-generated method stub
//doGet(request, response);
String username = request.getParameter("username"); 
String emailid = request.getParameter("email"); 
String country = request.getParameter("country"); 
String password = request.getParameter("password"); 
UserDao ud =new UserDao(); 
String msg = ud.createUser(username,emailid,country, password); 
response.getWriter().print(msg); 
} 
} 
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement; 
import java.sql.SQLException; 
public class UserDao { 
public String createUser(String str1,String str2,String str3,String str4) { 
String driver ="com.mysql.cj.jdbc.Driver"; 
String url ="jdbc:mysql://localhost:3306/jdbcdb"; 
String user ="root"; 
String pass ="hrithik"; 
String str = "Error"; 
String query =("insert into 
example(username,email,country,password)values(?,?,?,?)"); 
try { 
Class.forName("com.mysql.cj.jdbc.Driver"); 
Connection con =DriverManager.getConnection(url,user,pass); 
PreparedStatement pstmt=con.prepareStatement(query); 
pstmt.setString(1, str1); 
pstmt.setString(2, str2); 
pstmt.setString(3, str3); 
pstmt.setString(4, str4); 
pstmt.execute(); 
str = "Data added successfully"; 
}catch(SQLException | ClassNotFoundException e){ 
e.printStackTrace(); 
} 
return str; 
} 
} 
