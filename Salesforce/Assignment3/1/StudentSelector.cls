public  class StudentSelector extends fflib_SObjectSelector implements IStudentSelector {
    
    public List<Schema.SObjectField> getSObjectFieldList(){
        return new List<Schema.SObjectField>{
            Student__c.id,
            Student__c.LastName__c
    
        };
    }
    
    public Schema.SObjectType getSObjectType(){
        return Student__c.sObjectType;
    }
    
   
    public List<Student__c> getStudentsById(ID id) {   
		return (List<Student__c>) Database.query(
        
			newQueryFactory().
			setCondition('Student__c.Class__r.id = :id').
			toSOQL());
	}
}