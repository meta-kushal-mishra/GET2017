public class OpportunityServiceImp implements IOpportunityService, Schedulable {
   
    public void execute(SchedulableContext SC){
    	sendMail();
 	}
    
	public Integer sendMail(){
   		List<Messaging.SingleEmailMessage> mails = new List<Messaging.SingleEmailMessage>();
   		List<Opportunity> oppList = new OpportunitySelector().getOpportunityByModifiedDate(); 
     	for(Opportunity op : oppList){
          Messaging.SingleEmailMessage mail = new Messaging.SingleEmailMessage();
          mail.setTemplateId('00X7F000000l8wqUAA');
          mail.setTargetObjectId(op.Owner.id);
        //  mail.setSaveAsActivity(false);
          mails.add(mail);
    	}
      	if ( mails.size() > 0 )
        	Messaging.sendEmail(mails, false);
        System.debug(mails.size());
        return mails.size();
	}
}