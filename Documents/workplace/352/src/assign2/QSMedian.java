package assign2;

public class QSMedian {

	

	public static void sort(int[] input){
		if(input==null|input.length==0){
			System.out.println("Array has no element. System exits.");
			System.exit(0);
		}
		int s = 0;
		int e = input.length-1;
		
		QuickSort(input,s,e);
	}
	
	public static void QuickSort(int[] input, int s, int e){
		if(s<e){
			int q=partition(input,s,e);
			QuickSort(input, s, q-1);
			QuickSort(input,q+1, e);
		}
	}
	
	public static int partition(int[] input, int s, int e){//stating index should be 0
		int temp;
	
		
	//median setup	
		int median = (s+e)/2;
		if(input[e]<input[s]){
			temp=input[e];
			input[e]=input[s];
			input[s]=temp;
		}
		if(input[median]<input[s]){
			temp=input[median];
			input[median]=input[s];
			input[s]=temp;
		}
		if(input[e]<input[median]){
			temp=input[e];
			input[e]=input[median];
			input[median]=temp;
		}
		
		//median that is located in the middle = pivot
		int x= input[(e-s)/2];
		
		
		int i = s-1; // i pointer, starts at -1
		
		for(int j =s; j<e; j++){//j starts from s index, other wise indexException
			if(input[j]<=x){
				i=i+1;
				temp = input[i];
				input[i]=input[j];
				input[j]= temp;
			}
		}
		temp= input[i+1];
		input[i+1]=input[e];
		input[e]=temp;
		return (i+1);
		
	}
	
	  public static void display(int[]a){
		  for(int i =0; i<a.length;i++){
				System.out.print(a[i]+" ");
			}
	  }
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			int []a= {45,3,5,2,8,34,23,234,23};
			sort(a);
			
//			display(a);
		}

	
	
}
