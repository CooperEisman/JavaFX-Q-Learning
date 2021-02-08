/*
Code by Cooper Eisman
Created: 02/05/2021
Last Modified: 02/05/2021
*/


import javax.swing.*;

public class FrontendController {
    View view;

    public FrontendController() {
        view = new View();
    }

    private void setMainMenu() {
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("FILE");
        JMenu m2 = new JMenu("Help");
        mb.add(m1);
        mb.add(m2);
        JMenuItem m11 = new JMenuItem("Open");
        JMenuItem m22 = new JMenuItem("Save as");
        m1.add(m11);
        m1.add(m22);
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
