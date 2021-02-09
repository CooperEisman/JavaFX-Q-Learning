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

    public FrontendController(int width, int height) {
        //Itialize the View and Layout
        view = new View();
        layoutManager = new BorderLayout();

        //Initialize Current Screen and Set Layout
        currScreen = new JPanel();
        currScreen.setLayout(layoutManager);
        loadLayout();



        currScreen.validate();


        loadScreen();
    }

    public void loadScreen() {
        view.configureViewPort(currScreen);
    }

    private void loadLayout(int[][] vars) {
        //South Frame
        south = new JPanel();
        south.setMinimumSize(new Dimension(view.getMaxWidth(),(view.getMaxHeight()/5)*2));
        currScreen.add(south, "South");

        //East Frame
        east = new JPanel();
        east.setMinimumSize(new Dimension((view.getMaxWidth()/5),(view.getMaxHeight()/5)*3));
        currScreen.add(east, "East");

        //Center Frame
        center = new JPanel();
        center.setMinimumSize(new Dimension((view.getMaxWidth()/5)*4,(view.getMaxHeight()/5)*3));
        currScreen.add(center);
    }


}
