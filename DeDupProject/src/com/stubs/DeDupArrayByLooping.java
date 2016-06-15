/**
 * 
 */
package com.stubs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Santhosh Mani
 * De-duplication in Array Project Implementation Class
 */
public class DeDupArrayByLooping implements IArrayOperation {
	private static Log log = LogFactory.getLog(DeDupArrayByLooping.class);

	/**
	 * Method: Used to return Array without duplicates by using Looping and
	 * Iterator Implementation This will give array with unique elements and
	 * preserve the order of elements
	 * <p>
	 * <b>Use Cases:</b> When the order of the array is required to be
	 * maintained. When we need array of unique data.
	 * <p>
	 * <b>Advantages:</b>
	 * <p>
	 * Easy to Code We can get an ordered array elements Retrieval is easy as we
	 * know the position of elements
	 * <p>
	 * <b>Disadvantages:</b>
	 * <p>
	 * Performance is less. Takes longer as the data set increases
	 * 
	 * @param randomIntegers
	 *            Accepts int Array
	 * @return Object Array
	 */
	@Override
	public Object[] removeDuplicateInArray(int[] randomIntegers) {
		long processStartTime = System.currentTimeMillis();
		if (log.isInfoEnabled()){
			log.info("Start Process");
		}
		if (randomIntegers.equals(null))
			throw new RuntimeException();
		List<Object> outputList = null;
		try {
			List<Integer> inputList = new ArrayList<Integer>(randomIntegers.length);
			for (int iValue : randomIntegers)
				// Adding the elements to input ArrayList
				inputList.add(iValue);
			outputList = new ArrayList<Object>();
			for (Iterator<Integer> iIterate = inputList.iterator(); iIterate.hasNext();) {
				Object next = iIterate.next();
				// If outputList doesn't have the element then insert it
				if (!outputList.contains(next)) {
					outputList.add(next);
				} else {
					iIterate.remove();
				}
			}
			if (log.isInfoEnabled()){
				log.info("End Process");
			}
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		if (log.isInfoEnabled()){
			log.info("DeDuplication Process Completed in "
					+ (System.currentTimeMillis() - processStartTime) + " milliseconds");
		}
		// returning Array of unique Elements
		return outputList.toArray();
	}

}
