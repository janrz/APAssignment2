package assignment2;
import java.io.PrintStream;
import java.util.Scanner;

import assignment1.Collections;
import assignment1.Identifier;

public class Main {
	PrintStream out;
	APException e;
	//List<E> list;
	
	Main() {
		out = new PrintStream(System.out);
	}
	
	void start() {
		String statement = "hoi = abdc";
		Scanner in = new Scanner(System.in);
		while (in.hasNext()){
			try {
				processStatement(statement);
			}catch (APException e) {
				out.print(e);
				}
			}
		}
	
	void processProgram(Scanner input){

	}
	
	void processStatement(String statement) throws APException {	
		statement = statement.trim();
		if (statement.isEmpty()) {
			return;
			}
		char ch = statement.charAt(0);
		if (ch == '/') {
			processComment(statement);
		} else if (ch == '?') {
			processPrintStatement(statement);
		} else if (Character.isLetter(ch)){
			processAssignment(statement);
		} else {
			throw new APException("ongeldige regel");
		}
	}
	
	void processComment (String statement) {
		return;
	}
	
	void processPrintStatement (String statement) throws APException {
		//TODO bepalen of er een fout kan zijn in een print statement: anders kan exception gooien ook weg
		if (true) { // if geen fouten: print statement
			out.print(statement); // als er geen fouten kunnen zijn is dit de enige regel
		} else { 
			throw new APException("Error processing print statement");
		}
		// TODO return toevoegen?
	}

	void processAssignment(String statement) throws APException {
		 StringBuffer identifierStringBuffer = new StringBuffer();
		 int counter = 0;
		 while (!(statement.charAt(counter) == '=')){
			identifierStringBuffer.append(statement.charAt(counter));
			counter ++;
		 }
			Identifier identifier = createIdentifier(identifierStringBuffer.toString());
			counter +=2;
			StringBuffer expressionStringBuffer = new StringBuffer();			
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
	
	void processExpression(String statement){
		
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
	
	char processNumber (int num) throws APException {
		Number number = new Number();
		
	    if (num > 0 && num < 10) {
			number.add(in);
			}
			else if (! in.hasNext("[0]")){ 
			processZero(int input);
			} else {
				throw new APException("No valide Number");
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
	}

}
