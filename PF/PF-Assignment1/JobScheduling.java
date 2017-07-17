public class JobScheduling {
	public static void main(String arg[]){
		int arrival[]={1,5,9,25};
		int job_size[]={12,7,2,5};
		int arr[][]=FCFS(arrival,job_size);
		for(int i=0;i<arrival.length;i++){
			for(int j=0;j<5;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static int[][] FCFS(int arrival_time[], int job_size[]){
			int job_starts_at[] = new int[arrival_time.length];
			int waiting_time[] = new int[arrival_time.length];
			int job_finished_at[] = new int[arrival_time.length];
			job_starts_at[0] = arrival_time[0];
			for(int j=1;j<arrival_time.length;j++){
				job_starts_at[j] = job_starts_at[j-1] + job_size[j-1];
				if(job_starts_at[j]<arrival_time[j]){
					job_starts_at[j] = arrival_time[j];
				}
				
			}
			for(int j=0;j<arrival_time.length;j++){
				job_finished_at[j] = job_starts_at[j] + job_size[j] - 1;
			}
			waiting_time[0] = 0;
			for(int j=0;j<arrival_time.length;j++){
				waiting_time[j] = job_starts_at[j] - arrival_time[j];
			}
			
			int arr[][] = new int[arrival_time.length][5];
			for(int i = 0;i<arrival_time.length;i++){
				for(int j=0;j<5;j++){
					if(j==0){
						arr[i][j]=i+1;
					}
					else if(j==1){
						arr[i][j]=arrival_time[i];
					}
					else if(j==2){
						arr[i][j]=waiting_time[i];
					}
					else if(j==3){
						arr[i][j]=job_starts_at[i];
					}
					else if(j==4){
						arr[i][j]=job_finished_at[i];
					}
				}
			}
			return arr;
		}
	
	}

