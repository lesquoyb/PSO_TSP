package tsm;
import java.util.ArrayList;
/**
 * <p>
 * La classe Carte sert à représente une carte via une liste de villes (eux mêmes déterminées par des coordonnées ... ).
 * Elle possède un nom qui permet de la distinguer.
 * </p>
 * @author Nathanael & Sebastien
 * @version 2.0
 */
public class Carte {
        
        /**
         * La liste des villes de la carte.
         */
        private ArrayList<Ville> liste_villes;
        
        /**
         * La liste contenant le meilleur chemin (les bonnes villes dans le bon ordre)
         */
        private ArrayList<Ville> meilleur_chemin;
        
        /**
         * Le nom de la carte.
         */
        private String nom_carte;
    
    /**
     * le nombre de villes dans la carte
     */
    private int nb_villes;
    
    /**
     * le constructeur de carte créé une carte à partir du nom, on initialise le nombre de ville à 0, les villes seront ajoutées
     * au fur et à mesure après.
     * Il est appelé dans la méthode {@link Fichier#Rechercher_Carte(String)} .
     * @param nom
     *		 Le nom de la carte.
     * @see Fichier
     */
    public Carte(String nom){
            nom_carte = nom;    
            nb_villes = 0;
            liste_villes = new ArrayList<Ville>();
            meilleur_chemin = new ArrayList<Ville>();
    }
    
    
    public ArrayList<Ville> getListe_villes() {
		return liste_villes;
	}


	public void setListe_villes(ArrayList<Ville> liste_villes) {
		this.liste_villes = liste_villes;
	}


	public ArrayList<Ville> getMeilleur_chemin() {
		return meilleur_chemin;
	}


	public void setMeilleur_chemin(ArrayList<Ville> meilleur_chemin) {
		this.meilleur_chemin = meilleur_chemin;
	}


	public String getNom_carte() {
		return nom_carte;
	}


	public void setNom_carte(String nom_carte) {
		this.nom_carte = nom_carte;
	}


	public int getNb_villes() {
		return nb_villes;
	}


	public void setNb_villes(int nb_villes) {
		this.nb_villes = nb_villes;
	}


	/**
     * Permet d'ajouter une ville à la carte. 
     * Incrémente le nombre de ville.
     * @param nom
     *                                 le nom de la ville
     * @param posx
     *                                 la position de la ville en x
     * @param posy
     *                                 la position de la ville en y
     * @see Ville
     * @see Fichier#Rechercher_Carte(String)
     */
   public void Ajout_Ville(String nom,String posx, String posy) {
           
           double x = Double.parseDouble(posx);
           double y = Double.parseDouble(posy);
           Ville test = new Ville(nom,x,y);
           liste_villes.add(test);
           nb_villes++; 
   }
   
   
   
   
   /**
    * Permet d'ajouter le meilleur chemin supposé présent dans le fichier XML
    * @param nom
    *                         nom de la ville
    * @param posx
    *                         la position de la ville en x
    * @param posy
    *                         la position de la ville en y
    */
   public void Ajout_Meilleur(String nom, String posx, String posy){
       double x = Double.parseDouble(posx);
       double y = Double.parseDouble(posy);
       Ville meilleur = new Ville(nom,x,y);
       meilleur_chemin.add(meilleur);
   }
   
   
   
   
   /**
    * @return
    *                   Le nombre de ville de la carte
    * @see Carte#nb_villes
    */
   public int getnb_ville()
   {
           return nb_villes;
   }
   
   /**
    * @param no_ville
    *                  Numéro de la ville recherché
    * @return
    *                  La ville de numéro no_ville
    */
   public Ville getville(final int no_ville)
   {
           return liste_villes.get(no_ville);
   }
}
