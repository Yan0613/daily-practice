// 在 Go 语言中，切片是对底层数组的引用，它们共享相同的底层数组。当你将一个切片 path 添加到另一个切片 res 时，你实际上是将 path 的引用（即指向底层数组的指针和切片的长度、容量信息）添加到了 res 中。

// 因此，如果在添加引用到 res 之后，你修改了 path 的内容（例如，通过向 path 添加或删除元素），由于 res 中的切片和原始的 path 引用的是同一个底层数组，所以 res 中存储的所有对该数组的引用都会“看到”这些修改。

// 具体到你的例子，如果在 backtraking 函数中，你找到了一个回文子串并将其添加到 path 中，然后将 path（实际上是它的引用）添加到 res 中，接着在递归调用中修改了 path（例如，通过添加另一个回文子串），那么之前添加到 res 中的所有切片都会显示这个新添加的子串，因为它们都指向同一个底层数组。

// 为了避免这种情况，你需要确保在将 path 添加到 res 之前创建一个 path 的独立副本。这就是为什么你在代码中使用 tmp 切片，并通过 copy 函数将 path 的内容复制到 tmp 中，然后将 tmp 添加到 res 中的原因。这样，res 中的每个切片都包含 path 在那一刻的一个独立副本，而不是对原始 path 的引用。

var(
    res [][]string
    path []string
)
func partition(s string) [][]string {
    res  = make([][]string, 0)
    path = make([]string,0)
    backtraking(s,0)
    return res
}

func backtraking(s string, startIndex int) {
    if startIndex == len(s) {
        tmp := make([]string, len(path))
        copy(tmp, path)
        res = append(res, tmp)
        return 
    }
    for i:=startIndex ; i < len(s); i++ {
        str := s[startIndex:i+1]
        if ishuiwen(str) {
            path = append(path, str)
            backtraking(s,i+1)
            path = path[:len(path)-1]
        }

    }
}

func ishuiwen(s string) bool {
    for i, j := 0, len(s)-1; i < j; i, j = i+1, j-1 {
        if s[i] != s[j] {
            return false
        }
    }
    return true
}