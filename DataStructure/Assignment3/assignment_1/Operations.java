package assignment_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// class for operations to be performed on binary tree
public class Operations {

	// buffered reader object for input and output
	BufferedReader bufferedReader;
	
	public Operations(){

		bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public static void main(String[] args) {
		
		Operations operations = new Operations();

		try{

			Node<Integer> rootNode = null;
			
			// variable for user choice
			int choice = 0;

			// variable for user permission to continue or not
			char userPermission = '\0';

			do{
				
				// printing choices
				System.out.println("1. Insert in binary tree");

				System.out.println("2. Display preorder traversal");
				
				choice = operations.getUserIntegerInput("Please enter a valid choice");

				switch(choice){
				
				// insert elements in the tree
				case 1:
					
					System.out.println("Press -1 for null element");
					rootNode = operations.getUserInputForTree(rootNode);
					
					break;
					
				// display preOrder of binary tree
				case 2:
					
					operations.preorder(rootNode);
					break;
					
				// for invalid choice	
				default:

					System.out.println("Invalid Choice");
				}
				
				// taking user permission to continue or not
				userPermission = operations.getUserStringInput("Press Y or y to continue").charAt(0);

			}while(userPermission == 'y' || userPermission =='Y');


		}catch(Exception ex){

			System.out.println("Something went wrong: "+ex.getMessage());

		}finally{

			try{
				
				// closing the stream
				operations.bufferedReader.close();

				System.out.println("Program Ended");

			}catch(Exception ex){

				System.out.println("Something went wrong: "+ex.getMessage());
			}
		}

	}
	
	public Node<Integer> getUserInputForTree(Node<Integer> rootNode){
		
		BinaryTree<Integer> binaryTree = new BinaryTree<Integer>();
		
		// taking user input for root element
		Integer elementForRoot = getUserIntegerInput("Please enter an element for "
				+ "root of tree");

		// taking user input for element for left of root
		Integer elementForLeftOfRoot = getUserIntegerInput("Please enter an element "
				+ "for node to left of root");
		
		if(elementForLeftOfRoot.equals(-1)){
			
			elementForLeftOfRoot = null;
		}
		
		// taking user input for element for right of root
		Integer elementForRightOfRoot = getUserIntegerInput("Please enter an element "
				+ "for node to right of root");
		
		if(elementForRightOfRoot.equals(-1)){
			
			elementForRightOfRoot = null;
		}
		
		// getting rootNode
		rootNode = binaryTree.insertRoot(rootNode, elementForRoot, elementForLeftOfRoot, elementForRightOfRoot);
		
		// variable to take user permission to add left and right node
		char addAnother = 'y';
		
		addAnother = getUserStringInput("Please enter Y or y to add"
				+ " elements further").charAt(0);

		// checking condition
		while(addAnother == 'y' || addAnother == 'Y'){
			
			// taking user input for left node 
			Integer elementForLeft = getUserIntegerInput("Please enter an element "
					+ "for left node");
			
			if(elementForLeft.equals(-1)){
				
				elementForLeft = null;
			}

			// taking user input for right node
			Integer elementForRight = getUserIntegerInput("Please enter an element "
					+ "for right node");
			
			if(elementForRight.equals(-1)){
				
				elementForRight = null;
			}
			// getting root node
			rootNode = binaryTree.insert(rootNode, elementForLeft, elementForRight);

			// taking user permission to add another left and right node
			addAnother = getUserStringInput("Please enter Y or y to add"
					+ " elements further").charAt(0);
		}
		
		return rootNode;
	}

	public void preorder(Node<Integer> rootNode){

		try{
			
			// do traversal only if root node is not null
			if(rootNode != null){

				System.out.println(rootNode.nodeValue);

				preorder(rootNode.left);

				preorder(rootNode.right);
			}

		}catch(Exception ex){

			System.out.println("Something went wrong: "+ex.getMessage());
		}
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

		return userInput;
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
}