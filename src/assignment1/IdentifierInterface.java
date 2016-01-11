package assignment1;

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

public interface IdentifierInterface {
	
	/** Initializes the identifier object to the ...
	 * @precondition
	 * 		-
	 * @postcondition
	 * 		identifier contains only character c
	 */
	void init (char c);

	/** Adds character to identifier
	 * @precondition
	 * 		-
	 * @postcondition
	 * 		Character is in the identifier object
	 */
	void add(char c);

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
	boolean equals(Identifier src) ;
	
	/** 
	 * @precondition
	 * 		-
	 * @postcondition
	 * 		
	 */
	int length() ;
	
	

	
	
}





