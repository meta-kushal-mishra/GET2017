public class ClassDeleteFemaleDomain extends fflib_SObjectDomain {
	public ClassDeleteFemaleDomain(List<Class__c> sObjectList){
        super(sObjectList);
    }
    
    public class Constructor implements fflib_SObjectDomain.IConstructable {
        public fflib_SObjectDomain construct(List<sObject> sObjectList) {
            return new ClassDeleteFemaleDomain(sObjectList);
        }
    }
    
    public override void onBeforeDelete() {
   	List<Class__c> listOfClass = (List<Class__c>)Records;
       Set<Id> classIds = new Set<Id>();
       for(Class__c cls : listOfClass) {
           classIds.add(cls.Id);
       }
       List<Student__c> listOfStudents = new List<Student__c>();
       listOfStudents = new ClassDeleteFemaleSelector().getStudentsById(classIds);
       for(Class__c c : listOfClass) {
           Integer count = 0;
           for(Student__c student : listOfStudents){
               if(student.Class__c == c.Id && student.Sex__c == 'Female') {
                   count++;
               }
               if(count >= 2) {
                   c.addError('Can\'t delete class with more than two female students');
               }
           }
         
       }
    
   }
    
}