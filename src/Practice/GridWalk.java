/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practice;

import java.util.ArrayList;

/**
 *
 * @author Garden
 */
public class GridWalk {

    public static ArrayList<Location> list = new ArrayList<>();
    public static Boolean[][] status;

    public static class Location {

        int x, y;

        Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    //get the most longest range of the points
    public static int getRange(int x, int y, int result) {

        if (sumDigits(x) + sumDigits(y) > 19) {
            return result;
        }

        int range = getRange(x + 1, y, result + 1);

        return range;
    }

    public static void main(String[] args) {

        int range = getRange(0, 0, 0);
        // 1/4 matrix
        status = new Boolean[range][range];

        for (int i = 0; i < status.length; i++) {
            for (int j = 0; j < status[0].length; j++) {
                status[i][j] = false;
            }
        }

        status[0][0] = true;
        Location start = new Location(0, 0);

        list.add(start);

        int index = 0;
        while (true) {
            if (index >= list.size()) {
                break;
            }

            visited(list.get(index));
            index++;
        }
        System.out.println((list.size() - 299 * 2) * 4 + 299 * 4 + 1);
    }

    public static void visited(Location loc) {

        Location right = new Location(loc.x + 1, loc.y);
        Location up = new Location(loc.x, loc.y + 1);

        if (loc.x < 298 && loc.y < 298) {
            addIfNewAccessibleLocation(right);
            addIfNewAccessibleLocation(up);
        }
    }

    public static void addIfNewAccessibleLocation(Location loc) {
        //if can be added
        if (!status[loc.x][loc.y] && isAccessible(loc)) {
            status[loc.x][loc.y] = true;
            list.add(loc);
        }
    }

    public static boolean isAccessible(Location loc) {
        return (sumDigits(loc.x) + sumDigits(loc.y) <= 19);
    }

    public static int sumDigits(int n) {

        if (n == 0) {
            return 0;
        }
        n = Math.abs(n);

        return (n % 10) + sumDigits(n / 10);
    }
}
