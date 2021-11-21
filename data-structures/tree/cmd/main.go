package main

import (
	"bufio"
	"container/list"
	"fmt"
	"os"
	"sort"
	"strconv"
	"strings"
)

func main() {
	reader := bufio.NewReader(os.Stdin)

	var n int
	_, err := fmt.Scanf("%d", &n)
	if err != nil {
		return
	}

	second, _ := reader.ReadString('\n')
	second = second[:len(second)-1] // remove \n

	arr := strings.Split(second, " ")
	slice := make([]int, 0)
	for _, elem := range arr {
		asd, _ := strconv.Atoi(elem)
		slice = append(slice, asd)
	}
	sort.Ints(slice)
	root := Construct(0, len(slice)-1, slice)
	queue := list.New()
	queue.PushBack(root)

	cnt := 0
	for queue.Len() != 0 {
		cnt++
		for i := 0; i < queue.Len(); i++ {
			in := queue.Back()
			queue.Remove(in)
			e := in.Value.(*Node)
			if e.Left != nil {
				queue.PushBack(e.Left)
			}
			if e.Right != nil {
				queue.PushBack(e.Right)
			}
		}
	}
	fmt.Println(cnt)
}

type Node struct {
	Value       int
	Left, Right *Node
}

func Construct(l, r int, slice []int) *Node {
	if l > r {
		return nil
	}
	mid := l + (r-l)/2
	root := Node{Value: slice[mid]}
	root.Left = Construct(l, mid-1, slice)
	root.Right = Construct(mid+1, r, slice)
	return &root
}
