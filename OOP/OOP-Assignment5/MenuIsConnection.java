package oop5;
import java.util.Scanner;
import java.util.Stack;


public class MenuIsConnection extends CompositeMenuItem {

	private Graph graph;	//The social network on which the operation is to be performed
	private Stack<Node> bfs;	//Stack to store the visited nodes in the traversing
	
	public MenuIsConnection(Graph graph) {
		this.setName("Is Connection");
		this.graph = graph;
		bfs = new Stack<Node>();
	}
	
	@Override
	public void actionTaken(Scanner scan) {
		Node requester,query;
		boolean flag = true;
		do{
			System.out.println("Enter profile name of requester");
			//Checking if the requesting node exist
			if((requester = graph.getNode(scan.nextLine())) != null) 
				flag = false;
			else
				System.out.println("No such entity is present");
		}while(flag);
		
		flag = true;
		
		do{
			System.out.println("Enter the profile name to search connection with");
			//Checking if the node queried for exist
			if((query = graph.getNode(scan.nextLine())) != null) 
				flag = false;
			else
				System.out.println("No such entity is present");
		}while(flag);
		
		//Checking if there is any connection between the two nodes
		if(!search(requester,query)) {
			System.out.println("There is no connection between them");
		} else {
			System.out.println(" <- "+requester.getName());
		}
		bfs.clear();
	}
	
	public boolean search(Node requester, Node query) {
		boolean result = false;
		//Check if the queried node is a direct neighbor of requester
		if(requester.isFriend(query)) {
			System.out.print(query.getName());
			return true;
		}
		
		//Adding the node whose immediate neighbour is checked for the queried node
		bfs.add(requester);
		for(Node n : requester.getNeighbours()) {
			//Check if the neighbor node is already traversed to avoid cycle
			if(bfs.contains(n)) {
				continue;
			}
			//Performing the search on the neighbor node
			result = search(n, query);
			if(result) {
				System.out.print(" <- "+n.getName());
				break;
			}
		}
		
		return result;
	}
}
