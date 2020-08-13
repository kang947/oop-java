package garbage;




public class LinkedList {
	 class Node{
			
		private int key;//key in huffman
		private char character;//char in huffman
		private Node next;
		
	
		//ctor
		public Node(){
		}
		
		public Node(int d, char d2,Node t){
			key=d;
			character=d2;
			next=t;
		}
		public Node(int d){
			key=d;
			character='q';
			
		}

		public int getValue() {
			return key;
		}

		public void setValue(int value) {
			this.key = value;
		}
		
		public char getValue2(){
			return character;
		}
		
		public void setValue2(char value2){
			this.character=value2;
		}
		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
		
		
	}
	 
	
	private Node head;//the first pointer
	
	
	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

//	public void addAfter(int d, char d2){
//		if(head==null){
//			head= new Node(d,d2,head);
//		}
//		else{
//			Node t = head;
//			while(t.next!=null)
//		}
//	}
	
	public void addNode(int d, char d2){
		if(head==null){
//			Node n = new Node(d,head);//step 1&2, new node box with d stealing head-pointer.
										// 
			
//			head= n;//step3
//			n=null;//tieing up the loose end :)
			
			//code above is equivalent to
			head= new Node(d,d2,head);
		}
		else{//general case if node is 1 or more
			//temp node pointer
			Node t = head;
			while(t.next!=null){
				t=t.next;
			}
			t.next=new Node(d,d2, null);
				
		}
		
	}

	
	public int size(){
		Node t = head;
		int counter=0;
		if(head==null)
			return 0;
		while(t!=null)
		{
			t=t.next;
			counter++;
		}
		return counter;
	}
	
	public void display(){
		Node t = head;
		Node t2= head;
		
		while(t.next!=null){
			System.out.print(t.key+" -> ");
			t=t.next;
		}
		System.out.println(t.key);
		
		while(t2.next!=null){
			System.out.print(t2.character+" -> ");
			t2=t2.next;
		}
		System.out.println(t.character);

		
	}
	
	
	

	
}
