package lab;

public class VehicleDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		
		Car c1 = new Car(4,2003,"100miles per hour");
		Bicycle b1 = new Bicycle();
		
		Vehicle [] v1 = {c1,b1};
		
		for (Vehicle v : v1){
			System.out.println(v.greeting());
		}
	}

}
