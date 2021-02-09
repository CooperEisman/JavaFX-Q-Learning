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

    public FrontendController() {
        view = new View();
        currScreen = new JPanel();

        JButton[] buttons = new JButton[100];
        GridLayout g = new GridLayout(9,9);
        g.setHgap(1);
        g.setVgap(1);
        g.minimumLayoutSize(p);
        p.setLayout(g);

        for(int x = 0; x < buttons.length; x++) {
            buttons[x] = new JButton("B: " + x);
            p.add(buttons[x],x);
        }


        v.configureViewPort(p);
    }

    public void loadScreen() {

    }


}
