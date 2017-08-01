package oop5;

import java.util.ArrayList;
import java.util.List;

public class NodeUser extends Node{
	
	private ProfileUser profile;	//The attributes for the organisation node
	private List<Node> neighbour; 		//The list of all the immediate neighbours of the node
	private List<Node> blocked;		//The list of nodes with whom the edge creation is blocked
	
	public NodeUser(String name, String place, String type) {
		profile = new ProfileUser(name, place, type);
		neighbour = new ArrayList<Node>();
		blocked = new ArrayList<Node>();
	}
	
	@Override
	public String getName() {
		return profile.getName();
	}
	
	@Override
	public void setName(String name) {
		profile.setName(name);
	}
	
	@Override
	public String getPlace() {
		return profile.getPlace();
	}
	
	@Override
	public void setPlace(String place) {
		profile.setPlace(place);
	}
	
	@Override
	public String getType() {
		return profile.getType();
	}

	@Override
	public void setType(String type) {
		profile.setType(type);
	}

	@Override
	public void addNeighbour(Node conn) {
		if(!neighbour.contains(conn)) {
			neighbour.add(conn);
		}
	}
	
	@Override
	public boolean removeNeighbour(Node remove) {
		if(neighbour.contains(remove)) {
			neighbour.remove(remove);
			return true;
		}
		return false;
	}

	@Override
	public void displayNeighbour() {
		for(int i=0; i < neighbour.size(); i++) {
			System.out.print(neighbour.get(i).getName()+" ");
		}
		
		if(neighbour.size() < 4){
			System.out.print("\t");
		}
	}


	@Override
	public boolean isFriend(Node query) {
		if(neighbour.contains(query)) {
			return true;
		}
		return false;
	}

	@Override
	public List<Node> getNeighbours() {
		return neighbour;
	}
	
	@Override
	public boolean blockNode(Node node) {
		if(!blocked.contains(node)) {
			blocked.add(node);
			return true;
		}
		return false;
	}

	@Override
	public boolean isBlockedNode(Node node) {
		if(blocked.contains(node)) {
			return true;
		}
		return false;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		try {
			Node n = (Node) obj;
			if(hashCode() == n.hashCode()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return getName().hashCode() + getPlace().hashCode() + getType().hashCode();
	}
	
}
