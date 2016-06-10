/**
 * 
 */
package com.stubs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Santhosh Mani
 * De-duplication in Array Project Implementation Class
 */

public class DeDup {
   
	private static Log log = LogFactory.getLog(DeDup.class);
    
   //Class Level Variable to provide the input set of data
	public int[] randomIntegers = {1,2,34,34,25,1,45,3,26,85,4,34,86,25,43,2,1,10000,11,16,19,1,18,4,9,3,

            20,17,8,15,6,2,5,10,14,12,13,7,8,9,1,2,15,12,18,10,14,20,17,16,3,6,19,

            13,5,11,4,7,19,16,5,9,12,3,20,7,15,17,10,6,1,8,18,4,14,13,2,11};  


	/**
	 * Main Method to invoke any of the three implementation whic will take an array of integer and remove duplicates
	 * @param args
	 * The main method can be enhanced in the future to accept array as arg 
	 */
	public static void main(String ...args) {
		log.info("DeDup:Start Program");
		//create an instance of DeDup class
		DeDup dupClassInstance = new DeDup();
		log.debug("DeDup:Calling Print Array Method");
		try{
			dupClassInstance.printArray();
		}catch(Exception e){
			log.error("Exception Occured when calling PrintArray");
			e.printStackTrace();
		}
		log.info("DeDup: End Program");
	}

	/**
	 * Method: Used to print the Array which contains unique data When this
	 * method is invoked from main method or externally it runs one of the
	 * implementations to remove duplicate in array. Currently this takes the
	 * input int array from the hardcoded value in the class. This can be
	 * further enchanced if required
	 */
	public void printArray(){
		final long processedStartTime = System.currentTimeMillis();
		final DeDup dupClassInstance = new DeDup();
		log.debug("DeDup:Calling the method to return array with unique elements");
		//Passing the randomIntegers from the Class variable. Hence not declaring the method static. 
		//randomIntegers is mentioned non static in requirement
		final Object [] uniqueObjArray = dupClassInstance.removeDuplicateUsingSet(dupClassInstance.randomIntegers);
		
		//Uncomment for invoking Implementation 2
		//final Object [] uniqueObjArray = dupClassInstance.removeDuplicateUsingLinkedList(randomIntegers);
		//Uncomment for invoking Implementation 3
		//final Object [] uniqueObjArray = dupClassInstance.removeDuplicateBySorting(randomIntegers);
		log.info("Elements in input Array printed Below:");
		for (int iCount = 0; iCount <uniqueObjArray.length; iCount++){
			if (log.isInfoEnabled()) {
				log.info(" "+ uniqueObjArray[iCount]);
			    }
			
		}
		long processedEndTime = System.currentTimeMillis();
		final long totalProcessTime =  processedEndTime - processedStartTime;
		if (log.isInfoEnabled()) {
			log.info("DeDup:Print Array process completed in "+totalProcessTime+" milliseconds");
		    }
	}
	

	/**Method: Used to return Array without duplicates by using Set Implementation
	 * <p><b>Use Cases:</b>
	 * This implementation can be used when the following is priority. Insertion order
	 * is not important. Faster performance is required. When data set is small.
	 * <p><b>Advantages:</b><p>
	 * Objects are sorted for fast lookup. Performance is good. Easy to code(less LOC)
	 * <p><b>Disadvantages:</b><p>
	 * It does not guarantee that the order will remain constant over time.
	 * This implementation is not synchronized.
	 * This can be improvised by using synchronized set.
	 *  
	 * @param randomIntegers
	 * Accepts int Array
	 * @return Object Array
	 */
	public Object [] removeDuplicateUsingSet (final int[] randomIntegers){
		final long processStartTime = System.currentTimeMillis();
		log.info("Remove Duplicate Array Data Using Set Implementation");
		log.debug("DeDup:Start RemoveDuplicateUsingSet Method");
		//Creating an HashSet which will remove Duplicate Elements in Array
		Set<Integer> deDupSet = new HashSet<Integer>();
		try{
			//Iterating the input Array and adding to the Set
			for(int iCount = 0; iCount<randomIntegers.length; iCount++){
				deDupSet.add(randomIntegers[iCount]);
			}
		}catch (NullPointerException ne){
			//Catching Null Pointer Exception - This can occur when input array is null
			log.error("Null Pointer Exception Occured in removeDuplicateUsingSet method");
			ne.printStackTrace();
		}catch (Exception e){
			//Catching Other Exception
			log.error("Exception Occured at removeDuplicateUsingSet method");
			e.printStackTrace();
			
		}
		long processEndTime = System.currentTimeMillis();
		final long totalProcessTime = processEndTime - processStartTime;
		if (log.isInfoEnabled()) {
			log.info("DeDup:removeDuplicateUsingSet Method: Execution Completed in :"+totalProcessTime+" milliseconds");
		    }
		//returning Array of unique Elements
		return deDupSet.toArray();
	}
	
	/**Method: Used to return Array without duplicates by using LinkedList Implementation
	 * <p><b>Use Cases:</b>
	 * This implementation can be used when the following is priority.
	 * When the input data set is not constant and it can grow. Order of elements need to be maintained during 
	 * retrieval. 
	 * <p><b>Advantages:</b><p>
	 * Linked List is dynamic data structure. Efficient Memory Usage. As there is no need to allocate memory. Memory
	 * will be allocated at runtime. Elements can be accessed faster.
	 * <p><b>Disadvantages:</b><p>
	 * No random access of the data elements.
	 * More memory is utilized per data type.
	 *  
	 * @param randomIntegers
	 * Accepts int Array
	 * @return Object Array
	 */
	public Object[] removeDuplicateUsingLinkedList (final int[] randomIntegers){
		long processStartTime = System.currentTimeMillis();
		log.info("Remove Duplicate Array Data Using LinkedList Implementation");
		log.debug("DeDup:Start removeDuplicateUsingLinkedList Method");
		//Creating Linked List Object
		LinkedList<Integer>  list = new LinkedList<Integer>();
		//Iterating the input int Array
		try{
			for(int iCount = 0; iCount < randomIntegers.length; iCount++){
			/*	This code of will check if the int array contains the element.
				If not add the LinkedList. This will retain the order in which the element is inserted into the List*/
				if(!list.contains(randomIntegers[iCount])){
					list.addLast(randomIntegers[iCount]);
				}
			}
		} catch (NullPointerException ne){
			//Catching Null Pointer Exception - This can occur when input array is null
			log.error("Null Pointer Exception Occured in removeDuplicateUsingLinkedList method");
			ne.printStackTrace();
		}catch (Exception e){
			//Catching Other Exception
			log.error("Exception Occured at removeDuplicateUsingLinkedList method");
			e.printStackTrace();
			
		}
		long processEndTime = System.currentTimeMillis();
		final long totalProcessTime = processEndTime - processStartTime;
		 if (log.isInfoEnabled()) {
			 log.info("DeDup:removeDuplicateUsingLinkedList Method: Execution Completed in :"+totalProcessTime+" milliseconds");
		    }
		//returning Array of unique Elements
		return list.toArray();	
	}
	
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
	 * Accepts int Array
	 * @return Object Array
	 */
	public Object[] removeDuplicateBySorting (final int[] randomIntegers){
		long processStartTime = System.currentTimeMillis();
		log.info("Remove Duplicate Array Data Using TreeSet Implementation");
		log.debug("DeDup:Start removeDuplicateBySorting Method");
		//Creating SortedSet Object
		SortedSet<Integer> sortSet = new TreeSet<Integer>();
		try{
			//Iterating the input Array and adding to the Set
			for(int iCount = 0; iCount<randomIntegers.length; iCount++){
				sortSet.add(randomIntegers[iCount]);
			}
		}catch (NullPointerException ne){
			//Catching Null Pointer Exception - This can occur when input array is null
			log.error("Null Pointer Exception Occured in removeDuplicateBySorting method");
			ne.printStackTrace();
		}catch (Exception e){
			//Catching Other Exception
			log.error("Exception Occured at removeDuplicateBySorting method");
			e.printStackTrace();
			
		}
		long processEndTime = System.currentTimeMillis();
		final long totalProcessTime = processEndTime - processStartTime;
		if (log.isInfoEnabled()) {
			log.info("DeDup:removeDuplicateBySorting Method: Execution Completed in :"+totalProcessTime+" milliseconds");
		    }
		//returning Array of unique Elements
		return sortSet.toArray();
	}

}
