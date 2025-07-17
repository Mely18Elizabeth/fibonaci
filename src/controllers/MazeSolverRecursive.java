package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import Model.Cell;

public class MazeSolverRecursive implements MazeSolver {
    @Override
    public List<Cell> getPath(boolean[][] grid, Cell start, Cell end) {
        List<Cell> path = new ArrayList<>();
        if(grid == null || grid.length == 0)
            return path;
        if(findPath(grid, start, end, path)) {
            Collections.reverse(path);
            return path;
        }
        return new ArrayList<>();
    }

    private boolean findPath(boolean[][] grid, Cell start, Cell end, List<Cell> path) {
        int row = start.getRow();
        int col = start.getCol();

        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || !grid[row][col])
            return false;

        if(row == end.getRow() && col == end.getCol()) {
            path.add(start);
            return true;
        }
        grid[row][col] = false;

        if(findPath(grid, new Cell(row + 1, col), end, path) ||
           findPath(grid, new Cell(row, col + 1), end, path)) {
            path.add(start);
            return true;
        }

        return false;
    }
}
