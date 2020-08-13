package Tutorial6;


class NegativeException extends RuntimeException {}
class ZeroException extends NegativeException {}
public class Driver {
	static boolean Marathon (int a) {
		try{
			
		if (a<0) throw new NegativeException();
		else if (a==0) throw new ZeroException();
		else if (a>=42){
			System.out.println("plsd");
			return false;
		}
		else 
			return false;
		}
		catch (ZeroException e){
		System.out.println("Use natural number");}
		catch (NegativeException e){
			System.out.println("fucking wrong!");
		}

	finally{
//		System.out.println("asdf");
		System.out.println("One last thing");}
		System.out.println("All done.");
		return false;
		}
		public static void main(String[] args) {
		System.out.println(Marathon(100));
		System.out.println(Marathon(0));
		System.out.println(Marathon(-5));
		}//main
		}//Driver
