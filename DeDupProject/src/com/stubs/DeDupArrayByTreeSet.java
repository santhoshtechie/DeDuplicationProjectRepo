/**
 * 
 */
package com.stubs;

import java.util.SortedSet;
import java.util.TreeSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Santhosh Mani
 * De-duplication in Array Project Implementation Class
 */
public class DeDupArrayByTreeSet implements IArrayOperation {
	private static Log log = LogFactory.getLog(DeDupArrayByTreeSet.class);
	/**Method: Used to return Array without duplicates by using TreeSet Implementation
	 * This will give a sorted array with unique elements
	 * <p><b>Use Cases:</b>
	 * When the order of the array is not required to be maintained. 
	 * When we need a sorted array of unique data.
	 * <p><b>Advantages:</b><p>
	 * Ordered Collection which can give data in ascending order. Does not allow duplicates
	 * <p><b>Disadvantages:</b><p>
	 * Memory Overhead, Decreased Performance
	 *  
	 * @param randomIntegers
	 * Accepts int Arrays
	 * @return Object Array
	 */
	@Override
	public Object[] removeDuplicateInArray(int[] randomIntegers){
		long processStartTime = System.currentTimeMillis();
		if (log.isInfoEnabled()){
		log.info("Start Process");
		}
		if (randomIntegers.equals(null))
			throw new RuntimeException();
		//Creating SortedSet Object
		SortedSet<Integer> sortSet = new TreeSet<Integer>();
		try{
			//Iterating the input Array and adding to the Set
			for(int eachElement:randomIntegers)
				sortSet.add(eachElement);
			/*for(int iCount = 0; iCount<randomIntegers.length; iCount++){
				sortSet.add(randomIntegers[iCount]);
			}*/
			if (log.isInfoEnabled()) {
				log.info("End Process");
			}
			
		}catch (Exception e){
			throw new RuntimeException(e);	
		}
		if (log.isInfoEnabled()){
			log.info("DeDuplication Process Completed in  :"+(System.currentTimeMillis()-processStartTime)+" milliseconds");
		}
		//returning Array of unique Elements
		return sortSet.toArray();
	}

}
