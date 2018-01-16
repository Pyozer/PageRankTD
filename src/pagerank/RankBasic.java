package pagerank;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Leo on 10/01/2018.
 */
public class RankBasic {

    public static PageList rank(PageList liste, Matrice graphe) {
        //On associe l'importance à chaque page de la liste passée en paramètres
        for (int i = 0; i < liste.size() - 1; i++) {
            System.out.println("Importance: " + graphe.getNbLinks(i));
            liste.get(i).setImportance(graphe.getNbLinks(i));
        }

        //On trie la liste par ordre d'importance
        liste.sort(new PageComparator());
        return liste;
    }


}
