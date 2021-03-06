package oopmain;

public class MenuTransposeMatrix extends Menu {
	String Name;
	public MenuTransposeMatrix(){
		this.Name = "Transpose" ;
	}
	
	@Override
	public void actionTaken() {
		Matrix matrix = new Matrix();
		int[][] firstMatrix = matrix.createMatrix();
		int[][] matrixTranspose = new int[firstMatrix[0].length][firstMatrix.length];
		for(int i=0;i<firstMatrix[0].length;++i){
			for(int j=0;j<firstMatrix.length;++j)
				matrixTranspose[i][j] = firstMatrix[j][i];
		}
		matrix.display(matrixTranspose);
	}

	@Override
	public void setName(String name) {
		this.Name = name;
		
	}

	@Override
	public String getName() {
		return Name;
	}
}
