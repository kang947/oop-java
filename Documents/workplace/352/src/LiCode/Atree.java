package LiCode;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class Atree extends flexible {

	public static int comparisionNumber = 0;
	public static int nodeParentChange = 0;
	public static int findOperation = 0;
	public static int addOperation = 0;
	public static int removeOperation = 0;

	// connect with the main
	public void insert(int value) {
		this.root = insert(this.root, value);
	}

	public Node insert(Node node, int key) {
		// 1. binary search tree insert
		if (node == null)
			return (new Node(key));
		if (key < node.weight) {
			comparisionNumber++;
			node.leftchild = insert(node.leftchild, key);
		} else if (key > node.weight) {
			comparisionNumber++;
			node.rightchild = insert(node.rightchild, key);
		} else {// same number is not allowed
			comparisionNumber++;
			System.out.println("You can't insert the same number ");
			return node;
		}

		// 2. update height of each node, because we use recursion
		node.height = findHeight(node);

		// 3. check the node is balanced or not
		int balance = getBalance(node);

		// If this node becomes unbalanced, then there are 4 cases 
		// LL Case
		if (balance > 1 && key < node.leftchild.weight){
			comparisionNumber++;
			nodeParentChange++;
			return rightRotate(node);}

		// RR Case
		if (balance < -1 && key > node.rightchild.weight){
			comparisionNumber++;
			nodeParentChange++;
			return leftRotate(node);}

		// LR Case
		if (balance > 1 && key > node.leftchild.weight) {
			comparisionNumber++;
			nodeParentChange++;
			node.leftchild = leftRotate(node.leftchild);
			return rightRotate(node);
		}

		// RL Case
		if (balance < -1 && key < node.rightchild.weight) {
			comparisionNumber++;
			nodeParentChange++;
			node.rightchild = rightRotate(node.rightchild);
			return leftRotate(node);
		}

		//return the unchanged node pointer
		return node;
	}

	// while loop for insert
	public void addnode(int key) {

		if (root == null) {

			root = new Node(key);
		}

		else {

			Node temp = root;
			Node parent;
			while (true) {
				parent = temp;
				if (key < temp.weight) {
					temp = temp.leftchild;
					if (temp == null) {

						parent.leftchild = new Node(key);
						return;
					}
				}

				else if (key > temp.weight) {
					temp = temp.rightchild;
					if (temp == null) {

						parent.rightchild = new Node(key);
						return;
					}

				}

				else {

					System.out.println("It's the same number");

					return;
				}

			}

		}

	}

	public void deleteNode(int key) {
		System.out.println("Start to delete node!!!");
		this.root = deleteNode(this.root, key);
	}

	// find a successor
	public Node minValueNode(Node node) {

		Node current = node;

		/* loop down to find the leftmost leaf */
		while (current.leftchild != null)
			current = current.leftchild;

		return current;
	}

	public Node deleteNode(Node root, int key) {
		// STEP 1: PERFORM STANDARD BST DELETE
		if (root == null)
			return root;

		// If the key to be deleted is smaller than
		// the root's key, then it lies in left subtree
		if (key < root.weight)
			root.leftchild = deleteNode(root.leftchild, key);

		// If the key to be deleted is greater than the
		// root's key, then it lies in right subtree
		else if (key > root.weight)
			root.rightchild = deleteNode(root.rightchild, key);

		// if key is same as root's key, then this is the node
		// to be deleted
		else {

			// node with only one child or no child
			if ((root.leftchild == null) || (root.rightchild == null)) {
				Node temp = null;
				if (temp == root.leftchild)
					temp = root.rightchild;
				else
					temp = root.leftchild;

				// No child case
				if (temp == null) {
					temp = root;
					root = null;
				} else // One child case
					root = temp; // Copy the contents of
									// the non-empty child
			} else {

				// node with two children: Get the inorder
				// successor (smallest in the right subtree)
				Node temp = minValueNode(root.rightchild);

				// Copy the inorder successor's data to this node
				root.weight = temp.weight;

				// Delete the inorder successor
				root.rightchild = deleteNode(root.rightchild, temp.weight);
			}
		}

		// If the tree had only one node then return
		if (root == null)
			return root;

		// STEP 2: UPDATE HEIGHT OF THE CURRENT NODE
		root.height = getHeight(root);

		// STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether
		// this node became unbalanced)
		int balance = getBalance(root);

		// If this node becomes unbalanced, then there are 4 cases
		// Left Left Case
		if (balance > 1 && getBalance(root.leftchild) >= 0)
			return rightRotate(root);

		// Left Right Case
		if (balance > 1 && getBalance(root.leftchild) < 0) {
			root.leftchild = leftRotate(root.leftchild);
			return rightRotate(root);
		}

		// Right Right Case
		if (balance < -1 && getBalance(root.rightchild) <= 0)
			return leftRotate(root);

		// Right Left Case
		if (balance < -1 && getBalance(root.rightchild) > 0) {
			root.rightchild = rightRotate(root.rightchild);
			return leftRotate(root);
		}

		return root;
	}

	public void deletenode(int key) {

		if (BTsearch(key) == true) {

			Node temp = root;
			Node parent;
			while (true) {
				parent = temp;
				if (key < temp.weight) {
					temp = temp.leftchild;
					System.out.println("go left child");
				}

				else if (key > temp.weight) {
					temp = temp.rightchild;
					System.out.println("go right child");
				}

				if (key == temp.weight) {

					System.out.println("Find the node, let's start to delete");

					if (temp.leftchild == null && temp.rightchild == null) {

						if (temp == root) {
							System.out.println("The node is the root and doesn't have children");
							root = null;
							return;
						}

						else if (parent.leftchild == temp) {

							System.out.println("The node doesn't have children,replace parent left child");
							parent.leftchild = null;
							return;

						} else if (parent.rightchild == temp) {
							System.out.println("The node doesn't have children,replace parent right child");
							parent.rightchild = null;
							return;

						} else {
							System.out.println("something wrong in tree");
							return;
						}
					}

					else if (temp.leftchild == null && temp.rightchild != null) {

						if (temp == root) {
							System.out.println("The node is the root and have right children");
							root = root.rightchild;
							return;
						}

						if (parent.leftchild == temp) {

							System.out.println("The node only have right children,replace parent left child");
							parent.leftchild = temp.rightchild;
							return;

						} else if (parent.rightchild == temp) {
							System.out.println("The node only have right children,replace parent right child");
							parent.rightchild = temp.rightchild;
							return;

						}

					}

					else if (temp.rightchild == null && temp.leftchild != null) {

						if (temp == root) {
							System.out.println("The node is the root and have left children");
							root = root.leftchild;
							return;
						}

						if (parent.leftchild == temp) {

							System.out.println("The node only have left children,replace parent left child");
							parent.leftchild = temp.leftchild;
							return;

						} else if (parent.rightchild == temp) {
							System.out.println("The node only have left children,replace parent right child");
							parent.rightchild = temp.leftchild;
							return;

						}

					}
					// find a successor
					else {
						if (temp == root) {
							System.out.println("The node is the root and has two children");
							Node successor = findSuccessor(temp);
							int tempWeight = successor.weight;
							deletenode(successor.weight);
							temp.weight = tempWeight;
							System.out.println("The key is " + temp.weight);
							return;
						}

						if (parent.leftchild == temp) {

							System.out.println("The node has two children,replace parent left child");
							Node successor = findSuccessor(temp);
							int tempWeight = successor.weight;
							deletenode(successor.weight);
							temp.weight = tempWeight;
							System.out.println("The key is " + temp.weight);
							return;

						} else if (parent.rightchild == temp) {
							System.out.println("The node has two children,replace parent right child");
							Node successor = findSuccessor(temp);
							int tempWeight = successor.weight;
							deletenode(successor.weight);
							temp.weight = tempWeight;
							System.out.println("The key is " + temp.weight);
							return;

						}
					}
				}

			}
		}

	}

	private int max(int a, int b) {
		return a > b ? a : b;
	}
   
	
	// for right rotation
	public Node rightRotate(Node y) {
		Node x = y.leftchild;
		Node T2 = x.rightchild;

		// Perform rotation
		x.rightchild = y;
		y.leftchild = T2;

		// Update heights
		y.height = findHeight(x);
		x.height = findHeight(y);

		// Return new root
		return x;
	}

	// A utility function to left rotate subtree rooted with x
	public Node leftRotate(Node x) {
		Node y = x.rightchild;
		Node T2 = y.leftchild;

		// Perform rotation
		y.leftchild = x;
		x.rightchild = T2;

		// Update heights
		x.height = findHeight(x);
		y.height = findHeight(y);

		// Return new root
		return y;
	}

	// For while loop delete, hard to implement balance. So not use!!!
	public Node findSuccessor(Node delNode) {

		Node successor = delNode;
		Node current = delNode.rightchild; // go to right child
		while (current != null) // until no more
		{
			successor = current;
			current = current.leftchild; // go to left child
		}
		return successor;
	}

	/* Height for each node, use for balance */
	public int findHeight(Node node) {
		if (node == null) {
			return -1;
		} else {
			return (Math.max(findHeight(node.leftchild), findHeight(node.rightchild)) + 1);
		}
	}

	public int getBalance(Node node) {
		if (node == null)
			return 0;
		return findHeight(node.leftchild) - findHeight(node.rightchild);
	}

	public void updateHight(Node root) {
		Node temp = root;

		if (temp == null) {
			System.out.println("No more node");
			return;
		} else if (temp.leftchild == null && temp.rightchild == null) {
			System.out.println("only one node");
			temp.height = 0;
			return;
		} else if (temp.leftchild == null) {
			System.out.println("have right node");
			temp.height = findHeight(temp);
			updateHight(temp.rightchild);

		} else if (temp.rightchild == null) {
			System.out.println("have left node");
			temp.height = findHeight(temp);
			updateHight(temp.leftchild);
		} else {
			System.out.println("have two nodes");
			temp.height = findHeight(temp);
			System.out.println(temp);
			System.out.println("height is " + temp.height);
			updateHight(temp.leftchild);
			updateHight(temp.rightchild);
		}

	}

	public void changeUnbalanceNode(Node root) {

		Node temp = root;
		if (root == null) {
			System.out.println("Root is empty");
			return;
		} else {
			changeUnbalanceNode(root.leftchild);
			changeUnbalanceNode(root.rightchild);
			// Left Left case
			if (getBalance(temp) > 1 && getBalance(temp.leftchild) >= 0) {
				System.out.println("Left Left case");
				rightRotate(temp);
			}

			// Right Right Case
			else if (getBalance(temp) < -1 && getBalance(temp.rightchild) <= 0) {
				System.out.println("right right case");
				System.out.println("before right rotate " + temp);
				Node a = leftRotate(temp);
				System.out.println("after left rotate " + a);
			}

			// Left Right Case
			else if (getBalance(temp) > 1 && getBalance(temp.leftchild) < 0) {
				System.out.println("left right case");
				temp.leftchild = leftRotate(temp.leftchild);
				rightRotate(temp);
			}

			// Right Left Case
			else if (getBalance(temp) < -1 && getBalance(temp.rightchild) > 0) {
				System.out.println("right left case");
				temp.rightchild = rightRotate(temp.rightchild);
				leftRotate(temp);
			} else {
				System.out.println("Nothing find!!");
				return;
			}
		}
	}

	public static String readFileToString(String fileName) {

		Scanner sc = null;
		String paragraph;

		try {

			sc = new Scanner(new FileInputStream(fileName));
		} catch (FileNotFoundException e) {

			System.out.println("File hasn't been found. System terminates.");
			System.exit(0);

		}

		paragraph = sc.nextLine();
		sc.close();
		return paragraph;

	}
	

	
	

	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		// String fileName = "aa.txt";
//
//		// TextData[] TD = new TextData[100];
//		// String paragraph = readFileToString(fileName);
//		// System.out.println("paragraph " + paragraph);
//		
//		
		BufferedReader br;
		Atree bt = new Atree();
		try {
			br = new BufferedReader(new FileReader("Operations.txt"));
			String instruction=null;
			try {
				instruction = br.readLine();
				while(instruction!=null){
					char operation = instruction.charAt(0);
					int operand = Integer.parseInt(instruction.substring(1));
					switch (operation) {
					case 'a':
						bt.insert(operand);
						break;
					case 'r':
						bt.deleteNode(operand);
						break;
					case 'f':
						bt.BTsearch(operand);
						break;

					default:
						break;
					}
					
					instruction = br.readLine();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		System.out.println("Code");
		bt.inOrderTraversal(bt.root);
//		bt.preOrderTraversal(bt.root);
		

		
//		bt.insert(75);
//		bt.insert(85);
//		bt.insert(95);
//		bt.insert(10);
//		bt.insert(27);
		// bt.changeUnbalanceNode(bt.root);
		// System.out.println("change unbalance node " + bt.root);

//		int a = bt.findHeight(bt.root);
//		bt.inOrderTraversal(bt.root);
//		System.out.println("The tree: " + bt.root);
//		System.out.println();
//		System.out.println("Root Hight is " + a);
//
//		// int balance = bt.getBalance(bt.root);
//		// System.out.println("Root balance is " + balance);
//		// System.out.println(bt.root);
//		bt.deleteNode(27);
//		bt.deleteNode(30);
//		bt.inOrderTraversal(bt.root);*/

	}

}
