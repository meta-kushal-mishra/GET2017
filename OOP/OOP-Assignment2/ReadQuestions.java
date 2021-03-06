package oop2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadQuestions {
	
	private String path;	//path for the file to read
	private FileReader fileReader;
	private BufferedReader reader;
	
	public ReadQuestions(String path) {
		this.path = path;
	}
	
	// method to open file for reading
	private void openFile() throws FileNotFoundException {
		fileReader = new FileReader(path);
		reader = new BufferedReader(fileReader);
	}
	
	// method to read all the lines present in the file
	public String[] readLines() throws IOException {
		String[] lines=null;
		try {
			//initialize the lines object according to number of lines present in the file
			lines = new String[numberOfLines()];
			openFile();
			
			for(int i=0; i < lines.length; i++) {	//loop to read lines from the file
				lines[i] = reader.readLine();
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			reader.close();
		}
		
		return lines;
	}
	
	// method to count number of lines
	private int numberOfLines() throws IOException {
		int numberLines = 0;
		try{
		openFile();
		while(reader.readLine() != null) 	//loop to traverse through the files line by line
			numberLines++;
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		finally{
		reader.close();
		}
		return numberLines;
	}
}
