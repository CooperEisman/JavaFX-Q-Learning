import javax.swing.*;
import java.awt.*;

public class View {
    JFrame viewPort;

    public View() {
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


        /* This is for messing with runtimes
        try {
            synchronized(Main.main) {
                Main.main.wait(1000);
            }
        } catch (InterruptedException e) {
            System.exit(0);
        }
        */



    }
}
