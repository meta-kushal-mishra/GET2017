package assignment_1;

// a generic class for node 
public class Node<E> {
	
	// variable for node value
	public E nodeValue;
	
	// variable for right and left pointers of node
	public Node<E> left , right;
	
	/*
	 * Constructor for node
	 * Initialized both left , right and node value
	 */
	public Node(){
		
		nodeValue = null;
		
		left = null;
		
		right = null;
		
	}
	
	/**
	 * Parameterized constructor for node
	 * It initializes the node value for element and set left and right pointer to null
	 * 
	 * @param element
	 */
	public Node(E element){
		
		nodeValue = element;
		
		left = null;
		
		right = null;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		
		return nodeValue.toString();
	}

}
