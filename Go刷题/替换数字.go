package main

import "fmt"

func main(){
    var strByte []byte
    
    fmt.Scanln(&strByte)
    
    for i := 0; i < len(strByte); i++{
        if strByte[i] <= '9' && strByte[i] >= '0' {
            inserElement := []byte{'n','u','m','b','e','r'}
            strByte = append(strByte[:i], append(inserElement, strByte[i+1:]...)...)
            i = i + len(inserElement) -1
        }
    }
    
    fmt.Printf(string(strByte))
}