/**
 * 
 */
package com.stubs;

import static org.junit.Assert.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.*;

/**
 * @author Santhosh Mani
 * De-duplication in Array Project JUNIT Implementation Class
 */
public class DeDupTest {
    private static Log log = LogFactory.getLog(DeDupTest.class);
    public static int[] randomIntegers = {1,2,34,34,25,1,45,3,26,85,4,34,86,25,43,2,1,10000,11,16,19,1,18,4,9,3,

            20,17,8,15,6,2,5,10,14,12,13,7,8,9,1,2,15,12,18,10,14,20,17,16,3,6,19,

            13,5,11,4,7,19,16,5,9,12,3,20,7,15,17,10,6,1,8,18,4,14,13,2,11};

	/**This method will provide an input array with duplicate values and expects an array with no duplicates
	 * Test method for DeDupArrayByLooping Implementation
	 */
	@Test
	public void testImplementation1() {
		if (log.isInfoEnabled())
		log.info("testImplementation1: Test Case Started");
		//Knowing the unique elements count is 28
		int[] expectedArray = new int[] {1,2,34,25,45,3,26,85,4,86,43,10000,11,16,19,18,9,20,17,8,15,6,5,10,14,12,13,7};
		IArrayOperation loopingObj = new DeDupArrayByLooping();
		Object[] uniqueObjArray1  = loopingObj.removeDuplicateInArray(randomIntegers);
		
		int[] returnArray = new int[expectedArray.length];
		for(int iCount = 0; iCount < uniqueObjArray1.length;iCount++){
			returnArray[iCount] = Integer.parseInt(uniqueObjArray1[iCount].toString());
		}
		//invoking AssertArrayEquals method.
		assertArrayEquals(expectedArray,returnArray);
		if (log.isInfoEnabled()){
		log.info("testImplementation1: Test Case Completed");
		}
	}

	/**
	 * This method will provide an input array with duplicate values and expects an array with no duplicates
	 * Test method for DeDupArrayBySortAndRetrieve Implementation
	 */
	@Test
	public void testImplementation2() {
		if (log.isInfoEnabled()){
		log.info("testImplementation2: Test Case Started");
		}
		//Knowing the unique elements count is 28
		int[] expectedArray = new int[]{ 1,2,34,10,25,11,45,3,26,85,4,17,86,20,43,18,8,10000,9,16,19,13,6,12,15,5,14,7 };
		IArrayOperation sortAndRetrieveObj = new DeDupArrayBySortAndRetrieve();
		Object[] uniqueObjArray2  = sortAndRetrieveObj.removeDuplicateInArray(randomIntegers);
		
		int[] returnArray = new int[expectedArray.length];
		for(int iCount = 0; iCount < uniqueObjArray2.length;iCount++){
			returnArray[iCount] = Integer.parseInt(uniqueObjArray2[iCount].toString());
		}
		//invoking AssertArrayEquals method.
		assertArrayEquals(expectedArray,returnArray);
		if (log.isInfoEnabled()){
		log.info("testImplementation2: Test Case Completed");
		}
	}

	/**
	 * This method will provide an input array with duplicate values and expects an array with no duplicates
	 * Test method for testImplementation3 method
	 */
	@Test
	public void testImplementation3() {
		if (log.isInfoEnabled()){
		log.info("testImplementation3: Test Case Started");
		}
		//Knowing the unique elements count is 28
		int[] expectedArray = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,25,26,34,43,45,85,86,10000};
		IArrayOperation treeSetObj = new DeDupArrayByTreeSet();
		Object[] uniqueObjArray3 =   treeSetObj.removeDuplicateInArray(randomIntegers);
		
		int[] returnArray = new int[expectedArray.length];
		for(int iCount = 0; iCount < uniqueObjArray3.length;iCount++){
			returnArray[iCount] = Integer.parseInt(uniqueObjArray3[iCount].toString());
		}
		//invoking AssertArrayEquals method.
		assertArrayEquals(expectedArray,returnArray);
		if (log.isInfoEnabled()){
		log.info("testImplementation3: Test Case Completed");
		}
	}

}
