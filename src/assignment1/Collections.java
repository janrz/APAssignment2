package assignment1;

import java.util.Random;

public class Collections implements CollectionsInterface {

	private Identifier[] identifierArray;
	private int amountElements;

	Collections() {
		identifierArray = new Identifier[20];
		amountElements = 0;
	}

	Collections(Collections src) {
		identifierArray = new Identifier[20];
		amountElements = src.amountElements;
		for (int i = 0; i < src.amountElements; i++) {
			identifierArray[i] = new Identifier(src.identifierArray[i]);
		}
	}

	public void init() {
		amountElements = 0;
	}

	public boolean isEmpty() {
		if (identifierArray == null) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isFull() {
		if (identifierArray.length == 10) {
			return true;
		} else {
			return false;
		}
	}

	public void add(Identifier identifier) {
		if (!contains(identifier)) {
			identifierArray[amountElements] = identifier;
			amountElements += 1;
		}
	}
	
	public boolean contains(Identifier src){
		for(int i = 0; i < size(); i++){
			if(identifierArray[i].equals(src)){
				return true;
			}
		}
		return false;
	}

	public Identifier get() {
		Random random = new Random();
		int randomIndex = random.nextInt(identifierArray.length);
		return identifierArray[randomIndex];
	}

	public void delete(Identifier identifier) {
		for (int i = 0; i < size(); i++) {
			if (identifierArray[i].equals(identifier)) {
				for (int x = i; x < size()-1; x++) {
					identifierArray[x] = identifierArray[x + 1];
				}
				amountElements -= 1;
				return;
			}
		}
	}

	public Collections difference(Collections secondCollection) {
		Collections difference = new Collections(this);
		for (int i = 0; i < secondCollection.size(); i++) {
			for (int x = 0; x < difference.size(); x++) {
				if (secondCollection.identifierArray[i].equals(difference.identifierArray[x])) {
					difference.delete(difference.identifierArray[x]);
				}
			}
		}
		return difference;
	}

	public Collections intersection(Collections secondCollection) {
		Collections intersection = new Collections();
		for (int i = 0; i < this.size(); i++) {
			if (secondCollection.contains(this.identifierArray[i])) {
				intersection.add(this.identifierArray[i]);
			}
		}
		return intersection;
	}

	public Collections union(Collections secondCollection) {
		Collections union = new Collections(this);
		for (int i = 0; i < secondCollection.size(); i++) {
			union.add(secondCollection.identifierArray[i]);
		}
		return union;
	}

	public Collections symmetricDifference(Collections secondCollection) {
		Collections differenceFirst = this.difference(secondCollection);
		Collections differenceSecond = secondCollection.difference(this);
		Collections symmetricDifference = differenceFirst.union(differenceSecond);
		return symmetricDifference;
	}

	public int size() {
		return amountElements;
	}

	public Identifier[] show() {
		return identifierArray;
	}
}
