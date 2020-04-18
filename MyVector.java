import java.util.Arrays;

/**
 * This class extends MyAbstractList and overrides its methods, as well as the methods from MyList in order
 * to properly create abstract lists of objects.
 *
 * JDK version: 11.0.3
 *
 * @author  Kyrel Polifrone || 822711442 || CS108 Section 04
 * @version 1.0.0
 * @since   04-18-2020
 */

public class MyVector<E> extends MyAbstractList<E> {

    public E[] array;
    int capacityIncrement;


    /**
     * Default constructor for MyVector, initializes the vector to a capacity of 10 elements. Size is initialized
     * to 0, and the default capacity increment is 5.
     */
    @SuppressWarnings("unchecked")
    public MyVector() {
        array = (E[]) new Object[10];
        capacityIncrement = 5;
        size = 0;
    }

    /**
     * Constructor for MyVector, gets the initial capacity of the vector from the parameter. Size is initialized
     * to 0, and the default capacity increment is 5.
     * @param initCapacity - this is the initial capacity of the vector used to initialize the capacity of it
     */
    @SuppressWarnings("unchecked")
    public MyVector(int initCapacity) {
        array = (E[]) new Object[initCapacity];
        capacityIncrement = 5;
        size = 0;
    }

    /**
     * Constructor for MyVector, takes the initial capacity of the vector and the capacity increment. Size is
     * initialized to 0.
     * @param initCapacity - this is the initial capacity of the vector used to initialize the capacity of it
     * @param increment - this is the amount of capacity the vector will increment by whenever it runs out of
     *                  available locations to store data.
     */
    @SuppressWarnings("unchecked")
    public MyVector(int initCapacity, int increment) {
        array = (E[]) new Object[initCapacity];
        capacityIncrement = increment;
        size = 0;
    }
    /**
     * For all of the constructors, size is declared to 0 because when created, the vectors contain no data, thus
     * the size is 0. The vector capacity is the amount it is currently initialized to.
     */

    /**
     * Adds an element to the location specified and shifts all the following elements by one. If the vector is at
     * max capacity, it will increment the capacity. Size of the vector increases by 1 each time this method is called.
     * @param index - index at which the specified element is to be inserted
     * @param data - element to be inserted
     * @return - returns true since if the code makes it to the end of the method, the element was added successfully
     * @throws IndexOutOfBoundsException - if the index is not a valid location in the vector, an exception is thrown
     */
    @Override
    public boolean add(int index, E data) throws IndexOutOfBoundsException {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException(); // makes sure the index is valid
        }

        if (size() >= getCapacity()) {
            array = Arrays.copyOf(array, array.length + capacityIncrement);
        } // if the size of the vector is the same as the capacity, a new vector is created with additional capacity

        for (int i = 0; i < size()-1; i++) {
            array[size-i] = array[size-i-1];
        }
        array[index] = data;
        size++;

        return true;
    }

    /**
     * Appends an element to the end of the vector. If the size of the vector is equal to capacity, the vector is
     * recreated with additional capacity.
     * @param data - element to be appended
     * @return - returns true since if the code makes it to the end of the method, the element was added successfully
     */
    @Override
    public boolean add(E data) {

        array[size] = data;
        if (size() >= getCapacity()) {
            array = Arrays.copyOf(array, array.length + capacityIncrement);
        }

        array[size()-1] = data;
        size++;
        return true;
    }

    /**
     * Clears the vector
     */
    @Override
    public void clear() {
        Arrays.fill(array, null);
        size = 0;
    }

    /**
     * A getter which receives the element at a certain index
     * @param index - the element's index to get
     * @return - returns the element
     */
    @Override
    public E get(int index) {
        return array[index];
    }

    /**
     * Checks if the vector is empty
     * @return isEmpty - a boolean which will be true of the vector is empty
     */
    @Override
    public boolean isEmpty() {
        boolean isEmpty = true;
        if (getCapacity() > 0) { // if capacity is 0, no reason to check if it is filled
            for (int i = 0; i < array.length; i++) {
                if (array[i] != null) {
                    isEmpty = false;
                    break; // checks each element in the vector, if any do not equal null, isEmpty equals false
                }
            }
        }
        return isEmpty;
    }

    /**
     * Removes an element from the vector. When this is done, the size is decreased, and the elements following the
     * removed index are shifted over by one.
     * @param index - index of the element to be removed
     * @return elementRemoved - this is the element that has been removed from the vector
     * @throws IndexOutOfBoundsException
     */
    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        E elementRemoved = array[index];
        for (int i = index; i < size()-1; i++) {
            array[i] = array[i+1];
        }
        array[size()-1] = null;
        size--;
        return elementRemoved;
    }

    /**
     * Removes any null data from the end of the vector.
     */
    @Override
    public void trimToSize() {
        if (size < getCapacity()) {
            array = Arrays.copyOf(array, size);
        }
    }

    /**
     * Determines the size of the vector
     * @return listSize - size of the list
     */
    @Override
    public int size() {
        int vectorSize = 0;
        while (vectorSize < getCapacity()) {
            if (array[vectorSize] == null) {
                break; // parses through vector and for each non-null element, it adds 1 to the size.
            }
            vectorSize++;
        }
        return vectorSize;
    }

    /**
     * Formats the vector in an array format: [index 0, index 1, ... , index(size-1)]
     * @return stringVector - a string representation of the vector
     */
    @Override
    public String toString() {
        String stringVector = "[";
        for (int i = 0; i < size()-1; i++) {
            if (array[i] == null) {
                break;
            }
            stringVector += array[i] + ", ";
        }
        stringVector += array[size()-1] + "]";
        return stringVector;
    }

    /**
     * Getter for the capacity of the vector
     * @return - array.length is the same as the capacity of the vector
     */
    public int getCapacity() {
        return array.length;
    }

    /**
     * Getter for the capacity increment
     * @return capacityIncrement - capacity increment specified when initializing the vector
     */
    public int getIncrement() {
        return capacityIncrement;
    }
}
