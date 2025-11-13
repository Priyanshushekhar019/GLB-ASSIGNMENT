import java.util.Scanner;

public class Searchingelementsinmatrix {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no. of rows:");
        int n=sc.nextInt();
        System.out.println("Enter no. of columns:");
        int m=sc.nextInt();
        int[][] matrix=new int[n][m];
        System.out.println("Enter the elements of matrix:");
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                matrix[i][j]=sc.nextInt();
            }
        }
        System.out.println("Enter the elements to search:");
        int target=sc.nextInt();
        boolean found=false;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==target){
                    System.out.println("Elements found at position:("+i+","+j+")");
                    found=true;
                    break;
                }
            }
            if(found){
                break;
            }
        }
            if(!found){
                System.out.println("Elements not found in matrix");
            }
        }
    }

