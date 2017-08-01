package oop5;

public class ProfileUser extends Profile{

	private String name;	//The name attribute for the node
	private String place;	//The place attribute for the node
	private String type;	//The type attribute for the node
	
	public ProfileUser(String name, String place, String type) {
		this.name = name;
		this.place = place;
		this.type = type;
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setPlace(String place) {
		this.place = place;
	}

	@Override
	public String getPlace() {
		return place;
	}

	@Override
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String getType() {
		return type;
	}

}
