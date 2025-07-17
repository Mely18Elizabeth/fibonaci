package controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Model.Cell;

public class MazeSolverRecursivoCompletoBT {
    private List<Cell> path;
    private Set<Cell> visited;
    private Cell[][] grid;
    private Cell end;

    public MazeSolverRecursivoCompletoBT() {
        this.path = new ArrayList<>();
        this.visited = new HashSet<>();
    }

    public List<Cell> solve(Cell[][] grid, Cell start, Cell end) {
        path.clear();
        visited.clear();
        this.grid = grid;
        this.end = end;

        if (grid == null || grid.length == 0) {
            return new ArrayList<>();
        }

        if (findPath(start)) {
            return path;
        }

        return new ArrayList<>();
    }

    private boolean findPath(Cell current) {
        if (!isInMaze(current) || !isValid(current) || visited.contains(current)) {
            return false;
        }

        visited.add(current);
        path.add(current);

        if (current.equals(end)) {
            return true;
        }

        Cell[] directions = {
            new Cell(current.getRow(), current.getCol() + 1), // derecha
            new Cell(current.getRow() + 1, current.getCol()), // abajo
            new Cell(current.getRow(), current.getCol() - 1), // izquierda
            new Cell(current.getRow() - 1, current.getCol())  // arriba
        };

        for (Cell next : directions) {
            if (findPath(next)) {
                return true;
            }
        }

        path.remove(path.size() - 1);
        return false;
    }

    private boolean isInMaze(Cell cell) {
        return cell.getRow() >= 0 && cell.getRow() < grid.length &&
               cell.getCol() >= 0 && cell.getCol() < grid[0].length;
    }

    private boolean isValid(Cell cell) {
        return grid[cell.getRow()][cell.getCol()].isWalkable();
    }
}
