

import static org.junit.Assert.*;

import org.junit.Test;

public class RemoveDuplicatesTest {
	
	@Test
	public void noElement(){
		System.out.println("Test for no element in array");
		int[] input = {};
		int[] expected = RemoveDuplicates.removeDuplicates(input);
		assertEquals("no  elements",input,expected);
	}
	
	@Test
	public void singleElement(){
		System.out.println("Test for single element in array");
		int[] input = {5};
		int[] expected = RemoveDuplicates.removeDuplicates(input);
		assertEquals("one element",input,expected);
	}
	
	@Test
	public void validInput(){
		System.out.println("Test for valid array");
		int[] input = {2,5,4,6,3,8,5,9,3,3,6,3,9,0};
		int[] result = RemoveDuplicates.removeDuplicates(input);
		int[] expected = {0,2,3,4,5,6,8,9};
		assertArrayEquals(expected,result);
	}

}
