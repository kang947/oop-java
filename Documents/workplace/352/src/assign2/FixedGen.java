package assign2;

public class FixedGen {
	public static int[] generate(int n){
		int[] fixedArr = new int[n];
		for(int i=1; i<n+1; i++){
			fixedArr[i-1]=i;
		}
		return fixedArr;
	}
	
//	public static void display(int[]a){
//		  for(int i =0; i<a.length;i++){
//			  
//				System.out.print(a[i]+" ");
//			}
//	  }
//	
//	public static void main(String []args){
//		int[]a=generate(10);
//		display(a);
//	}
	
	//works good!
}
