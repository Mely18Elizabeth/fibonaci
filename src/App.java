import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import Model.Cell;
import Model.Maze;
import controllers.*;

public class App {
    public static void main(String[] args) throws Exception {
        runEjerciciosFibonacci();
        runMazeBoolean();
        runMazeCell(); 
    }

    private static void runEjerciciosFibonacci() {
        int n = 50;
        System.out.println("Ejercicio fibonacci recursivo");
        long start = System.nanoTime();
        long resultado = getFibonacci(n);
        long end = System.nanoTime();
        long duration = end - start;
        System.out.println("Resultado: " + resultado + " en tiempo = " + duration + " ns ( " + (duration / 1e9) + " segundos)");

        System.out.println("Ejercicio fibonacci recursivo con PD");
        start = System.nanoTime();
        resultado = getFibonacciPD(n);
        end = System.nanoTime();
        duration = end - start;
        System.out.println("Resultado: " + resultado + " en tiempo = " + duration + " ns (" + (duration / 1e9) + " segundos)");
    }

    private static long getFibonacci(int n) {
        if (n <= 1) return n;
        return getFibonacci(n - 1) + getFibonacci(n - 2);
    }

    private static long getFibonacciPD(int n) {
        Map<Integer, Long> cache = new HashMap<>();
        return getFibonacciPDHelper(n, cache);
    }

    private static long getFibonacciPDHelper(int n, Map<Integer, Long> cache) {
        if (n <= 1) return n;
        if (cache.containsKey(n)) return cache.get(n);
        long result = getFibonacciPDHelper(n - 1, cache) + getFibonacciPDHelper(n - 2, cache);
        cache.put(n, result);
        return result;
    }

    private static void runMazeBoolean() {
        System.out.println("\n----ejercicio----");
        boolean[][] predefineMaze = {
            {true, true, true, true},
            {false, true, true, true},
            {true, true, false, false},
            {true, true, true, true}
        };

        Maze maze = new Maze(predefineMaze);
        maze.printMaze();

        Cell start = new Cell(0, 0);
        Cell end = new Cell(3, 3);
        MazeSolver solver = new MazeSolverRecursive();
        List<Cell> path = solver.getPath(maze.getMaze(), start, end);

        System.out.println("Camino encontrado:");
        for (Cell cell : path) {
            System.out.println(cell);
        }
    }

    private static void runMazeCell() {
        System.out.println("\n-----ejercicio------");
        boolean[][] predefineMaze = {
            {true, true, true, true},
            {false, true, true, true},
            {true, true, false, false},
            {true, true, true, true}
        };

        int rows = predefineMaze.length;
        int cols = predefineMaze[0].length;
        Cell[][] cellMaze = new Cell[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cellMaze[i][j] = new Cell(i, j);
                cellMaze[i][j].setWalkable(predefineMaze[i][j]);
            }
        }

        Cell start = new Cell(0, 0);
        Cell end = new Cell(3, 3);
        MazeSolverRecursivoCompletoBT fullSolver = new MazeSolverRecursivoCompletoBT();
        List<Cell> path = fullSolver.solve(cellMaze, start, end);

        System.out.println("Camino encontrado:");
        for (Cell cell : path) {
            System.out.println(cell);
        }
    }
}
