package matrices;

import java.util.*;

public class GoldMiners {

    private static final int[] dirX = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static final int[] dirY = {0, 1, 1, 1, 0, -1, -1, -1};

    public static int mine(int[][] map, List<Integer> moves, List<String> history) {
        int totalResources = 3;
        int x = 0, y = 0;
        history.add("(" + x + ", " + y + ")");
        for (int move : moves) {
            int newX = x + dirX[move - 1];
            int newY = y + dirY[move - 1];
            if (isValidPosition(newX, newY, map.length, map[0].length)) {
                totalResources += map[newX][newY];
                map[newX][newY] = 0;
                x = newX;
                y = newY;
            }
            history.add("(" + x + ", " + y + ")");
        }
        return totalResources;
    }

    private static boolean isValidPosition(int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public static List<String> mostVisitedLocation(List<String> history) {
        Map<String, Integer> visitedCounts = new HashMap<>();
        int maxCount = 0;
        for (String loc : history) {
            visitedCounts.put(loc, visitedCounts.getOrDefault(loc, 0) + 1);
            maxCount = Math.max(maxCount, visitedCounts.get(loc));
        }
        List<String> mostVisited = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : visitedCounts.entrySet()) {
            if (entry.getValue() == maxCount) {
                mostVisited.add(entry.getKey());
            }
        }

        Collections.sort(mostVisited);
        return mostVisited;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] map = new int[n][m];
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < m; ++j)
                map[i][j] = scanner.nextInt();

        scanner.nextLine();
        String line = scanner.nextLine();
        String[] elems = line.split("\\s+");
        ArrayList<Integer> moves = new ArrayList<>();
        for (String elem : elems) {
            moves.add(Integer.parseInt(elem));
        }

        ArrayList<String> history = new ArrayList<>();

        System.out.println(mine(map, moves, history));

        List<String> loc = mostVisitedLocation(history);
        System.out.print(loc);
    }
}