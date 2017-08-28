package assignment_2;

import java.util.ArrayList;
import java.util.List;

public class GuestHouse {

	private String guestHouseName;
	private int guestHouseTotalRooms;
	
	public GuestHouse(String guestHouseName , int guestHouseTotalRooms){
		
		this.guestHouseName = guestHouseName;
		
		this.guestHouseTotalRooms = guestHouseTotalRooms;
	}
	
	public String getGuestHouseName(){
		
		return this.guestHouseName;
	}
	
	public List<Character> assignRoomNumbers(){
		
		List<Character> roomsList = new ArrayList<Character>();
		
		for(int i = 0 ; i < guestHouseTotalRooms ; ++i ){
			
			roomsList.add('E');
		}
		
		return roomsList;
	}
}