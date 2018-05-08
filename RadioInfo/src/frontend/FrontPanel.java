package frontend;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * @author Tommie Lindberg (c15tlg@cs.umu.se)
 * @version 09/04/2018.
 */
public class FrontPanel extends javax.swing.JPanel {
    //private JPanel panel;
    private int numChannels;
    private JScrollPane scroll;
    private JPanel panel;
    private JPanel background;
    private JPanel container;
    private ArrayList<JButton> buttonList;
    private String name;
    private ImageIcon image;
    private Dimension buttonSize;

    public FrontPanel(){
        this.setLayout(new GridLayout(0,1));

        panel = new JPanel();
        panel.setLayout(new GridLayout(5,1));
        //panel.setLayout(new GridLayout(0,5));
        background = new JPanel();
        background.setBackground(Color.BLACK);
        buttonList = new ArrayList<JButton>();

        //Kan behöva en button array [] men varje plats en button, men testa o se om de funkar.
        for(int i = 0; i < 55; i++){
            JButton newButton = new JButton("hej");
            newButton.setSize(new Dimension(400,400));
            newButton.setPreferredSize(new Dimension(150,200));
            //newButton.setIcon(getImage());
            //newButton.setSize(getButtonSize());
            newButton.setToolTipText("hers a tip\n");
            buttonList.add(newButton);
        }
        for (JButton aButtonList : buttonList) {
            panel.add(aButtonList);
        }
        container = new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));
        container.add(panel);
        background.add(container);
        scroll = new JScrollPane(background,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.add(scroll);
    }
    public void setNumChannels(int numChannels){
        this.numChannels=numChannels;
    }
    private int getNumChannels(){
        return numChannels;
    }
    public  void setName(String name){
        this.name = name;
    }

    private String getButtonName(){
        return name;
    }
    public void setImage(ImageIcon image){
        this.image=image;
    }
    private ImageIcon getImage(){
        return image;
    }
    private void setButtonSize(ImageIcon image){
        this.buttonSize = new Dimension(image.getIconWidth()+25,image.getIconHeight()+25);
    }
    private Dimension getButtonSize(){
        return buttonSize;
    }
    //Add action for every button
    public void addButtonListener(ActionListener listnerer){
        for(JButton button: buttonList){
            button.addActionListener(listnerer);
        }
    }
}
