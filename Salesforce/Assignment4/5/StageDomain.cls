public class StageDomain extends fflib_SObjectDomain{
	public StageDomain(List<Opportunity> sObjectList){
        super(sObjectList);
    }
    
    public class Constructor implements fflib_SObjectDomain.IConstructable {
        public fflib_SObjectDomain construct(List<sObject> sObjectList) {
            return new StageDomain(sObjectList);
        }
    }
    
   public override void onBeforeUpdate(Map<Id,SObject> existingRecords){
        for(Opportunity opp : (List<Opportunity>) Records){
        if(opp.StageName.Contains('Closed Won') || opp.StageName.Contains('Closed Lost')){
            opp.CloseDate = System.today();
        }
    }
    }
}