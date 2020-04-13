"""
Kata: Help the Bookseller!

Details:
A bookseller has lots of books classified in 26 categories labeled A, B, ... Z. Each book has a code c of 3, 4, 5 or more capitals letters. The 1st letter of a code is the capital letter of the book category. In the bookseller's stocklist each code c is followed by a space and by a positive integer n (int n >= 0) which indicates the quantity of books of this code in stock.
"""

def stock_list(listOfArt, listOfCat):
    if not listOfArt or not listOfCat:
        return ""
        
    stock = {}
    for code in listOfCat:
        stock[code] = 0
        for art in listOfArt:
            if art.startswith(code):
                if stock.get(code):
                    stock[code] += int(art.split(" ")[1])
                else:
                    stock[code] = int(art.split(" ")[1])
        
    return " - ".join([f"({code} : {amount})" for code, amount in stock.items()])

b = ["ABAR 200", "CDXE 500", "BKWR 250", "BTSQ 890", "DRTY 600"]
c = ["A", "B"]
assert stock_list(b, c) == "(A : 200) - (B : 1140)"

d = ["ABAR 200", "CDXE 500", "BKWR 250", "BTSQ 890", "DRTY 600"]
e = ["C", "D"]
assert stock_list(d, e) == "(C : 500) - (D : 600)"