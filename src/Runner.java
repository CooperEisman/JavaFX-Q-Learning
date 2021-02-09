import java.io.File;

public class Runner {

    public static void main(String[] args) {
        Maze m = new Maze(15,15,new File("./Resources/Maze.txt"));
        m.generateNewMaze();
        System.out.println(m.toString());

    }
}
