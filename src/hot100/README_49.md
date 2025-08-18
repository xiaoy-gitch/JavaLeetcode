## 1.题目解析

给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。

**示例 1:**

**输入:** strs = ["eat", "tea", "tan", "ate", "nat", "bat"]

**输出:** [["bat"],["nat","tan"],["ate","eat","tea"]]

**解释：**

- 在 strs 中没有字符串可以通过重新排列来形成 `"bat"`。
- 字符串 `"nat"` 和 `"tan"` 是字母异位词，因为它们可以重新排列以形成彼此。
- 字符串 `"ate"` ，`"eat"` 和 `"tea"` 是字母异位词，因为它们可以重新排列以形成彼此。

**示例 2:**

**输入:** strs = [""]

**输出:** [[""]]

## 2.解题思路

将列表中的没有字符串进行排序，结果一样的存到同一个键值下，这样：排序后相同的就构成了字母异位词分组。

## 3.代码

```python
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        dic = defaultdict(list) #当访问字典中不存在的键时，会自动创建一个空列表作为该键的默认值.
        for s in strs:
            #1.先将字符串转化成列表进行排序后转化成字符串
            s1 = " ".join(sorted(s))
            dic[s1].append(s)
        return list(dic.values())
```

## 4.知识点补充

```python
from collections import defaultdict

# 默认值为空列表
dic_list = defaultdict(list)      # 等价于 dic_list[key] = []

# 默认值为0（适合计数）
dic_int = defaultdict(int)        # 等价于 dic_int[key] = 0

# 默认值为空集合
dic_set = defaultdict(set)        # 等价于 dic_set[key] = set()

# 默认值为空字符串
dic_str = defaultdict(str)        # 等价于 dic_str[key] = ''
```

1. **`sorted()` 函数**

**返回新列表**，原字符串不变。

```python
s = "cba"
sorted_str = ''.join(sorted(s))  # 升序
# 输出: 'abc'

sorted_str_desc = ''.join(sorted(s, reverse=True))  # 降序
# 输出: 'cba'
```

- **特点**：
  - 返回字符列表，需用 `''.join()` 合并成字符串

2.**`str.sort()` 方法**

⚠️ **字符串本身不可变**，需先转为列表：

```python
s = "cba"
s_list = list(s)          # 转列表
s_list.sort()             # 原地排序（升序）
sorted_str = ''.join(s_list)
# 输出: 'abc'
```

- **特点**：
  - 直接修改原列表，无返回值

3.**按特定规则排序**

通过 `key` 参数自定义排序逻辑：

```python
words = ["apple", "Banana", "cherry"]
# 按字母顺序（忽略大小写）
sorted_words = sorted(words, key=lambda x: x.lower())
# 输出: ['apple', 'Banana', 'cherry']

# 按字符串长度排序
sorted_by_len = sorted(words, key=len)
# 输出: ['apple', 'cherry', 'Banana']
```

Q1：如何去除空格后排序？

```python
s = "c b a"
sorted_str = ''.join(sorted(s.replace(" ", "")))  # 输出: 'abc'
```

Q2：如何按单词的首字母排序？

```python
words = "banana apple cherry"
sorted_words = ' '.join(sorted(words.split(), key=lambda x: x[0]))
# 输出: 'apple banana cherry'
```

Q3：如何实现稳定排序？

Python 的 `sorted()` 本身就是[稳定排序](https://docs.python.org/3/glossary.html#term-stable-sort)，相同键值的元素顺序不变。