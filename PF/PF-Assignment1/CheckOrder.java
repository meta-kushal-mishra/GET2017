// Java program to check order of array

public class CheckOrder {
	// method for checking order of array taking that array as argument
	public static int orderCheck(int arr[]){
		int flag = 0;							//flag to track order
		// check for order
		for(int i=0;i<arr.length-1;i++){
			if(arr[i]<=arr[i+1] && (flag==0 || flag==1){
				flag=1;
			}
			else if(arr[i]>=arr[i+1] && (flag==0 || flag==2)){
				flag=2;
			}
			else{
				flag=0;
				break;
			}
		}
		// check for single element in array
		if(arr[0]==arr[arr.length-1]){
			flag=0;
		}
		return flag;							//return the flag 

	}

}
