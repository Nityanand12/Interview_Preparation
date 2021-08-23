import java.util.*;

public class Lecture10 {
  public static int countPartitionWithRecursion(int n, int k) {
    if (n == 0 || k == 0 || k > n) {
      return 0;
    }
    if (n == k || k == 1) {
      return 1;
    }
    int left = countPartitionWithRecursion(n - 1, k - 1);
    int right = countPartitionWithRecursion(n - 1, k);
    return left + right * k;
  }

  public static int countPartitionWithMemoization(int n, int k, int dp[][]) {
    if (n == 0 || k == 0 || k > n) {
      return dp[n][k] = 0;
    }
    if (n == k || k == 1) {
      return dp[n][k] = 1;
    }
    if (dp[n][k] != 0) {
      return dp[n][k];
    }
    int left = countPartitionWithMemoization(n - 1, k - 1, dp);
    int right = countPartitionWithMemoization(n - 1, k, dp);
    return dp[n][k] = left + right * k;
  }

  public static int countPartitionWithTabulation(int n, int k, int dp[][]) {
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= k; j++) {

        if (i == 0 || j == 0 || j > i) {
           dp[i][j] = 0;
           continue;
        }
        if (i == j || j == 1) {
           dp[i][j] = 1;
           continue;
        }
        int left = dp[i-1][j-1]; 
        int right = dp[i-1][j];
         dp[i][j] = left + right * j;
      }
    }
    return dp[dp.length-1][dp[0].length-1];
  }

  public static void main(String args[]) {
    int n = 4, k = 3;
    // System.out.println(countPartitionWithRecursion(n,k));
    int dp[][] = new int[n + 1][k + 1];
    System.out.println(countPartitionWithMemoization(n, k, dp));

    System.out.println(countPartitionWithTabulation(n, k, dp));
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        System.out.print(dp[i][j] + " ");
      }
      System.out.println();
    }
  }
}