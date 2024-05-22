func reverseStringSlice(slice []byte) {  
	for i, j := 0, len(slice)-1; i < j; i, j = i+1, j-1 {  
		slice[i], slice[j] = slice[j], slice[i]  
	}  
}  
func rightReverseStr(message string, k int) string {  
	bytes := []byte(message)  
	reverseStringSlice(bytes)   
	reverseStringSlice(bytes[:k])  
	reverseStringSlice(bytes[k:])  
	return string(bytes)  
}  