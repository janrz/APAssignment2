package assignment2;

/**	
 * @author Nousha van Dijk & Jan Rezelman
 * @elements : objects of type E
 * @structure : linear
 * @domain : 	The elements in the list are sorted monotonically increasing. 
 *				All rows of elements of type E are valid values for a list.
 *       		For every non-empty list the reference current is pointing to an 
 *				element in the list.
 *	@constructor - List();
 *	<dl>
 *		<dt><b>PRE-condition</b><dd>		-
 *		<dt><b>POST-condition</b><dd> 	The new List-object is the empty list.
 * </dl>
 **/

public interface DataInterface<E> extends ClonableInterface<E>, Comparable<E> {
	
	/**	@precondition -
	 *  @postcondition - ordening has been defined
	 **/
	
	/**	@precondition -
	 *  @postcondition - clone is made
	 **/

	
    /*
       This interface defines a type on which an ordening has been defined
       by compareTo() and from which copies can be made with clone().
    */

}


