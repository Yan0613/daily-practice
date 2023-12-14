func removeDuplicate(s string) string  {
	var stack []byte
	for i := 0; i < len(s); i++ {
		if len(stack) == 0 || stack[len(stack)-1] == s[i] {
			stack = stack[:len(stack)-1]
		}else{
			//入栈
			stack = stack.append(stack, s[i])
		}
	}
}