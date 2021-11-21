package stack

import (
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

// IsCorrectOrder
/*
   Check whether braces are placed in correct order.

   Input. String
   Output. Check whether braces are placed in correct order. Otherwise, return first incorrect index.
*/
func IsCorrectOrder(text string) string {
	head := Node{
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
