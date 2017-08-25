package assignment_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import assignment_1.BinaryTree;
import assignment_1.Node;

// class for operations on binary trees
public class Operations {

	// buffered reader object for taking input
	BufferedReader bufferedReader;

	public Operations(){

		bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	}
	
	// entry point for program
	public static void main(String[] args) {

		Operations operations = new Operations();

		try{
			
			// variable for root node of tree 1
			Node<Integer> rootNodeForTree1 = null;

			// variable for root node of tree 2
			Node<Integer> rootNodeForTree2 = null;

			// variable for user choice
			int choice = 0;

			// variable for user permission to continue or not
			char userPermission = '\0';

			do{

				// printing choices
				System.out.println("1. Insert in first binary tree");

				System.out.println("2. Insert in second binary tree");

				System.out.println("3. Check if trees are mirror image of each other");

				choice = operations.getUserIntegerInput("Please enter a valid choice");

				switch(choice){

				case 1:
					
					// insert elements in the first tree
					rootNodeForTree1 = operations.getUserInputForTree(rootNodeForTree1);
					
					break;

				case 2:

					// insert elements in the second tree
					rootNodeForTree2 = operations.getUserInputForTree(rootNodeForTree2);
					
					break;

				case 3:

					// variable to store result if mirror trees or not
					boolean result = operations.areMirrorTrees(rootNodeForTree1 , rootNodeForTree2);

					if(result == true){

						System.out.println("Yes , trees are mirror images of each other");
					}
					else{

						System.out.println("No , trees are not mirror images of each other");
					}
					break;

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
	
	public boolean areMirrorTrees(Node<Integer> rootNodeForTree1 , Node<Integer> rootNodeForTree2){

		if(rootNodeForTree1 == null && rootNodeForTree2 == null){

			return true;
		}

		if(rootNodeForTree1.nodeValue != rootNodeForTree2.nodeValue){

			return false;
		}

		if( (rootNodeForTree1 == null && rootNodeForTree2 != null) 
				|| rootNodeForTree2 == null && rootNodeForTree1 != null){

			return false;
		}

		return areMirrorTrees(rootNodeForTree1.left, rootNodeForTree2.right) && 
				areMirrorTrees(rootNodeForTree1.right, rootNodeForTree2.left);
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
					+ " elements futher").charAt(0);
		}
		
		return rootNode;
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