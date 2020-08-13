package assignment;

import java.util.Scanner;
/*
 * Byoungwoo Kang(27744544)
 * Comp249 
 * assignment #1
 * due date: Feb,1 2017
 */



public class BattleshipDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Hi, let's play battleship!");
		Battleship.breakln();
		
		
		Battleship b1 = new Battleship();// info board
		Battleship b2 = new Battleship();//display board
		
		
		b1.createBoard();
		
		//user input
		b1.userPosition();
		
		//computer random input
		b1.computerPosition();
		
		
		// set board changes both. meaning b1 = b2. I want to separate them. 
		b2.createBoard();
//		b2.showBoard();
		
		while(Battleship.nbOfShip!=6 && Battleship.computerShip!=6){
			
			if(!b2.skipHumanTurn){
				b2.userFire(b1, b2);
		
			}
			else{
				b2.skipHumanTurn=false;
			}
			
			if(!b2.skipComputerTurn){
				b2.computerFire(b1, b2);
				
			}
			else{
				b2.skipComputerTurn=false;
			}
		}
		
		
		//declaring who's the winner
		
		if(Battleship.computerShip==6){
			System.out.println("Human won, \n"
					+ "despite the missed time due to hitting grenade is: "+b2.userMiss);
			System.out.println();
			System.out.println("The ships and grenades were initially planted as: ");
			b1.showBoard();
		}
		else if(Battleship.nbOfShip==6){
			System.out.println("Computer won, \n"
					+ "despite the missed time due to hitting grenade is: " +b2.computerMiss);
			System.out.println();
			System.out.println("The ships and grenades were initially planted as: ");
			b1.showBoard();
		}
		
//		while(b1.getnbOfShip()!=6||b1.getcomputerShip()!=6){
//			if((Battleship.turn)%2==1){ //turn is odd
//				b2.userFire(b1, b2);
//				Battleship.turn++;
//			}
//			else
//				b2.computerFire(b1, b2);
//				Battleship.turn++;
//		}
		

		
	}

}
