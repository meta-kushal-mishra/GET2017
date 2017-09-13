public class Accounts extends fflib_SObjectDomain {
	public static fflib_SObjectUnitOfWork uow;
   	public Accounts(List<Account> sObjectList) {
    	super(sObjectList);
       
   }

   public class Constructor implements fflib_SObjectDomain.IConstructable {
       public fflib_SObjectDomain construct(List<SObject> sObjectList) {
           return new Accounts(sObjectList);
       }
   }
	public override void onAfterInsert() {
  		myChildCount(null); 
  	}
  	public override void onAfterUpdate(Map<Id, SObject> existingRecords) {
  		myChildCount(existingRecords);
  	}
  	public override void onAfterDelete() {
  		myChildCount(null); 
  	}
  	public void myChildCount(Map<Id, SObject> existingRecords){
      	List<Account> listOfAccount=(List<Account>)Records;
  		List<Account> accListToUpdate=new List<Account>();
   		Set<Id> parentAccountId=new Set<Id>();
 		if (Trigger.isInsert || Trigger.isUpdate || Trigger.isUndelete){
            for(Account acc : listOfAccount){
                if(acc.ParentAccount__c != null)
                    parentAccountId.add(acc.ParentAccount__c);
            }
  		}
        if(Trigger.isDelete){
      		for(Account acc :listOfAccount){
       			if(acc.ParentAccount__c!= null)
        			parentAccountId.add(acc.ParentAccount__c);
      		}
  		}
   		for(AggregateResult res : [SELECT count(Id)can,ParentAccount__c FROM Account WHERE ParentAccount__c IN :parentAccountId group by ParentAccount__c ]) {
        
       		accListToUpdate.add(new Account(Id=(Id)res.get('ParentAccount__c'),ChildCount__c=(Integer)res.get('can')));
  		}
      	try{
    		update accListToUpdate;
  		}catch(DmlException de){	
    		System.debug(de);
  		}

  	}
}