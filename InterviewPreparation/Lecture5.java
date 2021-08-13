import java.util.*;
public class Lecture5 {
  public static int combination(int arr[],int target){
    int dp[]= new int[target+1];
    dp[0]=1;
    for(int i=0;i<arr.length;i++){
      for(int j=0;j<=target;j++){
        if(j-arr[i]>=0){
          dp[j]= dp[j]+dp[j-arr[i]];
        }
      }
    }
    return dp[dp.length-1];
  }
  public static void main(String[] args) {
    int arr[]={1,4,3,5};
    int tar=5;
    System.out.println(combination(arr,tar));
  }
} 
