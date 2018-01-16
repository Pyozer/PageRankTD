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
