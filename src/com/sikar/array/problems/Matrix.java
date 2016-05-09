package com.sikar.array.problems;

import java.util.HashMap;
import java.util.Map;

public class Matrix {

	public static void rotate2DMatrixBy90Degrees(int[][] array,int rows,int cols){
		
		printMatrix(array, rows, cols);
		for(int row=0;row<rows;row++){
			
			for(int col=row;col<cols;col++){
				
				int temp = array[row][col];
				
				array[row][col] = array[col][row];
				
				array[col][row] = temp;
			}
		}
		printMatrix(array, rows, cols);
	}
	
	public static void printMatrix(int[][] array,int rows,int cols){
		
		System.out.println();
		for(int row=0;row<rows;row++){
			
			for(int col=0;col<cols;col++){
				
				System.out.print(array[row][col]+",");
			}
			System.out.println();
		}
	}
	
	public static int commonElementInAllRowsInA2DArray(int[][] a,int rows,int cols){
		
		if(a.length <=0){
			return -1;
		}
		
		int common = -1;
		
		Map<Integer,Integer> map = new HashMap<>();
		
		//insert 1st row into map
		for(int index=0;index<cols;index++){
			
			map.put(a[0][index], 1);
		}
		
		//check if others rows has a common element
		for(int row=1;row<rows;row++){

			for(int col=0;col<cols;col++){
				
				if(map.containsKey(a[row][col])){
					map.put(a[row][col], row+1);
				}
			}
			
		}
		
		for(Map.Entry<Integer, Integer> entry: map.entrySet()){
			
			if(entry.getValue() == rows){
				return entry.getKey();
			}
		}
		return common ;
	}
	
	public static void printSpiral(int[][] a){

		int top =0 , bottom = a.length-1, left = 0, right = a[0].length-1;
		int dir = 0;
		
		while(top <= bottom && left <= right){
		
			//left to right
			if(dir == 0){
			
				for(int i=left;i<=right;i++){
					
					System.out.println(a[top][i]);
				}
				top++;
				dir = 1;
			}
			//top to bottom
			else if(dir == 1){
			
				for(int i=top;i<=bottom;i++){
					
					System.out.println(a[i][right]);
				}
				right--;
				dir = 2;
			}
			//right to left
			else if(dir == 2){
				
				for(int i=right;i>=left;i--){
					
					System.out.println(a[bottom][i]);
				}
				bottom--;
				dir = 3;
			}
			//bottom to top
			else {
				for(int i=bottom;i>=top;i--){
					
					System.out.println(a[i][left]);
				}
				left++;
				dir = 4;
			}
			dir = dir%4;
		}
	}
	public static void main(String args[]){
		
		int array[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		
		rotate2DMatrixBy90Degrees(array, array.length, array[0].length);
//		printSpiral(array);
//		int a[][] = {{1, 2, 3, 4, 5},
//                	{2, 4, 5, 8, 10},
//                	{3, 5, 7, 5, 11},
//                	{1, 3, 5, 7, 19},};
//		
//		System.out.println(commonElementInAllRowsInA2DArray(a, a.length, a[0].length));
	}
}
