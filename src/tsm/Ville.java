package tsm;

/**
 * La classe Ville sert � donn� les informations relatives � une ville (nom,coordonn�es)
 * Chaque ville est contenu dans une liste formant ainsi la classe {@link Carte} 
 * @see Carte
 * @author Baptiste & Nathanael
 * @version 2.0
 */
public class Ville {
        
        /**
        * Le nom de la ville
        */
        private String nom;
        
        /**
         * La coordonn�e de la ville sur l'axe x
         */
        private double x;
        
        /**
         * La coordonn�e de la ville sur l'axe y
         */
        private double y;
        
        
        /**
         * Le constructeur de ville cr�er une ville � partir de son nom, et sa position
         * @param nom
         *                         Nom de la ville
         * @param x
         *                         Position de la ville sur l'axe x
         * @param y
         *                         Position de la ville sur l'axe y
         */
        public Ville(String nom, double x, double y){
                this.nom = nom;
                this.x = x;
                this.y = y;
        }
        
        /**
         * M�thode qui retourne le nom d'une ville
         */
        public String getNom() {
                return nom;
        }
        
        /**
         * M�thode qui attribue un nom � une ville
         */
        public void setNom(String nom) {
                this.nom = nom;
        }
        
        /**
         * M�thode qui retourne la position d'une ville sur l'axe x
         */
        public double getX() {
                return x;
        }
        
        /**
         * M�thode qui attribue une position sur l'axe x � une ville
         */
        public void setX(double x) {
                this.x = x;
        }
        
        
        /**
         * M�thode qui retourne la position d'une ville sur l'axe y
         */
        public double getY() {
                return y;
        }
        
        /**
         * M�thode qui attribue une position sur l'axe y � une ville
         */
        public void setY(double y) {
                this.y = y;
        }
        
        // Je crois que cette fonction ne sert plus � rien, supprime la si c'est bien le cas !
        public String toString(){
                return nom + ", position : " + Double.toString(x) + " , " + Double.toString(y) + "\n";
        }
}