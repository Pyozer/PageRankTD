package pagerank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window {
    public Window(){
        JFrame window= new JFrame("PageRankTD");
        JPanel pan = new JPanel();
        pan.setLayout(new GridLayout(1,2));
        JTextField search = new JTextField("");
        JTextArea text = new JTextArea("Welcome to our PageRank !");
        JButton send = new JButton("Send");
        send.setSize(30,30);

        pan.setSize(400,30);

        pan.add(search);
        pan.add(send);

        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(search.getText());
            }
        });


        search.setBounds(50,100, 400,30);
        window.add(pan);
        window.setSize(400,400);
        window.setVisible(true);
    }
}
