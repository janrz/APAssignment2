package assignment1;

public class Identifier implements IdentifierInterface {
	
	private StringBuffer stringBuffer;
	private boolean firstEntry;
	
	Identifier(){
		stringBuffer = new StringBuffer();
	}
	
	Identifier(Identifier src){
		stringBuffer = new StringBuffer();
		stringBuffer.append(src.get());
	}
	
	public void init (char c) {
		stringBuffer.append(c);
	}
	
	public void add(char c) {
		stringBuffer.append(c);
		if (firstEntry) {
			stringBuffer.deleteCharAt(0);
			char newEntry = stringBuffer.charAt(1);
			String newEntryString = String.valueOf(newEntry);
			stringBuffer.replace(0,1, newEntryString);
			stringBuffer.deleteCharAt(1);
			firstEntry = false;
		}
	}
	
	public String get() {
		return stringBuffer.toString();
	}
	
	public boolean equals(Identifier src) {
		if (stringBuffer.toString().equals(src.stringBuffer.toString())) {
			return true;
		} else {
			return false;
		}
	}
	
	public int length() {
		String string = stringBuffer.toString();
		int lengthString = string.length();
		return lengthString;
	}
}

