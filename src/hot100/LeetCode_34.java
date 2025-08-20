package hot100;

public class LeetCode_34 {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int first  = searchRange(nums, target);
        if (first == nums.length || nums[first] != target) {
            System.out.println(-1 + " " + -1);
            return;
        }
        int last = searchRange(nums, target+1)-1;
        int[] result = new int[]{first, last};
        System.out.println(result[0] + " " + result[1]);

    }

    private static int searchRange(int[] nums, int target) {
        int first =-1 ;
        int last =-1;
        int left =0;
        int right = nums.length-1;
        while(left<=right) {
            int mid = left + (right - left) / 2;//等价于(left+right)/2，目的：防止left+right越界
            if(nums[mid] >=target) {
                right = mid-1; //缩小范围到[left,mid-1],继续查找起始位置
            }else {
                left = mid+1;
            }
        }
        return left; //为什么返回的是:left?
    }
}