/**
 * 
 */
package com.stubs;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Santhosh Mani
 * De-duplication in Array Project Implementation Class
 */
public class DeDupArrayBySortAndRetrieve implements IArrayOperation {
	private static Log log = LogFactory.getLog(DeDupArrayBySortAndRetrieve.class);
	/**
	 * Method: This is kind of brute force approach to return Array without
	 * duplicates by comparing the element with other elements and moving the
	 * element towards the beginning of the array. The size of unique elements is
	 * maintained in a variable and after the segregation of array the unique
	 * elements are returned by iterating the array until the size. This will give
	 * array with unique elements.
	 * <p>
	 * <b>Use Cases:</b> When the requirement is not to use Collection implementation
	 * for identifying the duplicates. When we need array of unique data.
	 * <p>
	 * <b>Advantages:</b>
	 * <p>
	 * The appproach is faster in execution and consumes less object memory and runtime.
	 * <p>
	 * <b>Disadvantages:</b>
	 * <p>
	 * More lines of code and lot of looping constructs is used
	 * This modifies the input array. Also we can't delete the array elements
	 * @param randomIntegers
	 * Accepts int Array
	 * @return Object Array
	 */
	public Object[] removeDuplicateInArray(int[] randomIntegers) {
		List<Integer> outputList = null;
		long processStartTime = System.currentTimeMillis();
		if (log.isInfoEnabled()){
			log.info("Start Process");
		}
		if (randomIntegers.equals(null))
			throw new RuntimeException();
		outputList = new ArrayList<Integer>(randomIntegers.length);
		try {
			int Asize = randomIntegers.length;
			for (int currentElement = 0; currentElement <= Asize; currentElement++) {
				for (int nextElement = currentElement + 1; nextElement <= Asize; nextElement++) {
					if (randomIntegers[currentElement] == randomIntegers[nextElement]) {
						randomIntegers[nextElement] = randomIntegers[Asize - 1];
						Asize--;
					}
				}
			}
			//Asize determines fetching only unique values
			for (int iCount = 0; iCount < Asize; iCount++) {
				outputList.add(randomIntegers[iCount]);
			}

			if (log.isInfoEnabled()) {
				log.info("End Process");
			}
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		if (log.isInfoEnabled()){
			log.info("DeDuplication Process Completed in  :"+(System.currentTimeMillis()-processStartTime)+" milliseconds");
		}
		//returning Array of unique Elements
		return outputList.toArray();
	}
}
