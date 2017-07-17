import static org.junit.Assert.*;

import org.junit.Test;

// class to test the functioning of wholePyramid method 
// of DiamondPyramid class
public class DiamondPyramidTest
{
	// test case for valid input
	@Test
	public void testWholePyramid() 
	{
		// initializing the resultant string array
		String[] result = {"    1    ","   121   ","  12321  "," 1234321 ","123454321"," 1234321 ","  12321  "
				           ,"   121   ","    1    "};
		
		// stores the resultant string array
		String[] expected=DiamondPyramid.wholePyramid(5);
		
		// compares both string arrays
		assertArrayEquals(expected,result);
	}
	
	// test case for invalid input
	@Test
	public void testInvalidInput()
	{
		String[] result = {"invalid input"};
		String[] expected=DiamondPyramid.wholePyramid(-2);
		
		// compares result and expected string arrays
		assertArrayEquals(expected,result);
	}


}
