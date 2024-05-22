// 思路： 使用栈来进行括号的匹配
// 时间复杂度 O(n)
// 空间复杂度 O(n)
func isValid(s string) bool {
	// 使用切片模拟栈的行为
	stack := make([]rune, 0)

	// m 用于记录某个右括号对应的左括号
	m := make(map[rune]rune)
	m[')'] = '('
	m[']'] = '['
	m['}'] = '{'

	// 遍历字符串中的 rune
	for _, c := range s {
		// 左括号直接入栈
		if c == '(' || c == '[' || c == '{' {
			stack = append(stack, c)
		} else {
			// 如果是右括号，先判断栈内是否还有元素
			if len(stack) == 0 {
				return false
			}
			// 再判断栈顶元素是否能够匹配
			peek := stack[len(stack)-1]
			if peek != m[c] {
				return false
			}
			// 模拟栈顶弹出
			stack = stack[:len(stack)-1]
		}
	}

	// 若栈中不再包含元素，则能完全匹配
	return len(stack) == 0
}