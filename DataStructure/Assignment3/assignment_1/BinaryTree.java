
package assignment_1;

public class BinaryTree<E> {

	// a size variable
	// deciding factor for insertion to left or right node
	int size;
	
	public BinaryTree(){

		// initialized size to 1
		size = 1;
		
	}
	
	public Node<E> insertRoot(Node<E> rootNode , E elementForRoot , E elementForLeftOfRoot , 
			E elementForRightOfRoot){
		
		if(rootNode == null){
			
			rootNode = new Node<E>();
			
			rootNode.nodeValue = elementForRoot;
			
			rootNode.left = new Node<E>();
			
			rootNode.left.nodeValue = elementForLeftOfRoot;
			
			rootNode.right = new Node<E>();
			
			rootNode.right.nodeValue = elementForRightOfRoot;
		}
		
		return rootNode;
	}
	
	public Node<E> insert(Node<E> rootNode , E elementForLeft , E elementForRight){

		try{
			
			// if left and right of node both are null then insert to left and right at the same time
			// increment size variable
			if(rootNode.left == null && rootNode.right == null){
				
				rootNode.left = new Node<E>();
				
				rootNode.left.nodeValue = elementForLeft;
				
				rootNode.right = new Node<E>();
				
				rootNode.right.nodeValue = elementForRight;
				
				size++;
				
			}
			
			else{
				
				// if size is even then insert to left node
				if(size % 2 == 0){

					rootNode.left = insert(rootNode.left , elementForLeft , elementForRight);
				}
				
				// if size is odd then insert to right node
				else{

					rootNode.right = insert(rootNode.right , elementForLeft , elementForRight);
				}
			}

		}catch(Exception ex){

			System.out.println("Something went wrong: "+ex.getMessage());
		}

		return rootNode;
	}
}