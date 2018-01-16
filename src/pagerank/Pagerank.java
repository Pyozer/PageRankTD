package pagerank;

import java.util.ArrayList;
import java.util.List;

public class Pagerank {

    public static void main(String[] args) {
        int i = 0;
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

        List<Page> listePage = new ArrayList<>(List.of(page0, page1, page2, page3, page4, page5, page6, page7, page8, page9, page10, page11, page12, page13));

        int taille = 14;
        Matrice mat = new Matrice(listePage);
        mat.display();

        System.out.println("Matrice stochastique ? " + mat.isStochastique());

        List<Page> listePageAlgo1 = RankBasic.rank(listePage, mat);
        List<Page> listePageAlgo2 = RankWeighted.rank(listePage, mat);

        Window window = new Window(listePageAlgo2);
    }
}
