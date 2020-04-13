package kata;

public class EightQueens {


    public static String solution(String location) {
        String[][] board = initBoard(location);

        if (!solve(board, 0, location)) {
            System.out.print("Solution does not exist");
            return null;
        }

        System.out.println(asStr(board));
        return "";
    }

    public static boolean solve(String[][] board, int col, String location) {
        if (col >= board.length) return true;

        for (int row = 0; row < board.length; row++) {
            int r = charToInt(location.charAt(0));
            int c = Integer.parseInt(String.valueOf(location.charAt(1)));
            if (isSafe(row, col, board)) {
                board[row][col] = "Q";

                if (solve(board, col + 1, location)) return true;
                board[row][col] = "*";
            }
        }
        return false;
    }

    public static boolean isSafe(int row, int col, String[][] board) {
        int r, c;

        // check left side of current col
        for (c = 0; c < col; col++) {
            if (board[row][col].equals("Q")) return false;
        }

        // check upper diagonal on left side
        for (r = row, c = col; r >= 0 && c >= 0; r--, c--) {
            if (board[row][col].equals("Q")) return false;
        }

        // check lower diagonal on left side
        for (r = row, c = col; c >= 0 && r < board.length; r++, c--) {
            if (board[row][col].equals("Q")) return false;
        }

        return true;
    }


    public static String[][] initBoard(String location) {
        String[][] board = new String[8][8];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                int r = charToInt(location.charAt(0));
                int c = Integer.parseInt(String.valueOf(location.charAt(1)));
//                if (row == r && (col + 1) == c) {
//                    board[row][col] = "Q";
//                } else {
//
//                }
                board[row][col] = "*";
            }
        }
        return board;
    }

    public static int charToInt(char ch) {
        switch (ch) {
            case 'a':
                return 0;
            case 'b':
                return 1;
            case 'c':
                return 2;
            case 'd':
                return 3;
            case 'e':
                return 4;
            case 'f':
                return 5;
            case 'g':
                return 6;
            case 'h':
                return 7;
            default:
                return 8;
        }
    }

    public static String asStr(String[][] board) {
        StringBuilder sb = new StringBuilder();
        for (String[] row : board) {
            for (String col : row) {
                sb.append(col).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String... args) {
        System.out.println(solution("c3"));
//        assert(solution("c3").equals("d8,a7,e6,h5,b4,g3,c2,f1"));
    }
}
