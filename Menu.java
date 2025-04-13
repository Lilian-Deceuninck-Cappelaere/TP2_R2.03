import MG2D.*;
import MG2D.geometrie.*;
import java.awt.Font;

class Menu {
    ///// methode ///// 
    public static boolean choisir(){
        Fenetre fenetre = new Fenetre("Choix du mode de jeu", 600, 600);
        Clavier clavier = fenetre.getClavier();
        
        Texture fond = new Texture("images/fondMenu.png", new Point(0, 0), 600, 600);

        Texte titre = new Texte(Couleur.BLANC, new String("Pssss, tu veut cheat?"), new Font("Calibri", Font.TYPE1_FONT, 50), new Point(300, 500));
        Texte cheatOui = new Texte(Couleur.ROUGE, new String("OUI (press O)"), new Font("Impact", Font.TYPE1_FONT, 30), new Point(150, 150));
        Texte cheatNon = new Texte(Couleur.ROUGE, new String("NON (press N)"), new Font("Impact", Font.TYPE1_FONT, 30), new Point(450, 150));

        fenetre.ajouter(fond);
        fenetre.ajouter(titre);
        fenetre.ajouter(cheatOui); 
        fenetre.ajouter(cheatNon); 

        fenetre.rafraichir(); 

        boolean statusO = false; 
        boolean statusN = false; 
        boolean fini = true; 
        
        while (fini){ 
            // vérifie tout les 0.1 seconde : 
            try {
                Thread.sleep(100); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            statusO = clavier.getOEnfoncee();
            statusN = clavier.getNEnfoncee(); 

            if (statusO == true){ //triche 
                fini = false; 
                fenetre.fermer(); 
                return true; 
            }

            if (statusN == true){ //pas de triche
                fini = false; 
                fenetre.fermer(); 
                return false; 
            }
        }
    
        return false; // par défaut
    }
}


// class Test{
//     public static void main(String[] args) {
//         System.out.println("résultat : " + Menu.choisir());
//         System.out.println("fin"); 
//     }
// }