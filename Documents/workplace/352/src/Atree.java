import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class Atree extends flexibleStructure {
	
	//this only for statistics purposes. Node do not need to contain this infos.
	private static int totalNumComparison=0;
	private static int totalNumParentChange=-1;
	private static int totalNumFindOp=0;
	private static int totalNumAddOp=0;
	private static int totalNumRemoveOp=0;
	
	
	public Atree(){// default ctor
		
	}
	public Atree(Atree l, Atree r){//most important to create avlTree
		super(l, r);
	}
	public Atree(int k, char c){
		super(k, c);
	}
	
	//needs to be combined with all the method. This will be a headquarter method
	public void invokeOrders(Atree a,String fileName){
		Scanner sc= null;
		
		String oneLine;
		String number;
		int value;
		
		try{
			sc = new Scanner(new FileInputStream(fileName));
		}
		catch(FileNotFoundException e){
			System.out.println("File hasn't been found. System terminates.");
			System.exit(0);
		}
		
		while(sc.hasNextLine()){
			oneLine= sc.nextLine();
			number = oneLine.substring(1);
			value= Integer.parseInt(number);
			
			switch(oneLine.charAt(0)){
			case 'r': //remove;
				a.remove(value);
				break;
			case 'f': //find;
				a.find(value);
				break;
			case 'a': //add;
				a.add(value);
				totalNumAddOp++;
				break;
			}
			
			//will divide the order here!
		}
		
		sc.close();
	}
	
	
	
	public static Node rotateRight(Node root){
		Node newRoot= root.leftChild;
		Node t2=newRoot.rightChild;
		
		if(t2!=null){
			totalNumParentChange++;
		}
		newRoot.rightChild=root;
		root.leftChild=t2;
		
		totalNumParentChange+=2;
		return newRoot;
	}

	public static Node rotateLeft(Node root){
		Node newRoot= root.rightChild;
		Node t2 = newRoot.leftChild;
		
		if(t2!=null){
			totalNumParentChange++;
		}
		newRoot.leftChild=root;
		root.rightChild=t2;
		
		totalNumParentChange+=2;
		return newRoot;
	}
	
	//calling add function
	public void add(int key){
		totalNumParentChange++;
		root= add(root, key);
	}
	
	public static Node add(Node root, int key){
		// regular insert recursion
		if(root == null){
			return new Node(key);
		}
		if(key<root.key){
			totalNumComparison++;
			root.leftChild = add(root.leftChild, key);
		}
		else if(key>root.key){
			root.rightChild = add(root.rightChild,key);
			totalNumComparison++;
		}
		else{
			//duplicate key violates BST property. Do nothing
			totalNumComparison++;

		}
		
		
		root=AVLizing(root);
		return root;
	}
	
	public void find(int key){
		find(root, key);
	}
	
	public static boolean find (Node root, int key){
		if(root ==null){
			return false;
		}
		else if(key<root.key){
			totalNumComparison++;
			return find(root.leftChild, key);
		}
		else if(key>root.key){
			totalNumComparison++;
			return find(root.rightChild, key);
		}
		else{
			totalNumFindOp++;
			totalNumComparison++;
			return true;
		}
	}
	
	//this is correct. 
	public static int getHeight(Node n){
		if(n==null)
			return -1;
		else{
			return Math.max(getHeight(n.leftChild), getHeight(n.rightChild))+1;
		}
	}
	
	
	public void remove(int key){
		root = remove(root, key);
	}
	
	
	//this  method is credited to Youtube Channel: mycodeschool. 
	public static Node remove(Node root, int key){
		// regular delete
				if(root==null){
					return root;
				}
				if(key<root.key){
					totalNumComparison++;
					root.leftChild = remove(root.leftChild, key);
				}else if(key>root.key){
					totalNumComparison++;
					root.rightChild=remove(root.rightChild,key);
				} 
				else {
					totalNumRemoveOp++;
					totalNumComparison++;
					//case1:
					
					if(root.leftChild==null&& root.rightChild==null){
						totalNumParentChange++;
						root = null;
						
					}
					else if(root.leftChild ==null){
						Node temp =root;
						root = root.rightChild;
						temp=null;
						totalNumParentChange+=2;

						
					}
					else if(root.rightChild==null){
						Node temp = root;
						root = root.leftChild;
						temp = null;
						totalNumParentChange+=2;

					}
					else {
						Node temp = FindMin(root.rightChild);
						root.key = temp.key;
						root.rightChild=remove(root.rightChild, temp.key);
						totalNumParentChange+=3;

					}
				}

				
				root=AVLizing(root);
				return root;
	}
	
	//this only works when the difference of the balance does not exceed |2|= b/c avl property
	//avlizing does not require any comparisons. 
	public static Node AVLizing(Node root){

			//now, if balance exceeds |1|, adjust part
			int balance = 0;
			if(root!=null){//this is the special case took me 2hrs to debug. 
			balance=getHeight(root.leftChild)-getHeight(root.rightChild);
			}
			if(balance>1){
				if(getHeight(root.leftChild.leftChild)>=getHeight(root.leftChild.rightChild)){
					return rotateRight(root);// LL case
				}
				else{
					root.leftChild = rotateLeft(root.leftChild);
					return rotateRight(root); //LR case
				}
			}
			if(balance<-1){
				if(getHeight(root.rightChild.rightChild)>=getHeight(root.rightChild.leftChild)){
					return rotateLeft(root);//RR case
				}
				else{
					root.rightChild=rotateRight(root.rightChild);
					return rotateLeft(root);//RL case
				}
			}
			return root;
		}
		
	public static Node FindMin(Node root){
		Node current = root;
		while(current.leftChild!=null){
			current=current.leftChild;
		}
		return current;
	}
	
//	public static Node FindMax(Node root){
//		while(root.rightChild!=null){
//			root = root.rightChild;
//		}
//		return root;
//	}
	


	
	public static void main(String[] args) {
		String fileName = "Operations.txt"; //args[0];
		
		Atree a1 = new Atree();
		a1.invokeOrders(a1, fileName);

		
		System.out.println("---------------statistics---------------");
		System.out.println("The total number of comparisons: "+ totalNumComparison+
				"\nThe total number of times a Node's parent changes: "+totalNumParentChange +
				"\nThe total number of find operations: "+ totalNumFindOp+
				"\nThe total number of add operations: "+ totalNumAddOp+
				"\nThe total number of remove operations: "+ totalNumRemoveOp);
		
		
		
		
		
		
	}

}
