public class AccountFilterController {

      
   public string getBillingCitystring{get;set;}
      
   public string getBillingStatestring{get;set;}
      
   public string getBillingCountrystring{get;set;}
  
   public List<Account> createAccountList{get;set;}

  
   public void searchRecords(){
       createAccountList= new list<Account>();
       string Query = 'SELECT id,name,billingcity,billingCountry,billingState FROM Account where ';
       if(string.isBlank(getBillingCitystring)  && string.isBlank(getBillingStatestring) && string.isBlank(getBillingCountrystring)) {
           Query = 'SELECT id,name,billingcity,billingCountry,billingState FROM Account';
   		}    
   		
       if(!(string.isBlank(getBillingCitystring))){
            Query = Query + 'billingcity LIKE \'%'+getBillingCitystring+'%\' AND ';
       
       }
       if(!(string.isBlank(getBillingCountrystring))) {
           Query = Query + ' billingcountry  LIKE  \'%'+getBillingCountrystring+'%\' AND ';
       }
       
       if(!(string.isBlank(getBillingStatestring))) {
         Query = Query +  ' billingstate LIKE  \'%'+getBillingStatestring+'%\' AND ';
       }
       
       if(Query.substring(Query.length()-4,Query.length()).equals('AND ')) {
       Query= Query.substring(0,Query.length()-4);
       }
       Query = Query + ' limit 100';
       createAccountList= Database.query(Query);                  
   }
}