/*
Kata: Help the Bookseller!

Details:
A bookseller has lots of books classified in 26 categories labeled A, B, ... Z. Each book has a code c of 3, 4, 5 or more capitals letters. The 1st letter of a code is the capital letter of the book category. In the bookseller's stocklist each code c is followed by a space and by a positive integer n (int n >= 0) which indicates the quantity of books of this code in stock.
*/

package stockList

import (
	"fmt"
	"strings"
	"strconv"
)

func StockList(listArt []string, listCat []string) string {
	if len(listArt) < 1 || len(listCat) < 1 {
		return ""
	}
	var stockSummary []string
	for _, code := range listCat {
		var count int64
		for _, stock := range listArt {
			if strings.HasPrefix(stock, code) {
				stockCount, _ := strconv.ParseInt(strings.Split(stock, " ")[1], 10, 64)
				count += stockCount
			}
		}
		stockSummary = append(stockSummary, fmt.Sprintf("(%s : %d)", code, count))
	}
	return strings.Join(stockSummary[:], " - ")
}