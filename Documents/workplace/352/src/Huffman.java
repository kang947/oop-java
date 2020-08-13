
import java.util.*;
import java.io.*;

public class Huffman extends flexibleStructure {
	
	private static int sizeChar=0;
	
	public Huffman(){
		
	}
	
	public Huffman(Huffman l, Huffman r){
		super(l,r);
	}
	
	public Huffman(Huffman l){
		super(l);
	}
	
	public Huffman(int key, char character){
		// normal node with basic values
		super(key, character);
	}
	
	public Huffman(int key){
		super(key);
	}
	
	
	
	
	public static String readFileToString(String fileName){
		Scanner sc= null;
		
		String paragraph;
		
		try{
			sc = new Scanner(new FileInputStream(fileName));
		}
		catch(FileNotFoundException e){
			System.out.println("File hasn't been found. System terminates.");
			System.exit(0);
		}
		
		paragraph= sc.nextLine();
		sc.close();
		return paragraph;
		
	}
	
	//frequency recorded with many 0's
	public static int[] FreqTableWithManyZeros(String str){
		int [] allChar = new int[256];
		
		char []a = str.toCharArray();
		sizeChar = a.length;
		for(int i =0; i<a.length;i++){
			allChar[a[i]]++;
		}
		return allChar;
	}
	

	
	public static int[] FreqTableInOrder(String str, int size){
		int [] allChar = new int[size];
		char [] a = str.toCharArray();
		for(int i =0; i<a.length;i++){
			
			allChar[i]=a[i];
		}
		return allChar;
	}
	
	
	public static Huffman[] getHuffmanArrToSort (int[] charWithFrequency){
		
		int size=0;
		for(int i =0; i<charWithFrequency.length;i++){
			if(charWithFrequency[i]>0)
				size++;
		}
		
		
		Huffman[] huffmanArrToSort = new Huffman[size];
		
		int increment=0;//instead of using inner loop
		
		//get rid of elements with zero keys
		for(int i =0; i< charWithFrequency.length; i++){
			if(charWithFrequency[i]>0)
				huffmanArrToSort[increment++]= new Huffman(charWithFrequency[i], (char)i);
		}
		
		//object array has been successfully created here!! 
		
		return huffmanArrToSort;
		
	}
	

	
	public String toString(){
		return super.root.key+"   "+super.root.character;
	}
	
		
	public static void display(Huffman[] huff){
		for(int i =0; i<huff.length;i++){
			System.out.println(huff[i]);
		}
	}
	
	public static Huffman buildTree(Huffman [] huff){
		Huffman tempNode = new Huffman();
		
		while(huff.length>1){
			
			//first two element always combined together because they will be sorted array
			Huffman first = huff[0];
			Huffman second = huff[1];
			
			Huffman [] temp = new Huffman[huff.length-1];//MUST TRY this. ELEMENT SHOULD decrease? no?
			Huffman innerNode = new Huffman(first,second);
			
			
			for(int i =1; i<temp.length; i++){
				temp[0]= innerNode;
				temp[i]= huff[i+1];
			}
			
			Mergesort.sortBegins(temp);
			huff=temp;
			tempNode = innerNode;
			
		}
		return tempNode;
		
	}
	
		
	public static String[] getCode(Node root){
		if(root ==null)
			return null;
		String [] codes = new String[256];
		assignCode(root, codes);
		return codes;
	}
	
	public static void assignCode(Node root, String[] codes){
		if(root.leftChild!=null){
			root.leftChild.addressToChar = root.addressToChar+"0";
			assignCode(root.leftChild, codes);
			
			root.rightChild.addressToChar = root.addressToChar +"1";
			assignCode(root.rightChild, codes);
		}
		else{
			codes[(int) root.character]= root.addressToChar;
		}
	}
	

	


	
	
	//insert search delete compress 
	public static void main(String[] args) {
		

		//assume this will be the same file name below
		
		String fileName = "Jabberwock.txt";//args[0];
		
		String paragraph = readFileToString(fileName);
		
		
		int[] freqTableWZ = FreqTableWithManyZeros(paragraph);
		

		
		//unsorted
		Huffman[] huffArr = getHuffmanArrToSort(freqTableWZ);
		
		
		//now its sorted. 
		huffArr = Mergesort.sortBegins(huffArr);
		
		// sorting success!  yes!!!!!!!! now huffArr is an sorted object array
		
		Huffman test = new Huffman();
		test= Huffman.buildTree(huffArr);
		
	
		
		String[] codes = getCode(test.root);
		for(int i =0; i<codes.length; i++){
			if(freqTableWZ[i]!=0)
				System.out.printf("%-15d%-15s%-15d%-15s\n", i, (char) i + "", freqTableWZ[i], codes[i]);
		}
		
		
		//////////////////////////////////////////////////////////////////
		
//		System.out.println();
//		System.out.println("Hence, the original paragraph in binary form is: ");
		System.out.println();
		
		int [] originalToPrint= FreqTableInOrder(paragraph,sizeChar);
//		
		//original txt to binary translation
//		for(int i =0; i<originalToPrint.length;i++){
//			System.out.print(codes[originalToPrint[i]]);
//		}
		System.out.println();
		
		////////////////////////////////////////////////////////////////////////////////////////////
		
		int ASCIIBits = 0;
		int HuffmanBits = 0;
		for (int i = 0; i < codes.length; i++) {
			if (freqTableWZ[i] != 0) { // (char)i is not in text if counts[i] is 0
				ASCIIBits = ASCIIBits + freqTableWZ[i];

			}

		}
		
		for (int i = 0; i < codes.length; i++) {
			if (freqTableWZ[i] != 0) { // (char)i is not in text if counts[i] is 0
				HuffmanBits = HuffmanBits + (freqTableWZ[i]*codes[i].length());

			}

			
		}

//		System.out.println("ASCII needs " + ASCIIBits * 8 + " bits");
//		System.out.println("HuffmanBits needs " + HuffmanBits + " bits");
		
		
		Scanner kb = new Scanner(System.in);
		
		System.out.println("Please enter a string that you want to translate into the huffman binary code: ");
		String translate= kb.nextLine();
		
		while(translate.length()>0){
			for(int i =0; i<translate.length(); i++){
				System.out.print(codes[translate.charAt(i)]);
			}
			System.out.println();
			translate= kb.nextLine();
		}
	
		
		
		
	}
	
}

