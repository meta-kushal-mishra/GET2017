public class MapOfClass {
    
    public static Map<Class__c,List<Student__c>> getMapOfClass(){
        List<Class__c> classList=(new ClassSelector().getClassById());
        List<Student__c> studentList = new List<Student__c>();
        Map<Class__c,List<Student__c>> map1=new Map<Class__c,List<Student__c>>();
        System.debug(classList.size());
        for(Class__c classInstance : classList){
         	studentList= (new StudentSelector().getStudentsById(classInstance.id));
        	map1.put(classInstance,studentList);
        }
        System.debug(map1);
     	return map1;
    }
}