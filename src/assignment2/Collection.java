package assignment2;
 
public class Collection<E extends DataInterface<E>> implements CollectionInterface<E> {
	
    List<E> collection;
    int amountElements;
     
    Collection() {
    	amountElements = 0;
        collection = new List<>();
    }
 
    public void init() {
    	amountElements = 0;
        collection = new List<>();
    }
 
    public boolean isEmpty() {
        return collection.isEmpty();
    }
 
    public void add(E src) {
        if (!collection.find(src)) {
            collection.insert(src);
            amountElements ++;
        }
    }
    
    public E get() {
        return collection.retrieve();
    }
 
    public void delete(E src) {
        if (collection.find(src)) {
            collection.remove();
            amountElements --;
        }
    }
    
    public Collection<E> clone(){
        Collection<E> clonedCollection = new Collection<>();
        List<E> clonedList = collection.clone();
        clonedList.goToFirst();
        for (int i = 0; i < clonedList.size(); i++) {
            clonedCollection.add(clonedList.retrieve());
            clonedList.goToNext();
        }
        return clonedCollection;
    }
 
    public Collection<E> difference(Collection<E> secondCollection) {
        Collection<E> difference = clone();
        secondCollection.collection.goToFirst();
        difference.collection.goToFirst();
        
        for (int i = 0; i < secondCollection.size(); i++) {
            for (int x = 0; x < difference.size(); x++) {
                if (secondCollection.get().equals(difference.get())) {
                	difference.delete(difference.get());
                difference.collection.goToNext();
                }
            secondCollection.collection.goToNext();
            }
        }
        return difference;
    }
 
    public Collection<E> intersection(Collection<E> secondCollection) {
        Collection<E> intersection = new Collection<>();
        collection.goToFirst();
        secondCollection.collection.goToFirst();
        
        for (int i = 0; i < secondCollection.size(); i++) {
            for (int x = 0; x < collection.size(); x++) {
                if (secondCollection.get().equals(collection.retrieve())) {
                	intersection.add(collection.retrieve());
                collection.goToNext();
                }
            secondCollection.collection.goToNext();
            }
        }
        return intersection;
    }
 
    public Collection<E> union(Collection<E> secondCollection) {
        Collection<E> union = clone();
        secondCollection.collection.goToFirst();
        union.collection.goToFirst();
        
        for (int i = 0; i < secondCollection.size(); i++) {
            if (!union.collection.find(secondCollection.get())) {
            	union.add(secondCollection.get());
            }
            secondCollection.collection.goToNext();
        }
        return union;
    }
 
    public Collection<E> symmetricDifference(Collection<E> secondCollection) {
        Collection<E> differenceFirst = this.difference(secondCollection);
        Collection<E> differenceSecond = secondCollection.difference(this);
        Collection<E> symmetricDifference = differenceFirst.union(differenceSecond);
        return symmetricDifference;
    }
 
    public int size() {
        return amountElements;
    }

}