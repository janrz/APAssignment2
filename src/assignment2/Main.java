package assignment2;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {
	PrintStream out;
	APException e;
	Table<CollectionInterface<NumberInterface>,IdentifierInterface> table = new Table<CollectionInterface<NumberInterface>,IdentifierInterface>();
	
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
		in.close();
	}
	
	void processStatement(Scanner statement) throws APException {
		statement.useDelimiter("");
		statement.skip("\\s*");
		if (!statement.hasNext()) {
			out.print("Encountered empty line");
			return;
		} else if (statement.hasNext("\\/")) {
			return;
		} else if (statement.hasNext("[a-zA-Z]")) {
			processAssignment(statement);
		} else if (statement.hasNext("\\?")){
			statement.next();
			processPrintStatement(statement);
		} else {
			throw new APException("Invalid line");
		}
	}

	void processAssignment(Scanner statement) throws APException {
		statement.useDelimiter("\\s*=\\s*");
		Identifier identifier = createIdentifier(statement.next());
		if (table.contains(identifier)) {
			CollectionInterface<NumberInterface> existingCollection = new Collection();
			existingCollection = (table.retrieve(identifier));
		}
		Scanner expression = new Scanner(statement.next());
		Collection collection = new Collection();
		processExpression(expression);
		
		table.insert(collection, identifier);
	}

	void processPrintStatement (Scanner statement) throws APException {
		statement.useDelimiter("");
		CollectionInterface collection = new Collection();
		while (statement.hasNext()) {
			if (statement.hasNext("[a-zA-Z]")) {
				Identifier identifier = createIdentifier(statement.toString());
				if (table.contains(identifier)) {
					collection = (table.retrieve(identifier));
					printCollection(collection);
				} else {
					throw new APException("Set does not exist");
				}
			}
		}
		// TODO return toevoegen?
	}
	
	void printCollection(CollectionInterface collection) {
		out.print("{");
		if (collection.size() > 0) {
			List<NumberInterface> collectionList = collection.showList(); // TODO mag dit? functie toegevoegd aan Collection
			collectionList.goToFirst();
			for (int i = 0; i < collection.size(); i++) {
				out.print(collectionList.retrieve().toString());
				if (i < collection.size()) {
					out.print(", ");
				}
				collectionList.goToNext();
			}
		}
		out.print("}");
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
		String set = null;
		while (expression.hasNext()) {
			if (nextCharacterIs("(",expression)) {
				expression.next();
				processExpression(expression);
			} else if (expression.hasNext("[a-zA-Z]")) {
				processTerm(expression);
			}
		}
	}
	
	void processTerm(Scanner expression) {
		
	}
	
	CollectionInterface processSet(String set) {
		String[] setArray = set.split(",");
		CollectionInterface collection = new Collection();
		for (int i = 0; i < setArray.length; i++) {
			collection.add(setArray[i]); // collection zou elk type moeten kunnen hebben toch?
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
	
	Collection processUnion (String statement){
		Collection collectionUnion = firstCollection.union(secondCollection);
	}
	
	void processFactor(Scanner expression){
		Collection collection = new Collection();
		findOpenParentheses(expression);
		
		if (expression.hasNext("\\{")){
			processSet(expression);
		}
		else if (expression.hasNext("[a-zA-Z]")){
			
		}
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
	
	boolean nextCharacterIs(String pattern, Scanner expression) {
		return expression.hasNext(pattern);
	}
	
	public static void main(String[] args) {
		new Main().start();
	}

}
