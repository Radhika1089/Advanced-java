//LoginServlet Code- import 
java.io.IOException;  
import java.sql.ResultSet; import java.sql.SQLException;  
import javax.servlet.ServletException; import  
javax.servlet.annotation.WebServlet; import javax.servlet.http.HttpServlet; import javax.servlet.http.HttpServletRequest; import javax.servlet.http.HttpServletResponse;  
  
/**  
*	Servlet implementation class Login  
*/  
@WebServlet("/Login") public class Login extends HttpServlet { private static final long serialVersionUID = 1L;  
  
/**  
*	@see HttpServlet#HttpServlet()  
 	*/  public  
Login() { super();  
// TODO Auto-generated constructor stub }  
  
/**  
*	@see HttpServlet#doGet(HttpServletRequest request, 
HttpServletResponse response)  
*/ protected void doGet(HttpServletRequest request,  
HttpServletResponse response) throws ServletException, IOException {  
// TODO Auto-generated method stub  
response.getWriter().append("Served at: 
").append(request.getContextPath());  
}  
  
/**  
*	@see HttpServlet#doPost(HttpServletRequest request, 
HttpServletResponse response)  
*/ protected void doPost(HttpServletRequest request,  
HttpServletResponse response) throws ServletException, IOException {  
// TODO Auto-generated method stub  
//  	doGet(request, response);  
  
  
  
//Get username and password from the client  
String username = request.getParameter("username");  
String password = request.getParameter("password");  //Display the username and password on the serverside  
response.getWriter().print(" Client : Username- " + username + "<br>"); response.getWriter().print(" Client : Password- " + password + "<br>");  
  
UserDao ud= new UserDao();  
ResultSet rs=ud.readUser(username);  
  
try {  
while(rs.next()) {  
  response.getWriter().print(" Server : Username- "  
+ rs.getString(1) + "<br>"); response.getWriter().print(" Server : Passsword- " + rs.getString(2) + "<br>");  
  
}}  catch(SQLException e) {  
  
e.printStackTrace();  
}  
  
}  
  
}  
  
  
//UserDao.java - import java.sql.*;  
   public class 
UserDao {   public ResultSet readUser (String str){  
String driver ="com.mysql.cj.jdbc.Driver";  
String 
url="jdbc:mysql://localhost/javadb";     
String user="root";  
String pass="yash25";  
  
ResultSet rs=null;  
String query="SELECT*FROM clientserverdata WHERE username=?";  
  
try {  
  
Class.forName(driver);  
java.sql.Connection conn  
=DriverManager.getConnection(url,user,pass);  
PreparedStatement st=conn.prepareStatement(query); st.setString(1, str);  
rs=st.executeQuery();  
  
} catch (Exception e) {  
// TODO Auto-generated catch block  
e.printStackTrace();  
  
} return rs;  
}  
}  
  
  
//index.html-  
  
<!DOCTYPE html>  
<html>  
<head>  
<meta charset="ISO-8859-1">  
<title>Insert title here</title>  
</head>  
<body>  
  
<form action="Login" method="post">  
<h1 >Login</h1>  
<label>username</label>  
  
<input type ="text" name ="username">  
<br><br>  
  
<label> password</label>  
  
<input type ="password" name ="password">  
<br><br>  
  
  
<input type ="submit" name ="Submit"> <br/>  
</form>  
  
</body>  
</html>  
