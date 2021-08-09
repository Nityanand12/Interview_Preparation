import java.util.*;
public class Lec1 {
  public static int fibonacci_Recursion(int num){
    if(num<=1){
      return num;
    }
    int left= fibonacci_Recursion(num-1);
    int right= fibonacci_Recursion(num-2);
    return left+right;
  }
  public static int fibonacci_Memoization(int num,int dp[]){
    if(num<=1){
      return dp[num]=num;
    }
    if(dp[num]!=0){
      return dp[num];
    }
    int left= fibonacci_Memoization(num-1,dp);
    int right= fibonacci_Memoization(num-2,dp);
    return dp[num] = left+right;
  }
  public static int fibonacci_Tabulation(int num,int dp[]){
    for(int i=0;i<=num;i++){
      if(i<=1){
        dp[i]=i;
        continue;
      }
      dp[i]= dp[i-1]+dp[i-2];
    }
    return dp[num];
  }
  public static void main(String args[]){
    int num=45;
    // long start= System.currentTimeMillis();
    // System.out.println(fibonacci_Recursion(num));
    // long end= System.currentTimeMillis();
    // System.out.println(end-start);

    // int dp[]= new int[num+1];
    // long start= System.currentTimeMillis();
    // System.out.println(fibonacci_Memoization(num,dp));
    // long end= System.currentTimeMillis();
    // System.out.println(end-start);
    // for(int i=0;i<dp.length;i++){
    //   System.out.print(dp[i]+" ");
    // }


    // int dp[]= new int[num+1];
    // long start= System.currentTimeMillis();
    // System.out.println(fibonacci_Tabulation(num,dp));
    // long end= System.currentTimeMillis();
    // System.out.println(end-start);
    // for(int i=0;i<dp.length;i++){
    //   System.out.print(dp[i]+" ");
    // }

  }
}
