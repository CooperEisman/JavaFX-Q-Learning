/*
Code by Cooper Eisman
Created: 02/05/2021
Last Modified: 02/05/2021
*/

import javax.swing.*;
import java.awt.*;

public class View {
    //Frame Instance. Populated by View();
    protected JFrame viewPort;
    protected GraphicsConfiguration gConfig;

    //Find Bounds Instance. Populated by initViews()
    protected Rectangle virtualBounds;
    protected GraphicsEnvironment ge;
    protected GraphicsDevice[] gs;
    protected GraphicsConfiguration[] gc;

    //Constructor
    public View() {
        //Initializes Views
        initViews();

        //Sets up the ViewPort
        viewPort = new JFrame("HOI4 Mod Maker - By Cooper Eisman", gConfig);
        viewPort.setMaximizedBounds(virtualBounds);
        viewPort.setSize(gc[0].getBounds().getSize());
        viewPort.setVisible(true);
    }

    //Calculates the Bounds of the Device, and sets the instance to match;
    private void initViews() {
        //Set Variables
        virtualBounds = new Rectangle();
        ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        gs = ge.getScreenDevices();

        //Calculates the size of every view into virtualBounds
        for (int j = 0; j < gs.length; j++) {
            GraphicsDevice gd = gs[j];
            gc = gd.getConfigurations();

            for (int i=0; i < gc.length; i++) {
                virtualBounds = virtualBounds.union(gc[i].getBounds());
            }
        }
    }

    //Returns the Max Height of the Frame
    public int getMaxHeight() {
        return virtualBounds.getSize().height;
    }

    //Returns the max width of the Frame
    public int getMaxWidth() {
        return virtualBounds.getSize().width;
    }
}
