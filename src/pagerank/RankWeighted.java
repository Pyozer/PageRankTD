package pagerank;

import java.util.List;

/**
 * Created by Leo on 10/01/2018.
 */
public class RankWeighted {
    public static List<Page> rank(List<Page> liste, Matrice graphe){
        for(int i = 0; i< liste.size()-1;i++){
            liste.get(i).setImportance(graphe.getWeight(i));
        }
        //On trie la liste par ordre d'importance
        liste.sort(new PageComparator());
        return liste;
    }
}
