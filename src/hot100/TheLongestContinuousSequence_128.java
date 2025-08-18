package hot100;

import java.util.HashSet;
import java.util.Set;

public class TheLongestContinuousSequence_128 {
    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        int result = longestConsecutive(nums);
        System.out.println( result);
    }

    private static int longestConsecutive(int[] nums) {
        int ans  = 0;
        Set< Integer> set = new HashSet<>();
        //1.添加元素
        for (int num : nums) {
            set.add(num);
        }
        //2.遍历集合
        for (int x : nums) {
            if (set.contains(x - 1)) {
                continue;
            }
            int y = x + 1;
            while (set.contains(y)) {
                y++;
            }
            ans = Math.max(ans, y - x);
        }
        return ans;
    }
}
