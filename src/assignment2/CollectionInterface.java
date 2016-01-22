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
 * 		collection()
 * 		PRE
 * 		POST collection object contains only the empty collection
 */

public interface CollectionInterface<E extends DataInterface<E>> extends ClonableInterface<CollectionInterface<E>> {
	
	/** Initializes the collection object to the array
	 * @precondition
	 * 		-
	 * @postcondition
	 * 		the set is empty
	 */
	void init();
	
	/** Returns whether the collection is empty
	 * @precondition
	 * 		-
	 * @postcondition
	 * 		true: the collection is empty
	 * 		false: the collection is not empty
	 */
	boolean isEmpty();
	
	/** Add identifier to collection
	 * @precondition
	 * 		Collection is not full
	 * @postcondition
	 * 		src is in collection
	 */
	void add(E src);
	
	/** Get element from collection
	 * @precondition
	 * 		Collection is not empty
	 * @postcondition
	 * 		Random element in the collection is returned
	 */
	E get();
	
	/** Delete element from collection
	 * @precondition
	 *		-
	 * @postcondition
	 * 		src is not in collection
	 */
	void delete(E src);
	
	/** Adds all identifiers of the first collection that are not equal to any identifier in the second collection to the array
	 * @precondition
	 * 		-
	 * @postcondition
	 *		only identifiers in first collection that are not equal to any identifier in second collection are returned
	**/
	Collection<E> difference(Collection<E> secondCollection);
	
	/** Adds identifiers which are in both the first and second collection to the array
	 * @precondition
	 *		-
	 * @postcondition
	 *		Equal identifiers from first and second collection are returned
	**/
	Collection<E> intersection(Collection<E> secondCollection);
	
	/** Adds identifiers of first and second collection to the array
	 * @precondition
	 *		-
	 * @postcondition
	 *		All identifiers of first and second collection are returned, but no duplicates
	**/
	Collection<E> union(Collection<E> secondCollection);
	//throws Exception
	
	/** Adds identifiers of first and second collection to the array, except identifiers which are in both collections
	 * @precondition
	 *		-
	 * @postcondition
	 *		All non-equal identifiers of first and second collection are returned
	**/
	Collection<E> symmetricDifference(Collection<E> secondCollection);
	//throws Exception

	/** Returns the amount of elements of the stack.
	 * @precondition
	 *    	-
	 * @postcondition
	 *    	The amount of elements of the stack is returned.
	 **/
	int size();
	
	/** Returns the amount of elements of the stack.
	 * @precondition
	 *    	-
	 * @postcondition
	 *    	The amount of elements of the stack is returned.
	 **/
	Collection<E> clone();
	
	/** Returns the list object inside the collection.
	 * @precondition
	 * 		-
	 * @postcondition
	 * 		The list is returned.
	 **/
	List<E> showList();
	 
}