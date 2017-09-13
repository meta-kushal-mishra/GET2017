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
    	String fieldList = 'Id, Name';
		String query = String.format('SELECT {0}, (SELECT Id, Name from Students__r) from {1} ',
				new List<String>{
					fieldList,
					getSObjectName()
				});
		return (List<Class__c>) Database.query(query);
	}
}