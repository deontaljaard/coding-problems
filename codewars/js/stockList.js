/*
Kata: Help the Bookseller!

Details:
A bookseller has lots of books classified in 26 categories labeled A, B, ... Z. Each book has a code c of 3, 4, 5 or more capitals letters. The 1st letter of a code is the capital letter of the book category. In the bookseller's stocklist each code c is followed by a space and by a positive integer n (int n >= 0) which indicates the quantity of books of this code in stock.
*/

const takeStockOf = code => (acc, stock) => stock.startsWith(code) ? acc + parseInt(stock.split(" ")[1]) : acc;

function stockList(listOfArt, listOfCat) {
  if (!listOfArt.length || !listOfCat.length) return "";
  return listOfCat.map(code => `(${code} : ${listOfArt.reduce(takeStockOf(code), 0)})`).join(" - ")
}

let b = ["ABAR 200", "CDXE 500", "BKWR 250", "BTSQ 890", "DRTY 600"]
let c = ["A", "B"]
console.assert(stockList(b, c) == "(A : 200) - (B : 1140)")