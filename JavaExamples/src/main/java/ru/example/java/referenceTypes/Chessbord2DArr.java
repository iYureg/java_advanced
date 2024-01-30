package ru.example.java.referenceTypes;

public class Chessbord2DArr {
    public static void main(String[] args)
    {

        // my solution
        char[][] chessboard = new char[8][8];
        int count = 0;
        for (int i = 0; i < chessboard.length; i++) {

            for (int j = 0; j < chessboard[i].length; j++) {
                if(count % 2 == 0) chessboard[i][j] = '\u25A1';
                else chessboard[i][j] = '\u25A0';
                count++;
                System.out.print(chessboard[i][j] + " ");
            }
            count--;
            System.out.println();
        }

        System.out.println();
        System.out.println();
        // solution from JFB
        char[][] chessboard2 = new char[8][8];

        for (int y = 0; y < chessboard2.length; y++)
        {
            for (int x = 0; x < chessboard2.length; x++)
            {
                if ((x+y)%2 == 0)
                    chessboard2[y][x] = '\u25A1';
                else
                    chessboard2[y][x] = '\u25A0';
            }
        }

        for (char[] row: chessboard2)
        {
            for (char square: row)
            {
                System.out.print(square + " ");
            }
            System.out.println();
        }
    }
}
