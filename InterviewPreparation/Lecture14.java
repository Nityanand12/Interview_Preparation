import java.util.*;
public class Lecture14{
  public static void maximumSumIncreasingSubsequence() {
    int arr[]={3,8,1,6,7,100,9,12,4,13};
    int dp[]= new int[arr.length];
    int finalAns=0;
    for(int i=0;i<arr.length;i++){
      int ans=0;
      for(int j=0;j<i;j++){
        if(arr[i]>arr[j]){
          ans=Math.max(ans, dp[j]);
        }
      }
      dp[i]= ans+arr[i];
      finalAns=Math.max(finalAns, dp[i]);
    }
    for(int ele: dp){
      System.out.print(ele+" ");
    }
    System.out.println();
    System.out.println(finalAns);
  }
  public static void main(String args[]){
    maximumSumIncreasingSubsequence();
    }
}