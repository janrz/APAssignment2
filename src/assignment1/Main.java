package assignment1;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
	
	final int MAX_NUMBER_ELEMENTS_USER_SET = 10;
	
	PrintStream out;
	
	Main() {
		out = new PrintStream(System.out);
	}
	
	void start() {
		Scanner in = new Scanner(System.in);
		while (true) {
			Collections firstCollection = createUserCollection("first", in);
			Collections secondCollection = createUserCollection("second", in);
			executeSetOperations(firstCollection, secondCollection);
		}
	}

	Collections createUserCollection(String numberOfSet, Scanner in) {
		boolean setCorrect = false;
		String set = null;
		String[] setArray = new String[0];
		while (!setCorrect) {
			set = askUserInput(numberOfSet, in);
			if (checkCorrectInput(set)) {
				setCorrect = true;
			} else {
				continue;
			}
		}
		set = removeAccolades(set);
		setArray = createArray(set);
		Collections collection = createCollection(setArray);
		return collection;
	}
	
	String askUserInput(String numberOfSet, Scanner in) {
		out.printf("Give the %s set: ", numberOfSet);
		String set = in.nextLine();
		return set;
	}
		
	boolean checkCorrectInput(String set) {
		String[] setArray = new String[0];
		if (!hasLeftAccolade(set)) {
			out.printf("Left accolade is missing.\n\n");
			return false;
		} else if (!hasRightAccolade(set)) {
			out.printf("Right accolade is missing.\n\n");
			return false;
		} else {
			set = removeAccolades(set);
			
		}
		if (set.length() == 0) {
			return true;
		}
		setArray = createArray(set);
		if (setArray.length > MAX_NUMBER_ELEMENTS_USER_SET) {
			out.printf("Too many elements in set, maximum is %d\n\n", MAX_NUMBER_ELEMENTS_USER_SET);
			return false;
		} else if (!noEmptyElements(setArray)) {
			out.printf("Empty elements are not allowed\n\n");
			return false;
		} else if (!hasFirstLetter(setArray)) {
			out.printf("All elements must start with a letter\n\n");
			return false;
		} else if (!isAlphanumeric(setArray)) {
			out.printf("All characters must be alphanumeric\n\n");
			return false;
		} else {
			return true;
		}
	}
	
	boolean hasLeftAccolade (String set) {
		char beginChar = set.charAt(0);
		if (beginChar == '{') {
			return true;
		} else {
			return false;
		}
	}
	
	boolean hasRightAccolade (String set) {
		char endChar = set.charAt(set.length() - 1);
		if (endChar == '}') {
			return true;
		} else {
			return false;
		}
	}
	
	String removeAccolades(String set) {
		char[] array = set.toCharArray();
		char[] arrayWithoutAccolades = Arrays.copyOfRange(array, 1, array.length - 1);
		String stringWithoutAccolades = new String (arrayWithoutAccolades);
		return stringWithoutAccolades;
	}
	
	String[] createArray (String set){
		String[] array = set.split(" ");
		return array;
	}
	
	boolean noEmptyElements (String[] array){
		int counter = 0;
		for (int i = 0; i < array.length; i++){
			if (array[i] == "") {
				counter +=1;
			}	
		}
		if (counter == 0) {
			return true;
		} else {
			return false;
		}				
	}
	
	boolean hasFirstLetter(String[] array) {
		int counter = 0;
		for (int i = 0; i < array.length; i++) {
			if (!Character.isLetter(array[i].charAt(0))) {
				counter += 1;
			}
		}
		if (counter == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	boolean isAlphanumeric(String[] array){
		int counter = 0;
		for (int i = 0; i < array.length; i++) {
			for (int x = 0; x < array[i].length(); x++) {
				if (!Character.isLetterOrDigit(array[i].charAt(x))) {
					counter += 1;
				}
			}
		}
		if (counter == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	Identifier createIdentifier(String element){
		Identifier identifierObject = new Identifier();
		for (int i=0; i<element.length(); i++){
			identifierObject.add(element.charAt(i));
		}
		return identifierObject;
	}
	
	Collections createCollection (String[] array){
		Collections collectionObject = new Collections();
		for (int i = 0; i < array.length; i++) {
			Identifier identifier = createIdentifier(array[i]);
			collectionObject.add(identifier);
		}
		return collectionObject;
	}
	
	void executeSetOperations(Collections firstCollection, Collections secondCollection) {
		Collections collectionDifference = firstCollection.difference(secondCollection);
		Collections collectionIntersection = firstCollection.intersection(secondCollection);
		Collections collectionUnion = firstCollection.union(secondCollection);
		Collections collectionSymmetricDifference = firstCollection.symmetricDifference(secondCollection);
		
		printCollection(collectionDifference, "difference");
		printCollection(collectionIntersection, "intersection");
		printCollection(collectionUnion, "union");
		printCollection(collectionSymmetricDifference, "sym. diff.");
		out.printf("\n");
	}
	
	public void printCollection(Collections collection, String string) {
		out.printf("%s = {", string);
		Identifier[] array = collection.show();
		for (int i = 0; i < collection.size(); i++) {
			out.print(array[i].get());
			if (i < collection.size() - 1) {
				out.printf(" ");
			}
		}
		out.printf("}\n");
	}
	
	public static void main(String[] args) {
		new Main().start();
	}	
}
