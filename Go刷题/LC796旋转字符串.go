func rotateString(s string, goal string) bool {  
    if len(s) != len(goal) {  
        return false // 长度不同的字符串不可能通过旋转匹配  
    }  
    return strings.Contains(s+s, goal)  
}  
// 注意：你需要导入 "strings" 包来使用 strings.Contains 函数