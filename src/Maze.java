//Cooper Eisman -- Maze Class

import java.io.*;
import java.util.Scanner;


public class Maze {
    //Instance
    private int width = 3;
    private int height = 3;
    private File file;
    int[][] maze;

    int startPos;
    int endPos;

    //Instantiate with Default Height
    public Maze(File file) {
        this.file = file;
        maze = new int[3][3];
    }

    //Instatiate with overridden stats
    public Maze (int width, int height, File file) {
        this.width = width;
        this.height = height;
        this.file = file;
        maze = new int[width][height];

        //So that we don't die
        this.endPos = 0;
        this.startPos = 0;
    }

    //Writes/Wewrites the file; Returns false if operation fails
    public void generateNewMaze() {
        //Clear Array
        for(int x = 0; x < width; x++) {
            for(int y = 0; y < height; y++) {
                maze[x][y] = 0;
            }
        }

        int numBarriers = (width*height)/5;

        for(int x = 0; x < numBarriers; x++) {
            int position = (int)((width*height)*Math.random());

            if (!(maze[position/height][position%height] == -1)) {
                maze[position/height][position%height] = -1;
            }
        }
        //Set Final Position
        int position;
        do {
            position = (int)((width*height)*Math.random());
        } while ((maze[position/height][position%height] == -1));
        maze[position/height][position%height] = 10;
        endPos = position;

        //Set Start Position
        do {
            position = (int)((width*height)*Math.random());
        } while ((maze[position/height][position%height] == -1) || (maze[position/height][position%height] == 10));
        maze[position/height][position%height] = 1;
        startPos = position;
    }

    public String toString() {
        String s = "";
        for(int x = 0; x < width; x++) {
            for(int y = 0; y < height; y++) {
                int curr = maze[x][y];
                if(curr == 0) {
                    s += "O";
                } else if (curr == -1) {
                    s += "X";
                } else if (curr == 10) {
                    s += "F";
                } else {
                    s += "*";
                }
            }
            s+= "\n";
        }
        return s;
    }

    public void writeToFile() {
        clearTheFile();
        FileWriter toFile;
        try {
            toFile = new FileWriter(file);
            toFile.write(toString());
            toFile.close();
        } catch(IOException e) {
            System.out.println("Error: File not Read: " + e.toString());
        }

    }


    //Clears the File. Returns false if operation fails
    public boolean clearTheFile() {
        FileWriter fwOb;
        try {
            fwOb = new FileWriter(file, false);
        } catch (IOException e) {
            return false;
        }
        PrintWriter pwOb = new PrintWriter(fwOb, false);
        pwOb.flush();
        pwOb.close();
        try {
            fwOb.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public int[][] getArr() {
        return maze;
    }

    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }


    //
}
