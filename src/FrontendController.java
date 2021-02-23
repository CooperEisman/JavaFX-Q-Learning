/*
Code by Cooper Eisman
Created: 02/05/2021
Last Modified: 02/05/2021
*/


import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.io.File;

public class FrontendController {
    //Instance
    private View view;
    private JPanel currScreen;
    private LayoutManager layoutManager;

    private JPanel south;
    private JPanel east;
    private JPanel center;

    private int width;
    private int height;

    private Maze maze;
    private JButton[] mazeView;

    public FrontendController(Maze maze) {
        //Initiate Input from maze
        this.maze = maze;
        this.width = maze.getWidth();
        this.height = maze.getHeight();
        this.mazeView = new JButton[width*height];



        //Itialize the View and Layout
        view = new View();
        layoutManager = new BorderLayout();

        //Initialize Current Screen and Set Layout
        currScreen = new JPanel();
        currScreen.setLayout(layoutManager);
        loadLayout();

        //Initial View
        loadScreen();
    }

    //private callable setup
    private void instantiateNew(Maze maze) {
        this.maze = maze;
        this.width = maze.getWidth();
        this.height = maze.getHeight();
        this.mazeView = new JButton[width*height];
    }

    //Validate and Update Viewport
    public void loadScreen() {
        currScreen.validate();
        view.configureViewPort(currScreen);
    }

    //Loads the Touchy THings
    private void loadLayout() {
        //South Frame
        south = new JPanel();
        south.setMaximumSize(new Dimension(view.getMaxWidth(),(view.getMaxHeight()/5)*2));
        currScreen.add(south, "South");

        //East Frame
        east = new JPanel();
        east.setMaximumSize(new Dimension((view.getMaxWidth()/5),(view.getMaxHeight()/5)*3));
        loadEast();
        currScreen.add(east, "East");

        //Center Frame
        center = new JPanel();
        center.setLayout(new GridLayout(width, height));
        center.setMaximumSize(new Dimension((view.getMaxWidth()/5)*4,(view.getMaxHeight()/5)*3));
        currScreen.add(center);
    }

    //Load the Screen
    public void updateCenter() {
        //Fix layout
        maze.generateNewMaze();
        maze.writeToFile();
        int[][] vars = maze.getArr();

        //center.removeAll();
        center.removeAll();
        center.setMaximumSize(new Dimension((view.getMaxWidth()/5)*4,(view.getMaxHeight()/5)*3));
        GridLayout centerLayout = new GridLayout();

        centerLayout.setColumns(width);
        centerLayout.setRows(height);
        centerLayout.setHgap(1);
        centerLayout.setVgap(1);
        center.setLayout(centerLayout);


        for(int x = 0; x < vars.length; x++) {
            for(int y = 0; y < vars[x].length; y++) {
                if (vars[x][y] == -1) {
                    mazeView[y*width+x] = new JButton();
                    mazeView[y*width+x].setBackground(new Color(0));
                    mazeView[y*width+x].setForeground(new Color(99999999));
                    mazeView[y*width+x] = new JButton("Barrier");
                } else if (vars[x][y] == 1) {
                    mazeView[y*width+x] = new JButton("Start");
                    mazeView[y*width+x].setBackground(new Color(101010));
                } else if (vars[x][y] == 10) {
                    mazeView[y*width+x] = new JButton("Finish");
                    mazeView[y*width+x].setBackground(new Color(100100100));
                } else {
                    mazeView[y*width+x] = new JButton();
                }
                mazeView[y*width+x].setEnabled(false);
            }
        }
        for(int x = 0; x < mazeView.length; x++) {
            center.add(mazeView[x]);
        }
        loadScreen();
    }

    private void loadEast() {
        //Layout Stuff
        GridLayout eastLayout = new GridLayout();
        eastLayout.setColumns(2);
        eastLayout.setRows(3);
        east.setLayout(eastLayout);

        //new Button for New Load
        JButton reset = new JButton("Generate");
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateCenter();
            }
        });
        east.add(reset);

        //new Button for Calculate Best Path
        JButton build = new JButton("Q-Calculate");

        build.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addQLearn();
            }
        });
        east.add(build);
    }
    private void addQLearn() {
        QLearning q = new QLearning(maze.getWidth(), maze.getHeight());
        int currPos = maze.startPos;
        int nextPos;
        //how to find xand y from pos [position/height][position%height]

        int[] poli = q.policies();
        //switch them up()

        int x = 0;
        do {
            nextPos = poli[currPos];

            System.out.println(q.isFinalState(maze.endPos));

            //makecolors
            mazeView[currPos].setBackground(new Color(11111111));
            mazeView[currPos].setFont(new Font("Arial", Font.PLAIN, 40));
            if (nextPos == currPos + 1) { // go Right
                mazeView[currPos].setText("→");
            } else if (nextPos == currPos - 1) { // go Left
                mazeView[currPos].setText("←");
            } else if (nextPos == currPos - width) { // go up
                mazeView[currPos].setText("↑");
            } else { // else, down
                mazeView[currPos].setText("↓");
            }

            currPos = nextPos;
            System.out.println(currPos + "/" + maze.endPos);
            x++;
        } while (maze.endPos != currPos && x != 20);

        loadScreen();
    }
}
