func reverseWords(s string) string {  
	// 按空格分割字符串为单词数组  
	words := strings.Fields(s)  
	// 反转单词数组  
	for i, j := 0, len(words)-1; i < j; i, j = i+1, j-1 {  
		words[i], words[j] = words[j], words[i]  
	}  
	// 使用空格将单词重新组合为字符串  
	return strings.Join(words, " ")  
} 