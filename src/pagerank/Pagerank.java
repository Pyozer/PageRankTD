package pagerank;

public class Pagerank {
    public static void main(String[] args){
        Window window = new Window();
        //waw
        int taille =10;
       Matrice mat = new Matrice(taille);
       mat.display();
        for(int i =0; i<taille;i++){
            mat.fillCase(i,0,1.0f);
        }
       System.out.print(mat.isStochastique());
    }
}
