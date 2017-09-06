public class ClassDeleteFemaleSelector extends fflib_SObjectSelector {
    
 public List<Schema.SObjectField> getSObjectFieldList() 
   {
       return new List<Schema.SObjectField> 
       {
          Student__c.Id,
           Student__c.Name,
              Student__c.Class__c,
              Student__c.Sex__c
       };
   }

   public Schema.SObjectType getSObjectType() 
   {
       return Student__c.sObjectType;
   }

   
   public List<Student__c> getStudentsById(Set<Id> classIds) 
   {
       return (List<Student__c>) Database.query(
			newQueryFactory().
			setCondition('Class__r.Id IN :classIds').
       		toSOQL());
   }
}