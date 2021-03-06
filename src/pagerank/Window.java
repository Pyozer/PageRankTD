package pagerank;

import org.jgraph.JGraph;
import org.jgraph.graph.DefaultGraphCell;
import org.jgraph.graph.GraphConstants;
import org.jgrapht.ListenableGraph;
import org.jgrapht.ext.JGraphModelAdapter;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.ListenableDirectedGraph;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.*;
import java.util.List;

public class Window {
    private static final Color DEFAULT_BG_COLOR = Color.decode("#FAFBFF");
    private static final Dimension WINDOW_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
    private static final Dimension DEFAULT_SIZE = new Dimension(WINDOW_SIZE.width - 100, WINDOW_SIZE.height);
    //
    private JGraphModelAdapter m_jgAdapter;

    public Window(List<Page> pages) {

        Collections.reverse(pages);

        JFrame window = new JFrame("PageRankTD");
        window.setSize(WINDOW_SIZE);

        // create a JGraphT graph
        ListenableGraph g = new ListenableDirectedGraph(DefaultEdge.class);

        // create a visualization using JGraph, via an adapter
        m_jgAdapter = new JGraphModelAdapter(g);

        JGraph jgraph = new JGraph(m_jgAdapter);

        //Adjust the graph properties
        jgraph.setPreferredSize(DEFAULT_SIZE);
        Color c = DEFAULT_BG_COLOR;
        jgraph.setBackground(c);

        window.add(jgraph);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

        //Previous page added to the graph
        Page previous = null;

        int xPos = DEFAULT_SIZE.width / 2;
        int yPos = 50;

        int placeOnLine = 0;

        for (Page p : pages) {
            //System.out.println(p.getImportance());
            //If the importance is different, then start a new line
            if (previous != null && previous.getImportance() > p.getImportance()) {
                placeOnLine = 0; //Element place on the line
                xPos = DEFAULT_SIZE.width / 2;//Default position of element (center)
                yPos += 75;//Add a new line vertically
            }
            //Add the vertex to the graph
            g.addVertex(p.getId());

            //If we need to place, multiple element on the same line
            if (nbPagesSameWidth(p, pages) > 1 && placeOnLine == 0) {
                //For the first element of the line, add a place to the counter and start to the right
                placeOnLine++;
                xPos = 0;
            } else if (nbPagesSameWidth(p, pages) > 1) {
                //For the others elements of the line, add the width divided by the number of element on the line minus 1
                xPos += DEFAULT_SIZE.width / (nbPagesSameWidth(p, pages) - 1);
            }

            //Properly positioning the vertex on the graph, with the position calculated previously
            positionVertexAt(p.getId(), xPos, yPos);

            //Set the previous element
            previous = p;
        }


        for (Page p : pages) {
            //Add all the edge, representing the link of the page
            for (Page p2 : p.getPagesIn()) {
                g.addEdge(p2.getId(), p.getId());
                g.addEdge(p.getId(), p2.getId());
            }
        }
    }

    private void positionVertexAt(Object vertex, int x, int y) {
        DefaultGraphCell cell = m_jgAdapter.getVertexCell(vertex);
        Map attr = cell.getAttributes();
        Rectangle2D b = GraphConstants.getBounds(attr);

        GraphConstants.setBounds(attr, new Rectangle(x, y, (int) b.getWidth(), (int) b.getHeight()));

        Map cellAttr = new HashMap();
        cellAttr.put(cell, attr);
        m_jgAdapter.edit(cellAttr, null, null, null);
    }

    public int nbPagesSameWidth(Page page, List<Page> pages) {
        int nb = 0;
        for (Page p : pages) {
            if (p.getImportance() == page.getImportance()) {
                nb++;
            }
        }
        return nb;
    }
}
