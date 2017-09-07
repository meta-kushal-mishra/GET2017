public class ListOfSObjectService implements IListOfSObjectService{
	
	public static List<Schema.SObjectType> listobjects(){
        List<Schema.SObjectType> gd = Schema.getGlobalDescribe().Values();
		List<String> sObjects
        for(Schema.SObjectType f : gd) {
            System.debug(' ---' + f.getDescribe().getLabel() );
        }
		return gd;
    }
	
    
}