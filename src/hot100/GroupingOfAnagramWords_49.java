package hot100;

import java.util.*;

/**
 * 49:字母异位词分组
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 */

public class GroupingOfAnagramWords_49 {
    public static void main(String[] args) {
        //String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] strs = {"a"};
        // String[] strs = {""};
        List<List<String>> results = groupAnagrams(strs);
        System.out.println(results);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        //1.创建一个map集合，用来存放排序后的字符串和字符串本身
        //排序后相同的字符串存放在同一个键中
        Map<String, List<String>> map = new HashMap<>(); //hashMap特点：键唯一，值可重复，无序
        //2.遍历字符串数组
        for (String str : strs) {
            //3.将字符串排序(只有先转化成数组才可以调用数组的排序函数)
            char[] charArray = str.toCharArray(); //字符串转换成字符数组
            Arrays.sort(charArray);
            String key = new String(charArray);//字符数组转换成字符串
            //4.判断集合中是否存在键
//            if (map.containsKey(key)) {
//                map.get(key).add(str);
//                map.put(key, map.get(key));
//            }else{
//                map.put(key, new ArrayList<>());//不存在的键，创建一个list集合，将字符串添加到list集合中
//                map.get(key).add(str);
//                map.put(key, map.get(key));
//            }
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);//集合中存在键，添加值到对应的键值对中，不存在则创建一个list集合，将字符串添加到list集合中
        }

        return new ArrayList<>(map.values());//创建一个list集合，将map集合的值添加到list集合中
    }
}
