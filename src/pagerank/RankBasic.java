package pagerank;

/**
 * Created by Leo on 10/01/2018.
 */
public class RankBasic {

    public static PageList rank(PageList liste, Matrice graphe) {
        //On associe l'importance à chaque page de la liste passée en paramètres
        for (Page page : liste) {
            page.setImportance(page.getPagesIn().size());
        }

        //On trie la liste par ordre d'importance
        liste.sort(new PageComparator());
        return liste;
    }
}