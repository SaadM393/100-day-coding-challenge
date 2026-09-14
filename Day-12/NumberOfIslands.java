import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int columns = grid[0].length;
        int islandCount = 0;

        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (grid[row][column] == '1') {
                    islandCount++;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{row, column});
                    grid[row][column] = '0';

                    while (!queue.isEmpty()) {
                        int[] currentCell = queue.poll();
                        int currentRow = currentCell[0];
                        int currentColumn = currentCell[1];

                        for (int[] direction : directions) {
                            int nextRow = currentRow + direction[0];
                            int nextColumn = currentColumn + direction[1];

                            if (nextRow >= 0 && nextRow < rows
                                    && nextColumn >= 0 && nextColumn < columns
                                    && grid[nextRow][nextColumn] == '1') {
                                grid[nextRow][nextColumn] = '0';
                                queue.offer(new int[]{nextRow, nextColumn});
                            }
                        }
                    }
                }
            }
        }

        return islandCount;
    }

    public static void main(String[] args) {
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };

        System.out.println(numIslands(grid));
    }
}
