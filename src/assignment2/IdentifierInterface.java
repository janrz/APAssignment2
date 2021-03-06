package assignment2;

/** ADT for the class Identifier
 * 
 * @author Nousha van Dijk & Jan Rezelman
 * @elements
 * 		alphanumeric characters 
 * @structure
 * 		linear
 * @domain
 * 		identifiers 1-infinity
 * 
 * 		identifier()
 * 		PRE
 * 		POST identifier object contains only the empty identifiers
 * 		identifier (identifier src);
 * 		PRE
 * 		POST identifier object contains copy of src
 */

public interface IdentifierInterface extends DataInterface<IdentifierInterface>{
	
	/** Initializes the identifier object to the ...
	 * @precondition
	 * 		-
	 * @postcondition
	 * 		identifier contains identifierString
	 */
	void init ();

	/** Adds character to identifier
	 * @precondition
	 * 		-
	 * @postcondition
	 * 		Character is in the identifier object
	 */
	void add(String input);

	/** Get identifier
	 * @precondition
	 * 		-
	 * @postcondition
	 * 		identifier is returned
	 */
	String get();
	
	/** Compare identifiers
	 * @precondition
	 * 		-
	 * @postcondition
	 * 		true: identifiers are equal
	 * 		false: identifiers are not equal
	 */
	boolean compareTo(Identifier src) ;
	
}
