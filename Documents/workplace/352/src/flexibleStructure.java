
public class flexibleStructure  {
	
	/*
	* 
	* 1.c) 
	* The two Huffman and AVL trees have not many similarities other than the nodes for both trees have the key  to determine its position 
	* and Node{} the inner class has two Node pointers.
	* I've deliberately made many ctors with every possible scenarios because the core attributes for building the Huffman and AVL are different.
	* In doing this, this class guarantees the flexibility for both trees. 
	* 
	* 1.e)Huffman Tree class will extend its branches based on the flexibleStructure{} entity. 
	* 	Since Huffman Tree's node must contain both character and integer(key), it will be easily handled 
	* 	with an array of objects, especially for the sorting purpose.
	* 	A frequency of a letter AND the ASCII value of the corresponding letter will be stored into an array.
	* 	As a sorting algorithm, I chose mergesort because it is stable algorithm and time complexity is fairly efficient compared to others.
	* 	When the first sorting is done, the first 2 element of the huffman array will be the lowest.
	* 	then the two elements will be added, hence creating an internal node(one with only integer attribute), and 
	* 	it will be sorted again until the array length becomes 1: the tree root. 
	*	
	* 1.g)AVL is a self-adjusting binary search tree, and specifically the 'adjusting' occurs in two
	* 	core methods, which are add() and remove(). Hence I will separate this 'adjusting' function from the two methods and call it
	* 	AVLizing(). For AVL, each nodes only need to contain integer value(key), I could use recursive method to build the tree(add,remove). 
	* 
	* 1.h) when the data has no duplicate values and has only key values to contain, like "Opertaions.txt", it is time effective to use
	* 		AVL tree structure because it will force the tree to be balanced and the worst time complexity will be O(logn). 
	* 	on the other hand, Splay is specialized tree that can find the latest node quicly. I found it less useful than AVL in this data base. 
	* 
	* difference: for HuffmanTree, all the data needs to be read in full. 
	* for AVL it can be added individually ALSO the order of the value doesn't need to be considered.
	* 
	*/
	
	
	//Starting point -> root;
	//can't make it static
	 Node root;
	
	public flexibleStructure(){
		
	}
	
	//the most important ctor to build a tree
	public flexibleStructure(flexibleStructure fs1, flexibleStructure fs2){
		//huffman strictly b/c of the last line. 
		root = new Node();
		root.leftChild = fs1.root;
		root.rightChild=fs2.root;
		
		//to get the weight of the combined node -> hence internal
		root.key = fs1.root.key + fs2.root.key;
	}
	
	public flexibleStructure(flexibleStructure fs1){
		root= new Node();
		root.leftChild=fs1.root; //actually a linkedList
		root.rightChild=null;
		
		root.key=fs1.root.key;
		
	}
	
	public flexibleStructure(int w, char c){
		root = new Node(w,c);
	}
	
	public flexibleStructure(char c){
		root = new Node(c);
	}

	
	public flexibleStructure(int key){
		root = new Node(key);
	}
	
	
	//i don't need this
//	public Node get(int asciiNum, Node present){
//		if(present !=null){
//			if(present.character.equals(present.character))
//				return present;
//			else{
//				Node foundNode = get(asciiNum, present.leftChild);
//				if(foundNode==null){
//					foundNode= get(asciiNum, present.rightChild);
//				}
//				return foundNode;
//			}
//		}else
//			return null;
//		
//	}
	
	
//	//for avl soely
//	public int compareTo(flexibleStructure fs){
//		
//		if(root.key < fs.root.key)
//			return 1;
//		else if (root.key == fs.root.key)
//			return 0;
//		else 
//			return -1;
//	}
	
	
	
	public static void inOrderTraversal(Node root) {
		if (root != null) {
			inOrderTraversal(root.leftChild);
			System.out.println("root: "+ root);
			inOrderTraversal(root.rightChild);
		}
	}
	public static void preOrderTraversal(Node r){
		if(r!=null){
			System.out.println(r);
			preOrderTraversal(r.leftChild);
			preOrderTraversal(r.rightChild);
		}
	}
	
	public static void postOrderTraversal(Node r){
		if(r!=null){
			postOrderTraversal(r.leftChild);
			postOrderTraversal(r.rightChild);
			System.out.println(r);
		}
	}
	
	
//	public static void displayLinkedList(Node root){
//		if(root!=null){
//			System.out.println("root: "+ root);
//			displayLinkedList(root.leftChild);
//		}
//	}

	
	public static class Node{//A Node contains all the data. if leaf, two node pointers to null.
		int key;
		Character character=null;//if character is null its internal node
		
		Node leftChild;
		Node rightChild;
		
		String addressToChar = "";//for huffmanTree
		
		public Node(){
			
		}
		
		//regular node with two mandatory parameters
		public Node(int k, char v){
			key=k;
			character=v;
		}
		
		public Node(int k){
			key=k;
			character=null;
		}
		
		
		
		public String toString(){
			return "weight is "+ key+ " the chracter is "
					+ character;
		}
	
	}
	
	

}
