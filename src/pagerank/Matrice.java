package pagerank;

/**
 * Created by Leo on 12/12/2017.
 */
public class Matrice{

    private float tab[][];

    private int taille;

    public Matrice(){
        this(10);
    }
    public Matrice(int taille){
        this.taille=taille;
        tab= new float[taille][taille];
    }

    public void fill(int i, int j, float value){
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

}
