package assignment_1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestOperations {
	
	Operations operations;

	
	@Before
	public void setUp() throws Exception {
		
		operations = new Operations();
	}

	@Test
	public void testInfixToPostFix() {
		
		assertEquals("AB*CD/+",operations.infixToPostFix("( (A * B) + (C / D) )"));
		assertEquals("ABC+*D/",operations.infixToPostFix("((A * (B + C) ) / D)"));
		assertEquals("ABCD/+*",operations.infixToPostFix("(A * (B + (C / D) ) )"));
		assertEquals("ab+cdj^%i*p/-",operations.infixToPostFix("a+b-c%d^j*i/p"));
	}

}
