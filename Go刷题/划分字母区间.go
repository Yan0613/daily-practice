func partitionLabels(s string) partition []int  {
	lastPos := [26]int{}
	for i := 0; i < len(s); i++ {
	    lastPos[s[i]-'a'] = i
	}

	start, end := 0, 0
	for i := 0; i < len(s); i++ {
		if lastPos[s[i]-'a'] > end {
		    end = lastPos[s[i]-'a']
		}
		if i == end {
		    partition = append(partition, end-start+1)
		    start = end + 1
		}
	}

	return
}