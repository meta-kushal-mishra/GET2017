package PF3;

public class QuickSort {
	
	//takes array and left and rightmost indes and returns index for partition
	public static int partition(int arr[], int low, int high){
		
		int pivot = arr[high]; 
		int i = (low-1); // index of smaller element
		for (int j=low; j<high; j++){
			
			// If current element is smaller than or
			// equal to pivot
			if (arr[j] <= pivot)
			{
				i++;

				// swap arr[i] and arr[j]
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		// swap arr[i+1] and arr[high] (or pivot)
		int temp = arr[i+1];
		arr[i+1] = arr[high];
		arr[high] = temp;

		return i+1;
 }

	// takes array and leftmost and rightmost index 
	 public static int[] sort(int arr[], int low, int high){
		
		if (low < high)
		{
	        int pi = partition(arr, low, high);
	
	        // Recursively sort elements before
	        // partition and after partition
	        sort(arr, low, pi-1);
	        sort(arr, pi+1, high);
	    }
		
		return arr;
 }

	public static void main(String[] args){
		int[] input = {2,5,8,9,10, 77, 55, 11};
		int result[] = new int[input.length];
		if(input.length>0)
			 result = QuickSort.sort(input, 0, input.length-1);
		
		for(int i=0;i<input.length;i++)
			System.out.print(result[i]);

	}

}
