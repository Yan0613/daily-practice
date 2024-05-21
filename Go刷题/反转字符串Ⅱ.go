func reverseStr(s string, k int) string {
    ss := []byte(s)
    length := len(s)
    for i := 0; i < length; i += 2 * k {
     // 1. 每隔 2k 个字符的前 k 个字符进行反转
     // 2. 剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符
        if i + k <= length {
            reverse(ss[i:i+k])
        } else {
            reverse(ss[i:length])
        }
    }
    return string(ss)
}

func reverse(b []byte) {
    left := 0
    right := len(b) - 1
    for left < right {
        b[left], b[right] = b[right], b[left]
        left++
        right--
    }
}