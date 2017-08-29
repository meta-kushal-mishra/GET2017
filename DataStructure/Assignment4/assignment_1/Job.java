package assignment_1;

class Job
{
    private int priority;
    private String message;
 
    public Job(int priority, String message) {
    	
        this.priority = priority;
        this.message = message;
    }
  
    public int getJobPriority() {
    	
    	return this.priority;
    }
    
    public String getJobMessage() {
    	return this.message;
    }
    
    public String toString() {
    	
        return "priority : "+ priority + "   message : "+ message;
    }
}
