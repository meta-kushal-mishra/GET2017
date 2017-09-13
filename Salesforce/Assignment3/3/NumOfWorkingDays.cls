public class NumOfWorkingDays {
	 public static Integer numOfWorkingDays(Date startDate, Date endDate){
        Integer numOfWorkingDays = 0;
        if(startDate>endDate)
            return -1;
		Date tempStartDate = startDate.addDays(1);
        for(Integer i=0; tempStartDate != endDate; i++){
           if(tempStartDate.daysBetween(tempStartDate.toStartofWeek()) == 0 ||
              tempStartDate.daysBetween(tempStartDate.toStartofWeek()) == -6){
           			tempStartDate = tempStartDate.adddays(1);
       		}
			else{
				numOfWorkingDays = numOfWorkingDays+1;
				tempStartDate = tempStartDate.adddays(1);
			}
        }        
        return numOfWorkingDays;
    }
}