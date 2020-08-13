package sortingAlgorithms;

public class Quicksort {
	
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		int [] arb = {14,10,15};
		
		int[] inputArr = {45,45,23,11,89,77,98,4,28,65,43};

		quicksort(inputArr, 0, 10);
		long endTime = System.nanoTime();
		
		System.out.println("time took: "+(endTime-startTime));

		display(inputArr);

	}
	
	//quick sort pack
		//O(n^2) the rest nlogn
		  public static int Partition(int[] a, int p, int r)//at least 3 elements needed
		     {
		         int x = a[r];

		         int i = p-1;//i initially -1;
		         int temp=0;

		         for(int j=p; j<r; j++) //n times
		         {
		             if(a[j]<=x)
		             {
		                 i++;
		                 temp = a[i];
		                 a[i] = a[j];
		                 a[j] = temp;
		             }
		         }

		         temp = a[i+1];
		         a[i+1] = a[r];
		         a[r] = temp;
		         return (i+1);
		     }
		
		
		  public static void quicksort(int[] a, int p, int r)
		    {
		        if(p<r)//basic condition
		        {
		            int q = Partition(a, p,r);
		            quicksort(a, p, q-1);
		            quicksort(a, q+1, r);
		        }
		        
		     }
		  
		  public static void display(int[]a){
			  for(int i =0; i<a.length;i++){
					System.out.print(a[i]+" ");
				}
		  }
}
