import static org.junit.Assert.*;
import org.junit.Test;

// Test class for checking order of array
public class CheckOrderTest {

	// Method to check the ascending order
	@Test
	public void checkAscending(){
		System.out.println("Ascending order check");
		int input[]={1,2,3,4,5};
		int result = CheckOrder.orderCheck(input);
		assertEquals("ascending order", 1,result);
	}
	
	// method to check descending order
	@Test
	public void checkDescending(){
		System.out.println("descending order check");
		int input[]={5,4,3,2,1};
		int result = CheckOrder.orderCheck(input);
		assertEquals("descending order", 2,result);
	}
	
	// test case for no order check
	@Test
	public void checkNoOrder(){
		int input[]={1,2,4,3,5};
		int result = CheckOrder.orderCheck(input);
		System.out.println("No order check");
		assertEquals("no order", 0,result);
	}

}
