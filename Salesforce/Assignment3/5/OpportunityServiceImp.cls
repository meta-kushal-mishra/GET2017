public class OpportunityServiceImp implements IOpportunityService, Schedulable {
   
    public void execute(SchedulableContext SC){
    	sendMail();
 	}
    
	public Integer sendMail(){
   		List<Messaging.SingleEmailMessage> mails = new List<Messaging.SingleEmailMessage>();
   		List<Opportunity> oppList = new OpportunitySelector().getOpportunityByModifiedDate(); 
		EmailTemplate templateId = [Select id from EmailTemplate where name = 'OpportunityOwner'];
     	for(Opportunity op : oppList){
			Mwssaging.SingleEmailMessage mail = new Messaging.SingleEmailMessage();
			mail.setTemplateId(templateId.id);
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