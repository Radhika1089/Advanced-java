package expt6_InetAddress;
import java.net.*;
public class Expt6_InetAddress {
public static void main(String args[])throws UnknownHostException{
System.out.println("Details of My Machine Using getLocalHost(): ");
InetAddress Address = InetAddress.getLocalHost();
System.out.println(Address);
System.out.println();
System.out.println("Details of My Machine Using getByName(): ");
Address = InetAddress.getByName("DESKTOP-3KT3MEG");
System.out.println(Address);
System.out.println();
System.out.println("Details of www.google.com Using getByName(): ");
InetAddress SW1[] = InetAddress.getAllByName("www.google.com");
for(int i=0;i<SW1.length;i++)
System.out.println(SW1[i]);
System.out.println();
System.out.println("Details of www.sinhgad.com Using getByName(): ");
InetAddress SW2[] = InetAddress.getAllByName("www.google.com");
for(int i=0;i<SW2.length;i++)
System.out.println(SW2[i]);
}
}
