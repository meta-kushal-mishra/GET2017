public class InsertLoanDomain extends fflib_SObjectDomain {
	public InsertLoanDomain(List<Loan__c> sObjectList){
        super(sObjectList);
    }
    
    public class Constructor implements fflib_SObjectDomain.IConstructable {
        public fflib_SObjectDomain construct(List<sObject> sObjectList) {
            return new InsertLoanDomain(sObjectList);
        }
    }
    
    public override void onBeforeInsert(){
        Set<String> loanId = new Set<string>();
        for(Loan__c loan : (List<Loan__c>) Records){
            loanId.add(loan.City__c);
        }
        
        List<CityManager__c> managerList = new LoanCitySelector().getManagerByCity(loanId);
        List<Loan__c> l = new List<Loan__c>();
        for(Loan__c loan : (List<Loan__c>) Records){
        	for(CityManager__c manager : managerList){
        		if(loan.City__c == manager.City__c){
        			loan.Manager__c = manager.Name;
        			l.add(loan);
        		}
        	}
        }
       // update l;
    }

}