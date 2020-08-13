package LiCode;

public class flexible implements Comparable<flexible> {
	Node root; // The root of the tree

	/** default constructor */
	public flexible() {
	}

	/** Create a tree containing an integer */
	public flexible(int weight) {
		root = new Node(weight);
	}

	/** Create a tree containing a leaf node */
	public flexible(int weight, char element) {
		root = new Node(weight, element);
	}

	/** Create a tree with two subtrees */
	public flexible(flexible t1, flexible t2) {
		root = new Node();
		root.leftchild = t1.root;
		root.rightchild = t2.root;
		root.weight = t1.root.weight + t2.root.weight;
	}

	public int getHeight(Node node) {

		if (node == null) {
			return -1;
		} else {

			return node.height;
		}
	}

	public int compareTo(flexible t) {
		if (root.weight < t.root.weight) // Purposely reverse the order
			return 1;
		else if (root.weight == t.root.weight)
			return 0;
		else
			return -1;
	}

	// search method
	public boolean BTsearch(int weight) {

		if (root == null) {
			System.out.println("This is a empty tree");
			return false;
		}

		else {
			Node temp = root;

			while (true) {

				if (weight > temp.weight) {

					temp = temp.rightchild;
					Atree.comparisionNumber++;

					if (temp == null) {
						Atree.comparisionNumber++;
						System.out.println("Not found in this tree");
						return false;
					}

				}

				else if (weight < temp.weight) {

					temp = temp.leftchild;
					Atree.comparisionNumber++;
					if (temp == null) {
						Atree.comparisionNumber++;
						System.out.println("Not found in this tree");
						return false;
					}
				} else {
					Atree.comparisionNumber++;
					System.out.println("It's in the tree");
					return true;
				}

			}

		}
	}

	public Node insert(Node t, int value) {
		if (t == null) {
			return new Node(value);
		}
		if (value < t.weight) {
			t.leftchild = insert(t.leftchild, value);
		} else if (value > t.weight) {
			t.rightchild = insert(t.rightchild, value);
		} else {
		}
		// update height
		t.height = Math.max(getHeight(t.leftchild), getHeight(t.rightchild)) + 1;
		return t;
	}

	public static class Node {
		char element; // Stores the character for a leaf node
		int weight; // weight of the subtree rooted at this node
		int height; // height for AVL tree
		Node leftchild; // Reference to the left subtree
		Node rightchild; // Reference to the right subtree
		String code = ""; // The code of this node from the root

		/** Create an empty node */
		public Node() {
		}

		public Node(int weight) {
			this.weight = weight;
			this.element = 0;
		}

		public Node(int weight, int height) {
			this.weight = weight;
			this.height = height;
			this.element = 0;
		}

		/** Create a node with the specified weight and character */
		public Node(int weight, char element) {
			this.weight = weight;
			this.element = element;
		}

		public String toString() {

			/**
			 * return (element + " has frequency: " + weight + ". Left child is
			 * " + leftchild + ". Right child is " + rightchild + " Height: " +
			 * height);
			 */

			return (" " + weight);
		}

	}

	public void inOrderTraversal(Node root) {
		if (root != null) {
			inOrderTraversal(root.leftchild);
			System.out.print(root + " ");
			inOrderTraversal(root.rightchild);
		}
	}

	public void preOrderTraversal(Node root) {
		if (root != null) {
			System.out.println(root + " ");
			preOrderTraversal(root.leftchild);
			preOrderTraversal(root.rightchild);
		}
	}

	public void postOrderTraversal(Node root) {
		if (root != null) {
			inOrderTraversal(root.leftchild);
			inOrderTraversal(root.rightchild);
			System.out.println(root);
		}
	}

}
