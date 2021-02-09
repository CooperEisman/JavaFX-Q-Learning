/*
Code by Cooper Eisman
Created: 02/05/2021
Last Modified: 02/05/2021
*/

import javax.swing.*;
import java.io.File;
import java.lang.reflect.Array;

class Main {
    //Callable Main value, allows for synchronized runtime processing
    public static Main main = null;

    //Starts Program
    public static void main(String[] args) {
        main = new Main();
        FrontendController screen = new FrontendController();

        int length = 15;
        int width = 15;
        JPanel main = new JPanel();
        JTextPane[][] words = new JTextPane[length][width];
        Maze m = new Maze(length,width,new File("./Resources/Maze.txt"));
        m.generateNewMaze();

        int temp = 0;
        for(int x = 0; x < m.getWidth(); x++) {
            for(int y = 0; y < m.getHeight(); y++) {
                m.getArr()[x][y] = temp;
                if (temp == -1) {
                    words[x][y] = new JTextPane();
                }
                words[x][y] = new JTextPane()
            }
        }
    }
}
