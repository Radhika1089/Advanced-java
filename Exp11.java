import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class Studentdb {
// TODO Auto-generated method stub
final static String URL="jdbc:mysql://localhost:3306/studentdb";
static final String USER="root";
static final String PASS="Pravin08@";
public static void main(String[] args) {
// TODO Auto-generated method stub
try {
Class.forName("com.mysql.cj.jdbc.Driver");
Connection
con=DriverManager.getConnection(URL,USER,PASS);
Statement stmt=con.createStatement();
System.out.println("enter the student details");
Scanner s=new Scanner(System.in);
System.out.println("enter the student rollno");
int id=s.nextInt();
System.out.println("enter the student name");
s.nextLine();
String name=s.nextLine();
System.out.println("enter the student ajp marks");
int ajp=s.nextInt();
System.out.println("enter the student cn marks");
int cn=s.nextInt();
System.out.println("enter the student pdc marks");
int pdc=s.nextInt();
System.out.println("enter the student pm marks");
int pm=s.nextInt();
System.out.println("enter the student stp marks");
int stp=s.nextInt();
int avg=(((ajp+cn+pdc+pm+stp)/5));
String sql="INSERT INTO STUDENT
values('"+id+"','"+name+"','"+ajp+"','"+cn+"','"+pdc+"','"+pm+"','"+stp+"','"+avg+"')";
stmt.executeUpdate(sql);
System.out.println("data inserted succesfully");
System.out.println("=========================result=====================");
String sql2="select * from student where id="+id+"";
ResultSet rs=stmt.executeQuery(sql2);
while(rs.next()) {
System.out.println("| ID |"+ "| NAME |"+"| AJP | "+" CN
|"+" PDC |"+ "PM |"+" STP |"+" AVG");
System.out.println(rs.getInt(1)+" "+" "+rs.getString(2)+"
"+" "+rs.getInt(3)+" "+" "+rs.getInt(4)+" "+" "+rs.getInt(5)+" "+" "+rs.getInt(6)+" "+"
"+rs.getInt(7)+" "+" "+rs.getInt(8));
}
}
catch(Exception e) {
System.out.println(e);
}
}
}