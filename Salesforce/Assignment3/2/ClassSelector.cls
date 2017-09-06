public class ClassSelector extends fflib_SObjectSelector implements IClassSelector{
    
    public List<Schema.SObjectField> getSObjectFieldList(){
        return new List<Schema.SObjectField>{
            Class__c.id,
            Class__c.Name,
            Class__c.NumberOFStudents__c,
            Class__c.MaxSize__c
        };
    }
    
    public Schema.SObjectType getSObjectType(){
        return Class__c.sObjectType;
    }
    
    public List<Class__c> selectById(Set<ID> idSet){
   		return (List<Class__c>)selectSObjectsById(idSet);
   }
    
    public List<Class__c> getClassById() {   
    	return (List<Class__c>) Database.query( newQueryFactory().toSOQL());
	}
}