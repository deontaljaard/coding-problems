/*
Kata: Help the Bookseller!

Details:
A bookseller has lots of books classified in 26 categories labeled A, B, ... Z. Each book has a code c of 3, 4, 5 or more capitals letters. The 1st letter of a code is the capital letter of the book category. In the bookseller's stocklist each code c is followed by a space and by a positive integer n (int n >= 0) which indicates the quantity of books of this code in stock.
*/

package kata;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StockList {


    // 1st parameter is the stocklist (L in example),
    // 2nd parameter is list of categories (M in example)
    public static String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        if (lstOfArt.length == 0 || lstOf1stLetter.length == 0) return "";
        return Arrays.stream(lstOf1stLetter).map(code -> "(" + code + " : " + takeStock(code, lstOfArt) + ")").collect(Collectors.joining(" - "));
    }

    private static int takeStock(String code, String[] art) {
        return Arrays.stream(art)
                .map(stock -> stock.startsWith(code) ? Integer.parseInt(stock.split(" ")[1]) : 0)
                .reduce(0, Integer::sum);
    }


    public static void main(String... args) {
        String[] d = {"ABAR 200", "CDXE 500", "BKWR 250", "BTSQ 890", "DRTY 600"};
        String[] e = {"C", "D"};
        assert (stockSummary(d, e).equals("(C : 500) - (D : 600)"));
    }
}
