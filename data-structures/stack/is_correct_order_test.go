package stack

import "testing"

func TestIsCorrectOrder(t *testing.T) {
	assertEqual(t, 1, IsCorrectOrder("([](){([])})"), "Success")
	assertEqual(t, 2, IsCorrectOrder("()[]}"), "5")
	assertEqual(t, 3, IsCorrectOrder("{{[()]]"), "7")
	assertEqual(t, 4, IsCorrectOrder("{{{[][][]"), "3")
	assertEqual(t, 5, IsCorrectOrder("{*{{}"), "3")
	assertEqual(t, 6, IsCorrectOrder("[[*"), "2")
	assertEqual(t, 7, IsCorrectOrder("{*}"), "Success")
	assertEqual(t, 8, IsCorrectOrder("{{"), "2")
	assertEqual(t, 9, IsCorrectOrder("{}"), "Success")
	assertEqual(t, 10, IsCorrectOrder(""), "Success")
	assertEqual(t, 11, IsCorrectOrder("}"), "1")
	assertEqual(t, 12, IsCorrectOrder("*{}"), "Success")
	assertEqual(t, 13, IsCorrectOrder("{{{**[][][]"), "3")
	assertEqual(t, 14, IsCorrectOrder("([](){([])})"), "Success")
	assertEqual(t, 15, IsCorrectOrder("()[]}"), "5")
	assertEqual(t, 16, IsCorrectOrder("{{[()]]"), "7")
	assertEqual(t, 17, IsCorrectOrder("{{{[][][]"), "3")
	assertEqual(t, 18, IsCorrectOrder("{*{{}"), "3")
	assertEqual(t, 19, IsCorrectOrder("[[*"), "2")
	assertEqual(t, 20, IsCorrectOrder("{*}"), "Success")
	assertEqual(t, 21, IsCorrectOrder("{{"), "2")
	assertEqual(t, 22, IsCorrectOrder("{}"), "Success")
	assertEqual(t, 23, IsCorrectOrder(""), "Success")
	assertEqual(t, 24, IsCorrectOrder("}"), "1")
	assertEqual(t, 25, IsCorrectOrder("*{}"), "Success")
	assertEqual(t, 26, IsCorrectOrder("{{{**[][][]"), "3")
	assertEqual(t, 27, IsCorrectOrder("()({}"), "3")
	assertEqual(t, 28, IsCorrectOrder("{{[()]}"), "1")
	assertEqual(t, 29, IsCorrectOrder("[]"), "Success")
	assertEqual(t, 30, IsCorrectOrder("{}[]"), "Success")
	assertEqual(t, 31, IsCorrectOrder("[()]"), "Success")
	assertEqual(t, 32, IsCorrectOrder("(())"), "Success")
	assertEqual(t, 33, IsCorrectOrder("{[]}()"), "Success")
	assertEqual(t, 34, IsCorrectOrder("([](){([])})"), "Success")
	assertEqual(t, 35, IsCorrectOrder("oo(bar);"), "Success")
	assertEqual(t, 36, IsCorrectOrder("{"), "1")
	assertEqual(t, 37, IsCorrectOrder("{[}"), "3")
	assertEqual(t, 38, IsCorrectOrder("()[]}"), "5")
	assertEqual(t, 39, IsCorrectOrder("{{[()]]"), "7")
	assertEqual(t, 40, IsCorrectOrder("[]([]"), "3")
}

func assertEqual(t *testing.T, i int, actual string, expected string) {
	if actual != expected {
		t.Fatalf("case=[%d]: expected=[%s] but got=[%s]", i, expected, actual)
	}
}
