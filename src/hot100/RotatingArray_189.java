package hot100;

public class RotatingArray_189 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        int n = nums.length;
        k %= n;
        rotated(nums, 0,n-1);//三次反转
        rotated(nums,0,k-1);
        rotated(nums,k,n-1);
        for (int i = 0; i < n; i++) {
            System.out.print(nums[i]+" ");
        }

    }

    /**
     * 思考：因为方法参数 nums 和原 nums 指向同一个数组对象，所以通过任何一个引用修改数组内容，都会影响原数组。
     * Java 中所有的参数传递都是值传递（pass by value），但是对于引用类型（如数组、对象），传递的是引用的副本，而不是对象本身的副本。
     * nums=数组的地址
     * 数组的值会存放堆内存中，并返回一个地址给nums。
     * @param nums
     * @param start
     * @param end
     */
    private static void rotated(int[] nums, int start, int end) {
        while (start < end){
            int temp =nums[start];
            nums[start] =nums[end];
            nums[end] = temp;
            start++;
            end--;
        }

    }
}
