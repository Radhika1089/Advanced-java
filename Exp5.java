//PalindromeInterface class 
import java.rmi.Remote; 
import java.rmi.RemoteException; 
public interface PalindromeInterface extends Remote{ 
 public boolean Palindrome(String str) throws RemoteException; 
} 
// PalindromeImplement class 
import java.rmi.RemoteException; 
import java.rmi.server.UnicastRemoteObject; 
public class PalindromeImplement extends UnicastRemoteObject implements PalindromeInterface { 
 protected PalindromeImplement() throws RemoteException { 
 super(); 
 // TODO Auto-generated constructor stub 
 } 
 public boolean Palindrome (String str) { 
 String revString=""; 
 for(int i=str.length()-1;i>=0;i--) { 
 revString +=str.charAt(i); 
 } 
 if(str.compareTo(revString)==0) { 
 return true; 
 } 
 else { 
 return false; 
 } 
 } 
} 
//Server class 
import java.net.MalformedURLException; 
import java.rmi.Naming; 
import java.rmi.RemoteException; 
public class ServerClass { 
 public static void main(String args[]) { 
 
 try { 
 PalindromeImplement pi = new PalindromeImplement(); 
 try { 
 Naming.rebind("rmi://localhost/abc",pi); 
 } catch (MalformedURLException e) { 
 // TODO Auto-generated catch block 
 e.printStackTrace(); 
 } 
 System.out.println("Server Ready"); 
 } catch (RemoteException e) { 
 // TODO Auto-generated catch block 
 e.printStackTrace( 
 
 } 
} 
//Client class 
import java.net.MalformedURLException; 
import java.rmi.Naming; 
import java.rmi.NotBoundException; 
import java.rmi.RemoteException; 
public class ClientClass { 
 public static void main(String arg[]) { 
 PalindromeInterface pi; 
 boolean b = false; 
 try { 
 pi= (PalindromeInterface) Naming.lookup("rmi://localhost/abc"); 
 b = pi.Palindrome("lvel"); 
 if(b) { 
 System.out.println("String is Palindrome"); 
 } 
 else { 
 System.out.println("Not Palindrome"); 
 } 
 } catch (Exception e) {
 // TODO Auto
 e.printStackTrace();
 } 
 } 
} 


