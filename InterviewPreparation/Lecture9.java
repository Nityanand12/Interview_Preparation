import java.util.*;
public class Lecture9 {
  public static int friendsPairingProblemWithRecursion(int n){
    if(n<=2){
      return n;
    }
    return friendsPairingProblemWithRecursion(n-1)+friendsPairingProblemWithRecursion(n-2)*(n-1);
  }

  public static int friendsPairingProblemWithMemoization(int n,int dp[]){
    if(n<=2){
      return dp[n]= n;
    }
    if(dp[n]!=0){
      return dp[n];
    }
    return dp[n]= friendsPairingProblemWithMemoization(n-1,dp)+friendsPairingProblemWithMemoization(n-2,dp)*(n-1);
  }

  public static int friendsPairingProblemWithTabulation(int n,int dp[]){
    for(int i=0;i<=n;i++){
      if(i<=2){
         dp[i]= i;
         continue;
      }
       dp[i]= dp[i-1]+dp[i-2]*(i-1);
    }
    return dp[dp.length-1];
  }
  public static void main(String[] args) {
    int n=6;
    // System.out.println(friendsPairingProblemWithRecursion(n));
    int dp[]= new int[n+1];
    // System.out.println(friendsPairingProblemWithMemoization(n,dp));
    // for(int i=0;i<=n;i++){
    //   System.out.print(dp[i]+" ");
    // }
    System.out.println(friendsPairingProblemWithTabulation(n,dp));
    for(int ele: dp){
      System.out.print(ele+" ");
    }
  }
}
