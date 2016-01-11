package assignment2;

public class Number implements NumberInterface {
	
	private static final double NATURAL_NUMBER = 0;
	private StringBuffer stringBuffer;
	
	Number() {
		stringBuffer = new StringBuffer();
	}

	public void init() {
		stringBuffer.append(NATURAL_NUMBER);
	}
	
	public void add(int number){
		if (stringBuffer.charAt(0) == 0) {
			stringBuffer.replace(0, 1, String.valueOf(number));
		}
		else {
			stringBuffer.append(number);
		}
	}
	
	public StringBuffer get(){
		return stringBuffer;
	}

	@Override
	public int compareTo(NumberInterface o) {
		String string = stringBuffer.toString();
		String oString = o.get().toString();
		int result = string.compareTo(oString);
		if (result == 0) {
			return 0;
		} else if (result > 0) {
			return 1;
		} else {
			return -1;
		}
	}

	@Override
	public NumberInterface clone() {
		Number clonedNumber = new Number();
		for (int i = 0; i < stringBuffer.length(); i++) {
			clonedNumber.add(stringBuffer.charAt(i));
		}
		return clonedNumber;
	}
	
}