

public class LongestSequence {

	public static void main(String[] args) {
		int input[]={1,2,3,2,3,4,5,3,4,2,2,3,4,5,6,7,8,1,2,4,5,6,7,8,9};
		LongestSequence.longestSequence(input);
	}
	
	// method returns longest increasing sequence and takes array input
	public static int[] longestSequence(int input[]){
		int i=0,j=0,k=0,max=0,start=0,last=0;
		int length = input.length;
		if (length==0 || length==1)
            		return input;
		for(i=0;i<input.length-1;i++){
			if(input[i]<input[i+1]){
				k++;
			}
			else{
				if(k>max){
					start=j;
					last=i;
					max=k;
				}
	
				j=i+1;
				k=0;
			}
		}
		if(k>max){
			start=j;
			last=i;
			max=k;
		}
		//k1=0;
		int resultArr[] =new int[max+1];
		for(int i1=start,k1=0;i1<=last;i1++,k1++){
			resultArr[k1]=input[i1];
		System.out.print(resultArr[k1]);
		}
		System.out.println(resultArr.length);
		return resultArr;
		}
	

}
