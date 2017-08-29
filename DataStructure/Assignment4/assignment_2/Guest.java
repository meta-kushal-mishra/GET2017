package assignment_2;

public class Guest {

	private String guestName;
	private int guestAge;
	
	public Guest(String guestName , int guestAge){
		
		this.guestName = guestName;
		
		this.guestAge = guestAge;
	}
	
	// return guest name
	public String getGuestName(){
		
		return this.guestName;
	}
	
	// return guest age
	public int getGuestAge(){
		
		return this.guestAge;
	}

}
