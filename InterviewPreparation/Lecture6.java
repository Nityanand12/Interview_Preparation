import java.util.*;
public class Lecture6 {
  public static boolean targetSumRecursion(int arr[],int target,int pos){
    if(target==0||pos==0){
      if(target==0){
        return true;
      }
      return false;
    }
    boolean left=false,right=false;
    left= targetSumRecursion(arr,target,pos-1);
    if(target-arr[pos-1]>=0){
     right= targetSumRecursion(arr,target-arr[pos-1],pos-1);
    }
    return left||right;
  }


  public static boolean targetSumMemoization(int arr[],int target,int pos,Boolean dp[][]){
    if(target==0||pos==0){
      if(target==0){
        return dp[pos][target]= true;
      }
      return dp[pos][target]=  false;
    }
    if(dp[pos][target]!=null){
      return dp[pos][target];
    }
    boolean left=false,right=false;
    left= targetSumMemoization(arr,target,pos-1,dp);
    if(target-arr[pos-1]>=0){
     right= targetSumMemoization(arr,target-arr[pos-1],pos-1,dp);
    }
    return dp[pos][target]= left||right;
  }
  public static boolean targetSumTabulation(int arr[],int target,Boolean dp[][]){
    for(int i=0;i<=arr.length;i++){
      for(int j=0;j<=target;j++){
        if(i==0||j==0){
          if(j==0){
            dp[i][j]=true;
          }
          else{
            dp[i][j]=false;
          }
          continue;
        }
        boolean left= false,right=false;
        left= dp[i-1][j];
        if(j-arr[i-1]>=0){
          right= dp[i-1][j-arr[i-1]];
        }
        dp[i][j]= left||right;
      }
    }
    return dp[dp.length-1][dp[0].length-1];
  }
  public static int minimumPartition(int arr[],int target,Boolean dp[][]){
    for(int i=0;i<=arr.length;i++){
      for(int j=0;j<=target;j++){
        if(i==0||j==0){
          if(j==0){
            dp[i][j]=true;
          }
          else{
            dp[i][j]=false;
          }
          continue;
        }
        boolean left= false,right=false;
        left= dp[i-1][j];
        if(j-arr[i-1]>=0){
          right= dp[i-1][j-arr[i-1]];
        }
        dp[i][j]= left||right;
      }
    }
    for(int i=target;i>=0;i--){
      if(dp[arr.length][i]==true){
        return i;
      }
    }
    return 0;
    
  }
  public static void main(String[] args) {
    int arr[]={1,6,11,5};
    int target=12;
    // System.out.println(targetSumRecursion(arr,target,arr.length));
    Boolean dp[][]= new Boolean[arr.length+1][target+1];
    // System.out.println(targetSumMemoization(arr,target,arr.length,dp));
    // for(int i=0;i<dp.length;i++){
    //   for(int j=0;j<dp[0].length;j++){
    //     System.out.print(dp[i][j]+" ");
    //   }
    //   System.out.println();
    // }
    
    System.out.println(targetSumTabulation(arr,target,dp));
    //   for(int i=0;i<dp.length;i++){
    //   for(int j=0;j<dp[0].length;j++){
    //     System.out.print(dp[i][j]+" ");
    //   }
    //   System.out.println();
    // }
    int sum=0;
    for(int ele: arr){
      sum=sum+ele;
    }
    target= sum/2;
    System.out.println(sum-2*minimumPartition(arr,target,dp));
  }
}
