package tutorial7;

public class recursion {

	public static String reverse(String s){
		
		if(s.length()==1)
			return s;
		else
			return reverse(s.substring(1))+s.charAt(0);
	}
	
	public static int fibonacci(int index){
		if(index==0||index==1)
			return index;
		else
			return (fibonacci(index-1)+fibonacci(index-2));
	}
	
	public static void print(int n)
	{
		if(n>0)
		{
			print(n-1);
			System.out.println(n);
			print(n-1);
		}
		else
		{
			System.out.println(n);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(reverse("iloveyou"));
		
		print(3);
		
	}

}
