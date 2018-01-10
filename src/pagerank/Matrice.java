package pagerank;

/**
 * Created by Leo on 12/12/2017.
 */
public class Matrice{

    //attributs
    private float tab[][];
    private int taille;


    //Constructeurs
    public Matrice(){
        this(10);
    }

    public Matrice(int taille){
        this.taille=taille;
        tab= new float[taille][taille];
    }

    //Getters et setters
    public float[][] getTab() {
        return tab;
    }
    public void setTab(float[][] tab) {
        this.tab = tab;
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    /**
     * fonction qui permet de remplir simplement les cases de l'attribut tab
     * @param i
     * @param j
     * @param value
     */
    public void fillCase(int i, int j, float value){
        tab[i][j] = value;
    }


    public boolean isStochastique(){
        for (int j=0;j<taille;j++){//pour toutes les colonnes
            float total = 0.0f;
            for(int i=0;i<taille;i++){ //pour chaque valeur dans la colonne
                total += tab[i][j];
            }
            if(total!=1.0f){
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
     *
     * @return la matrice dans un format lisible
     */
    @Override
    public String toString() {
        String resul="";
        for(int i =0; i<taille;i++){
            resul+="{";
            for(int j =0;j<taille;j++){
                resul+=" "+tab[i][j]+" ";
            }
            resul+="}\n";
        }
        return resul;
    }
}
