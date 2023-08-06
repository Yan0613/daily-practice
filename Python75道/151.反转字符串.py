class Solution:
    def reverseWords(self, s: str) -> str:
        return " ".join(s.strip().split()[::-1]);

#"".join,""是用于拼接的字符串，join参数可以是数组