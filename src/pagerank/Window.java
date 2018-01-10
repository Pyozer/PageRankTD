package pagerank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window {
    public Window(){
        //Fenetre principale
        JFrame window = new JFrame("PageRankTD");
        window.setSize(400,400);
        //Contenu de la fenetre
        JPanel pan = new JPanel();
        //Layout principal
        pan.setLayout(new GridLayout(3,1));

        //Header
        Panel headerP = new Panel();
        BorderLayout headerL = new BorderLayout();
        headerP.setLayout(headerL);
        //Search
        Panel searchP = new Panel();
        searchP.setMaximumSize(new Dimension(50,50));
        GridLayout searchL = new GridLayout(1,2);
        searchP.setLayout(searchL);
        searchP.setPreferredSize(new Dimension(window.getWidth(), 75));
        //Results
        JScrollPane resultP = new JScrollPane();
        ScrollPaneLayout resultL = new ScrollPaneLayout();
        resultP.setLayout(resultL);

        /* Header elements */
        JTextArea text = new JTextArea("Welcome to our PageRank !");
        text.setEditable(false);
        headerP.add(text);

        /* Search elements */
        JTextField search = new JTextField("");
        JButton send = new JButton("Send");
//        send.setSize(30,30);
//        pan.setSize(400,30);
        searchP.add(search);
        searchP.add(send);


        /* Results elements */
        DefaultListModel<String> l1 = new DefaultListModel<>();//Empty list
        JList<String> list = new JList<>(l1);
        list.setBounds(0,0, window.getWidth(),200);
        resultP.add(list);

        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                l1.addElement(search.getText());
                System.out.println(search.getText());
            }
        });


        /* Add each layout to the main one */
        pan.add(headerP,BorderLayout.NORTH);
        pan.add(searchP,BorderLayout.CENTER);
        pan.add(resultP,BorderLayout.SOUTH);

        window.add(pan);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}
