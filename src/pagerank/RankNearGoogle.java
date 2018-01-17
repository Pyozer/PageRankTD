package pagerank;

public class RankNearGoogle {


    public static PageList rank(PageList liste, Matrice graphe, double c) {
        // 1/c est le nombre moyen de pages visitées
        //c est la probabilité d'arriver au hazard sur une page du réseau
        for(Page p: liste){
            p.setImportance(1000*c/liste.size());
        }

        for (Page j : liste) {
            for(Page i :j.getPagesOut()){
                i.setImportance(i.getImportance()+(1-c)/j.getPagesOut().size()*j.getImportance());
            }
        }

        //On trie la liste par ordre d'importance
        liste.sort(new PageComparator());
        return liste;
    }

}
