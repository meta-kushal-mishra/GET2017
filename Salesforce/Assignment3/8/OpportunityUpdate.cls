public class OpportunityUpdate extends fflib_SObjectDomain {
    public OpportunityUpdate(List<Opportunity> sObjectList) {
        super(sObjectList);
    }
    
    public class Constructor implements fflib_SObjectDomain.IConstructable {
        public fflib_SObjectDomain construct(List<sObject> sObjectList) {
            return new OpportunityUpdate(sObjectList);
        }
    }
    
    public override void onBeforeInsert() {
        accountUpdate();
	}
    public override void onBeforeUpdate(Map<Id,SObject> existingRecords) {
      	accountUpdate();
	}
    
    public void accountUpdate(){
        for(Opportunity opp : (List<Opportunity>) Records) {                  
            if(opp.BillToContact__c != null && opp.Manager__c == null){
                    opp.Manager__c =opp.Account.Id;
                }
        }
    }
}