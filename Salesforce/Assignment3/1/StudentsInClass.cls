public  class StudentsInClass{
    
    public static List<Student__c> getStudents(){
    	//StudentsInClass students = new StudentsInClass();
    	return(new StudentSelector().getStudentsById('a017F000002fFGgQAM'));
    }
}