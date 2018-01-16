package pagerank;

/**
 * Created by Leo on 12/12/2017.
 */
public class Matrice {

    private final static int TAILLE = 10;

    //attributs
    private float matrice[][];
    private int taille;

    //Constructeurs
    public Matrice() {
        this(TAILLE);
    }

    public Matrice(int taille) {
        this.taille = taille;
        matrice = new float[taille][taille];
    }

    //Getters et setters
    public float[][] getMatrice() {
        return matrice;
    }

    public void setMatrice(float[][] tab) {
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
     * @param col Colonne
     * @param line Ligne
     * @param value Valeur
     */
    public void fillCase(int line, int col, float value) {
        matrice[line][col] = value;
    }

    public float getNbLinks(int ligne) {
        int result = 0;
        for (int col = 0;col < taille;col++) {
            if(matrice[ligne][col] > 0) {
                result += 1;
            }
        }
        return result;
    }

    public float getWeight(int ligne) {
        int result = 0;
        for (int col = 0;col < taille;col++) {
            if(matrice[ligne][col] > 0) {
                result += matrice[ligne][col];
            }
        }
        return result;
    }

    public boolean isStochastique() {
        for (int line = 0; line < taille; line++) { // Pour chaque colonne
            float totalCol = 0.0f;

            for (int col = 0; col < taille; col++) { // Pour chaques valeurs dans la colonne
                totalCol += matrice[line][col]; // Emplacement (j, i)
            }

            if (totalCol != 1.0f) { // Si le total (ligne ou colonne) est supérieur à 0 et non égal à 1
                System.out.println(totalCol);
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
                result.append(" ").append(matrice[col][line]).append(" ");
            }
            result.append("\n");
        }
        return result.toString();
    }
}
