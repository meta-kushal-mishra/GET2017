import static org.junit.Assert.*;

import org.junit.Test;


public class MergeSortedArraysTest {
	
	@Test
	public void noElement(){
		System.out.println("Test for no element in arrays");
		int[] input1 = {};
		int[] input2 = {};
		int[] merged = new int[input1.length+input2.length];
		int[] expected = MergeSortedArrays.mergeArrays(input1,input2,input1.length,input2.length,merged);
		assertArrayEquals(input1,expected);
	}
	
	@Test
	public void singleElement(){
		System.out.println("Test for single element in array");
		int[] input = {5};
		int[] expected = RemoveDuplicates.removeDuplicates(input);
		assertEquals("one element",expected,expected);
	}
	
	@Test
	public void validInput(){
		System.out.println("Test for valid array");
		int[] input1 = {1,3,5,7};
		int[] input2 = {2,3,4,6};
		int[] merged = new int[input1.length+input2.length];
		int[] expected = {1,2,3,4,5,6,7};
		int[] result = MergeSortedArrays.mergeArrays(input1,input2,input1.length,input2.length,merged);
		assertArrayEquals(expected,result);
	
	}

}