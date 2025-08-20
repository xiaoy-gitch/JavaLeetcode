## 1.题目描述

给你一个按照非递减顺序排列的整数数组 `nums`，和一个目标值 `target`。请你找出给定目标值在数组中的开始位置和结束位置。

如果数组中不存在目标值 `target`，返回 `[-1, -1]`。

你必须设计并实现时间复杂度为 `O(log n)` 的算法解决此问题。

**示例 1：**

```
输入：nums = [5,7,7,8,8,10], target = 8
输出：[3,4]
```

**示例 2：**

```
输入：nums = [5,7,7,8,8,10], target = 6
输出：[-1,-1]
```

**示例 3：**

```
输入：nums = [], target = 0
输出：[-1,-1]
```

## 2.解题思路

方法一：通过**双指针**一起查找，当二者指向同一目标元素时，通过while循环，查看该目标元素的左右两侧是否有等于目标值的元素。

方法二：由于数组有序，并且要求时间复杂度为O(log(n)),所以想到**二分查找**来做；在找起始位置的时候——找到mid指向目标元素，则继续查找其左边的区间，是否有等于目标值的，令right = mid -1;在找终点位置的时候——找到mid指向目标元素，则继续查找其右边的区间，是否有等于目标值的，令left = mid +1.

方法三：使用同一个二分查找方法

## 3.代码

```java
package hot100;

public class LeetCode_34 {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] result = searchRange(nums, target);
        System.out.println(result[0] + " " + result[1]);
    }

    private static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        int left = 0;
        int right = nums.length - 1;

        // 使用双指针查找目标值的范围(O(n)),效率不高，推荐是由二分查找
        while (left <= right) {
            if (nums[left] == target && nums[right] == target) {
                // 找到目标范围，向两边扩展
                while (left > 0 && nums[left - 1] == target) {
                    left--;
                }
                while (right < nums.length - 1 && nums[right + 1] == target) {
                    right++;
                }
                return new int[]{left, right};
            }

            if (nums[left] < target) {
                left++;
            }
            if (nums[right] > target) {
                right--;
            }

            // 如果指针交叉，说明没找到
            if (left > right) {
                break;
            }
        }

        return new int[]{-1, -1};
        
    }
}
```

```java
package hot100;

public class LeetCode_34 {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] result = searchRange(nums, target);
        System.out.println(result[0] + " " + result[1]);
    }

    private static int[] searchRange(int[] nums, int target) {
        int first =-1 ;
        int last =-1;
        int left =0;
        int right = nums.length-1;
        while(left<=right) {
            int mid = left + (right - left) / 2;//等价于(left+right)/2，目的：防止left+right越界
            if (nums[mid] == target) {
                first = mid; //查找起始位置，不断的向左区间查找
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        int left1 =0;
        int right1 = nums.length-1;

        while(left1<=right1) {
            int mid1 = left1 + (right1 - left1) / 2;//等价于(left+right)/2，目的：防止left+right越界
            if (nums[mid1] == target) {
                last = mid1; //查找起始位置，不断的向左区间查找
                left1 = mid1 + 1;
            } else if (nums[mid1] > target) {
                right1 = mid1 - 1;
            } else {
                left1 = mid1 + 1;
            }
        }
        return new int[]{first,last};
    }
}
```

```java
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
```