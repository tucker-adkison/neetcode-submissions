class Solution {
    public void islandsAndTreasure(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    boolean[][] visited = new boolean[grid.length][grid[i].length];
                    bfs(new Cell(i, j), grid, visited);
                }
            }
        }
    }

    public void bfs(Cell start, int[][] grid, boolean[][] visited) {
        Cell[] neighbors = new Cell[] {
            new Cell(0, 1),
            new Cell(1, 0),
            new Cell(0, -1),
            new Cell(-1, 0)
        };

        Queue<Cell> q = new LinkedList<Cell>();
        q.add(start);
        visited[start.x][start.y] = true;

        while (!q.isEmpty()) {
            Cell curr = q.poll();

            for (Cell n : neighbors) {
                int x = curr.x + n.x;
                int y = curr.y + n.y;

                if (x >= 0 && y >= 0 && x < grid.length && y < grid[x].length) {
                    if (grid[x][y] > 0 && !visited[x][y]) {
                        grid[x][y] = Math.min(grid[x][y], grid[curr.x][curr.y] + 1);
                        q.add(new Cell(x, y));
                        visited[x][y] = true;
                    }
                }
            }
        }
    }

    record Cell(int x, int y) {}
}
