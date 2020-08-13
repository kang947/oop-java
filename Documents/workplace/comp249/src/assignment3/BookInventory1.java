package assignment3;

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;

//-----------------------------------------------------
//Assignment #3
//Part: 1
//Written by: Byoungwoo Kang(27744544); Nayagen Manikion(40020905);
//-----------------------------------------------------

public class BookInventory1 {
	
	private static Book bkArr[];
	private static int nbOfRecords;
	private static int j=0;
	private static boolean done=false;
	
	public static void fixInventory(Scanner sc,PrintWriter outS)throws IOException{
		
		//search algorithm 
		//1.making an object from the file. an array of objects.
		

		
		//1-1 scanner created
		//read the file and make an object.
		long ISBN1;
		String title;
		int year;
		String author;
		double price;
		int nbPages;
		
		int counter=0;
		bkArr= new Book [nbOfRecords];
		

		while(sc.hasNextLine()){
			ISBN1 = sc.nextLong();
			title = sc.next();
			year = sc.nextInt();
			author = sc.next();
			price = sc.nextDouble();
			nbPages = sc.nextInt();
			
			bkArr[counter++] = new Book(ISBN1, title, year, author, price, nbPages);
			
		
		}
			
		
		if(nbOfRecords ==0||nbOfRecords==1){
			System.out.println("The file does not need to be fixed, program terminates");
			System.out.println("meaning Initial_Book_Info.txt is correct.");
			System.exit(0);
		}
	
			
		
		//detection & correction within the array
		detecCorec();
			
		//throw new DuplicateISBNException();
		while(!done){
			try{
				duplicateCheck();
				done=true;
			}
			catch(DuplicateISBNException e){
				detecCorec2();
			}
		}
		
		//object into output file.
		for(int i=0; i<bkArr.length; i++){
			outS.print(bkArr[i].getISBN()+" ");
			outS.print(bkArr[i].getTitle()+" ");
			outS.print(bkArr[i].getIssueYear()+" ");
			outS.print(bkArr[i].getAuthor()+" ");
			outS.print(bkArr[i].getPrice()+" ");
			outS.print(bkArr[i].getNbOfPages()+" ");
			outS.println();
		}
			sc.close();
			outS.close();
	}
	
	//detec&corec but with exception handling. 
	public static void duplicateCheck() throws DuplicateISBNException{
		Scanner kb = new Scanner(System.in);
		System.out.println("Attempt of duplicate entry to a previous record.");
		int i=0;
		for(i =0; i<nbOfRecords; i++){
			for(j = i+1; j<nbOfRecords; j++){
				if(bkArr[i].getISBN()==bkArr[j].getISBN()){
					throw new DuplicateISBNException("Initial appearance of ISBN "+bkArr[i].getISBN()+
							" found at record #: "+j+"."
									+ "\nError.... Duplicate Entry ofISBN. The entered ISBN exists for another record.");
									
				}
			}
		}
	}

	
	
	//primary correction without exception handling
	public static void detecCorec(){
		Scanner kb = new Scanner(System.in);
		
		for(int i =0; i<nbOfRecords; i++){
			for(int j=i+1; j<nbOfRecords;j++){
				if(bkArr[i].getISBN()== bkArr[j].getISBN()){
					System.out.println("Duplicate ISBN "+bkArr[i].getISBN() +" detected in record # "+(j+1)+
							". Please enter the correct ISBN: ");
					bkArr[j].setISBN(kb.nextLong());
				}
			}
		}
	}
	//secondary correction in the exception catch
	public static void detecCorec2(){
		Scanner kb = new Scanner(System.in);
		outer:
		for(int i =0; i<nbOfRecords; i++){
			for(int j=i+1; j<nbOfRecords;j++){
				if(bkArr[i].getISBN()== bkArr[j].getISBN()){
					System.out.println("Duplicate ISBN "+bkArr[i].getISBN() +" detected in record # "+(j+1)+
							". Please enter the correct ISBN: ");
					bkArr[j].setISBN(kb.nextLong());
					break outer;
				}
			}
		}
	}
	
	public static int helper(Scanner inS){
						
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
	
	
	
	public static void main(String[] args) throws IOException {
		
		String s1; //for file name String
		PrintWriter pw = null;
		Scanner kb = new Scanner(System.in);//input will be required
		Scanner sc = null; //create a BufferedReader object to read from input files
		BufferedReader br = null,br1 =null;
		
		System.out.println("Please enter the name of output file, which will have correct information: ");
		s1= kb.next();
		
		File corrected= new File(s1);
		
		while(corrected.exists())
		{
			System.out.println("Error: there is an existing file called: " + s1+".");
			System.out.println("That file already has a size of " + corrected.length() + "bytes.");
			System.out.println("\nPlease enter another file name to create: ");
			s1 = kb.next();
			corrected = new File(s1);//looping here
		}
		
		
		//try for pw
		try{
			
			pw = new PrintWriter(new FileOutputStream(s1, true));
		}
		catch(FileNotFoundException e){
			System.out.println("PW caused FileNotFoundException");
			System.exit(0);
		}
		catch(IOException e){
			System.out.println("Error: An error has occurred while reading from the " + s1 + " file. ");
			System.out.println("Program will terminate.");
			System.exit(0);		
		}
		
		
		
		System.out.println("Attempting to open file: Initial_Book_Info.txt");
		
		//try sc for check the records
		try{
			sc = new Scanner(new FileInputStream("Initial_Book_Info.txt"));
			nbOfRecords=helper(sc);

		}
		catch(FileNotFoundException e){
			System.out.println("scanner input Stream try caused FileNotFoundException");
			System.exit(0);
		}
		catch(IOException e){
			System.out.println("Error: An error has occurred while reading from the " + s1 + " file. ");
			System.out.println("Program will terminate.");
			System.exit(0);		
		}
		
		
		
		
		//try for sc, initializaing bkArr()
		try{
			sc = new Scanner(new FileInputStream("Initial_Book_Info.txt"));
			fixInventory(sc,pw);

		}
		catch(FileNotFoundException e){
			System.out.println("scanner input Stream try caused FileNotFoundException");
			System.exit(0);
		}
		catch(IOException e){
			System.out.println("Error: An error has occurred while reading from the " + s1 + " file. ");
			System.out.println("Program will terminate.");
			System.exit(0);		
		}
		
		
		pw.close();
		sc.close();
		
		//bufferedReader for display(original)
		try{
			br = new BufferedReader(new FileReader("Initial_Book_Info.txt"));
			System.out.println("\nHere are the contents of file Initial_Book_Info.txt BEFORE copying operation:"
					+ "\n=======================================================================================");
			displayFileContents(br);
		}
		catch(FileNotFoundException e){
			System.out.println("Problem opening files. Cannot proceed to copy.");
			System.out.println("Program will terminate.");
			System.exit(0);		
		}
		catch(IOException e){
			System.out.println("Error: An error has occurred while reading from the " + s1 + " file. ");
			System.out.println("Program will terminate.");
			System.exit(0);		
		}
		br.close();
		
		
		//bufferedReader for display(corrected)
		try{
			br1 = new BufferedReader(new FileReader(s1));
			System.out.println("\n\nHere are the contents of file "+s1+":"
					+ "\n=======================================================================================");
			displayFileContents(br1);
		}
		catch(FileNotFoundException e){
			System.out.println("Problem opening files. Cannot proceed to copy.");
			System.out.println("Program will terminate.");
			System.exit(0);		
		}
		catch(IOException e){
			System.out.println("Error: An error has occurred while reading from the " + s1 + " file. ");
			System.out.println("Program will terminate.");
			System.exit(0);		
		}
		br1.close();
	
	}

}
