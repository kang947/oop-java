package sortingAlgorithms;

public class MergeSort {
	
	    public static void main(String a[]){
	         
	        int[] inputArr = {45,23,11,89,77,98,4,28,65,43};
	        mergesort(inputArr, 0,9);
	        display(inputArr);
	    }
	     
		public static void display(int[]a){
		  for(int i =0; i<a.length;i++){
				System.out.print(a[i]+" ");
			}
		}
		
	 
	    public static void mergesort(int[]a,int lowerIndex, int higherIndex) {
	         
	        if (lowerIndex < higherIndex) {
	            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
	            // Below step sorts the left side of the array
	            mergesort(a,lowerIndex, middle);
	            // Below step sorts the right side of the array
	            mergesort(a,middle + 1, higherIndex);
	            // Now merge both sides
	            merge(a,lowerIndex, middle, higherIndex);
	        }
	    }
	 
	    public static void merge(int []a,int s, int mid, int e) {
	 
	    	//two list needs to be created
	    	//meaning it is not in-place sorting. 
	    	
	    	int[] l= new int[mid-s+2];// +1 compensation, +1 for infinite 
	    	
	        for (int i = s; i <= mid; i++) { //copy l-list
	            l[i-s] = a[i];//i-s critical??
	        }
	        l[mid-s+1]=Integer.MAX_VALUE;//infinite value
	        
	        //repeat for right-list
	        int[] r = new int[e-mid+1];//no compensation, +1 for infinite
	        
	        for(int j= mid+1; j<= e;j++){//copy r-list
	        	r[j-mid-1]=a[j];//j-mid-1 to simply j? nope
	        }
	        r[e-mid]=Integer.MAX_VALUE;//infinite value
	        
	        int i=0,j =0;
	        for(int k = s; k<=e; k++){
	        	if(l[i]<r[j]){ //when left-list is smaller, it overwrites on array;
	        		a[k]=l[i];
	        		i++;
	        	}else{
	        		a[k]=r[j];
	        		j++;
	        	}
	        }
	        
	 
	    }
}
