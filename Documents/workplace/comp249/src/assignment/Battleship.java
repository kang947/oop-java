package assignment;

/*
 * Byoungwoo Kang(27744544)
 * Comp249 
 * assignment #1
 * due date: Feb,1 2017
 */

import java.util.*;
import java.util.Scanner;

public class Battleship {
	
	private static Scanner kb = new Scanner(System.in);
	
	private String [][] board = new String [8][8];
	public static int nbOfShip=0;
	public static int computerShip=0;
	public static int turn;
	
	public int userMiss=0;
	public int computerMiss=0;
	
	public boolean skipHumanTurn = false;
	public boolean skipComputerTurn= false;
	
	
	public Battleship(){
		
		this.board = new String [8][8];
		turn =5;
	}
	
	
	
	
	public int getnbOfShip(){
		return nbOfShip;
	}
	
	public int getcomputerShip(){
		return computerShip;
	}

	public static void breakln(){
		System.out.println("____________________________________");
	}
	
	
	public  void createBoard(){
		for (int r=0; r<board.length;r++){
			for(int c=0; c<board[0].length; c++){
				board[r][c] ="-";
			}
		}
	}
	
	public void showBoard(){
		for(int r=0; r<board.length;r++){
			for(int c=0; c<board[0].length;c++){
				System.out.print(board[r][c]+" ");
			}
			System.out.println();
		}
		breakln();
	}
	
	public void userShip(){
		
		int row, col;
		
		for(int i =0; i<6; i++){
		System.out.println("Enter the coordinates of your ship #"+(i+1)+": ");
		String coordinate = kb.next();
		
		row = (coordinate.charAt(0)-'A');
		col = (coordinate.charAt(1)-'1');
		
		//validity test
		if(coordinate.charAt(0)<'A'||coordinate.charAt(0)>'H'){
			System.out.println("Sorry, coordinates outside the grid try again!");
			i -=1; continue;
		}
		else if(coordinate.charAt(1)<'1'||coordinate.charAt(1)>'8'){
			System.out.println("Sorry, coordinates outside the grid try again!");
			i -=1; continue;
		}
		else if(coordinate.length() !=2){
			System.out.println("Invalid coordinate - try again!");
			i -=1; continue;
		}
		else if(board[row][col]=="s" || board[row][col]=="g"){
			System.out.println("Sorry, coordinates already used. try again!");
			i -=1;	continue;
		}
	
		
		board[row][col] ="s";
		
		
		}
	}
	
	public void userGrenade(){
		
		int row, col;
		
		for(int i =0; i<4; i++){
		System.out.println("Enter the coordinates of your grenade #"+(i+1)+": ");
		String coordinate = kb.next();
		
		row = (coordinate.charAt(0)-'A');
		col = (coordinate.charAt(1)-'1');
		
		//validity test
		if(coordinate.charAt(0)<'A'||coordinate.charAt(0)>'H'){
			System.out.println("Sorry, coordinates outside the grid try again!");
			i -=1; continue;
		}
		else if(coordinate.charAt(1)<'1'||coordinate.charAt(1)>'8'){
			System.out.println("Sorry, coordinates outside the grid try again!");
			i -=1; continue;
		}
		else if(coordinate.length() !=2){
			System.out.println("Invalid coordinate - try again!");
			i -=1; continue;
		}
		else if(board[row][col]=="s" || board[row][col]=="g"){
			System.out.println("Sorry, coordinates already used. try again!");
			i -=1;	continue;
		}
	
		
		board[row][col] ="g";
		
		
		}
	}
	
	public void userPosition (){
		userShip();
		userGrenade();
		System.out.println("user successfuly placed ships and grenades");
		breakln();
	}
	
	public void createRandomShip(){
		
		for(int i =0; i<6; i++){
		
		int row = (int)(Math.random()*board.length);
		int col = (int)(Math.random()*board[0].length);
		
		if(board[row][col]=="S"|| board[row][col]=="G"){
			i=i-1;
			continue;
		}
		else if(board[row][col]=="g"|| board[row][col]=="s"){
			i-=1;
			continue;
		}
		board[row][col] = "S";
		}
		
	}
	

	
	
	public void createRandomGrenade(){
		
		for(int i =0; i<4; i++){
			
			int row = (int)(Math.random()*board.length);
			int col = (int)(Math.random()*board[0].length);
			
			if(board[row][col] =="G" || board[row][col]== "S"){
				i= i-1;
				continue;
			}
			else if(board[row][col]=="g"|| board[row][col]=="s"){
				i-=1;
				continue;
			}
			else
			board[row][col] = "G";
			}
	}
	
	public void computerPosition(){
		createRandomShip();
		createRandomGrenade();
		System.out.println("OK, the computer placed its ships and grenades at random. Let's play.");
		
	}
	
	
	
	public void computerFire(Battleship a, Battleship b){
		
		int row,col;
		char alphabet;
		
		
			
			System.out.println("position of computer rocket: ");
			
			row = (int)(Math.random()*8);
			col = (int)(Math.random()*8);
			
			alphabet = (char)('A'+row);
			System.out.print(alphabet);
			System.out.println(col+1);
			
			if(b.board[row][col]=="s"||b.board[row][col]=="S"||b.board[row][col]=="g"||b.board[row][col]=="G"){
				System.out.println("ALREADY HIT THIS COORDINATE: NOTHING HAPPENS");
				breakln();
			}
			else{
			
				if(a.board[row][col]=="s"){
					System.out.println("human ship hit.");
					b.board[row][col]="s";
					
					
					nbOfShip++;
					
					b.showBoard();
					
				}
				else if(a.board[row][col]=="S"){
					System.out.println("Computer hits its own ship");
					b.board[row][col]="S";
					
					
					computerShip++;
					
					b.showBoard();
				}
				else if(a.board[row][col]=="-"){
					System.out.println("nothing.");
					b.board[row][col]="*";
					b.showBoard();
				}
				else if(a.board[row][col]=="g"||a.board[row][col]=="G"){
					System.out.println("BOOM! grenade.");
					b.board[row][col]="g";
					skipComputerTurn =true;
					computerMiss++;
					b.showBoard();
				}
				else{
				System.out.println("your code is wrong");
				}
			//b is display board, a is info board.
			}
			
		
	}
	
	
	
	public void userFire(Battleship a,Battleship b){
		int row,col;
		String rocket;
		
		
			
		System.out.println("position of human rocket: ");
		rocket = kb.next();
		
		col = (rocket.charAt(1)-'1');// to derive the 'pure' integer out of Ascii
		row = (rocket.charAt(0)-'A');
		
		for(int i =0; i<1; i++){
			
		
		if(rocket.charAt(0)<'A'||rocket.charAt(0)>'H'){
			System.out.println("Sorry, coordinates outside the grid try again!");
			i-=1; continue;
		}
		else if(rocket.charAt(1)<'1'||rocket.charAt(1)>'8'){
			System.out.println("Sorry, coordinates outside the grid try again!");
			i-=1; continue;
		}
		else if(rocket.length() !=2){
			System.out.println("Invalid coordinate - try again!");
			i-=1; continue;
		}
		}
		//PLAY
		if(b.board[row][col]=="s"||b.board[row][col]=="S"||b.board[row][col]=="g"||b.board[row][col]=="G"){
			System.out.println("ALREADY HIT THIS COORDINATE: NOTHING HAPPENS");
			breakln();
		}
		else{
			if(a.board[row][col]=="S"){
				System.out.println("computer ship hit.");
				b.board[row][col]="S";
				
				
				computerShip++;
				
				b.showBoard();
			}
			else if(a.board[row][col]=="s"){
				System.out.println("human hits his own ship");
				b.board[row][col]="s";
				
				
				nbOfShip++;
				
				b.showBoard();
			}
			
			else if(a.board[row][col]=="-"){
				System.out.println("nothing.");
				b.board[row][col]="*";
				b.showBoard();
			}
			else if(a.board[row][col]=="G"||a.board[row][col]=="g"){
				System.out.println("BOOM! grenade.");
				b.board[row][col]="G";
				skipHumanTurn =true;
				userMiss++;
				b.showBoard();
				
			}
			else{
			System.out.println("your code is wrong");
			System.out.println(a.board[row][col]);
			b.showBoard();
			}
		//b is display board, a is info board.
		
		}

//		System.out.println("the game is over: human won!");
	}
	
	
	public boolean isDone(){
		
		return(nbOfShip!=6);
		
	}
	

	
	

	
	
	
}


