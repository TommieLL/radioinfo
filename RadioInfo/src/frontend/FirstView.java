package frontend;

import javax.swing.*;
import java.awt.*;

/**
 * @author Tommie Lindberg (c15tlg@cs.umu.se)
 * @version 27/03/2018.
 */
public class FirstView{
    String title = "RadioPro";
    private JFrame frame;
    private JPanel cardpanel;
    private JPanel frontpanel;
    private JPanel programPanel;



    public FirstView(){

        frame = new JFrame(title);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1000,1000);
        frame.setLocationRelativeTo(null);

        cardpanel = new JPanel(new CardLayout());

        frontpanel = new FrontPanel();
        cardpanel.add(frontpanel);

        //programPanel = new ProgramPanel();
        //cardpanel.add(programPanel);

        frame.add(cardpanel,BorderLayout.CENTER);

        frame.setVisible(true);

    }


}
