package assignment1;

/** ADT for the class Collections
 * 
 * @author Nousha van Dijk & Jan Rezelman
 * @elements
 * 		identifiers of the type Collection
 * @structure
 * 		no structure
 * @domain
 * 		collections 0-20
 * 
 * 		collections()
 * 		PRE
 * 		POST collection object contains only the empty collection
 * 		collections (collections src);
 * 		PRE
 * 		POST collection object contains copy of src
 */

public interface CollectionsInterface {
	
	/** Initializes the collection object to the array
	 * @precondition
	 * 		-
	 * @postcondition
	 * 		the set is empty
	 */
	void init ();
	
	/** Returns whether the collection is empty
	 * @precondition
	 * 		-
	 * @postcondition
	 * 		true: the collection is empty
	 * 		false: the collection is not empty
	 */
	boolean isEmpty ();
	
	/** Add identifier to collection
	 * @precondition
	 * 		Collection is not full
	 * @postcondition
	 * 		src is in collection
	 */
	void add (Identifier identfier);
	
	/** Returns whether the collection is full
	 * @precondition
	 * 		-
	 * @postcondition
	 * 		true: the collection is full
	 * 		false: the collection is not full
	 */
	boolean isFull();
	
	/** Check if identifier is in collection
	 * @precondition
	 * 		Collection is not empty
	 * @postcondition
	 * 		Boolean value is returned
	 */
	boolean contains(Identifier src);
	
	/** Get element from collection
	 * @precondition
	 * 		Collection is not empty
	 * @postcondition
	 * 		Random element in the collection is returned
	 */
	Identifier get ();
	
	/** Delete element from collection
	 * @precondition
	 *		-
	 * @postcondition
	 * 		src is not in collection
	 */
	void delete (Identifier identifier);
	
	/** Adds all identifiers of the first collection that are not equal to any identifier in the second collection to the array
	 * @precondition
	 * 		-
	 * @postcondition
	 *		only identifiers in first collection that are not equal to any identifier in second collection are returned
	**/
	Collections difference (Collections secondCollection);
	
	/** Adds identifiers which are in both the first and second collection to the array
	 * @precondition
	 *		-
	 * @postcondition
	 *		Equal identifiers from first and second collection are returned
	**/
	Collections intersection (Collections secondCollection);
	
	/** Adds identifiers of first and second collection to the array
	 * @precondition
	 *		-
	 * @postcondition
	 *		All identifiers of first and second collection are returned, but no duplicates
	**/
	Collections union (Collections secondCollection) throws Exception;
	//throws Exception
	
	/** Adds identifiers of first and second collection to the array, except identifiers which are in both collections
	 * @precondition
	 *		-
	 * @postcondition
	 *		All non-equal identifiers of first and second collection are returned
	**/
	Collections symmetricDifference (Collections secondCollection);
	//throws Exception

	/** Returns the amount of elements of the stack.
	 * @precondition
	 *    	-
	 * @postcondition
	 *    	The amount of elements of the stack is returned.
	 **/
	int size ();
	
	/** Returns the elements of the collections
	 * @precondition
	 * 	-
	 * @postcondition {
	 * 	elements of the collections are returned
	**/
	//public Collections show();
}