/*
Code by Cooper Eisman
Created: 02/05/2021
Last Modified: 02/05/2021
*/

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.lang.reflect.Array;

class Main {
    //Callable Main value, allows for synchronized runtime processing
    public static Main main = null;

    //Starts Program
    public static void main(String[] args) {
        main = new Main();

        FrontendController fc = new FrontendController(5,5);
        Maze m = new Maze(5,5,new File("./Resources/Maze.txt"));
        m.generateNewMaze();
        fc.updateCenter(m.getArr());
    }
}
