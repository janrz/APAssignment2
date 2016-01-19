package assignment2;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {
	PrintStream out;
	APException e;
	// List<E> list; // TODO wat moet hiermee? stond er nog in
	Table table = new Table();
	
	Main() {
		out = new PrintStream(System.out);
	}
	
	void start() {
		Scanner in = new Scanner(System.in);
		while (in.hasNextLine()){
			try {
				Scanner statement = new Scanner(in.nextLine());
				processStatement(statement);
			} catch (APException e) {
				out.print(e);
			}
		}
		in.close(); // TODO moet deze erin?
	}
	
	void processStatement(Scanner statement) throws APException {
		statement.useDelimiter("");
		statement.skip("\\s*");
		if (!statement.hasNext() || statement.hasNext("\\/")) {
			return;
		} else if (statement.hasNext("[a-zA-Z]")) {
			processAssignment(statement);
		} else if (statement.hasNext("\\?")){
			processPrintStatement(statement);
		} else {
			throw new APException("Invalid line");
		}
	}

	void processAssignment(Scanner statement) throws APException {
		statement.useDelimiter("\\s*=\\s*");
		Identifier identifier = createIdentifier(statement.next());
		if (table.contains(identifier)) {
			identifier = (table.retrieve(identifier));
		}
		
		Scanner expression = new Scanner(statement.next());
		Collection collection = new Collection();
		processExpression(expression);
		
		table.insert(collection, identifier);
	}

	void processPrintStatement (Scanner statement) throws APException {
		//TODO bepalen of er een fout kan zijn in een print statement: anders kan exception gooien ook weg
		if (true) { // if geen fouten: print statement
			out.print(statement); // als er geen fouten kunnen zijn is dit de enige regel
		} else { 
			throw new APException("Error processing print statement");
		}
		// TODO return toevoegen?
	}
	
	Identifier createIdentifier(String statement) throws APException {
		statement = statement.trim();
		Identifier newIdentifier = new Identifier();
		for (int i = 0; i < statement.length(); i++) {
			if (Character.isLetterOrDigit(statement.charAt(i))) {
				newIdentifier.add(Character.toString(statement.charAt(i)));
			} else {
				throw new APException("Identifier can only contain alphanumeric characters");
			}
		}
		return newIdentifier;
	}
	
	void processExpression(Scanner expression){
		expression.useDelimiter("\\s*(\\s*|\\s*)\\s*");
		processSet(set);
	}
	
	Collection processSet(Scanner set) {
		set.useDelimiter("\\s*,\\s*");
		Collection collection = new Collection();
		while (set.hasNext()) {
			collection.add(set.next()); // collection zou elk type moeten kunnen hebben toch?
		}
		return collection;
	}
	
	void additiveOperator(String statement) throws APException{	
		int i = 0;
		boolean operatorFound = false;
		while (i < statement.length() && operatorFound == false) {
			char ch = statement.charAt(i);
			if (ch == '+') {
				operatorFound = true;
				processUnion(statement);
			} else if (ch == '-') {
				operatorFound = true;
				processDifference(statement);
			} else if (ch == '|'){
				operatorFound = true;
				processSymmetricDifference(statement);
			} else {
				i++;
			}
		}
		if (i == statement.length() && operatorFound == false) {
			throw new APException("No additive operator found");
		}
	}
	
	void multiplicativeOperator(String statement) throws APException{	
		int i = 0;
		boolean operatorFound = false;
		while (i < statement.length() && operatorFound == false) {
			char ch = statement.charAt(i);
			if (ch == '*') {
				operatorFound = true;
				processIntersection(statement);
			} else {
				i++;
			}
		}
		if (i == statement.length() && operatorFound == false) {
			throw new APException("No multiplicative operator found");
		}
	}
	
	Collection createCollection (String statement){
		Collection collectionObject = new Collection();
		for (int i = 0; i < statement.length(); i++) {
			Identifier identifier = createIdentifier(array[i]);
			collectionObject.add(statement);
		}
		return collectionObject;
	}
	
	Collection processUnion (String statement){
		Collection collectionUnion = firstCollection.union(secondCollection);
	}
	
	void processFactor (String statement){
		
	}
	
	void processNumber (int num) throws APException {		
	    if (num > 0 && num < 10) {
			processNotZero(num);
		} else if (num == 0) { 
			processZero(num);
		} else {
			throw new APException("No valid number");
		}
	}

	char processZero (int input) throws APException {
		Number number = new Number();
		number.add(input);
		throw new APException("Not zero");
	}

	char processNotZero (int input) throws APException {
		Number number = new Number();
		number.add(input);
		throw new APException("No number object");
	}
	
	void processLetter(String statement){
		char ch = statement.charAt(0);
		for (int i = 0; i<statement.length(); i++){
			if statement.
		}
	}
	
	void processIntersection (String statement){
		
	}
	
	void processDifference (String statement){
	}
	
	void processSymmetricDifference (String statement){
	}
	
	public static void main(String[] args){ //throws APException {
		new Main().start();
		//throw new APException("...");
		//TODO waarom die exception?
	}

}
