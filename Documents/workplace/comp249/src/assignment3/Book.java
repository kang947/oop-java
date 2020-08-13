package assignment3;

import java.io.Serializable;
//-----------------------------------------------------
//Assignment #3
//Part: 1
//Written by: Byoungwoo Kang(27744544); Nayagen Manikion(40020905);
//-----------------------------------------------------
public class Book implements Serializable {

	private long ISBN;
	private String title;
	private int issueYear;
	private String author;
	private double price;
	private int nbOfPages;
	
	public Book(){
		ISBN = 00001;
		title = "The_Adventures_Of_Tom_Sawyer";
		issueYear = 1876;
		author = "Mark_Twain";
		price = 6.99;
		nbOfPages =356;
	}
	
	public Book(long I, String t, int y, String a, double p, int n){
		ISBN = I;
		title = t;
		issueYear =y;
		author = a;
		price =p;
		nbOfPages =n;
		
	}
	
	//for deep copy
	public Book(Book b){
		ISBN = b.ISBN;
		title = b.title;
		issueYear =b.issueYear;
		author = b.author;
		price =b.price;
		nbOfPages = b.nbOfPages;
	}

	public long getISBN() {
		return ISBN;
	}

	public void setISBN(long iSBN) {
		ISBN = iSBN;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getIssueYear() {
		return issueYear;
	}

	public void setIssueYear(int issueYear) {
		this.issueYear = issueYear;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	public int getNbOfPages(){
		return nbOfPages;
	}
	public void setNbOfPages(int nbOfPages){
		this.nbOfPages=nbOfPages;
	}

	@Override
	public String toString() {
		return "Book [ISBN=" + ISBN + ", title=" + title + ", issueYear=" + issueYear + ", author=" + author
				+ ", price=" + price + ", nbOfPages=" + nbOfPages + "]";
	}
	
	
	
	
	
}
