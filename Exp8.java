import java.io.*; 
import java.sql.*; 
import javax.sql.*; 
import java.util.*; 
import java.sql.ResultSet; 
import java.sql.ResultSetMetaData; 
public class jdbc 
{ 
public static void main(String[] args) throws Exception 
{ int rno,age; 
String usn,name,marks; 
Statement s=null; 
ResultSet rs=null; 
int ch; 
boolean flag=true; 
Scanner sc=new Scanner(System.in); 
String driver ="com.mysql.cj.jdbc.Driver"; 
String url ="jdbc:mysql://localhost:3306/jdbcdb"; 
String user ="root"; 
String pass ="hrithik"; 
try 
{ 
Class.forName("com.mysql.cj.jdbc.Driver"); 
System.out.println("Successfully registered driver"); 
Connection con=DriverManager.getConnection(url,user,pass); 
System.out.println("Got connected with DB"); 
} 
catch(Exception e) 
{ 
System.out.println("error1"+e); 
} 
do 
{ 
System.out.println("Press 1 to INSERT into the DB"); 
System.out.println("Press 2 to DELETE from DB"); 
System.out.println("Press 3 to UPDATE into DB"); 
System.out.println("Press 4 to VIEW ALL from DB"); 
System.out.println("Press 5 to EXIT"); 
System.out.println("Enter your choice"); 
ch=Integer.parseInt(sc.nextLine()); 
switch(ch) 
{ 
case 1: 
System.out.println(" enter usn"); 
usn=sc.nextLine(); 
System.out.println(" enter name"); 
name=sc.nextLine(); 
System.out.println(" enter marks"); 
marks=sc.nextLine(); 
try 
{ 
Connection con =DriverManager.getConnection(url,user,pass); 
String query="Insert into stud values('"+usn+"','"+name+"','"+marks+"')"; 
s=con.createStatement(); 
s.execute(query); 
System.out.println("row inserted"); 
} 
catch(Exception e) 
{ 
System.out.println("error2"+e); 
} 
break; 
case 2: 
try 
{ 
Connection con =DriverManager.getConnection(url,user,pass); 
System.out.println("Eneter the usn"); 
String str2=sc.nextLine(); 
//String query="delete from stud where usn=str2"; 
s=con.createStatement(); 
int x=s.executeUpdate("delete from stud where username="+"'"+str2+"'"); 
System.out.println("deleted rows are:"+x); 
} 
catch(Exception e) 
{ 
System.out.println("error3"+e); 
} 
break; 
case 3: 
try 
{ 
Connection con =DriverManager.getConnection(url,user,pass); 
System.out.println("enter usn to be updated"); 
String usn1=sc.nextLine(); 
String query="update stud set marks=90 where username='"+usn1+"'"; 
s=con.createStatement(); 
boolean x=s.execute(query); 
System.out.println("updated rows are:"+x); 
} 
catch(Exception e) 
{ 
System.out.println("error4"+e); 
} 
break; 
case 4: 
try 
{ 
Connection con =DriverManager.getConnection(url,user,pass); 
String query="select * from stud "; 
s=con.createStatement(); 
ResultSet rs1=s.executeQuery(query); 
boolean rec=rs1.next(); 
while(!rec) 
{ 
System.out.println("no record"); 
} 
do 
{ 
usn=rs1.getString(1); 
name=rs1.getString(2); 
marks=rs1.getString(3); 
System.out.print(usn+"\t"); 
System.out.print(name+"\t"); 
System.out.println(marks); 
}while(rs1.next()); 
s.close(); 
con.close(); 
} 
catch(Exception e) 
{ 
System.out.println("error5"+e); 
} 
break; 
case 5: 
System.exit(1); 
break; 
default: 
System.out.println("i am default"); 
} 
System.out.println("do u want to continue(yes /no)"); 
String str=sc.nextLine(); 
if(str.equals("yes")|| str.equals("y")) 
flag=true; 
if(str.equals("no")||str.equals("no")) 
flag=false; 
}while(flag); 
} 
} 