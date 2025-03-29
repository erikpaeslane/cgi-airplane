package cgi.internship.project.utils;

import java.util.Random;

/**
 *
 * Abiklass, mis lennu isendi loomisel juhuslikult genereerib lennuki istekohtade kinnisust
 * antud rida ja veeru arvude põhjal
 * true -> istekoht on tühi
 * false -> istekoht on kinni
 *
 */
public class SeatsGenerator {

    public static boolean[][] fillSeats(int rows, int columns) {
        Random random = new Random();
        boolean[][] seats = generateSeats(rows, columns);

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                int randomInt = random.nextInt(2);
                if (randomInt == 1)
                    seats[row][column] = true;
            }
        }
        return seats;
    }

    private static boolean[][] generateSeats(int rows, int columns) {
        return new boolean[rows][columns];
    }

}
