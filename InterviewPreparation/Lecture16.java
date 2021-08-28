import java.util.*;
public class Lecture16 {
  static class Pair implements Comparable<Pair>{
    int north,south;
    Pair(int north,int south){
      this.north= north;
      this.south= south;
    }
    Pair(){

    }
    @Override
    public int compareTo(Pair o){
      if(this.north==o.north){
        return this.south-o.south;
      }
      else{
        return this.north-o.north;
      }
    }
  }

  public static int lengthOfLisInNLongN(Pair nums[]) {
    int ans = 0;
    ArrayList<Integer> al = new ArrayList<Integer>();
    if (nums.length == 0)
      return 0;
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i].south;
      int low = 0, high = ans;
      while (low < high) {
        int mid = (low + high) / 2;
        if (al.get(mid) > num) {
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
    Pair[] pair= new Pair[8];
    pair[0]= new Pair(3,5);
    pair[1]= new Pair(4,2);
    pair[2]= new Pair(2,3);
    pair[3]= new Pair(7,8);
    pair[4]= new Pair(1,4);
    pair[5]= new Pair(5,7);
    pair[6]= new Pair(9,6);
    pair[7]= new Pair(5,6);
    Arrays.sort(pair);
    for(int i=0;i<pair.length;i++){
      System.out.println(pair[i].north+" "+pair[i].south);
    }
    System.out.println(lengthOfLisInNLongN(pair));

  }
}
