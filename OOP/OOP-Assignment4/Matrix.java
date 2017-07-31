package oopmain;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Matrix {
	
	BufferedReader br;
	CompositeMenuItem mainmenu;

	public Matrix(){
		br = new BufferedReader(new InputStreamReader(System.in));
		
	}
	public void createMenu() {
		mainmenu = new CompositeMenuItem();
		
	}
	
	public void display(int[][] result){
		for(int i=0;i < result.length ; ++i){
			for(int j=0;j<result[0].length;++j)
				System.out.print(result[i][j]+" ");
			System.out.println();
		}
		
	}
	public int getPositiveIntegerInput(String inputMessage, boolean negative_allowed ){
		int inputNumber;
		try{
			System.out.println(inputMessage);
			inputNumber = Integer.parseInt(br.readLine());
			if(inputNumber <= 0 && !negative_allowed)
				inputNumber = getPositiveIntegerInput(inputMessage, negative_allowed);

		}
		catch(Exception ex){
			System.out.println("invalid input: "+ex.getMessage());
			inputNumber = getPositiveIntegerInput(inputMessage, negative_allowed);
		}
		return inputNumber;
	}
	
	public int[][] createMatrix(){
		Matrix matrix = new Matrix();
		int numberOfRowsInMatrix = matrix.getPositiveIntegerInput("Please enter valid number " + "of rows in matrix", false);
		int numberOfColumnsInMatrix = matrix.getPositiveIntegerInput("Please enter valid " + "number of columns in matrix", false);
		int[][] matrixArray = new int[numberOfRowsInMatrix][numberOfColumnsInMatrix];
		for(int i=0;i<numberOfRowsInMatrix;++i){
			for(int j=0;j<numberOfColumnsInMatrix;++j)
				matrixArray[i][j] = matrix.getPositiveIntegerInput("Please enter valid value at " + (i+1)+" th row and "+(j+1) + " th column in matrix", true);
		}
		return matrixArray;
	}
	public static void main(String args[]){
		Matrix matrix = new Matrix();
		matrix.createMenu();

	}
}

