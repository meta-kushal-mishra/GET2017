public class CustomStatusDomain extends fflib_SObjectDomain {
	public CustomStatusDomain(List<Opportunity> sObjectList){
        super(sObjectList);
    }
    
    public class Constructor implements fflib_SObjectDomain.IConstructable {
        public fflib_SObjectDomain construct(List<sObject> sObjectList) {
            return new CustomStatusDomain(sObjectList);
        }
    }
    
    public override void onBeforeUpdate(Map<Id,SObject> existingRecords) {
    	Set<Id> opporutnityIdSet = new Set<Id>();
    	for (Opportunity objOpportunity : (List<Opportunity>) Records) {
    		if (objOpportunity.CustomStatus__c != null && objOpportunity.CustomStatus__c == 'Reset') {
    			opporutnityIdSet.Add(objOpportunity.id);
    		}
    	}
        if (opporutnityIdSet != null && opporutnityIdSet.size() > 0) {
            List<OpportunityLineItem> opportunityLineItemList = [select id from OpportunityLineItem where Opportunity.Id IN :opporutnityIdSet];
            Database.delete(opportunityLineItemList);
        }
    
    }
    
}