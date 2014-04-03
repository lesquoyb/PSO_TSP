package tsm;

/**
 * La classe Ville sert à donné les informations relatives à une ville (nom,coordonnées)
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
         * La coordonnée de la ville sur l'axe x
         */
        private double x;
        
        /**
         * La coordonnée de la ville sur l'axe y
         */
        private double y;
        
        
        /**
         * Le constructeur de ville créer une ville à partir de son nom, et sa position
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
         * Méthode qui retourne le nom d'une ville
         */
        public String getNom() {
                return nom;
        }
        
        /**
         * Méthode qui attribue un nom à une ville
         */
        public void setNom(String nom) {
                this.nom = nom;
        }
        
        /**
         * Méthode qui retourne la position d'une ville sur l'axe x
         */
        public double getX() {
                return x;
        }
        
        /**
         * Méthode qui attribue une position sur l'axe x à une ville
         */
        public void setX(double x) {
                this.x = x;
        }
        
        
        /**
         * Méthode qui retourne la position d'une ville sur l'axe y
         */
        public double getY() {
                return y;
        }
        
        /**
         * Méthode qui attribue une position sur l'axe y à une ville
         */
        public void setY(double y) {
                this.y = y;
        }
        
        // Je crois que cette fonction ne sert plus à rien, supprime la si c'est bien le cas !
        public String toString(){
                return nom + ", position : " + Double.toString(x) + " , " + Double.toString(y) + "\n";
        }
}