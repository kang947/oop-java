package assign1;

/*Byoungwoo Kang
 * 27744544 
 * comp352 assignment#1
 * 
 * 2) The algorithm of the program below is called 'binary search algorithm'
 * 	The absolute condition for this algorithm is that the data should be in order. 
 * 	The wanted value will be compared with the middle element of the array and if they are
 * 	unequal, the algorithm will be re-executed with the half interval of the array that does contain
 * the value in it. It will continue until the middle element of the array matches the wanted value.
 * 	
 * 
 * 3) instead of using direct comparisons(>,<,=), i'd replace it with compareTo() method.
 * As long as they are known to be sorted, binary search algorithm will work without a problem. 
 * compareTo() method will return 0 when the two strings match, <0 if the latter string is bigger,
 * and >0 when the first string is bigger based on the Ascii table. 
 */

public class bsortTest {
	public static void searchNum(int[]a, int e, int v){// the array is in order
		 
		int s = 0; //first index is always zero
	
		//make a while loop here!
		while(s<=e){ 
			 int mid = (e+s)/2;
	
			  if(a[mid]==v){
				 System.out.println(v+"=");
				 break;
			 }
			 
			 else if(a[mid]>v){
				 System.out.println(v+"<"+a[mid]);
				 e= mid-1;
			 }
			 else if(a[mid]<v){
				 System.out.println(v+">"+a[mid]);
				 s= mid+1;
			 }
	 }
		
		
		if(e<s){
			 System.out.println("!");
			
		 }
	 
	 
	}
	
	public static void main(String []args){
		String str1 = args[0];//before the space
		
		int value = Integer.parseInt(args[1]);
		
		String[] arr = str1.split(",");//string array created
		
		int[] data = new int[arr.length];//same size array
		for(int i=0; i<arr.length; i++)
			data[i]= Integer.parseInt(arr[i]);
		
		int end= arr.length-1;
		
		searchNum(data, end, value);
		
		
		
		
	}
}
