/*
Code by Cooper Eisman
Created: 02/05/2021
Last Modified: 02/05/2021
*/

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class View {
    //Frame Instance Vars
    protected JFrame viewPort;
    protected GraphicsConfiguration gConfig;
    protected GraphicsEnvironment ge;
    protected GraphicsDevice[] gd;

    //Constructor
    public View() {
        //Finds all the Views and Populates Instance
        ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        gd = ge.getScreenDevices();
        gConfig = ge.getDefaultScreenDevice().getConfigurations()[0];


        //Sets up the ViewPort
        viewPort = new JFrame("QLearning Design - By Cooper Eisman");

        //Sets Size and Behaviour
        viewPort.setExtendedState(JFrame.MAXIMIZED_BOTH);
        viewPort.setSize(gConfig.getBounds().getSize());
        viewPort.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Set ViewPort Bounds
        viewPort.setMinimumSize(new Dimension((int)(gConfig.getBounds().getX()/4), (int)(gConfig.getBounds().getX()/4)));
        viewPort.setMaximizedBounds(gConfig.getBounds());
        viewPort.setMaximumSize(gConfig.getBounds().getSize());

        //Adds listener to avoid overstepping view bounds
        addEventListener();

        //Add Menu Bar and Make Visible
        addMenu();
        viewPort.setVisible(true);
    }

    //Sets up Movement so that the App will not Exceed maximum frame size
    protected void addEventListener() {
        //Add a Listener for if Properties Change
        PropertyChangeListener viewListener = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                //Update Sizes whenever position changes
                gConfig = viewPort.getGraphicsConfiguration();

                viewPort.setMaximizedBounds(gConfig.getBounds());
                viewPort.setMaximumSize(gConfig.getBounds().getSize());

                //ensures no window escapes minimum size
                if (viewPort.getOwnedWindows().length != 0) {
                    viewPort.getOwnedWindows()[0].setMinimumSize(new Dimension((int)(gConfig.getBounds().getX()/4), (int)(gConfig.getBounds().getX()/4)));
                }
            }
        };


        viewPort.addPropertyChangeListener(viewListener);
    }

    //Returns the Max Height of the Frame
    public int getMaxHeight() {
        return viewPort.getMaximumSize().height;
    }

    //Returns the max width of the Frame
    public int getMaxWidth() {
        return viewPort.getMaximumSize().width;
    }

    public void configureViewPort(JPanel view) {

        viewPort.add(view);

        viewPort.setVisible(true);
    }

    private void addMenu() {
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("FILE");
        JMenu m2 = new JMenu("Help");
        mb.add(m1);
        mb.add(m2);
        JMenuItem m11 = new JMenuItem("Open");
        JMenuItem m22 = new JMenuItem("Save as");
        m1.add(m11);
        m1.add(m22);
        viewPort.getContentPane().add(BorderLayout.NORTH, mb);
    }
}
