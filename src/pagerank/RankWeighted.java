package pagerank;

/**
 * Created by Leo on 10/01/2018.
 */
public class RankWeighted {

    public static PageList rank(PageList liste, Matrice graphe) {
        for (Page page : liste) {
            page.setImportance(page.getPagesIn().getWeight());
        }
        //On trie la liste par ordre d'importance
        liste.sort(new PageComparator());
        return liste;
    }
}
