package controllers;
import java.util.List;
import Model.Cell;

public interface MazeSolver {
    List<Cell> getPath(boolean[][] grid, Cell start, Cell end);
    
}