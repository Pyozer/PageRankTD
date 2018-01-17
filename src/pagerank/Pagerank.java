package pagerank;

import org.graphstream.graph.ElementNotFoundException;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.MultiGraph;

public class Pagerank {

    private static final double C = 0.02f;
    private PageList listePage;

    public void initPages() throws ElementNotFoundException {
        System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");

        int i = 0;
        // Création des pages
        Page page0 = new Page(i);
        Page page1 = new Page(++i);
        Page page2 = new Page(++i);
        Page page3 = new Page(++i);
        Page page4 = new Page(++i);
        Page page5 = new Page(++i);
        Page page6 = new Page(++i);
        Page page7 = new Page(++i);
        Page page8 = new Page(++i);
        Page page9 = new Page(++i);
        Page page10 = new Page(++i);
        Page page11 = new Page(++i);
        Page page12 = new Page(++i);
        Page page13 = new Page(++i);
        // Création des liens entre page
        page0.setPagesOut(page1, page2, page3, page4, page6);
        page1.setPagesOut(page0, page4);
        page2.setPagesOut(page0, page1);
        page3.setPagesOut(page0, page2);
        page4.setPagesOut(page0, page3);
        page5.setPagesOut(page0, page7, page9);
        page6.setPagesOut(page5);
        page7.setPagesOut(page5, page6, page8);
        page8.setPagesOut(page5);
        page9.setPagesOut(page8, page10, page11, page12, page13);
        page10.setPagesOut(page9, page13);
        page11.setPagesOut(page9, page10);
        page12.setPagesOut(page9, page11);
        page13.setPagesOut(page9, page12);

        listePage = new PageList(page0, page1, page2, page3, page4, page5, page6, page7, page8, page9, page10, page11, page12, page13);

        Matrice mat = new Matrice(listePage);
        mat.display();

        System.out.println("Matrice stochastique ? " + mat.isStochastique());

        //Window window = new Window(listePageAlgo2);
    }

    public void startGrapheBasic() {
        PageList listePageAlgo = RankBasic.rank(listePage, null);
        showGraphe(listePageAlgo);
    }
    public void startGrapheWeighted() {
        PageList listePageAlgo = RankWeighted.rank(listePage, null);
        showGraphe(listePageAlgo);
    }
    public void startGrapheNearGoogle() {
        PageList listePageAlgo = RankNearGoogle.rank(listePage, null, C);
        showGraphe(listePageAlgo);
    }

    public void showGraphe(PageList pageList) {
        // Création du graphe
        Graph graph = new MultiGraph("Graphe");
        graph.addAttribute("ui.antialias", true);
        graph.addAttribute("ui.stylesheet", "node {" +
                "fill-color: red;" +
                "size-mode: dyn-size;" +
                "text-alignment: above;" +
                "text-background-mode: plain;" +
                "text-background-color: #33333388;" +
                "text-padding: 2px;" +
                "}" +
                "edge {" +
                "arrow-size: 5px;" +
                "arrow-shape: arrow;" +
                "}");

        graph.setStrict(false);
        graph.setAutoCreate(true);

        for (Page page : pageList) {
            for (Page pageOut : page.getPagesOut()) {
                String idNode = page.getId() + ":" + pageOut.getId();
                String nodeOrigin = String.valueOf(page.getId());
                String nodeDest = String.valueOf(pageOut.getId());

                graph.addEdge(idNode, nodeOrigin, nodeDest, true);

                Node node = graph.getNode(nodeOrigin);
                node.addAttribute("ui.size", Math.round((double) pageList.size() / ((double) pageList.size() / page.getImportance())) * 20);
                node.addAttribute("ui.label", "Page " + nodeOrigin + " (Rank " + page.getImportance() + ")");
            }

        }

        graph.display();
    }
}
