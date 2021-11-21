package main

import (
	"bufio"
	"fmt"
	"os"
)

const (
	openBracket  = 40
	closeBracket = 41
	openSquare   = 91
	closeSquare  = 93
	openCurly    = 123
	closeCurly   = 125
)

func main() {
	reader := bufio.NewReader(os.Stdin)
	text, _ := reader.ReadString('\n')
	text = text[:len(text)-1] // remove \n
	nStack := StackNode{
		elem:          -1,
		simpleCnt:     0,
		squareCnt:     0,
		curlyCnt:      0,
		lastSquareIdx: -1,
		lastSimpleIdx: -1,
		lastCurlyIdx:  -1,
		prev:          nil,
		next:          nil,
	}

	stack := &nStack

	possibleElems := map[int32]struct{}{
		openBracket:  {},
		closeBracket: {},
		openSquare:   {},
		closeSquare:  {},
		openCurly:    {},
		closeCurly:   {},
	}

	for i, r := range text {
		if _, ok := possibleElems[r]; !ok {
			continue
		}

		if stack.len == 0 {
			if r == closeBracket || r == closeCurly || r == closeSquare {
				fmt.Println(i + 1)
				return
			}
			stack = stack.append(i, r)
			continue
		}

		top := stack.elem
		if (top == openCurly && r == closeCurly) || (top == openBracket && r == closeBracket) || (top == openSquare && r == closeSquare) {
			stack = stack.prev
		} else {
			if (stack.simpleCnt == 0 && r == ')') || (stack.curlyCnt == 0 && r == '}') || (stack.squareCnt == 0 && r == ']') {
				fmt.Println(i + 1)
				return
			}
			stack = stack.append(i, r)
		}
	}

	if stack.simpleCnt == 0 && stack.squareCnt == 0 && stack.curlyCnt == 0 {
		fmt.Println("Success")
		return
	}

	if stack.simpleCnt > stack.curlyCnt && stack.simpleCnt > stack.squareCnt {
		fmt.Println(stack.lastSimpleIdx + 1)
		return
	}
	if stack.curlyCnt > stack.simpleCnt && stack.curlyCnt > stack.squareCnt {
		fmt.Println(stack.lastCurlyIdx + 1)
		return
	}

	fmt.Println(stack.lastSquareIdx + 1)
}

type StackNode struct {
	elem                                       rune
	simpleCnt, squareCnt, curlyCnt             int
	lastSquareIdx, lastSimpleIdx, lastCurlyIdx int
	len                                        int
	prev, next                                 *StackNode
}

func (s *StackNode) append(i int, elem rune) *StackNode {
	node := StackNode{
		elem:          elem,
		simpleCnt:     s.simpleCnt,
		squareCnt:     s.squareCnt,
		curlyCnt:      s.curlyCnt,
		lastCurlyIdx:  s.lastCurlyIdx,
		lastSquareIdx: s.lastSquareIdx,
		lastSimpleIdx: s.lastSimpleIdx,
		prev:          s,
		next:          nil,
		len:           s.len + 1,
	}
	switch elem {
	case '(':
		node.lastSimpleIdx = i
		node.simpleCnt = s.simpleCnt + 1
	case '{':
		node.lastCurlyIdx = i
		node.curlyCnt = s.curlyCnt + 1
	case '[':
		node.lastSquareIdx = i
		node.squareCnt = s.squareCnt + 1
	}

	s.next = &node
	return &node
}
