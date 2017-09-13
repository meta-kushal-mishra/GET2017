public interface IAccountsService 
{
	void updateContactIdsInAccounts(String contactId);
    Id insertAccount(String accountName, String actNumber, String actType, String dummy);
    void insertAccounts(List<AccountsService.AccountWrapper> accountsWrapper);
}