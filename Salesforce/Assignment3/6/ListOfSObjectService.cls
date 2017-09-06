public class ListOfSObjectService implements IListOfSObjectService{
	
	public static void listobjects(){
        List<Schema.SObjectType> gd = Schema.getGlobalDescribe().Values();
        for(Schema.SObjectType f : gd) {
            System.debug(' ---' + f.getDescribe().getLabel() );
        }
    }
	
    
}