// This class creates a diamond pattern using modular approach
public class DiamondPyramid{
	
	// Method that joins the spaces and numbers string
	// and builds the pyramid
	public static String[] wholePyramid(int max_num){
		
		// checks if the input is valid 
		String[] invalid = {"invalid input"};
		if(max_num<=0)
			return invalid;
		
		// creates a string array to store result
		String[] result = new String[2*max_num-1];
		
		// joins spaces and number strings in for of
		// resultant pyramid
		for(int i=0;i<max_num;i++){
			
			result[i] = spaces(max_num,i)+numbers(max_num,i)+spaces(max_num,i);
			result[2*max_num-2-i] = spaces(max_num,i)+numbers(max_num,i)+spaces(max_num,i);
		}
		
		//returns resultant string array
		return result;
	}
	
	public static String spaces(int max_num, int k){
		
		// creates string to store spaces
		String spaces = new String();
		
		// modifies spaces string
		for(int i=0;i<max_num-k-1;i++){
			spaces = spaces + " ";
		}
		
		// returns resultant spaces string
		return spaces;
	}
	
	// method to return numbers pattern and takes maximum num and current posn as argument
	public static String numbers(int n, int k)
	{
		// creates string to store numbers 
		String numbers = new String();
		
		// initializes string with number we want in middle
		numbers = Integer.toString(k+1);
		
		// loop to create number pattern
		for(int i=k;i>0;i--){
			numbers = Integer.toString(i) + numbers + Integer.toString(i);
		}
		
		// returns resultant string
		return numbers;
	}
}
