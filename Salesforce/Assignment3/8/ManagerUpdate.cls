public class ManagerUpdate {

   public static void updateManager(List<Opportunity> opplist){
   	
       List<Id> listOfContactId = new List<Id>();
       
       for(Opportunity opp: opplist){
       	
           listOfContactId.add(opp.BillToContact__c);
       }
       
       Map<Id,Contact> Mymap = new Map<Id,Contact>([select Id, AccountId from contact where Id in :listOfContactId]);
       
      
       for(Opportunity opp: opplist){
          if(opp.BillToContact__c != null && opp.Manager__c == null){
             if(Mymap.containsKey(opp.BillToContact__c)) {
                 opp.Manager__c = Mymap.get(opp.BillToContact__c).AccountId;
             } 
          }
       }
	}
}