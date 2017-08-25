package assignment_2;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class TestCollegeCounselling {

	ArrayList<College> collegeLists;
	Queue<Candidate> candidates;
	CollegeCounselling collegeCounselling= new CollegeCounselling();
	Map<String,String> assignedColleges; 
	Map<String,String> assignedColleges1; 
	@Before
	public void setUp() throws Exception {
		
		collegeLists = new ArrayList<College>();
		candidates = new Queue<Candidate>();
		assignedColleges  = new HashMap<String , String>();
		try{
		College college1 = new College("LNMIIT", 1,1);
		College college2 = new College("Amity University", 2,1);
		College college3 = new College("JECRC",3,2);
		College college4 = new College("SKIT",4,3);
		College college5 = new College("Poornima University", 5,3);
		College college6 = new College("Jaipur University", 6,2);

		collegeLists.add(college1);
		collegeLists.add(college2);
		collegeLists.add(college3);
		collegeLists.add(college4);
		collegeLists.add(college5);
		collegeLists.add(college6);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		Candidate candidate1 = new Candidate("test1", 1);
		Candidate candidate2 = new Candidate("test2", 2);
		Candidate candidate3 = new Candidate("test3", 3);
		Candidate candidate4 = new Candidate("test4", 4);
		Candidate candidate5 = new Candidate("test5", 5);
		Candidate candidate6 = new Candidate("test6", 6);
		Candidate candidate7 = new Candidate("test7", 7);
		Candidate candidate8 = new Candidate("test8", 8);
		Candidate candidate9 = new Candidate("test9", 9);
		Candidate candidate10 = new Candidate("test10", 10);
		Candidate candidate11 = new Candidate("test11", 11);
		Candidate candidate12 = new Candidate("test12", 12);
		Candidate candidate13 = new Candidate("test13", 13);

		candidates.enqueue(candidate1);
		candidates.enqueue(candidate2);
		candidates.enqueue(candidate3);
		candidates.enqueue(candidate4);
		candidates.enqueue(candidate5);
		candidates.enqueue(candidate6);
		candidates.enqueue(candidate7);
		candidates.enqueue(candidate8);
		candidates.enqueue(candidate9);
		candidates.enqueue(candidate10);
		candidates.enqueue(candidate11);
		candidates.enqueue(candidate12);
		candidates.enqueue(candidate13);
		
		assignedColleges.put("test1", "LNMIIT");
		assignedColleges.put("test2", "Amity University");
		assignedColleges.put("test3", "JECRC");
		assignedColleges.put("test4", "JECRC");
		assignedColleges.put("test5", "SKIT");
		assignedColleges.put("test6", "SKIT");
		assignedColleges.put("test7", "SKIT");
		assignedColleges.put("test8", "Poornima University");
		assignedColleges.put("test9", "Poornima University");
		assignedColleges.put("test10", "Poornima University");
		assignedColleges.put("test11", "Jaipur University");
		assignedColleges.put("test12", "Jaipur University");
		
		//assignedColleges1 = collegeCounselling.collegeCounsellingProcess(collegeLists, candidates, 12);
	}
	

	@Test
	public void testCreateListOfColleges() {
		assertEquals(collegeLists.getElement(0).getCollegeName(), 
						collegeCounselling.createListOfColleges().getElement(0).getCollegeName());
	}
	
	@Test
	public void testCreateQueueOfCandidates() {
		assertEquals(candidates.getSize(), 
						collegeCounselling.createQueueOfCandidates().getSize());
	}

}
