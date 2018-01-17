package pagerank;

import javax.swing.*;

public class Menu extends JFrame {

    public Menu() {

        Pagerank pagerank = new Pagerank();
        pagerank.initPages();

        setTitle("Page Rank");
        setSize(500, 400);

        // Create JButton and JPanel
        JButton buttonAlgo1 = new JButton("Algo Basic");
        buttonAlgo1.addActionListener(actionEvent -> pagerank.startGrapheBasic());
        JButton buttonAlgo2 = new JButton("Algo Weighted");
        buttonAlgo2.addActionListener(actionEvent -> pagerank.startGrapheWeighted());

        JButton buttonAlgo3 = new JButton("Algo Near Google");
        buttonAlgo3.addActionListener(actionEvent -> pagerank.startGrapheNearGoogle());

        JPanel panel = new JPanel();

        // Add button to JPanel
        panel.add(buttonAlgo1);
        panel.add(buttonAlgo2);
        panel.add(buttonAlgo3);
        // And JPanel needs to be added to the JFrame itself!
        this.getContentPane().add(panel);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Menu a = new Menu();
    }
}