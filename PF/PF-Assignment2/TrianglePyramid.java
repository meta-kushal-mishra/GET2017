// This class creates a diamond pattern using modular approach
public class TrianglePyramid
{
	// Method that joins the spaces and numbers string
	// and builds the pyramid
	public static String[] wholePyramid(int max_num)
	{
		// checks if the input is valid
		String[] invalid = {"invalid input"};
		if(max_num<=0)
			return invalid;
		
		// creates a string array to store result
		String[] result = new String[max_num];
		
		// joins spaces and number strings in for of
		// resultant pyramid
		for(int i=0;i<max_num;i++){
			result[i] = returnSpaces(max_num,max_num-i-1)+returnNumbers(max_num,i);
			
		}
		
		//returns resultant string array
		return result;
	}
	public static String returnSpaces(int max_num, int k)
	{
		// creates string to store spaces
		String spaces = new String();
		
		// modifies spaces string
		for(int i=max_num-k-1;i>0;i--)
		{
			spaces = spaces + " ";
		}
		// returns resultant spaces string
		return spaces;
	}
	
	// method to return numbers pattern
	public static String returnNumbers(int max_num, int k)
	{
		// creates string to store numbers 
		String numbers = new String();
		
		// loop to create number pattern
		for(int i=0;i<max_num-k;i++){
			numbers =  numbers+Integer.toString(i+1) ;
		}
		
		// returns resultant string
		return numbers;
	}

}
