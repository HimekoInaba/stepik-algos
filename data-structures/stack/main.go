package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
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
	fmt.Println(IsCorrectOrder(text))
}

// IsCorrectOrder
/*
   Check whether braces are placed in correct order.

   Input. String
   Output. Check whether braces are placed in correct order. Otherwise, return first incorrect index.
*/
func IsCorrectOrder(text string) string {
	head := StackNode{
		elem:          -1,
		simpleCnt:     0,
		squareCnt:     0,
		curlyCnt:      0,
		lastSquareIdx: 0,
		lastSimpleIdx: 0,
		lastCurlyIdx:  0,
		prev:          nil,
		next:          nil,
	}

	stack := &head

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
				return strconv.Itoa(i + 1)
			}
			stack = stack.append(i, r)
			continue
		}

		top := stack.elem
		if (top == openCurly && r == closeCurly) || (top == openBracket && r == closeBracket) || (top == openSquare && r == closeSquare) {
			stack = stack.prev
		} else if top != openCurly && r == closeCurly {
			return strconv.Itoa(i + 1)
		} else if top != openBracket && r == closeBracket {
			return strconv.Itoa(i + 1)
		} else if top != openSquare && r == closeSquare {
			return strconv.Itoa(i + 1)
		} else {
			stack = stack.append(i, r)
		}
	}

	if stack.curlyCnt > stack.squareCnt && stack.curlyCnt > stack.simpleCnt {
		return strconv.Itoa(stack.lastCurlyIdx + 1)
	}

	if stack.squareCnt > stack.curlyCnt && stack.squareCnt > stack.simpleCnt {
		return strconv.Itoa(stack.lastSquareIdx + 1)
	}

	if stack.simpleCnt > stack.squareCnt && stack.simpleCnt > stack.curlyCnt {
		return strconv.Itoa(stack.lastSimpleIdx + 1)
	}

	return "Success"
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
