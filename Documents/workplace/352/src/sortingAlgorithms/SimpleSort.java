package sortingAlgorithms;

public class SimpleSort {
	
	
	public static void bubble(int[]a){//O(n^2)
		//two loops -> each element needs to be compared with all thus n^2
		//this algorithm guarantees rightmost number to be sorted for each bubble
		for(int i =0; i<a.length-1;i++){ //n-1 time because n-1 comparison needed
			for(int j =0; j<a.length-1;j++){
				if(a[j]>a[j+1]){
					int temp = a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
		}
		
	}
	
	
	public static void insertion(int[]a){//in-place , O(n^2), hole position
		//insert next number to sorted section. 
		
		int temp;
		for(int i =1; i< a.length;i++){//i is 1 because first element is alws sorted
			for(int j=i-1;j>0;j--){//notice j decrements
				if(a[j]<a[j-1]){ //index j is the focused element being compared with previous one.
					temp= a[j];//j runs inner loop. so use j as an index. 
					a[j]=a[j-1];
					a[j-1]=temp;
				}
			}
		}
		
	}
	
	
	public static void selection(int[]a){ //inplace 
		int temp;
		int minIndex;
		int min;
		
		for(int i=0; i<a.length;i++){
			min = a[i];
			minIndex =i;
			for(int j = i; j<a.length;j++){//minimum value selection occurs here
				if(min>a[j]){
					min=a[j];
					minIndex=j;
				}
			}
			//i's comparison with the rest is done: swap!
			temp=a[i];
			a[i]=a[minIndex];
			a[minIndex]=temp;
		}
		
	}
	
	public static void shell(int[]a){
		//calculating interval  = g
		//p1->n/2
		//p2->p1/2 and so on..
		//compare two element each 
		//when g=1. and swap occurs, it compares all the way to the beginning.
	
		
	}
	
		

	  
	  public static void display(int[]a){
		  for(int i =0; i<a.length;i++){
				System.out.print(a[i]+" ");
			}
	  }
	
	public static void heapsort(int[]a){
		//nlogn
		//not stable
		//inplace!
	}
	
	
	
	
	public static void sifting(int[]a){
		
	}
	

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime = System.nanoTime();
		int [] arb = {14,10,15};
		
		int[] inputArr = {45,45,23,11,89,77,98,4,28,65,43};
//		bubble(inputArr);
//		insertion(inputArr);
//		selection(inputArr);
		
		long endTime = System.nanoTime();
		
		
		
		System.out.println("time took: "+(endTime-startTime));

		display(inputArr);

	}

}
