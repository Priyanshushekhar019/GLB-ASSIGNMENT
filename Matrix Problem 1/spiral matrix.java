import java.util.*;
public class spiraltraversal {
    static int[] spiralorder(int[][] matrix){
        int n=matrix.length;
        int m =matrix[0].length;
        int[] result=new int[n*m];
        int index=0;
        int startRow=0;
        int endRow=n-1;
        int startCol=0;
        int endCol=m-1;
        while(startRow<=endRow && startCol<=endCol){
            for(int j=startCol;j<=endCol;j++){
                result[index++]=matrix[startRow][j];
            }
            for(int i=startRow+1;i<=endRow;i++){
                result[index++]=matrix[i][endCol];
            }
            if(startRow<endRow){
                for(int j=endCol-1;j>=startCol;j--){
                    result[index++]=matrix[endRow][j];
                }
            }
            if(startCol<endCol){
                for(int i=endRow-1;i>startRow;i--){
                    result[index++]=matrix[i][startCol];
                }
            }
            startRow++;
            endRow--;
            startCol++;
            endCol--;

        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no. of rows:");
        int n=sc.nextInt();
        System.out.println("Enter no. of columns:");
        int m=sc.nextInt();
        int[][] matrix=new int[n][m];
        System.out.println("Enter matrix elements:");
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                matrix[i][j]=sc.nextInt();
            }
        }
        int[] result=spiralorder(matrix);
        System.out.println("Spiral matrix:");
        for(int val:result){
            System.out.print(val+" ");
        }
    }
}
