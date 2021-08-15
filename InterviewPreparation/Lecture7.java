import java.util.*;
public class Lecture7 {
  public static void main(String[] args) {
    int arr[][]={{1,3,1},{1,5,1},{4,2,1}};
    // System.out.println(minimumPathSumWithRecursion(0,0,arr));
    int dp[][]= new int[arr.length][arr[0].length];
    // System.out.println(minimumPathSumWithMemoization(0,0,arr,dp));
    // for(int i=0;i<dp.length;i++){
    //   for(int j=0;j<dp[0].length;j++){
    //     System.out.print(dp[i][j]+" ");
    //   }
    //   System.out.println();
    // }
    System.out.println(minimumPathSumWithTabulation(arr,dp));
    for(int i=0;i<dp.length;i++){
      for(int j=0;j<dp[0].length;j++){
        System.out.print(arr[i][j]+" ");
      }
      System.out.println();
    }
  }
  public static int minimumPathSumWithTabulation(int arr[][],int dp[][]){
    for(int i=arr.length-1;i>=0;i--){
      for(int j=arr[0].length-1;j>=0;j--){
        if(i==arr.length-1&&j==arr[0].length-1){
          // dp[i][j]= arr[i][j];
          continue;
        }
        if(i==arr.length-1){
          arr[i][j]= arr[i][j+1]+arr[i][j];
          continue;
        }
        if(j==arr[0].length-1){
          arr[i][j]= arr[i+1][j]+arr[i][j];
          continue;
        }
        arr[i][j]=Math.min(arr[i+1][j], arr[i][j+1])+arr[i][j];
      }
    }
    return arr[0][0];
  }

  public static int minimumPathSumWithMemoization(int row,int col,int arr[][],int dp[][]){
    if(row==arr.length-1&&col==arr[0].length-1){
      return dp[row][col]= arr[row][col];
    }
    if(row>=arr.length||col>=arr[0].length){
      return Integer.MAX_VALUE;
    }
    if(dp[row][col]!=0){
      return dp[row][col];
    }
    int left= minimumPathSumWithMemoization(row,col+1,arr,dp);
    int right= minimumPathSumWithMemoization(row+1,col,arr,dp);
    return dp[row][col]= Math.min(left,right)+arr[row][col];
  }
  public static int minimumPathSumWithRecursion(int row,int col,int arr[][]){
    if(row==arr.length-1&&col==arr[0].length-1){
      return arr[row][col];
    }
    if(row>=arr.length||col>=arr[0].length){
      return Integer.MAX_VALUE;
    }
    int left= minimumPathSumWithRecursion(row,col+1,arr);
    int right= minimumPathSumWithRecursion(row+1,col,arr);
    return Math.min(left,right)+arr[row][col];
  }
}
