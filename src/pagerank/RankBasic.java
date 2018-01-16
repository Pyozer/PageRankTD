package pagerank;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Leo on 10/01/2018.
 */
public class RankBasic {

    public List<Page> rank(List<Page> liste, Matrice graphe){

        //On associe l'importance à chaque page de la liste passée en paramètres
        for(int i = 0; i< liste.size()-1;i++){
            liste.get(i).setImportance(graphe.getNbLinks(i));
        }

        //On trie la liste par ordre d'importance
        liste.sort(new PageComparator());
        return liste;
    }


}
