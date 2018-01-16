package pagerank;

import java.util.ArrayList;
import java.util.List;

public class Pagerank {
    public static void main(String[] args) {
        List<Page> liste = new ArrayList<Page>();
        for (int i = 1; i < 15; i++) {
            liste.add(new Page(i));
        }
        //System.out.println(liste);
        int i = 0;
        Page page0 = new Page(++i);
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

        page0.addPageIn(page1, page2, page3, page4, page5);
        page1.addPageIn(page0, page2);
        page2.addPageIn(page0, page3);
        page3.addPageIn(page0, page4);
        page4.addPageIn(page0, page1);
        page5.addPageIn(page6, page7, page8);
        page6.addPageIn(page0, page7);
        page7.addPageIn(page5);
        page8.addPageIn(page7, page9);
        page9.addPageIn(page5, page10, page11, page12, page13);
        page10.addPageIn(page9, page11);
        page11.addPageIn(page9, page12);
        page12.addPageIn(page9, page13);
        page13.addPageIn(page9, page10);

        page0.addPageOut(page1, page2, page3, page4, page6);
        page1.addPageOut(page0, page4);
        page2.addPageOut(page0, page1);
        page3.addPageOut(page0, page2);
        page4.addPageOut(page0, page3);
        page5.addPageOut(page0, page7, page9);
        page6.addPageOut(page5);
        page7.addPageOut(page5, page6, page8);
        page8.addPageOut(page5);
        page9.addPageOut(page8, page10, page11, page12, page13);
        page10.addPageOut(page9, page13);
        page11.addPageOut(page9, page10);

        int taille = 14;
        Matrice mat = new Matrice(taille);

        mat.fillCase(1, 0, 1 / 5f);
        mat.fillCase(2, 0, 1 / 5f);
        mat.fillCase(3, 0, 1 / 5f);
        mat.fillCase(4, 0, 1 / 5f);
        mat.fillCase(5, 0, 1 / 5f);

        mat.fillCase(0, 1, 1 / 2f);
        mat.fillCase(2, 1, 1 / 2f);

        mat.fillCase(0, 2, 1 / 2f);
        mat.fillCase(3, 2, 1 / 2f);

        mat.fillCase(0, 3, 1 / 2f);
        mat.fillCase(4, 3, 1 / 2f);

        mat.fillCase(0, 4, 1 / 2f);
        mat.fillCase(1, 4, 1 / 2f);

        mat.fillCase(6, 5, 1/3f);//1/3
        mat.fillCase(7, 5, 1/3f);//1/3
        mat.fillCase(8, 5, 1/3f);//1/3

        mat.fillCase(0, 6, 1 / 2f);
        mat.fillCase(7, 6, 1 / 2f);

        mat.fillCase(5, 7, 1f);

        mat.fillCase(9, 8, 1 / 2f);
        mat.fillCase(7, 8, 1 / 2f);

        mat.fillCase(5, 9, 1 / 5f);
        mat.fillCase(10, 9, 1 / 5f);
        mat.fillCase(11, 9, 1 / 5f);
        mat.fillCase(12, 9, 1 / 5f);
        mat.fillCase(13, 9, 1 / 5f);

        mat.fillCase(9, 10, 1 / 2f);
        mat.fillCase(11, 10, 1 / 2f);

        mat.fillCase(9, 11, 1 / 2f);
        mat.fillCase(12, 11, 1 / 2f);

        mat.fillCase(13, 12, 1 / 2f);
        mat.fillCase(9, 12, 1 / 2f);

        mat.fillCase(9, 13, 1 / 2f);
        mat.fillCase(10, 13, 1 / 2f);

        mat.display();

        Window window = new Window(mat);

        System.out.print("Matrice stochastique ? " + mat.isStochastique());
    }
}
