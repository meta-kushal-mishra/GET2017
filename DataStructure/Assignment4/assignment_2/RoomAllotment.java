
package assignment_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class RoomAllotment {

	BufferedReader bufferedReader = null;

	public RoomAllotment(){

		bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	}

	public static void main(String[] args){

		RoomAllotment roomAllotment = new RoomAllotment();

		try{

			GuestHouse guestHouse = new GuestHouse("Test Guest House", 13);
			List<Character> roomsList = guestHouse.assignRoomNumbers();
			char userPermission = '\0';

			// variable for total rooms occupied
			int roomsOccupied = 0;

			do{
				// printing message
				System.out.println("Welcome to "+ guestHouse.getGuestHouseName());

				// taking user input for guest name
				String guestName = roomAllotment.getUserStringInput("Please enter your name");

				// taking user input for guest age
				int guestAge = roomAllotment.getUserIntegerInput("Please enter your age");

				// initialized guest with guest name and guest age
				Guest guest = new Guest(guestName , guestAge);

				// variable for room alloted 
				int roomAlloted = roomAllotment.allotRoomNumberToGuest(roomsList , guestAge , roomsOccupied);

				// increment the rooms occupied variable 
				roomsOccupied++;

				// displaying result
				if(roomAlloted == -1){

					System.out.println("Sorry " +guest.getGuestName()+" Cannot assign room.All the rooms are occupied");
				}

				else{
					
					System.out.println("Thank you "+ guest.getGuestName() +" for using our service. "
							+ "\n" +"The room alloted to you is: "+roomAlloted);
				}

				// taking user permission to continue
				userPermission = roomAllotment.getUserStringInput("Press Y or y to continue").charAt(0);

			}while(userPermission == 'y' || userPermission == 'Y');
			
			System.out.println("Program Ended");
			
		}catch(Exception ex){

			System.out.println("Something went wrong: "+ex.getMessage());

		}finally{

			try{

				// closing buffered reader stream
				roomAllotment.bufferedReader.close();

			}catch(Exception ex){

				System.out.println("Something went wrong: "+ex.getMessage());
			}
		}	
		
		
	}

	public int allotRoomNumberToGuest(List<Character> roomsList , int guestAge , int roomsOccupied){
		
		// if all the rooms are occupied then return -1
		if(roomsOccupied == roomsList.size()){

			return -1;
		}
		// computed alloted room
		int allotedRoom = guestAge % roomsList.size();

		// until alloted room is not empty
		while(roomsList.get(allotedRoom) != 'E'){

			// increment 
			allotedRoom++;

			// if greater than size of rooms then reduce it
			allotedRoom = allotedRoom % roomsList.size();

		}

		roomsList.set(allotedRoom, 'F');

		return allotedRoom;
	}

	public String getUserStringInput(String message){			
		// variable for user input
		String userInput = "";

		try{

			System.out.println(message);

			// taking user input
			userInput = bufferedReader.readLine();

		}catch(Exception ex){

			System.out.println("Something went wrong: "+ex.getMessage());
			getUserStringInput(message);

		}

		return userInput;
	}

	public int getUserIntegerInput(String message){

		// variable for user input
		int userInput = 0;

		try{

			System.out.println(message);

			// taking user input
			userInput = Integer.parseInt(bufferedReader.readLine());

		}catch(Exception ex){

			System.out.println("Something went wrong: "+ex.getMessage());
			getUserIntegerInput(message);

		}
		
		// return user input 
		return userInput;
	}
}