public class MapOfClass {
    
    public static Map<Class__c,List<Student__c>> getMapOfClass(){
        List<Class__c> classList=(new ClassSelector().getClassById());
        integer index=0;
        List<Student__c> studentList = new List<Student__c>();
        Map<Class__c,List<Student__c>> map1=new Map<Class__c,List<Student__c>>();
        for(Class__c classInstance : classList){
         	studentList = classList.get(index).Students__r;
        	map1.put(classInstance,studentList);
            index++;
        }
     	return map1;
    }
}