/**
 * This abstract class defines MyAbstractList and contains a few methods for it
 *
 * JDK version: 11.0.3
 *
 * @author  Kyrel Polifrone || 822711442 || CS108 Section 04
 * @version 1.0.0
 * @since   04-18-2020
 */

public abstract class MyAbstractList<E> implements MyList<E> {

	protected int size;

	/**
	 * Default constructor for MyAbstractList
	 */
	public MyAbstractList() {
	}

	/**
	 * Checks if the size of an object is 0
	 * @return - returns a boolean for if the size of the object which is being called is 0
	 */
	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	/**
	 * Checks the size of a object list
	 * @return - returns the size of the object list.
	 */
	@Override
	public int size() {
		return this.size;
	}

}