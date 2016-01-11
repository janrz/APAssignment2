package assignment2;

/** ADT for the class Collections
 * 
 * @author Nousha van Dijk & Jan Rezelman
 * @elements
 * 		Objects of the type E
 * @structure
 * 		no structure
 * @domain
 * 		0 or more Objects
 * 
 * 		Table()
 * 		PRE
 * 		POST collection object contains only the empty collection
 */

public interface TableInterface<V extends ClonableInterface<V>,K extends DataInterface<K>> extends ClonableInterface<TableInterface<V,K>> {
	/** Initializes the variable object to the table
	 * @precondition
	 * 		-
	 * @postcondition
	 * 		the set is empty
	 */
	void insert (V value, K key);
	
	/** Returns whether the collection is empty
	 * @precondition
	 * 		there has to be a key
	 * @postcondition
	 * 		true: the collection is empty
	 * 		false: the collection is not empty
	 */
	V retrieve(K key);
	
	/** Add identifier to collection
	 * @precondition
	 * 		Collection is not full
	 * @postcondition
	 * 		src is in collection
	 */
	boolean contains(K key);
	
}