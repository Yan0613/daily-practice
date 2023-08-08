class Solution:
    def reverseWords(self, s: str) -> str:
        return " ".join(s.strip().split()[::-1]);

#"".join,""是用于拼接的字符串，join参数可以是数组
#split函数，参数可以是正则，在正则表达式中"\d+"表示一个或多个数字，是用于从一堆数字字母以及其它字符组成的字符串中获取非数字字符或字符串。