package IntList;

/**
* @author 	Gustaf Nislstadius
* @version 	1.0
* @since	2015-01-21
*/
public class IntList {
	
	private int[] intArray;
	private int maxSize, currentSize;
	
	/**
	 * Initialize with given size
	 * 
	 * @param initialCapacity  Initial size of internal array
	 */
	public IntList (int initialCapacity) throws Exception{
		if (initialCapacity< 1){
			throw new Exception("Initial Capacity to low");
		}
		intArray = new int[initialCapacity];
		maxSize = initialCapacity; currentSize = 0;
	}
	
	/**
	 * Initialize with standard (10) size
	 * 
	 */
	public IntList () throws Exception{
		int initialCapacity = 10;
		intArray = new int[initialCapacity];
		maxSize = initialCapacity; currentSize = 0;
	}
	
	/**
	 * Add element at end of list
	 * 
	 * @param element  The integer to be added to end of list 
	 * @return  True if element was added 
	 */
	public boolean add(int element){
		if((currentSize) >= maxSize){
			realloc();
		}
		intArray[currentSize++] = element;
		return true;
	}
	
	/**
	 * Add element at specific index in list
	 * 
	 * @param index  Index to add the element
	 * @param element  The integer to be added at index 
	 * @return  True if element was added
	 */
	public boolean add(int	index, int element){
		if(index > currentSize){
			return false;
		} else if((currentSize+1) >= maxSize){
			realloc();
		}
		
		if(index!=currentSize){
			move(index, 1);
		}

		intArray[index] = element;
		currentSize++;
		return true;
	}
	
	/**
	 * Returns element at index
	 * 
	 * @param index  Index to return
	 * @return  The int at index
	 */
	public int get(int	index){
		if(index < currentSize){
			return intArray[index];
		}
		return -1;
	}
	
	/**
	 * Removes int at index 
	 * 
	 * @param index  The index to be removed
	 * @return  True if index is removed
	 */
	public boolean remove(int index){
		if(index >= currentSize){
			return false;
		} else {
			System.arraycopy(intArray, index+1, intArray, index, intArray.length-index-1);
			currentSize--;
			return true;
		}
	}
	
	/**
	 * Search the list and return the index of first occurrence 
	 * 
	 * @param element  The int to search for
	 * @return  The index of first occurrence of element, -1 is not found
	 */
	public int indexOf(int	element){
		for (int i = 0; i < currentSize; i++) {
			if(intArray[i] == element){
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Set index to element 
	 * 
	 * @param index
	 * @param element
	 * @return  True if set
	 */
	public boolean set(int	index, int element){
		if(index >= currentSize){
			return false;
		} else {
			intArray[index] = element;
			return true;
		}
	}
	
	/**
	 * The current number of elements in the list
	 * 
	 * @return  The current number of elements in the list
	 */
	public int size() {
		return currentSize;
	}

	/**
	 * Moves the array a given i amount of steps from index
	 * <p>
	 * Creates a gap with the size of i from index.
	 * No data is lost while moving.
	 * 
	 * @param index  Index from where to start create gap
	 * @param i  Size of gap
	 */
	private void move(int index, int i) {
		int[] tmpIntArray = new int[intArray.length+i];
		if(!(index-i <= 0)){
			System.arraycopy(intArray, 0, tmpIntArray, 0, index);
		}
		System.arraycopy(intArray, index, tmpIntArray, index+i, intArray.length-index);
		intArray = tmpIntArray;
	}

	/**
	 * Reallocates The internal array to a a larger size.
	 */
	private void realloc() {
		maxSize*=2;
		int[] tmpIntArray = new int[maxSize];
		System.arraycopy(intArray, 0, tmpIntArray, 0, intArray.length);
		intArray = tmpIntArray;
		
	}
	
	/**
	 * 
	 * @return  A string with all the elements listed. Beginning -> End
	 */
	public String toString(){
		String ret = new String();
		for (int i = 0; i < currentSize; i++) {
			ret+= intArray[i] + ", ";		
		}
		return ret;
	}
}
