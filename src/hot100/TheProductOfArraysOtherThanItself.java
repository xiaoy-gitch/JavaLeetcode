package hot100;

public class TheProductOfArraysOtherThanItself {
    /**
     * 思想:先计算出每个元素的前缀乘积，后缀乘积，然后相乘
     * 这样就得到了除了该元素之外的所有元素的乘积
     */
    public static void main(String[] args) {
        int[] nums={1,2,3,4};
        int[] ans=productExceptSelf(nums);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]+" ");
        }
    }

    private static int[] productExceptSelf(int[] nums) {
        int n =nums.length;
        int[] ans=new int[n];
        int[] pre =new int[n];
        int[] last =new int[n];
        pre[0]=1; //第一个元素的前缀乘积为1
        last[n-1]=1;//最后一个元素后缀乘积为1
        for (int i = 1; i <n ; i++) {
           pre[i] = pre[i-1]*nums[i-1];
        }
        for (int j = n-2; j >=0 ; j--) {
            last[j] = last[j+1]*nums[j+1];
        }
        for (int i = 0; i < n; i++) {
            ans[i] = pre[i]*last[i];
        }
        return ans;
    }


}
