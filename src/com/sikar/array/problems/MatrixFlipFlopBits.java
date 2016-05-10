package com.sikar.array.problems;

public class MatrixFlipFlopBits extends Matrix{

	/**
	 * Given a boolean matrix mat[M][N] of size M X N, modify it such that if a
	 * matrix cell mat[i][j] is 1 (or true) then make all the cells of ith row
	 * and jth column as 1
	 */
	
	public static void booleanMatrix(int[][] a){
		
		int rows = a.length;
		
		int cols = a[0].length;
		
		if(rows > 0 && cols > 0){
			
			boolean paintRow = false;
			boolean paintCol = false;
			
			
			//Check if the first row has any 1 in it.
			for(int col=0;col<cols;col++){
				
				if(a[0][col] == 1){
					paintRow = true;
					break;
				}
			}
			
			//Check if the first col has any 1 in it.
			for(int row=0;row<rows;row++){
				
				if(a[row][0] == 1){
					
					paintCol = true;
					break;
				}
			}
			//By this time we have covered the first row and first col
			//now move to the subsequent rows/cols
			for(int row=1;row<rows;row++){
				
				for(int col=1;col<cols;col++){
					
					if(a[row][col]==1){
						//store the values in top row and column
						a[row][0] = 1;
						a[0][col] = 1;
					}
				}
			}
			
			//In above loop we might have changed the top row or column
			//make the necessary changes in the remaining matrix
			for(int row=1;row<rows;row++){
				
				for(int col=1;col<cols;col++){
					
					if(a[row][0]==1 || a[0][col]==1){
						a[row][col] = 1;
					}
				}
			}
			
			//Now paint the rows
			if(paintRow){
				for(int col=0;col<cols;col++){
					
					a[0][col]=1;
				}
			}
			
			//Paint the cols
			if(paintCol){
				for(int row=0;row<rows;row++){
					
					a[row][0]=1;
				}
			}
		}
	}
	
	public static void main(String args[]){
		
	int [][] mat = new int[][] { {1, 0, 0, 1},{0, 0, 1, 0},{0, 0, 0, 0}};
	 
    System.out.println("Input Matrix \n");
    printMatrix(mat, mat.length, mat[0].length);

    booleanMatrix(mat);

    System.out.println("Matrix after modification \n");
    printMatrix(mat, mat.length, mat[0].length);
    
	}
}
