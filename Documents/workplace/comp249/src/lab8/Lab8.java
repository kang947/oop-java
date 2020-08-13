package lab8;

public class Lab8 {
	public static int deran(int n){
		if (n==1||n==0)
			return 0;
		else if(n==2)
			return 1;
		else
			return ((n-1)*(deran(n-1)+deran(n-2)));
	}
	
	public static int Tribo(int n){
		if (n==1||n==0||n==-1)
			return 0;
		else if(n==2)
			return 1;
		else
			return (Tribo(n-1)+Tribo(n-2)+Tribo(n-3));
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(deran(7));
	}
}
