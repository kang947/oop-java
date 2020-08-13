package tutorial;

public class ShapeDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Circle c1 = new Circle();
		
		c1.setRadius(2.0);
		System.out.println(c1);
		
		Circle c2 = new Circle();
		c2.setRadius(3.0);
		System.out.println(c2);
		
		
		//exercise 3
		
		Rectangle r1 = new Rectangle();
		r1.setHeight(2.0);
		r1.setHeight(3.0);
		System.out.println(r1);
		
		Shape[] shapes={c1,c2,r1};
		
		System.out.println("Total Area is "+ Shape.totalArea(shapes));
		
		
		}

}
