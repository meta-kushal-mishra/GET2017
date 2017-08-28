package assignment_1;

import java.util.ArrayList;
import java.util.List;

class PriorityQueue{

	private List<Job> jobList = null;

	private int heapSize;

	public PriorityQueue() {

		jobList = new ArrayList<Job>();

		heapSize = 0;

		// add first element as null to start indexing from 1
		jobList.add(null);
	}

	public void maxHeapify(List<Job> jobList ,  int parentIndex){

		try{

			// variable for index of largest element
			int largestElementIndex = parentIndex;

			// variable for index of left child 
			int leftChildIndex = 2*parentIndex;

			// variable for index of right child
			int rightChildIndex = 2*parentIndex+1;

			// if left child index is less than heap Size and its priority is greater than its parent 
			// set largest to it
			if(leftChildIndex <= heapSize){

				if(jobList.get(leftChildIndex).getJobPriority() < jobList.get(parentIndex).getJobPriority()){

					largestElementIndex = leftChildIndex;
				}
			}

			// if right child index is less than heap size and its priority is greater than the largest 
			// set largest to it
			if(rightChildIndex <= heapSize){

				if(jobList.get(rightChildIndex).getJobPriority() < jobList.get(largestElementIndex).getJobPriority()){

					largestElementIndex = rightChildIndex;
				}
			}

			if(largestElementIndex == parentIndex){

				return;
			}

			// swap largest with root
			swap(largestElementIndex , parentIndex);
 
			maxHeapify(jobList , largestElementIndex);

		}catch(Exception ex){

			System.out.println("Something went wrong: "+ex.getMessage());
		}

	}
	
	public void insertJob(int priority){

		try{

			Job newJob = new Job(priority);

			jobList.add(newJob);

			heapSize++;

			for(int i = heapSize/2 ; i > 0 ;--i){

				maxHeapify(jobList,i);
			}

		}catch(Exception ex){

			System.out.println("Something went wrong: "+ex.getMessage());
		}
	}

	public void printJobQueue(){

		try{

			for(int i = jobList.size()-1 ; i > 1;--i){

				swap(1,i);

				heapSize = heapSize	- 1;

				maxHeapify(jobList, 1);
			}

			if(jobList.size() == 1){

				System.out.println("No jobs to execute");
			}

			for (Job job : jobList) {

				if(job!= null){

					System.out.println(job);
				}
			}

			// make list empty after executing all jobs
			makeJobListEmpty();

		}catch(Exception ex){

			System.out.println("Something went wrong: "+ex.getMessage());
		}
	}

	private void makeJobListEmpty(){

		try{

			jobList = new ArrayList<Job>();

			jobList.add(null);

			heapSize = 0;

		}catch(Exception ex){

			System.out.println("Something went wrong: "+ex.getMessage());
		}
	}
	
	private void swap(int index1 , int index2){

		try{

			Job tempJobObject = jobList.get(index1);

			jobList.set(index1 , jobList.get(index2));

			jobList.set(index2, tempJobObject);
			
		}catch(Exception ex){

			System.out.println("Something went wrong: "+ex.getMessage());
		}
	}
}