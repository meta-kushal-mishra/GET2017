


public class RemoveDuplicates {

	public static void main(String[] args) {
		int input[] = {1,2,3,3,5,6,7,8};
		int result[] = removeDuplicates(input);
		for(int i =0;i<result.length;i++){
			System.out.print(result[i]);
		}
	}
	
	public static void merge(int arr[], int l, int m, int r)
	{
	    // Find sizes of two subarrays to be merged
	    int n1 = m - l + 1;
	    int n2 = r - m;
	
	    /* Create temp arrays */
	    int L[] = new int [n1];
	    int R[] = new int [n2];
	
	    /*Copy data to temp arrays*/
	    for (int i=0; i<n1; ++i)
	        L[i] = arr[l + i];
	    for (int j=0; j<n2; ++j)
	        R[j] = arr[m + 1+ j];
	
	
	    /* Merge the temp arrays */
	
	    // Initial indexes of first and second subarrays
	    int i = 0, j = 0;
	
	    // Initial index of merged subarry array
	    int k = l;
	    while (i < n1 && j < n2)
	    {
	        if (L[i] <= R[j])
	        {
	            arr[k] = L[i];
	            i++;
	        }
	        else
	        {
	            arr[k] = R[j];
	            j++;
	        }
	        k++;
	    }
	
	    /* Copy remaining elements of L[] if any */
	    while (i < n1)
	    {
	        arr[k] = L[i];
	        i++;
	        k++;
	    }
	
	    /* Copy remaining elements of R[] if any */
	    while (j < n2)
	    {
	        arr[k] = R[j];
	        j++;
	        k++;
	    }
	}
	
	// Main function that sorts arr[l..r] using
	// merge()
	public static void sort(int arr[], int l, int r)
	{
	    if (l < r)
	    {
	        // Find the middle point
	        int m = (l+r)/2;
	
	        // Sort first and second halves
	        sort(arr, l, m);
	        sort(arr , m+1, r);
	
	        // Merge the sorted halves
	        merge(arr, l, m, r);
	    }
	}
	public static int[] removeDuplicates(int arr[] )
    {	
		int n = arr.length;
		sort(arr,0,n-1);
        // Return, if array is empty
        // or contains a single element
        if (n==0 || n==1)
            return arr;
      
        int[] temp = new int[n];
         
        // Start traversing elements
        int j = 0;
        for (int i=0; i<n-1; i++){
            // If current element is not equal
            // to next element then store that
            // current element
            if (arr[i] != arr[i+1]){
                temp[j++] = arr[i];
            } 
        // Store the last element as whether
        // it is unique or repeated, it hasn't
        // stored previously
        }
        temp[j++] = arr[n-1];   
    
        // Modify original array
        int[] result = new int[j];
        for(int i=0;i<j;i++){
        	result[i] = temp[i];
        }
        return result;
    }
}

