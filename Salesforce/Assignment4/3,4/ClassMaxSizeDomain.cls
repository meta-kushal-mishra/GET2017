public class ClassMaxSizeDomain extends fflib_SObjectDomain{
	
   public ClassMaxSizeDomain(List<Student__c> sObjectList){
       super(sObjectList);
   }
   
   public class Constructor implements fflib_SObjectDomain.IConstructable {
       public fflib_SObjectDomain construct(List<sObject> sObjectList){
           return new ClassMaxSizeDomain(sObjectList);
       }
   }
   
  public override void onBeforeInsert() {
     
      Map<Student__c,Class__c> studentClassMap = new Map<Student__c,Class__c>();
      studentClassMap = generateStudentClassMap();

      for(Student__c student : studentClassMap.keySet()) {
          Class__c cls = studentClassMap.get(student);
          if(cls.MaxSize__c <= cls.NumberOfStudents__c) {
              student.addError('Entries full in class '+ cls.Name);
          }
      }
      
  }
   public override void onBeforeUpdate(Map<Id,SObject> existingRecords) {
     
      Map<Student__c,Class__c> studentClassMap = new Map<Student__c,Class__c>();
      studentClassMap = generateStudentClassMap();

      for(Student__c student: studentClassMap.keySet()) {
          Class__c cls = studentClassMap.get(student);
          if(cls.MaxSize__c <= cls.NumberOfStudents__c) {
              student.addError('Entries full in class '+cls.Name);
          }
      }
      
  }
     public override void onAfterInsert()
   {
Map<Student__c,Class__c> studentClassMap = new Map<Student__c,Class__c>();
      studentClassMap = generateStudentClassMap();
List<Class__c> clss = new List<Class__c>();
      for(Student__c student: studentClassMap.keySet())
      {
          Class__c cls = studentClassMap.get(student); 
          cls.MyCount__c = cls.NumberOfStudents__c +1;
          clss.add(cls);
      }
       update clss;
   } 
     public override void onAfterUpdate(Map<Id,SObject> existingRecords)
   {
Map<Student__c,Class__c> studentClassMap = new Map<Student__c,Class__c>();
      studentClassMap = generateStudentClassMap();
List<Class__c> clss = new List<Class__c>();
      for(Student__c student: studentClassMap.keySet())
      {
          Class__c cls = studentClassMap.get(student); 
          cls.MyCount__c = cls.NumberOfStudents__c;
          clss.add(cls);
      }
       update clss;
   } 
    
     public Map<Student__c,Class__c> generateStudentClassMap() {
          Map<Student__c,Class__c> studentClassMap = new Map<Student__c,Class__c>();
          List<Student__c> listOfStudents = (List<Student__c>)Records;
          Set<Id> classIds = new Set<Id>();
          for(Student__c student: listOfStudents) {
              classIds.add(student.Class__c);
          }
          List<Class__c> listOfClass = new ClassSelector().selectById(classIds);
          for(Student__c student: listOfStudents) {
              
              for(Class__c cls : listOfClass) {
                  if(student.Class__c == cls.Id) {
                      studentClassMap.put(student, cls);
                  }
              }
          }
          return studentClassMap;
  }
}