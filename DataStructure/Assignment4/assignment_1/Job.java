package assignment_1;

class Job
{
    private int priority;
 
    public Job(int priority) {
    	
        this.priority = priority; 
    }
  
    public int getJobPriority() {
    	
    	return this.priority;
    }
    
    public String toString() {
    	
        return "priority : "+ priority;
    }
}
