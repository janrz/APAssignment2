package assignment2;

public interface ClonableInterface<E> extends Cloneable {

    /* In order to be able to use clone() everywhere is is overridden with
       a public version.
    */
	/** @precondition  -
	 *	@postcondition - A deep-copy of clone has been returned.
	 **/
    public E clone();

}