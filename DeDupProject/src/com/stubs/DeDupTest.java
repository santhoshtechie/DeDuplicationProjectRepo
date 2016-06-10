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
    
	/**This method will provide an input array with duplicate values and expects an array with no duplicates
	 * Test method for {@link com.stubs.DeDup#removeDuplicateUsingSet(int[])}.
	 */
	@Test
	public void testRemoveDuplicateUsingSet() {
		log.info("DeDupTest:testRemoveDuplicateUsingSet: Test Case Started");
		int[] inputArray = {1,2,3,3, 4,5};
	    int[] expectedArray = {1,2,3,4,5};
		DeDup deDuplicateObject = new DeDup();
		Object[] returnArrayObj = deDuplicateObject.removeDuplicateUsingSet(inputArray);
		int[] returnArray = new int[expectedArray.length];
		for(int iCount = 0; iCount < returnArrayObj.length;iCount++){
			returnArray[iCount] = Integer.parseInt(returnArrayObj[iCount].toString());
			if (log.isDebugEnabled()) {
				log.debug("Array Value:"+ returnArray[iCount]);
		    }
		}
		//invoking AssertArrayEquals method.
		assertArrayEquals(expectedArray,returnArray);
		log.info("DeDupTest:testRemoveDuplicateUsingSet: Test Case Completed");
	}

	/**
	 * This method will provide an input array with duplicate values and expects an array with no duplicates
	 * Test method for {@link com.stubs.DeDup#removeDuplicateUsingLinkedList(int[])}.
	 */
	@Test
	public void testRemoveDuplicateUsingLinkedList() {
		log.info("DeDupTest:testRemoveDuplicateUsingLinkedList: Test Case Started");
		int[] inputArray = {10,1,2,3,3, 4,5};
	    int[] expectedArray = {10,1,2,3,4,5};
		DeDup deDuplicateObject = new DeDup();
		Object[] returnArrayObj = deDuplicateObject.removeDuplicateUsingLinkedList(inputArray);
		int[] returnArray = new int[expectedArray.length];
		for(int iCount = 0; iCount < returnArrayObj.length;iCount++){
			returnArray[iCount] = Integer.parseInt(returnArrayObj[iCount].toString());
			if (log.isDebugEnabled()) {
				log.debug("Array Value:"+ returnArray[iCount]);
		    }
		}
		//invoking AssertArrayEquals method.
		assertArrayEquals(expectedArray,returnArray);
		log.info("DeDupTest:testRemoveDuplicateUsingLinkedList: Test Case Completed");
	}

	/**
	 * This method will provide an input array with duplicate values and expects an array with no duplicates
	 * Test method for {@link com.stubs.DeDup#removeDuplicateBySorting(int[])}.
	 */
	@Test
	public void testRemoveDuplicateBySorting() {
		log.info("DeDupTest:testRemoveDuplicateBySorting: Test Case Started");
		int[] inputArray = {10,1,1,3,3, 4,5};
	    int[] expectedArray = {1,3,4,5,10};
		DeDup deDuplicateObject = new DeDup();
		Object[] returnArrayObj = deDuplicateObject.removeDuplicateUsingSet(inputArray);
		int[] returnArray = new int[expectedArray.length];
		for(int iCount = 0; iCount < returnArrayObj.length;iCount++){
			returnArray[iCount] = Integer.parseInt(returnArrayObj[iCount].toString());
			if (log.isDebugEnabled()) {
				log.debug("Array Value:"+ returnArray[iCount]);
		    }
		}
		//invoking AssertArrayEquals method.
		assertArrayEquals(expectedArray,returnArray);
		log.info("DeDupTest:testRemoveDuplicateBySorting: Test Case Completed");
	}

}
