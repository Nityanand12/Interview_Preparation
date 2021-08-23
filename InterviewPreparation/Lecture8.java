import java.util.*;
public class Lecture8 {
  public static void main(String[] args) {
    int arr[][]={{1,3,1,5},{2,2,4,1},{5,0,2,3},{0,6,1,2}};
    // int ans=0;
    // for(int i=0;i<arr.length;i++){
    //   ans=Math.max(ans,goldMineWithRecursion(arr,i,0));
    // }
    // System.out.println(ans);


    Integer dp[][]=new Integer[arr.length][arr[0].length];
    // int ans=0;
    // for(int i=0;i<arr.length;i++){
    //   ans=Math.max(ans,goldMineWithMemoization(arr,i,0,dp));
    // }
    // System.out.println(ans);
    // for(int i=0;i<dp.length;i++){
    //   for(int j=0;j<dp[0].length;j++){
    //     System.out.print(dp[i][j]+" ");
    //   }
    //   System.out.println();
    // }
    System.out.println(goldMineWithTabulation(arr));
    for(int i=0;i<arr.length;i++){
      for(int j=0;j<arr[0].length;j++){
        System.out.print(arr[i][j]+" ");
      }
      System.out.println();
    }
  }
  public static int goldMineWithTabulation(int arr[][]){
    for(int i=arr[0].length-1;i>=0;i--){
      for(int j=0;j<arr.length;j++){
        int a=0,b=0,c=0;
        if(j-1>=0&&i+1<arr[0].length){
          a= arr[j-1][i+1];
        }
        if(i+1<arr[0].length){
          b= arr[j][i+1];
        }
        if(i+1<arr[0].length&&j+1<arr.length){
          c= arr[j+1][i+1];
        }
        arr[j][i]+=Math.max(a, Math.max(b, c));
      }
    }
    int ans=0;
    for(int i=0;i<arr.length;i++){
      ans=Math.max(ans, arr[i][0]);
    }
    return ans;
  }






  public static int goldMineWithMemoization(int arr[][],int row,int col,Integer dp[][]){
    if(row<0||col>=arr[0].length||row>=arr.length){
      return 0;
    }
    if(dp[row][col]!=null){
      return dp[row][col];
    }
    int a= goldMineWithMemoization(arr,row-1,col+1,dp);
    int b= goldMineWithMemoization(arr,row,col+1,dp);
    int c= goldMineWithMemoization(arr,row+1,col+1,dp);
    return dp[row][col]= Math.max(a, Math.max(b, c))+arr[row][col];
  }


  public static int goldMineWithRecursion(int arr[][],int row,int col){
    if(row<0||col>=arr[0].length||row>=arr.length){
      return 0;
    }
    int a= goldMineWithRecursion(arr,row-1,col+1);
    int b= goldMineWithRecursion(arr,row,col+1);
    int c= goldMineWithRecursion(arr,row+1,col+1);
    return Math.max(a, Math.max(b, c))+arr[row][col];
  }
}
