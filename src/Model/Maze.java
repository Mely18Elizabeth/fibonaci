package Model;
public class Maze {
    boolean [][] maze;
    public Maze(boolean [][] predefineMaze){
        this.maze = predefineMaze;
    }
    public void printMaze(){
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if(maze[i][j]){
                    System.out.print( " - ");
                }else{
                    System.out.print( " + ");
                }
            }
            System.out.println();
        }
    }
    public boolean[][] getMaze() {
        return maze;
    }
    public void setMaze(boolean[][] maze) {
        this.maze = maze;
    }
    
}