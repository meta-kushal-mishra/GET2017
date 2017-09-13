public  class StudentsInClass{
    
    public static List<String> getStudents(String id){
    	
    	List<Student__c> studentList = new StudentSelector().getStudentsById(id);
    	List<String> studentNames = new List<String>();
    	
    	for(Student__c student : studentList){
    		studentNames.add(student.LastName__c);
    	}
    		
    	return studentNames;
    }
}