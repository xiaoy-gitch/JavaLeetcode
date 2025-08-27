package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeInterval_56 {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] ans = merges(intervals);
    }

    private static int[][] merges(int[][] intervals) {
        //按照区间左端点进行排序
        Arrays.sort(intervals, new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        return o1[0] - o2[0];
                    }
                }
        );
        //<int[]> 指定比较的对象类型是整型数组
        List<int[]> ans = new ArrayList<>(); //存放结果
        for (int[] interval : intervals) {
            if (!ans.isEmpty() && ans.get(ans.size() - 1)[1] >= interval[0]) {
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], interval[1]);
            } else {
                ans.add(interval);
            }
        }
        return ans.toArray(new int[ans.size()][]); //将 List 转换为数组
    }
}
// 方式1：创建正好大小的数组（最佳性能）
//return ans.toArray(new int[ans.size()][]);
//
// 方式2：创建空数组（同样正确，可能稍慢）
//return ans.toArray(new int[0][]);