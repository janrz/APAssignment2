package assignment2;

/** ADT for the class Number
 * 
 * @author Nousha van Dijk & Jan Rezelman
 * @elements
 * 		number
 * @structure
 * 		linear
 * @domain
 * 		Number()
 * 		PRE
 * 		POST object contains natural number
 */

public interface NumberInterface extends DataInterface<NumberInterface>{
	
	/** Initializes the number object to the ...
	 * @precondition
	 * 		-
	 * @postcondition
	 * 		natural number is zero
	 */
	void init();

	/** Changes the natural number into the number
	 * @precondition
	 * 		-
	 * @postcondition
	 * 		number is natural number
	 */
	void add(int Number);

	/** Returns natural number
	 * @precondition
	 * 		-
	 * @postcondition
	 * 		natural number is returned
	 */
	StringBuffer get(); 
	
}