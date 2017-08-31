
package assignment_1;

// class to define binary search tree
public class BinarySearchTree {
	
	public Node insertNode(Node startNode , int element){
		
		// if start node is null
		if(startNode == null){
			
			startNode = new Node();
			
			startNode.nodeValue = element;
			
			startNode.left = null;
			
			startNode.right = null;
		}
		
		else{
			
			// if current element is greater than start node value 
			// insert node to left
			if(startNode.nodeValue  >  element){
				
				startNode.left = insertNode(startNode.left, element);
			}
			
			// else insert node to right
			else if(startNode.nodeValue < element){
				
				startNode.right = insertNode(startNode.right, element);
			}
		}
		
		return startNode;
	}
}