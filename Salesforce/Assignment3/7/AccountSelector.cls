public class AccountSelector extends fflib_SObjectSelector {
	
	public List<Schema.SObjectField> getSObjectFieldList() {
		
		return new List<Schema.SObjectField> {
			Account.Id,
			Account.Name	
		};
	}
	
	public Schema.SObjectType getSObjectType() {
		return Account.SObjectType;
	}
	
	public override String getOrderBy() {
		return 'Name';
	}
	
	public List<Account> getAccountsWithContacts(Integer recordLimit) {
		String fieldList = 'Id, Name';
		String query = String.format('SELECT {0}, (SELECT Id, Name from Contacts) from {1} ORDER BY {2} Limit {3}',
				new List<String>{
					fieldList,
					getSObjectName(),
					getOrderBy(),
					String.valueOf(recordLimit)
				});
		return (List<Account>) Database.query(query);
	}    
}