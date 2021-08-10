import java.util.*;
public class lecture3 {
  public static int unboundedKnapsackWithRecursion(int wt[],int val[],int cap){
    if(cap==0){
      return 0;
    }
    int ans=0;
    for(int i=0;i<wt.length;i++){
      if(cap-wt[i]>=0){
        ans= Math.max(ans,unboundedKnapsackWithRecursion(wt,val,cap-wt[i])+val[i]);
      }
    }
    return ans;
  }
  public static int unboundedKnapsackWithMemoization(int wt[],int val[],int cap,int dp[]){
    if(cap==0){
      return dp[cap]= 0;
    }
    if(dp[cap]!=0){
      return dp[cap];
    }
    int ans=0;
    for(int i=0;i<wt.length;i++){
      if(cap-wt[i]>=0){
        ans= Math.max(ans,unboundedKnapsackWithMemoization(wt,val,cap-wt[i],dp)+val[i]);
      }
    }
    return dp[cap]= ans;
  }
  public static int unboundedKnapsackWithTabultaion(int wt[],int val[],int dp[]){
    for(int cap=0;cap<dp.length;cap++){
      if(cap==0){
         dp[cap]= 0;
         continue;
      }
      int ans=0;
      for(int i=0;i<wt.length;i++){
        if(cap-wt[i]>=0){
          ans= Math.max(ans,dp[cap-wt[i]]+val[i]);
        }
      }
      dp[cap]= ans;
    }
    return dp[dp.length-1];


    
  }
  public static void main(String[] args) {
    int wt[]={1,4,3,5};
    int val[]={10,40,50,70};
    int cap=8;
    // System.out.println(unboundedKnapsackWithRecursion(wt,val,cap));

    int dp[]= new int[cap+1];
    // System.out.println(unboundedKnapsackWithMemoization(wt,val,cap,dp));
     
    // for(int i=0;i<dp.length;i++){
    //   System.out.print(dp[i]+" ");
    // }
    System.out.println(unboundedKnapsackWithTabultaion(wt,val,dp));
  }
}
