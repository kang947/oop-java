package avlTree;


public class AVLTree {
	
	Node root;
	


public int getHeight(Node n){
	if(n==null)
		return -1;
	else{
		return Math.max(getHeight(n.leftChild), getHeight(n.rightChild))+1;
	}
}

public Node rotateRight(Node root){
	Node newRoot= root.leftChild;
	root.leftChild=newRoot.rightChild;
	newRoot.rightChild=root;
	return newRoot;
}

public Node rotateLeft(Node root){
	Node newRoot= root.rightChild;
	root.rightChild=newRoot.leftChild;
	newRoot.leftChild=root;
	return newRoot;
}

public void avlInsert(int key, String name){
	
	this.root=avlInsert(this.root,key,name);
}

	
public Node avlInsert(Node root, int key, String name){
	//regular insert recursive
	//this can produce balance exceeds |1|. 
	if(root ==null){
		root= new Node(key, name);
		return root;
		}
	if(key<= root.key){
		
		root.leftChild = avlInsert(root.leftChild, key, name);
		}
	else
		root.rightChild = avlInsert(root.rightChild,key, name);
	
	//now, if balance exceeds |1|, adjusting part
	int balance = getHeight(root.leftChild)-getHeight(root.rightChild);
	
	if(balance>1){//left height is deeper
		if(getHeight(root.leftChild.leftChild)>=getHeight(root.leftChild.rightChild))
			return rotateRight(root);//LL case
		else{
			root.leftChild = rotateLeft(root.leftChild);
			return rotateRight(root);//LR case
		}
		}
	if(balance<-1){
		if(getHeight(root.rightChild.rightChild)>=getHeight(root.rightChild.leftChild))
			return rotateLeft(root);//RR case
		else{
			root.rightChild= rotateRight(root.rightChild);
			return rotateLeft(root);//RL case
		}
	}
	return root;
		
}

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
		return "(key: "+key +" L: "+ leftChild +" R: "+rightChild+")";
		
	}
	
}

public static void main(String []args){
	AVLTree a1 = new AVLTree();
//	AVLTree a2 = new AVLTree();
	a1.avlInsert(19, "asdf");
	a1.avlInsert(15, "yeah");
	a1.avlInsert(25, "yes");
	a1.avlInsert(10, "alright");
	a1.avlInsert(5, "okdoki");
	
//	a1.addNode(10, "hi");
	
	inOrderTraversal(a1.root);
	
	
}


}
