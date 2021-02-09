/*
Code by Cooper Eisman
Created: 02/05/2021
Last Modified: 02/05/2021
*/


import javax.swing.*;
import java.awt.*;

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

    public FrontendController(int width, int height) {
        //Initiate Input
        this.width = width;
        this.height = height;


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
        currScreen.add(east, "East");

        //Center Frame
        center = new JPanel();
        center.setLayout(new GridLayout(width, height));
        center.setMaximumSize(new Dimension((view.getMaxWidth()/5)*4,(view.getMaxHeight()/5)*3));
        currScreen.add(center);
    }

    //Load the Screen
    public void updateCenter(int[][] vars) {
        //Fix layout
        center.removeAll();
        center.setMaximumSize(new Dimension((view.getMaxWidth()/5)*4,(view.getMaxHeight()/5)*3));
        GridLayout centerLayout = new GridLayout();
        centerLayout.setColumns(width);
        centerLayout.setRows(height);
        centerLayout.setHgap(1);
        centerLayout.setVgap(1);
        center.setLayout(centerLayout);

        for(int x = 0; x < vars.length; x++) {
            for(int y = 0; x < vars[x].length; y++) {
                Button b;
                if (vars[x][y] == -1) {
                    b = new Button("Barrier");
                    b.setBackground(new Color(0));
                    b.setForeground(new Color(99999999));
                } else if (vars[x][y] == 1) {
                    b = new Button("Start");
                    b.setBackground(new Color(101010));
                } else if (vars[x][y] == 10) {
                    b = new Button("Finish");
                    b.setBackground(new Color(100100100));
                } else {
                    b = new Button("Box");
                }
                center.add(b);
            }
        }
        loadScreen();
    }


}
