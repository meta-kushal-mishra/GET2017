package oop2;

import java.util.Arrays;
import java.io.IOException;

public class SortQuestions{

	private Question[] ques;
	private ReadQuestions read = new ReadQuestions("questions.txt");
	
	
	// Method to sort the questions based on the question text
	public void sortQuestions() throws IOException{
		String[] lines = read.readLines();	
		ques = new SurveyApplication().separateLines(lines);		//creating the question objects
		
		Arrays.sort(ques);
		//printing the sorted array
		for(int i=0;i<ques.length;i++) {
			System.out.println(ques[i].getQuestion());
		}
	}
	
	public static void main(String[] args) {
		SortQuestions sortQues = new SortQuestions();
		try{
			sortQues.sortQuestions();
		}
		catch(IOException e){
			e.printStackTrace();
	}
}
