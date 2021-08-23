import java.util.*;
public class Lecture13{
  public static void main(String[] args) {
    int arr[]={1,8,6,9,4,5,2,1};
    int lis[]= new int[arr.length];
    for(int i=0;i<arr.length;i++){
      int ans=0;
      for(int j=0;j<i;j++){
        if(arr[j]<arr[i]){
          ans=Math.max(ans,lis[j]);
        }
      }
      lis[i]= ans+1;
    }
    int lds[]= new int[arr.length];
    for(int i=arr.length-1;i>=0;i--){
      int ans=0;
      for(int j=arr.length-1;j>i;j--){
        if(arr[i]>arr[j]){
          ans=Math.max(ans,lds[j]);
        }
      }
      lds[i]= ans+1;
    }
    int finalAns=0;
    for(int i=0;i<arr.length;i++){
      finalAns=Math.max(finalAns, lds[i]+lis[i]-1);
      System.out.print(lds[i]+lis[i]-1+" ");
    }
    System.out.println();
    System.out.println(finalAns);
  }
  
}