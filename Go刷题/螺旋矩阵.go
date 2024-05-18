func generateMatrix(int n)  {
	res:= make([][]int, n)
	startx, starty := 0, 0
	loop_range := n/2
	offset := 1

	for loop_range > 0 {
		cur_num := 1
		i, j := startx, starty
		//→
		for i := startx; i < n-startx; i++ {
		    res[i][j] =  cur_num
			cur_num++
		}
		//↓
		for j := starty+1; j < n-offset; j++ {
		    res[i][j] =  cur_num
			cur_num++
		}
		//←这里不要开始给i赋值
		for ; i > startx; i-- {
		    res[i][j] =  cur_num
			cur_num++
		}
		//↑
		for ; i > starty ; j--{
			res[i][j] =  cur_num
			cur_num++
		}
		startx++
		starty++
		offset++
	    loop_range--
	}
	if n%2 == 1 {
		res[n/2][n/2] = cur_num
	}
}