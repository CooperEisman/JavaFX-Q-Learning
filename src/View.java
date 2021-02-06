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

    public View() {
        //Initializes Views
        initViews();

        //Sets up the ViewPort
        viewPort = new JFrame("HOI4 Mod Maker - By Cooper Eisman", gConfig);
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



    /*
        Runtime runtime = Runtime.getRuntime();

        JPanel mainMenu = new JPanel();
        JButton send = new JButton("Send");

        mainMenu.add(send);
        mainMenu.setSize(200,200);

        viewPort = new JFrame();
        viewPort.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewPort.setSize(400,400);

        viewPort.setVisible(true);


        JPanel p2 = new JPanel();
        JButton re = new JButton("Recieve");
        p2.add(re);
        viewPort.add(mainMenu,0);
        viewPort.add(p2,1);
        viewPort.setVisible(true);


        This is for messing with runtimes
        try {
            synchronized(Main.main) {
                Main.main.wait(1000);
            }
        } catch (InterruptedException e) {
            System.exit(0);
        }
        */
}
