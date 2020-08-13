package assignment3;
//-----------------------------------------------------
//Assignment #3
//Part: 1
//Written by: Byoungwoo Kang(27744544); Nayagen Manikion(40020905);
//-----------------------------------------------------
 class DuplicateISBNException extends Exception {

	public DuplicateISBNException() {
		System.out.println("Error! There is an identical book!");
	}

	public DuplicateISBNException(String message) {
		System.out.println(message);
	}
	
	public String getMessage(){
		return super.getMessage();
	}
	
	
}
