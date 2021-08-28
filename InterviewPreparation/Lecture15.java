import java.util.*;
public class Lecture15{
  public static int lis(int nums[]) {
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

  public static void main(String args[]){
    int arr[]={2,8,17,6,9,101,11,15};
    int finalAns=arr.length-lis(arr);
    System.out.println(finalAns);
  }
}