
public class Mergesort {
	
	public static Huffman[] sortBegins(Huffman[]huff){
		mergesort(huff, 0, huff.length-1);
		//sorted array will be written back to huff. hence just return
		return huff;
	}
	
	  public static void mergesort(Huffman [] huff,int lowerIndex, int higherIndex) {
	         
	        if (lowerIndex < higherIndex) {
	            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
	            // Below step sorts the left side of the array
	            mergesort(huff,lowerIndex, middle);
	            // Below step sorts the right side of the array
	            mergesort(huff,middle + 1, higherIndex);
	            // Now merge both sides
	            merge(huff,lowerIndex, middle, higherIndex);
	        }
	    }
	 
	    public static void merge(Huffman [] huff,int s, int mid, int e) {
	 
	    	//two list needs to be created
	    	//meaning it is not in-place sorting. 
	    	
	    	Huffman [] l= new Huffman[mid-s+2];// +1 compensation, +1 for infinite 
	    	
	        for (int i = s; i <= mid; i++) { //copy l-list
	            l[i-s] = huff[i];//i-s critical?? yes critical
	        }
	        l[mid-s+1]= new Huffman(Integer.MAX_VALUE);//infinite value
	        
	        //repeat for right-list
	        Huffman [] r = new Huffman [e-mid+1];//no compensation, +1 for infinite
	        
	        for(int j= mid+1; j<= e;j++){//copy r-list
	        	r[j-mid-1]=huff[j];//j-mid-1 to simply j? nope
	        }
	        r[e-mid]= new Huffman(Integer.MAX_VALUE);//infinite value
	        
	        int i=0,j =0;
	        for(int k = s; k<=e; k++){
	        	if(l[i].root.key<r[j].root.key){ //when left-list is smaller, it overwrites on array;
	        		huff[k]=l[i];
	        		i++;
	        	}else{
	        		huff[k]=r[j];
	        		j++;
	        	}
	        }
	        
	 
	    }
}
