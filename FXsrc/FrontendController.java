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

    public FrontendController(int width, int height) {
        //Itialize the View and Layout
        view = new View();
        layoutManager = new BorderLayout();

        //Initialize Current Screen and Set Layout
        currScreen = new JPanel();
        currScreen.setLayout(layoutManager);


        //loadLayout();
        loadScreen();
    }

    public void loadScreen() {
        view.configureViewPort(currScreen);
    }

    private void loadLayout() {
        JButton b = new JButton("My Ass");
        //South Frame
        JFrame south = new JFrame();
        south.setMinimumSize(new Dimension(view.getMaxWidth(),(view.getMaxHeight()/10)*2));
        south.add(b);
        currScreen.add(south,0);

        //East Frame
        JFrame east = new JFrame();
        east.setMinimumSize(new Dimension((view.getMaxWidth()/5),(view.getMaxHeight()/10)*8));
        east.add(b);
        currScreen.add(east,1);

        //Center Frame
        JFrame center = new JFrame();
        center.setMinimumSize(new Dimension((view.getMaxWidth()/5)*4,(view.getMaxHeight()/10)*8));
        center.add(b);
        currScreen.add(center,2);

        currScreen.validate();


    }


}
