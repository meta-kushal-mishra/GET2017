package pf4;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TestTowerOfHanoi {

	ArrayList<String> expectedList1 = new ArrayList<String>(Arrays.asList(
			"Move Disk 3 from A to B", "Move Disk 2 from A to C", "Move Disk 3 from B to C",  
			"Move Disk 1 from A to B", "Move Disk 3 from C to A", "Move Disk 2 from C to B", 
			"Move Disk 3 from A to B"));
	
	ArrayList<String> expectedList2 = new ArrayList<String>(Arrays.asList(
			"Move Disk 2 from A to C", "Move Disk 1 from A to B", "Move Disk 2 from C to B"));
	
	ArrayList<String> expectedList3 = new ArrayList<String>(Arrays.asList("Move Disk 1 from A to B"));
		
	ArrayList<String> input1 = new ArrayList<String>();
	ArrayList<String> input2 = new ArrayList<String>();
	ArrayList<String> input3 = new ArrayList<String>();

	@Test
	public void testTower1() {
			
		List<String> result1 = new ArrayList<String>();
		result1  = TowerOfHanoi.towerOfHanoi("A", "B", "C", 3);
		assertEquals(expectedList1, result1 );
	}
	@Test
	public void testTower2() {
		List<String> result2 = new ArrayList<String>();
		result2  = TowerOfHanoi.towerOfHanoi("A", "B", "C", 2);
		assertEquals(expectedList2, result2 );
	}
	@Test
	public void testTower3() {
			
		List<String> result3 = new ArrayList<String>();
		result3  = TowerOfHanoi.towerOfHanoi("A", "B", "C", 1);
		assertEquals(expectedList3, result3 );
	}
}
