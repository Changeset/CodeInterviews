package alibaba;

import java.util.Scanner;

public class Test1 {
    public static int times = Integer.MAX_VALUE;
    public static int curr = 0;
    public static int dx = 0;
    public static int dy = 0;
    public static int ds = 0;
    public static int r = 0;
    public static int c = 0;

    public static void main(String[] arg) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            times = Integer.MAX_VALUE;
            curr = 0;

            int x = in.nextInt();
            int y = in.nextInt();
            int s = transform(in.next());

            dx = in.nextInt();
            dy = in.nextInt();
            ds = transform(in.next());

            r = in.nextInt();
            c = in.nextInt();

            int[][] map = new int[r][c];
            for (int i = 0; i < r; i++)
                for (int j = 0; j < c; j++)
                    map[i][j] = in.nextInt();

            judge(x, y, s, map);
            times = (times == Integer.MAX_VALUE) ? 65535 : times;
            System.out.println(times);
        }
        in.close();
    }

    public static int transform(String str) {
        int result = -1;
        if ("EAST".equals(str))
            result = 0;
        else if ("SOUTH".equals(str))
            result = 1;
        else if ("WEST".equals(str))
            result = 2;
        else if ("NORTH".equals(str))
            result = 3;
        return result;
    }

    public static int rotate(int s, int d) {
        int t = Math.abs(s - d);
        return Math.min(t, 4 - t);
    }

    public static void judge(int x, int y, int s, int[][] map) {
        if (x == dx && y == dy) {
            curr += rotate(s, ds);
            if (curr < times)
                times = curr;
            return;
        }
        int record = curr;
        if (y + 1 < c && map[x][y + 1] == 0) {
            curr += rotate(s, 0) + 1;
            map[x][y + 1] = 1;
            judge(x, y + 1, 0, map);
            map[x][y + 1] = 0;
            curr = record;
        }
        if (x + 1 < r && map[x + 1][y] == 0) {
            curr += rotate(s, 1) + 1;
            map[x + 1][y] = 1;
            judge(x + 1, y, 1, map);
            map[x + 1][y] = 0;
            curr = record;
        }
        if (y - 1 >= 0 && map[x][y - 1] == 0) {
            curr += rotate(s, 2) + 1;
            map[x][y - 1] = 1;
            judge(x, y - 1, 2, map);
            map[x][y - 1] = 0;
            curr = record;
        }
        if (x - 1 >= 0 && map[x - 1][y] == 0) {
            curr += rotate(s, 3) + 1;
            map[x - 1][y] = 1;
            judge(x - 1, y, 3, map);
            map[x - 1][y] = 0;
            curr = record;
        }
    }
}