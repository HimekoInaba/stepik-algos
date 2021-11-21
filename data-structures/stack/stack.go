package stack

type Node struct {
	elem                                       rune
	simpleCnt, squareCnt, curlyCnt             int
	lastSquareIdx, lastSimpleIdx, lastCurlyIdx int
	len                                        int
	prev, next                                 *Node
}

func (s *Node) append(i int, elem rune) *Node {
	node := Node{
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
