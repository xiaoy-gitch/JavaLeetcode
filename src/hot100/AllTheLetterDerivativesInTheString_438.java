package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllTheLetterDerivativesInTheString_438 {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s,p));
        
    }
    private static List<Integer> findAnagrams(String s, String p) {
        //1.统计p中每个字符出现的次数
        List<Integer> ans = new ArrayList<>();
        int[] pCount = new int[26];
        int[] sCount = new int[26];
        for(int i = 0; i < p.length(); i++){
            pCount[p.charAt(i) - 'a']++;
        }
        //2.遍历 s
        for(int right = 0; right < s.length(); right++){
            int rightChar = s.charAt(right) - 'a';
            sCount[rightChar]++;
            int left = right - p.length()+1;//窗口左边界
            if(left<0){
                continue;//表示还没有取够p长度的字符串
            }
            if(Arrays.equals(pCount,sCount)){//比较两个数组是否相等
                ans.add(left);
            }
            //3.窗口左边界向右移动一位,始终保持p长度的字符串
            int leftChar = s.charAt(left) - 'a';
            sCount[leftChar]--;

        }
        return ans;
    }
}
