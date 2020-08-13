package lab;

public class Student extends Person{
	
	private String program;
	
	public Student(String fn, String ln, String p){
		this.program =p;
		
		setFirstName(fn);
		setLastName(ln);
	}
	
	public String toString(){
		return super.toString()+" and I'm studying " + program;
	}
	
	
}
