import java.util.*;
public class Lecture11{
  public static int countWaysToTileFloorWithRecursion(int m,int n){
    if(m==n){
      return 2;
    }
    if(n<m){
      return 1;
    }
    int left=countWaysToTileFloorWithRecursion(m,n-1);
    int right= countWaysToTileFloorWithRecursion(m,n-m);
    return left+right;
  }

  public static int countWaysToTileFloorWithMemoization(int m,int n,int dp[]){
    if(m==n){
      return  dp[n]= 2;
    }
    if(n<m){
      return dp[n]= 1;
    }
    if(dp[n]!=0){
      return dp[n];
    }
    int left=countWaysToTileFloorWithMemoization(m,n-1,dp);
    int right= countWaysToTileFloorWithMemoization(m,n-m,dp);
    return dp[n]= left+right;
  }


  public static int countWaysToTileFloorWithTabulation(int m,int n,int dp[]){
    for(int i=1;i<=n;i++){
      if(m==i){
          dp[n]= 2;
          continue;
      }
      if(i<m){
         dp[n]= 1;
         continue;
      }
      int left=countWaysToTileFloorWithMemoization(m,i-1,dp);
      int right= countWaysToTileFloorWithMemoization(m,i-m,dp);
      dp[i]= left+right;
    }
    return dp[dp.length-1];
  }
  
  public static void main(String[] args) {
    int m=3,n=5;
    int dp[]= new int[n+1];
    // System.out.println(countWaysToTileFloorWithRecursion(m,n));
    // System.out.println(countWaysToTileFloorWithMemoization(m,n,dp));
    // for(int i=1;i<=n;i++){
    //   System.out.print(dp[i]+" ");
    // }
    System.out.println(countWaysToTileFloorWithTabulation(m,n,dp));
     for(int i=1;i<=n;i++){
      System.out.print(dp[i]+" ");
    }
  }

}