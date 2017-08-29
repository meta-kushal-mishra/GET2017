package assignment_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JobScheduling {

	BufferedReader bufferedReader = null;

	public JobScheduling(){

		bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	}

	public static void main(String[] args){

		// object of scheduling class
		JobScheduling jobScheduling = new JobScheduling();

		// object of priority queue
		PriorityQueue priorityQueue = new PriorityQueue();

		// variable for user permission to continue or not
		char userPermission = '\0';

		try{

			do{
				// displaying choices
				System.out.println("1. Insert Job");

				System.out.println("2. Print Jobs Based On Priority");

				// taking user choice 
				int userChoice = jobScheduling.getUserIntegerInput("Please enter a valid choice");

				switch (userChoice){

				// to insert job
				case 1 : 

					int jobPriority = jobScheduling.getUserIntegerInput("Please enter the priority of job");
					String jobMessage = jobScheduling.getUserStringInput("Enter message for job");

					priorityQueue.insertJob(jobPriority, jobMessage);

					break;                          

					// to print job queue
				case 2 : 

					System.out.println("Job Execution Order");

					priorityQueue.printJobQueue();

					break;        

				default : 

					System.out.println("Invalid Choice");

					break;   
				}   

				userPermission = jobScheduling.getUserStringInput("Please enter Y or y to continue").charAt(0);

			} while (userPermission == 'Y'|| userPermission == 'y');

		}catch(Exception ex){

			System.out.println("Something went wrong: "+ex.getMessage());

		}finally{

			try{
				// close input stream
				jobScheduling.bufferedReader.close();
				
			}catch(Exception ex){

				System.out.println("Something went wrong: "+ex.getMessage());
			}
		}
	}

	public int getUserIntegerInput(String message){
		
		int userInput = 0;

		try{

			System.out.println(message);
			userInput = Integer.parseInt(bufferedReader.readLine());

		}catch(Exception ex){

			System.out.println("Something went wrong: "+ex.getMessage());
			getUserIntegerInput(message);

		}

		return userInput;
	}

	public String getUserStringInput(String message){			
		String userInput = "";

		try{

			System.out.println(message);
			userInput = bufferedReader.readLine();

		}catch(Exception ex){

			System.out.println("Something went wrong: "+ex.getMessage());
			getUserStringInput(message);

		}
		return userInput;
	}
}