package pagerank;

import java.util.List;

/**
 * Created by Leo on 12/12/2017.
 */
public class Matrice {

    private final static int TAILLE = 10;

    //attributs
    private double matrice[][];
    private int taille;

    //Constructeurs
    public Matrice() {
        this(TAILLE);
    }

    public Matrice(PageList listePages) {
        this(listePages.getMaxId() + 1);
        generateFromPageList(listePages);
    }

    public Matrice(int taille) {
        this.taille = taille;
        matrice = new double[taille][taille];
    }

    private void generateFromPageList(PageList listePages) {
        for(Page page : listePages) {
            for(Page pageIn : page.getPagesIn()) {
                double value = 1.0f / (double) page.getPagesIn().size();
                System.out.println("PAGE IN: " + pageIn.getId() + "\nPAGE: " + page.getId());
                fillCase(pageIn.getId(), page.getId(), value);
            }
        }
    }

    //Getters et setters
    public double[][] getMatrice() {
        return matrice;
    }

    public void setMatrice(double[][] tab) {
        this.matrice = tab;
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    /**
     * fonction qui permet de remplir simplement les cases de l'attribut tab
     *
     * @param col   Colonne
     * @param line  Ligne
     * @param value Valeur
     */
    public void fillCase(int line, int col, double value) {
        matrice[line][col] = value;
    }

    public double getCaseValue(int line, int col) {
        return matrice[line][col];
    }

    public double getNbLinks(int ligne) {
        int result = 0;
        for (int col = 0; col < taille; col++) {
            if (getCaseValue(ligne, col) > 0) {
                result += 1;
            }
        }
        return result;
    }

    public double getWeight(int ligne) {
        double result = 0.0f;
        for (int col = 0; col < taille; col++) {
            if (getCaseValue(ligne, col) > 0) {
                result += getCaseValue(ligne, col);
            }
        }
        return result;
    }

    public boolean isStochastique() {
        for (int col = 0; col < taille; col++) { // Pour chaque colonne
            double totalCol = 0.0f;

            for (int line = 0; line < taille; line++) { // Pour chaques valeurs dans la colonne
                totalCol += getCaseValue(line, col); // Emplacement (j, i)
            }

            totalCol = precisionRound(totalCol, 3);

            if (totalCol != 1.0f && totalCol != 0.0f) { // Si le total est supérieur à 0 et non égal à 1
                return false;
            }
        }
        return true;
    }


    /**
     * demande l'afficage de la matrice dans la console
     */

    public void display() {
        System.out.println(this.toString());
    }


    /**
     * @return la matrice dans un format lisible
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int line = 0; line < taille; line++) {
            for (int col = 0; col < taille; col++) {
                result.append(" ").append(String.format( "%.3f", precisionRound(getCaseValue(line, col)))).append(" ");
            }
            result.append("\n");
        }
        return result.toString();
    }

    private double precisionRound(double number) {
        return precisionRound(number, 3);
    }
    private double precisionRound(double number, int precision) {
        double factor = Math.pow(10, precision);
        return Math.round(number * factor) / factor;
    }
}
