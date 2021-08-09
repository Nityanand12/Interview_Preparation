import java.util.*;
public class Lecture2{
  public static int permutationWithRecursion(int arr[],int target){
    if(target==0){
      return 1;
    }
    int myAns=0;
    for(int i=0;i<arr.length;i++){
      if(target-arr[i]>=0){
        myAns= myAns+ permutationWithRecursion(arr,target-arr[i]);
      }
    }
    return myAns;
  }
  public static int permutationWithMemoization(int arr[],int target,int dp[]){
    if(target==0){
      return dp[target]= 1;
    }
    if(dp[target]!=0) return dp[target];
    int myAns=0;
    for(int i=0;i<arr.length;i++){
      if(target-arr[i]>=0){
        myAns= myAns+ permutationWithMemoization(arr,target-arr[i],dp);
      }
    }
    return dp[target]= myAns;
  }
  public static int permutationWithTabulation(int arr[],int dp[]){
    // for(int i=0;i<dp.length;i++){
    //   if(i==0){
    //     dp[i]= 1;
    //     continue;
    //   }
    //   int ans=0;
    //   for(int j=0;j<arr.length;j++){
    //     if(i-arr[j]>=0){
    //       ans= ans+dp[i-arr[j]];
    //     }
    //   }
    //   dp[i]= ans;
    // }
    // return dp[dp.length-1];
    for(int target=0;target<dp.length;target++){
      if(target==0){
         dp[target]= 1;
         continue;
      }
      int myAns=0;
      for(int i=0;i<arr.length;i++){
        if(target-arr[i]>=0){
          myAns= myAns+ dp[target-arr[i]]; 
        }
      }
       dp[target]= myAns;
    }
    return dp[dp.length-1];
  }
  public static void main(String[] args) {
    int arr[]={1,4,3,2};
    int target=5;
    // long start= System.currentTimeMillis();
    // System.out.println(permutationWithRecursion(arr,target));
    // long end= System.currentTimeMillis();
    // System.out.println(end-start);

    // long start= System.currentTimeMillis();
    // int dp[]= new int[target+1];
    // System.out.println(permutationWithMemoization(arr,target,dp));
    // long end= System.currentTimeMillis();
    // System.out.println(end-start);
    // for(int i=0;i<dp.length;i++){
    //   System.out.print(dp[i]+" ");
    // }

    long start= System.currentTimeMillis();
    int dp[]= new int[target+1];
    System.out.println(permutationWithTabulation(arr,dp));
    long end= System.currentTimeMillis();
    System.out.println(end-start);
    for(int i=0;i<dp.length;i++){
      System.out.print(dp[i]+" ");
    }
  }
}