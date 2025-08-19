package hot100;

public class TheContainerThatHoldsTheMostWater_11 {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    private static int  maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int ans = 0;
        while(left<right){
            ans = Math.max(ans,(right-left)*Math.min(height[left],height[right]));
            if(height[left]<height[right]){ //高的一端保持不动，低一端向中间移动
                left++;
            }else{
                right--;
            }
        }
        return ans;
    }
}
