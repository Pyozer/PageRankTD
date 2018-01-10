package pagerank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window {
    public Window(){
        //Fenetre principale
        JFrame window= new JFrame("PageRankTD");
        window.setSize(400,400);
        //Contenu de la fenetre
        JPanel pan = new JPanel();
        //Layout principal
        pan.setLayout(new BorderLayout());//new GridLayout(1,2)

        //Header
        Panel headerP = new Panel();
        BorderLayout headerL = new BorderLayout();
        headerP.setLayout(headerL);
        //Search
        Panel searchP = new Panel();
        GridLayout searchL = new GridLayout(1,2);
        searchP.setLayout(searchL);
        searchP.setPreferredSize(new Dimension(window.getWidth(), 75));
        //Results
        Panel resultP = new Panel();
        BorderLayout resultL = new BorderLayout();
        resultP.setLayout(resultL);


        /* Add each layout to the main one */
        pan.add(headerP,BorderLayout.NORTH);
        pan.add(searchP,BorderLayout.CENTER);
        pan.add(resultP,BorderLayout.SOUTH);

        /* Header elements */
        JTextArea text = new JTextArea("Welcome to our PageRank !");
        headerP.add(text);

        /* Search elements */
        JTextField search = new JTextField("");
        JButton send = new JButton("Send");
        send.setSize(30,30);
        pan.setSize(400,30);
        searchP.add(search);
        searchP.add(send);


        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(search.getText());
            }
        });

        window.add(pan);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}
