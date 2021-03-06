package assignment_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class CollegeCounselling {

	// object of buffered reader for input
	BufferedReader bufferedReader;

	public CollegeCounselling(){

		bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	}

	// entry point of the program
	public static void main(String[] args) {

		// creating object of collegeCounselling
		CollegeCounselling collegeCounselling = new CollegeCounselling();

		try{

			System.out.println("Welcome to college counselling process");

			// array list of colleges
			ArrayList<College> collegesList = collegeCounselling.createListOfColleges();

			// queue of candidates
			Queue<Candidate> candidatesQueue = collegeCounselling.createQueueOfCandidates();

			// variable for total seats in all the colleges
			int totalSeats = collegeCounselling.getTotalSeats(collegesList);

			// HashMap to map the candidate to assigned college
			Map<String,String> assignedColleges = new HashMap<String,String>();

			assignedColleges = collegeCounselling.collegeCounsellingProcess(collegesList , candidatesQueue ,totalSeats);
			
			// printing the result
			System.out.println("Assigned Colleges: ");
			for(Map.Entry<String, String> entry : assignedColleges.entrySet()){

				System.out.println("candidate Name: "+entry.getKey()+" , "+" assigned college: "+entry.getValue());
			}
			
		}finally{

			try{
				// closing the input stream
				collegeCounselling.bufferedReader.close();

			}catch(Exception ex){

				System.out.println("Something went wrong: "+ex.getMessage());
			}

		}
	}

	public Map<String,String> collegeCounsellingProcess(ArrayList<College> collegesList , Queue<Candidate> candidatesQueue , int totalSeats){

		// a Map to map the candidates to college
		Map<String,String> assignedColleges  = new HashMap<String , String>();

		try{

			// variable for user input
			int userInput = 0;

			// variable for candidate name
			String candidateName = "";

			// until all the candidates get the seats or all the seats are full
			while(candidatesQueue.getSize() != 0 && totalSeats != 0){
				
				// variable for number of seats
				int numberOfSeats = 0;
				
				// getting the candidate name with the best rank
				candidateName = candidatesQueue.getFront().getCandidateName();

				// displaying the college list to candidate
				System.out.println("College List is: ");

				for(int i = 0 ;i < collegesList.getSize() ; ++i){

					College college = collegesList.getElement(i);

					System.out.println((i+1)+"."+" Name: "+college.getCollegeName() + 
							" Rank: "+college.getCollegeRank()
							+" Seats Available: "+college.getCollegeSeats());
				}

				// taking user input for college they want
				userInput = getUserInput("Candidate: "+candidateName + " Please enter the college number you want to select");

				// if user input is greater than the total colleges
				// print message for invalid input
				if(userInput > collegesList.getSize()){

					System.out.println("Invalid Input. Try Again");
				}
				
				// else get the total seats in that college
				else{

					numberOfSeats = collegesList.getElement(userInput - 1).getCollegeSeats();
				}

				// if number of seats is greater than zero 
				if(numberOfSeats > 0){

					// subtract the totalSeats by 1
					totalSeats = totalSeats - 1;

					// remove candidate name from queue
					candidateName = candidatesQueue.dequeue().getCandidateName();

					// assign college to candidate
					assignedColleges.put(candidateName, collegesList.getElement(userInput - 1).getCollegeName());

					// reduce the number of seats in that college by 1
					--numberOfSeats;

					// create a new object with the updated seats
					College college = collegesList.getElement(userInput -1 );

					college.setCollegeSeats(numberOfSeats);

					// overwrite the list with new object
					collegesList.overwriteElement(userInput - 1, college);

				}

				// if number of seats is less than or equal to zero then display message
				else{

					System.out.println("The college you entered is already full. Please select another college");

				}
			}

		}catch(Exception ex){

			System.out.println("Something went wrong: "+ex.getMessage());
		}

		return assignedColleges;
	}


	public ArrayList<College> createListOfColleges(){

		ArrayList<College> collegeLists = new ArrayList<College>();

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
			
		}catch(Exception ex){

			System.out.println("Something went wrong: "+ex.getMessage());

			createListOfColleges();
		}

		return collegeLists;
	}

	public Queue<Candidate> createQueueOfCandidates(){

		Queue<Candidate> candidates = new Queue<Candidate>();

		try{

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

		}catch(Exception ex){

			System.out.println("Something went wrong: "+ex.getMessage());

			createQueueOfCandidates();
		}

		return candidates;

	}
	
	public int getTotalSeats(ArrayList<College> collegesList){

		int totalSeats = 0;

		try{

			for(int i = 0 ; i < collegesList.getSize() ; ++i){

				totalSeats += collegesList.getElement(i).getCollegeSeats();
			}
		}catch(Exception ex){

			System.out.println("Something went wrong: "+ex.getMessage());

			getTotalSeats(collegesList);
		}

		return totalSeats;
	}

	public int getUserInput(String message){

		int userInput = 0;

		try{

			System.out.println(message);

			userInput = Integer.parseInt(bufferedReader.readLine());

			while(userInput <= 0){

				getUserInput(message);
			}

		}catch(Exception ex){

			System.out.println("Something went wrong: "+ex.getMessage());

			getUserInput(message);

		}
		return userInput;
	}
}