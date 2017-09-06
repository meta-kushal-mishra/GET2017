public class LoanCitySelector extends fflib_SObjectSelector {
    
    public List<Schema.SObjectField> getSObjectFieldList(){
        return new List<Schema.SObjectField>{
            CityManager__c.Name,
            CityManager__c.City__c
        };
    }
    
    public Schema.SObjectType getSObjectType(){
        return CityManager__c.sObjectType;
    }
    
    public List<CityManager__c> getManagerByCity(Set<String> city) {  

     
   		 return (List<CityManager__c>) Database.query( newQueryFactory(). setCondition('CityManager__c.City__c IN :City').toSOQL());
	}
}