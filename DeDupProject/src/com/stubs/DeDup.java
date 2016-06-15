/**
 * 
 */
package com.stubs;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Santhosh Mani
 * De-duplication in Array Project Implementation Class
 */

public class DeDup implements IArrayOperation {
   
	private static Log log = LogFactory.getLog(DeDup.class);
	private static final String IMPLEMENTATION1 = "IMPLEMENTATION1";
	private static final String IMPLEMENTATION2 = "IMPLEMENTATION2";
	private static final String IMPLEMENTATION3 = "IMPLEMENTATION3";
    
   //Class Level Variable to provide the input set of data
	public static int[] randomIntegers = {1,2,34,34,25,1,45,3,26,85,4,34,86,25,43,2,1,10000,11,16,19,1,18,4,9,3,

            20,17,8,15,6,2,5,10,14,12,13,7,8,9,1,2,15,12,18,10,14,20,17,16,3,6,19,

            13,5,11,4,7,19,16,5,9,12,3,20,7,15,17,10,6,1,8,18,4,14,13,2,11};

	/**
	 * Main Method to invoke any of the three implementation which will take an array of integer and remove duplicates
	 * @param args
	 * The main method can be enhanced in the future to accept array as arg 
	 */
	public static void main(String ...args) {
		if (log.isInfoEnabled()){
		log.info("main:Start Program");
		}
		//create an instance of DeDup class
		DeDup dupClassInstance = new DeDup();
		try{
			//Implementaion1 using Looping logic
			IArrayOperation loopingObj = new DeDupArrayByLooping();
			Object[] uniqueObjArray1  = loopingObj.removeDuplicateInArray(randomIntegers);
			dupClassInstance.printArray(uniqueObjArray1,IMPLEMENTATION1);
			
			//Implementaion2 using sort and retrieve logic
			IArrayOperation sortAndRetrieveObj = new DeDupArrayBySortAndRetrieve();
			Object[] uniqueObjArray2  = sortAndRetrieveObj.removeDuplicateInArray(randomIntegers);
			dupClassInstance.printArray(uniqueObjArray2,IMPLEMENTATION2);
			
			//Implementation using TreeSet logic
			IArrayOperation treeSetObj = new DeDupArrayByTreeSet();
			Object[] uniqueObjArray3 =   treeSetObj.removeDuplicateInArray(randomIntegers);
			dupClassInstance.printArray(uniqueObjArray3,IMPLEMENTATION3);
		}
		catch(RuntimeException e){
			if (log.isWarnEnabled()){
			log.warn("main:Runtime Exception Occured: ",e);
			}
		}
		catch(Exception e){
			if (log.isWarnEnabled()){
			log.warn("main:Exception Occured in Main method: ",e);
			}
		}
		if (log.isInfoEnabled()){
		log.info("main: End Program");
		}
	}

	/**
	 * Method: Used to print the Array which contains unique data When this
	 * method is invoked from main method or externally it runs one of the
	 * implementations to remove duplicate in array. Currently this takes the
	 * input int array from the hardcoded value in the class. This can be
	 * further enchanced if required
	 * @param uniqueObjArray
	 * input unique Array object
	 * @param impMethod
	 * type of implementation
	 */
	public void printArray(final Object[] uniqueObjArray, String impMethod) {
		final long processStartTime = System.currentTimeMillis();
		String strArrayString = "";
		// Calling instance of DeDupArrayByLooping Implementation
		try {
			if (log.isInfoEnabled()){
				log.info("Printing Array by " + impMethod + " Method");
			}
			for(Object eachElement:uniqueObjArray)
				strArrayString = strArrayString +eachElement +",";
			if (log.isInfoEnabled()){
				log.info("Unique Array = { " + strArrayString.substring(0, strArrayString.length()-1) + " }");
				log.info("Print Array process completed in " + (System.currentTimeMillis() - processStartTime)
						+ " milliseconds");
			}

		} catch (Exception e) {
			// Throwing new unchecked exception
			throw new RuntimeException(e);
		}
	}

	@Override
	/**
	 * Method Definition for implementing Interface. Did not want to expose any
	 * business logic through this method 
	 * @param randomIntegers Accepts int
	 * Array
	 * @return Object Array
	 */

	public Object[] removeDuplicateInArray(int[] randomIntegers) {
		return null;
	}

}
