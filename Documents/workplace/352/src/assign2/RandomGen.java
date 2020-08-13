package assign2;

import java.util.Random;
public class RandomGen {

	static Random rand = new Random();
	public static int[] generate(int n){
		int[] ranArr = new int[n];
		for(int i =0; i<n; i++){
			
			ranArr[i]=rand.nextInt()+1;
		}
		return ranArr;
	}
	
	public static int[] generateWithSeed(int n,long seed){
		Random generator = new Random(seed);
		int [] ranArr = new int[n];
		for(int i =0; i<n;i++){
			int num = generator.nextInt();
			ranArr[i]= num;
		}
		
		return ranArr;
	}
	 public static void display(int[]a){
		  for(int i =0; i<a.length;i++){
			  
				System.out.print(a[i]+" ");
			}
	  }
	 
	 public static void main(String []args){
			int[]a=generate(10);
			display(a);
		}
	//works good!
	 
}
