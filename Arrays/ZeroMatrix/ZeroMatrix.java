/*
Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
column are set to O.
*/
import java.util.*;
public class ZeroMatrix{
	
	public static void main(String args[]){
		int[][] matrix = new int[][]{{1, 2, 3},{2, 4, 0},{2, 4, 5},{3, 0, 4}};
		
		
		System.out.println("Matrix before: ");
		printMatrix(matrix);
		int[][] zeroedMatrix = zeroMatrix(matrix);
		System.out.println("Matrix after: ");
		printMatrix(zeroedMatrix);
	}
	
	static int[][] zeroMatrix(int[][] matrix){
		Set<Integer> rowsToZero = new HashSet<>();
		Set<Integer> columnsToZero = new HashSet<Integer>();
		int n = matrix.length;
		int m = matrix[0].length;
		for (int i=0;i < n;i++){
			for(int j=0;j<m;j++){
				if (matrix[i][j] == 0){
					rowsToZero.add(i);
					columnsToZero.add(j);
				}
			}
		}
		
		for(Integer row: rowsToZero){
			for (int j = 0; j<m; j++){
				matrix[row][j] = 0;
			}
		}
		
		
		for(Integer column: columnsToZero){
			for (int i = 0; i<n; i++){
				matrix[i][column] = 0;
			}
		}
		
		return matrix;
	}
	
	static void printMatrix(int[][] matrix){
		int n = matrix.length;
		int m = matrix[0].length;
		
		for (int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}