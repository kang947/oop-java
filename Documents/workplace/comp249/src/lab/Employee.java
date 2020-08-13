package lab;

public class Employee{
	
	private String firstN, lastN;
	private long employeeId;
	
	
	public Employee (){
		firstN= "Byoung";
		lastN = "Kang";
		employeeId = 27744544;
	}
	public Employee(String f, String l, long e){
		firstN = f;
		lastN = l;
		employeeId = e;
	}
	public Employee(Employee e){
		firstN = e.firstN;
		lastN= e.lastN;
		employeeId = e.employeeId;
	}
	public String getFirstN() {
		return firstN;
	}
	public void setFirstN(String firstN) {
		this.firstN = firstN;
	}
	public String getLastN() {
		return lastN;
	}
	public void setLastN(String lastN) {
		this.lastN = lastN;
	}
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	
	

}
