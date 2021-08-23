import java.util.*;

public class Lecture12 {
  public static int lengthOfLisInN2(int arr[]) {
    if (arr.length == 0) {
      return 0;
    }
    int dp[] = new int[arr.length];
    int finalAns=0;
    for (int i = 0; i < arr.length; i++) {
      int ans = 0;
      for (int j = 0; j < i; j++) {
        if (arr[j] < arr[i]) {
          ans = Math.max(ans, dp[j]);
        }
      }
      dp[i] = ans + 1;
      finalAns=Math.max(finalAns, dp[i]);
    }
    return finalAns;
  }

  public static int lengthOfLisInNLongN(int nums[]) {
    int ans = 0;
    ArrayList<Integer> al = new ArrayList<Integer>();
    if (nums.length == 0)
      return 0;
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      int low = 0, high = ans;
      while (low < high) {
        int mid = (low + high) / 2;
        if (al.get(mid) >= num) {
          high = mid;
        } else {
          low = mid + 1;
        }
      }
      if (low < al.size()) {
        al.set(low, num);
      } else {
        al.add(num);
      }
      if (low == ans)
        ans++;
    }
    return al.size();
  }

  public static void main(String[] args) {
    int arr[] = { 2, 8, 7, 9, 100, 3 };
    System.out.println(lengthOfLisInN2(arr));
    System.out.println(lengthOfLisInNLongN(arr));
  }
}