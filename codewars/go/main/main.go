package main

import (
	"fmt"
	"reflect"
	"github.com/deontaljaard/codewars/go/dups"
	"github.com/deontaljaard/codewars/go/spinWords"
	"github.com/deontaljaard/codewars/go/stockList"
	"github.com/deontaljaard/codewars/go/rectIntoSquares"
	"github.com/deontaljaard/codewars/go/pigLatin"
	"github.com/deontaljaard/codewars/go/square"
	"github.com/deontaljaard/codewars/go/nameFormat"
)

func main() {
	// duplicate count
	fmt.Println("Duplicate count")
	fmt.Println(dups.DuplicateCount("aadd") == 2)
	fmt.Println(dups.DuplicateCount("abcdefabcabA") == 3)
	fmt.Println("================")

	// spin words
	fmt.Println("Spin words")
	fmt.Println(spinWords.SpinWords("Stop spinning this around!") == "Stop gninnips this !dnuora")
	fmt.Println(spinWords.SpinWords("Hey fellow warriors") == "Hey wollef sroirraw")
	fmt.Println(spinWords.SpinWords("Burgers are my favorite fruit") == "sregruB are my etirovaf tiurf")
	fmt.Println("================")

	// stock list
	fmt.Println("Bookkeeper helper")
	var b = []string{"BBAR 150", "CDXE 515", "BKWR 250", "BTSQ 890", "DRTY 600"}
	var c = []string{"A", "B", "C", "D"}
	fmt.Println(stockList.StockList(b, c) == "(A : 0) - (B : 1290) - (C : 515) - (D : 600)")
	fmt.Println("================")
	
	// square in rect 
	fmt.Println("Squares in rectangle")
	fmt.Println(reflect.DeepEqual(rectIntoSquares.SquaresInRect(5, 3), []int{3, 2, 1, 1}))
	fmt.Println(reflect.DeepEqual(rectIntoSquares.SquaresInRect(5, 5), []int{}))
	fmt.Println("================")

	// pig latin
	fmt.Println("Pig latin")
	fmt.Println(pigLatin.PigIt("How are you doing?") == "owHay reaay ouyay oing?day")
	fmt.Println(pigLatin.PigIt("Pig latin is cool") == "igPay atinlay siay oolcay")
	fmt.Println("================")

	// square
	fmt.Println("Square")
	fmt.Println(square.Square(0) == true)
	fmt.Println(square.Square(-1) == false)
	fmt.Println("================")

	// name format
	fmt.Println("Name format")
	fmt.Println(nameFormat.FormatNames([]map[string]string{ {"name": "Bart"}, {"name": "Lisa"}, {"name": "Maggie"}, {"name": "Homer"}, {"name": "Marge"} }) == "Bart, Lisa, Maggie, Homer & Marge")
	fmt.Println(nameFormat.FormatNames([]map[string]string{ {"name": "Bart"}, {"name": "Lisa"} }) == "Bart & Lisa")
	fmt.Println(nameFormat.FormatNames([]map[string]string{ {"name": "Bart"} }) == "Bart")
	fmt.Println("================")
}
