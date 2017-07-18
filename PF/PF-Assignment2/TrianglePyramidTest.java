import static org.junit.Assert.*;
import org.junit.Test;

/* class to test the functioning of wholePyramid method 
of TrianglePyramid class*/
public class TrianglePyramidTest{
	
	// test case for valid input
	@Test
	public void test(){
		
		// initializing the resultant string array
		String[] result = {"12345"," 1234","  123","   12","    1"};
		
		// stores the resultant string array
		String[] expected=TrianglePyramid.wholePyramid(5);
		
		// compares both string arrays
		assertArrayEquals(expected,result);
	}
	
	// test case for invalid input
	@Test
	public void testInvalidInput() {
		String[] result = {"invalid input"};
		String[] expected=TrianglePyramid.wholePyramid(0);
		
		// compares result and expected string arrays
		assertArrayEquals(expected,result);
	}


}
