package assignment2;

public class Identifier implements IdentifierInterface {
	
	private String identifierString;
	
	Identifier(){
		identifierString = "";
	}
	
	Identifier(Identifier src){
		identifierString = "";
		identifierString = src.get();
	}
	
	public void init () {
		identifierString = "";
	}
	
	public void add(String input) {
		identifierString = input;
	}
	
	public String get() {
		return identifierString;
	}
	
	public boolean compareTo(Identifier src) {
		if (identifierString.equals(src.identifierString)) {
			return true;
		} else {
			return false;
		}
	}
	
}