package binarySearchTree;

public class BinaryTree {
		
		Node root;
		
		
		
	public void addNode(int k, String n){
		
		Node newNode = new Node(k,n);
		
		if(root ==null){
			root = newNode;
		}
		else{
			Node temp = root;
			Node parent;
			while(true){
				parent=temp;
				if(newNode.key<temp.key){
					temp = temp.leftChild;
					if(temp==null){
						parent.leftChild= newNode;
						return;
					}
					
				}else{
					temp = temp.rightChild;
					if(temp==null){
						parent.rightChild= newNode;
						return;
					}
					
				}
			}
		}
	}
	
	public static void inOrderTraversal(Node r){
		//left to right 
		
		if(r!=null){
		inOrderTraversal(r.leftChild);
		System.out.println(r);
		inOrderTraversal(r.rightChild);
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
	
	class Node{
		
		int key;
		String name;
		
		Node leftChild;
		Node rightChild;
		
		public Node(int k, String n){
			this.key=k;
			this.name=n;
		}
		
		public String toString(){
			return "this key is: "+key+" and the name is: "+name;
		}
		
	}

	
	public static void main(String[]args){
		BinaryTree b1 = new BinaryTree();
		
		b1.addNode(25, "byoung");
		b1.addNode(30, "Li");
		b1.addNode(24, "vickel");
		b1.addNode(12, "yujung");
		
//		inOrderTraversal(b1.root);
		preOrderTraversal(b1.root);
	}
	
}
