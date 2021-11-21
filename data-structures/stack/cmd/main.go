package main

import (
	"bufio"
	"data-structures/stack"
	"fmt"
	"os"
)

func main() {
	reader := bufio.NewReader(os.Stdin)
	text, _ := reader.ReadString('\n')
	text = text[:len(text)-1] // remove \n
	fmt.Println(stack.IsCorrectOrder(text))
}
