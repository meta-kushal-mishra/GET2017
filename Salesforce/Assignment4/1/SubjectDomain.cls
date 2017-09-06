public class SubjectDomain extends fflib_SObjectDomain {
    public SubjectDomain(List<Contact> sObjectList){
        super(sObjectList);
    }
    
    public class Constructor implements fflib_SObjectDomain.IConstructable {
        public fflib_SObjectDomain construct(List<sObject> sObjectList) {
            return new SubjectDomain(sObjectList);
        }
    }
    
    public override void onBeforeInsert() {
        restrictTeacher();
	}
    
    public override void onBeforeUpdate(Map<Id,SObject> existingRecords){
        restrictTeacher();
    }
    
    private void restrictTeacher(){
		for (Contact cont : (List<Contact>) Records){        
            if(cont.Subject__c.equals('Hindi'))
                cont.addError('can not insert as hindi is taught');
        }
    }
}