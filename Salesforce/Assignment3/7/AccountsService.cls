global with sharing class AccountsService implements IAccountsService {
	
	public static void updateContactIdsInAccounts(String contactId) {
		
		fflib_SObjectUnitOfWork uow = new fflib_SObjectUnitOfWork(
			new Schema.SObjectType[] {
				Account.SObjectType
			}
		);
		
		List<Account> accounts = new AccountSelector().getAccountsWithContacts(10);
		for(Account acc : accounts) {
			if(acc.ContactIds__c != null) {
				if(!acc.ContactIds__c.contains(contactId)) {
					acc.ContactIds__c += ', '+contactId;
					uow.registerDirty(acc);
				}
			}
			else {
				List<String> contactIds = new List<String>();
				for(Contact cntct : acc.Contacts) {
					contactIds.add(cntct.Id);
				}
				acc.ContactIds__c = String.join(contactIds, ', ');
				uow.registerDirty(acc);
			}
		}
		
		try {
			uow.commitWork();
		}
		catch(Exception e) {
			throw e;
		}
	}
	
	global static Id insertAccount(String accountName, String actNumber, String actType, String dummy) {
		fflib_SObjectUnitOfWork uow = new fflib_SObjectUnitOfWork(
			new Schema.SObjectType[] {
				Account.SObjectType
			}
		);
		
		Account acc = new Account(Name = accountName, accountNumber = actNumber, Type = actType);
		uow.registerNew(acc);
		
		try {
			uow.commitWork();
		}
		catch(Exception e) {
			throw e;
		}
		
		return acc.Id;
	}
	
	public static void insertAccounts(List<AccountWrapper> accountsWrapper) {
		fflib_SObjectUnitOfWork uow = new fflib_SObjectUnitOfWork(
			new Schema.SObjectType[] {
				Account.SObjectType
			}
		);
		
		for(AccountWrapper accountWrapper : accountsWrapper) {
			uow.registerNew(new Account(name = accountWrapper.accountName, accountNumber = accountWrapper.accountNumber, Type = accountWrapper.accountType));
		}
		
		try {
			uow.commitWork();
		}
		catch(Exception e) {
			throw e;
		}
	}
	
	global class AccountWrapper {
		public String accountName {get; set;}
		public String accountNumber {get; set;}
		public String accountType {get; set;}
		
		public AccountWrapper(String name, String actNumber, String actType) {
			accountName = name;
			accountNumber = actNumber;
			accountType = actType;
		}
	}
}