package assignment3.a;

import java.io.PrintWriter;
import java.util.Scanner;

import assignment3.Book;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.File;

import java.io.ObjectOutputStream;
import java.io.EOFException;

//-----------------------------------------------------
//Assignment #3
//Part: 2
//Written by: Byoungwoo Kang(27744544); Nayagen Manikion(40020905);
//-----------------------------------------------------

public class BookInventory2 {

	private static Book [] bkArr;
	private static int nbOfRecords;
	private static int binaryCounter=0, sequentialCounter=0;
	
	
	public static void addRecords(PrintWriter pw){
		Scanner kb = new Scanner(System.in);
		int records;
		System.out.println("How many records would you add to the file Sorted_Book_Info File?:");
		records=kb.nextInt();
		long firstInput=0,secondInput=0;
		
		
		for(int i =0; i<records; i++){
			System.out.println("\nAdding #"+(i+1)+" new records:");
			System.out.println("Enter ISBN #: ");
			//reject or accept but how?
			//its not chronologically before bkArr[] // even nbOfRecords is not available
			//assume the first appending input is greater than the last ISBN number of the original list.
			if(i==0){
			firstInput=kb.nextLong();
			pw.print(firstInput+" ");
			}
			else
			{
				secondInput=kb.nextLong();
				while(firstInput>=secondInput)
				{
					System.out.println("the ISBN value has to be greater than the previous one. Enter again: ");
					secondInput=kb.nextLong();
				}
				pw.print(secondInput+" ");
				firstInput=secondInput;
			}
		
			System.out.println("Enter the title: ");
			pw.print(kb.next()+" ");
			System.out.println("Enter the year issued: ");
			pw.print(kb.nextInt()+" ");
			System.out.println("Enter the author's name: ");
			pw.print(kb.next()+" ");
			System.out.println("Enter the price: ");
			pw.print(kb.nextDouble()+" ");
			System.out.println("Enter the page number: ");
			pw.print(kb.nextInt()+" ");
			pw.println();

			
			System.out.println("New records #"+(i+1)+" has been succesfully added to the file");
		}
		 
		
	}
	
	public static int helper(Scanner inS){
		
		int nbOfRecords=0;
		
		
		while(inS.hasNextLine())
		{
			inS.nextLine();
			nbOfRecords++;
		}
		return nbOfRecords;
	}

	
	public static void displayFileContents(BufferedReader inS)throws IOException{
		/* read line by line from input file and display it(on the monitor)
		 * The method actually uses the read() method (instead of readLine(), which we
		 * could have surely used here without a problem). The read() method reads 
		 * character by character, but each character is read as type int, so casting is needed
		 * so that we can display character and not their integer value
		 */
		
		int x;
		x= inS.read();
		while(x!=-1)//returns -1 when EOF
		{
			System.out.print((char)x);
			x = inS.read();
		}
		//must close the file
		inS.close();
	}
	
	
	public static int binaryBookSearch(Book[]b, int s, int e, long I){
		
		int foundIndex = -1, mid=0;
		boolean found = false;
		
		
		if(s>e){
			return -1;
		}
		
		mid= (s+e)/2;
		
		if((s<=e)&&!found){
			binaryCounter++;
			
			if(b[mid].getISBN()==I)
			{
				System.out.println("\nThe value was found...");
				foundIndex= mid;
				System.out.println("The value we are looking for is located at index #: "+(foundIndex));
				found=true;

			}
			else{
				if(I< b[mid].getISBN())
				{
					foundIndex = binaryBookSearch(b, s, mid-1, I);
				}
				else
				{
					foundIndex = binaryBookSearch(b, mid+1, e, I); 
				}
			}
		}
		return foundIndex;
	}
	
	public static int sequentialBookSearch(Book[]b, int s, int e, long I){
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter the ISBN you wish to find: ");
		I=kb.nextLong();

		
		int foundIndex = -1;
		for(int i =0; i<b.length;i++){
			sequentialCounter++;
			if(b[i].getISBN()==I)
			{
				foundIndex=i;
				System.out.println("\nThe value was found ......"
						+ "\nThe value we are looking for is located at index #: " +foundIndex);
				
				break;
			}
		}
		return foundIndex;
	}
	
	public static void makeObjectArr(Scanner sc)throws IOException{
		//read the file and make an object.
		long ISBN1;
		String title;
		int year;
		String author;
		double price;
		int nbPages;
		
		int counter=0;
		bkArr= new Book [nbOfRecords];
		
	
		while(sc.hasNextLong()){
			
			ISBN1 = sc.nextLong();
			title = sc.next();
			year = sc.nextInt();
			author = sc.next();
			price = sc.nextDouble();
			nbPages = sc.nextInt();
		
			bkArr[counter] = new Book(ISBN1, title, year, author, price, nbPages);
			
			counter++;
		}
		
	}
	
	
	
	
	public static void main(String[] args) {
		
		//1. must open Sorted_Book_Info.txt and append it
		//try for pw
		PrintWriter pw= null;
		BufferedReader br = null;
		Scanner sc = null,sc1 = null;
		
		ObjectOutputStream oos = null;
		ObjectInputStream ois=null;
		
		//addRecords(pw) can be called once pw is made. 
		try{
			pw = new PrintWriter(new FileOutputStream("Sorted_Book_Info.txt", true));
			addRecords(pw);
		}
		catch(FileNotFoundException e){
			System.out.println("PW caused FileNotFoundException");
			System.exit(0);
		}
		catch(IOException e){
			System.out.println("Error: An error has occurred while reading from the Sorted_Book.Info.txt file. ");
			System.out.println("Program will terminate.");
			System.exit(0);		
		}
		pw.close();
		
		
		//then call displayFileContents() but br first. 
		try{
			br = new BufferedReader(new FileReader("Sorted_Book_Info.txt"));
			System.out.println();
			displayFileContents(br);
			br.close();
		}
		catch(FileNotFoundException e){
			System.out.println("Problem opening files. Cannot proceed to copy.");
			System.out.println("Program will terminate.");
			System.exit(0);		
		}
		catch(IOException e){
			System.out.println("Error: An error has occurred while reading from the Sorted_Book_Info.txt file. ");
			System.out.println("Program will terminate.");
			System.exit(0);		
		}
		
		
		//open scanner, then use helper() to find out the array size
		try{
			sc = new Scanner(new FileInputStream("Sorted_Book_Info.txt"));
			nbOfRecords =helper(sc);
		}
		catch(FileNotFoundException e){
			System.out.println("scanner(helper use) input Stream try caused FileNotFoundException");
			System.exit(0);
		}
		catch(IOException e){
			System.out.println("Error: An error has occurred while reading from the Sorted_Book_Info.txt file. ");
			System.out.println("Program will terminate.");
			System.exit(0);	
		}
		
		//to make an objectArr()
		try{
			sc1 = new Scanner(new FileInputStream("Sorted_Book_Info.txt"));
			makeObjectArr(sc1);

		}
		catch(FileNotFoundException e){
			System.out.println("scanner input Stream try caused FileNotFoundException");
			System.exit(0);
		}
		catch(IOException e){
			System.out.println("Error: An error has occurred while reading from the Sorted_Book_Info.txt file. ");
			System.out.println("Program will terminate.");
			System.exit(0);	
		}
		
		System.out.println("\n=========================================================");
		//can't make it inside the method when recursion is used. 
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter the ISBN you wish to find: ");
		long I=kb.nextLong();
		
		binaryBookSearch(bkArr, 0, nbOfRecords, I);
		System.out.println("\n=========================================================");

		System.out.println("Binary search took "+binaryCounter+"times of iteration to find the target location.");

		System.out.println("\n=========================================================");
		sequentialBookSearch(bkArr, 0, nbOfRecords, 230759326);
		System.out.println("\n=========================================================");

		System.out.println("Sequential search took "+sequentialCounter+"times of iteration to find the target location.");

		try{
			oos = new ObjectOutputStream(new FileOutputStream("Books.dat"));
			for(int i =0; i<nbOfRecords; i++){
				oos.writeObject(bkArr[i]);}
			oos.close();
			System.out.println("Objects have been written to Book.dat file.");
		}
		catch(FileNotFoundException e){
			System.out.println("oos try caused FileNotFoundException");

			System.exit(0);

		}
		catch(IOException e){
			System.out.println("Error: An error has occurred while writing from the Books.dat file. ");
			System.out.println("Program will terminate.");
			System.exit(0);
		}
		
		
		//to check if the objects array created successfully
//		try{
//			ois = new ObjectInputStream(new FileInputStream("Books.dat"));
//			
//			Book b;
//			int i =1;
//			
//			try{
//				while(true){
//					b = (Book)ois.readObject();
//					
//					System.out.println("\nHere is the information of object # " + i++ + ":");
//					System.out.println("====================================== ");
//					System.out.println(b);
//					
//				}
//			}
//			catch(ClassNotFoundException e)
//			{
//				System.out.println("Error has occurred while reading the file: Books.dat.");
//			}
//			catch(EOFException e)
//			{
//				System.out.println("\nReading file Book.dat has been completed.");
//			}
//			ois.close();		// Close the file
//		}
//		catch(FileNotFoundException e){
//			System.out.println("oos try caused FileNotFoundException");
//			System.exit(0);
//
//		}
//		catch(IOException e){
//			System.out.println("Error: An error has occurred while writing from the Books.dat file. ");
//			System.out.println("Program will terminate.");
//			System.exit(0);
//		}
//		
		
	}

}
