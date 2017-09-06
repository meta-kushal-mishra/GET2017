public class OpportunitySelector extends fflib_SObjectSelector implements IOpportunitySelector {
    
     public List<Schema.SObjectField> getSObjectFieldList(){
        return new List<Schema.SObjectField>{
            Opportunity.Name,
            Opportunity.Owner.id
    
        };
    }
    
    public Schema.SObjectType getSObjectType(){
        return Opportunity.sObjectType;
    }
    
   
    public List<Opportunity> getOpportunityByModifiedDate() {   
    return (List<Opportunity>) Database.query(
        
        newQueryFactory().
        setCondition('LastModifiedDate=LAST_N_DAYS:30').
        toSOQL());
	}
}