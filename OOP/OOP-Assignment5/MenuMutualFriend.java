package oop5;
import java.util.Scanner;
public class MenuMutualFriend extends CompositeMenuItem {

	private Graph graph;	//The social network on which the operation is to be performed
	
	public MenuMutualFriend(Graph graph) {
		this.setName("Mutual Friend");
		this.graph = graph;
	}
	
	//@Override
	public void actionTaken(Scanner scan) {
		Node requester, query;
		
		do{
			System.out.println("Enter profile name of requester");
			//Checking if the requesting node exist
			if((requester = graph.getNode(scan.nextLine())) != null) 
				break;
			else
				System.out.println("No such entity is present");
		}while(true);
		

		do{
			System.out.println("Enter the profile name to search mutual friends with");
			//Checking if the node queried for exist
			if((query = graph.getNode(scan.nextLine())) != null) 
				break;
			else
				System.out.println("No such entity is present");
		}while(true);
		
		
		System.out.println("Mutual friends are :");
		//Loop to iterate over all the neighbors of the requesting node
		for (Node n : requester.getNeighbours()) {
			//Checking if the neighbor node is also a neighbor of the queried node
			if(query.isFriend(n)) {
				System.out.println(n.getName()+" ");
			}
		}
	}
}
