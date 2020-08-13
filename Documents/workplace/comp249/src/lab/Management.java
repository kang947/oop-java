package lab;

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;


public class Management {

	//driver
	public static void main(String[] args){
		
		PrintWriter pw= null;//for complier
		String s;
		long l;
		Scanner kb = new Scanner(System.in);
		
		try{
			pw = new PrintWriter(new FileOutputStream("info.txt",true));
		}
		catch(FileNotFoundException e){
			System.out.println("cannot open imput file for reading.");
			System.exit(0);
		}
		
		
		// driver start
		System.out.println("we need to store your infomration; \n"
				+ "Please enter your First Name: ");
		
		s= kb.next();
		pw.println("First Name: "+s); //into the file
		
		System.out.println("\nPlease Enter your Last Name: ");
		s = kb.next();
		pw.println("Last Name: "+s);
		
		System.out.println("\nPlease Enter Employee_id: ");
		l= kb.nextLong();
		pw.println("Employee_id: "+l);
		
		pw.close();
		System.out.println("Thank you for filling your information."); 
		System.out.println("Your information has been stored in a file called \"Info.txt\".");
		
		
		
		
		
	}
	
	
	
}
