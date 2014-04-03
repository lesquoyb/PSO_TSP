package tsm;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import ChartDirector.ChartViewer;
/**
 * La classe Panneau est le coeur de l'interface graphique, c'est elle qui contient tout les élement (boutons, champs, graphique ...) visible par l'utilisateur
 * @see Graphique
 * @author Baptiste & Nathanaël
 * @version 2.0
 */
public class Panneau extends JPanel {
        
	    /**
	     * Le champ contenant le nombre d'itérations renseigné par l'utilisateur
	     */
        private JFormattedTextField iteration = new JFormattedTextField(NumberFormat.getIntegerInstance());
        
	    /**
	     * Le champ contenant le nombre de particules renseigné par l'utilisateur
	     */
        private JFormattedTextField particule = new JFormattedTextField(NumberFormat.getIntegerInstance());

        
        /**
         * Les différents labels de l'affichage graphique
         */
        private JLabel lab_iteration = new JLabel("entrez un nombre d'itérations:");
        private JLabel lab_particule = new JLabel("entrez un nombre de particules:");
        private JLabel lab_vide = new JLabel("");
        private JLabel lab_menu = new JLabel("choisissez une des villes:");
        
        /**
         *  Le menu déroulant contenant la liste des différentes cartes disponnibles
         */
        private ArrayList<String> contenu_menu = Fichier.Lister_Carte();
        
        /**
         * Le menu déroulant proposant les différentes cartes
         */
        private JComboBox menu_deroulant ;
        
        /**
         *Le outon qui fait démarer le programme 
         */
        private JButton commencer;
        
         /**
	     * L'élément dans lequel le graphique et ses légendes seront contenus
	     */
        private ChartViewer viewer = new ChartViewer();
        
        /**
         * Le graphique
         * @see Graphique
         */
        private Graphique graphique;
        
         /**
     * variable contenant la valeur de la borne inférieur
     */        
        private double borne_inferieur;
        
    /**
     * variable contenant la valeur de la borne supérieur
     */
        private double borne_superieur;
        
        
    /**
     * Constructeur de Panneau
     * <p>
     *     On initialise toutes les variables, et on positionne les objets dans le panneau
     * </p>
     * @see Panneau.BoutonListener
     */        
                public Panneau(){
                        this.setLayout(new BorderLayout());
                        graphique = new Graphique(viewer );
                        commencer  = new JButton("Commencer");
                        commencer.addActionListener(new BoutonListener());
                        
                        /**
                         * <p>
                         * On initialise le menu déroulant à l'aide de la liste des {@link Carte}s disponibles dans le {@link Fichier} et accessible via la méthode {@link Fichier#Lister_Carte()}
                         * </p>
                         */
                        menu_deroulant = new JComboBox();
                        contenu_menu = Fichier.Lister_Carte();
                        int i;
                        for (i=0;i<contenu_menu.size();i++){
                                menu_deroulant.addItem(contenu_menu.get(i));
                        }
                        menu_deroulant.addActionListener( new ComboBoxListener());
                        JPanel haut = new JPanel();                                        
                        haut.setLayout(new GridLayout(2,2));
                        haut.add(lab_iteration);
                        haut.add(iteration);
                        haut.add(lab_particule);
                        haut.add(particule);
                        haut.add(lab_menu);
                        haut.add(menu_deroulant);
                        haut.add(lab_vide);
                        haut.add(commencer);

                        
                        
                        JPanel conteneur_haut = new JPanel();
                        conteneur_haut.setLayout(new BorderLayout());
                        conteneur_haut.add(haut, BorderLayout.CENTER);
                        
                        this.add(conteneur_haut,BorderLayout.NORTH);//on ajoute "conteneur_haut" en haut du panneau                
                        this.add(graphique.get_viewer(),BorderLayout.CENTER);
                        
                }
                
	                
	             /**
		         * Classe implémentant ActionListener.
		         * <p> 
		         * Elle permet d'écouter le bouton {@link Panneau#commencer} .<br/>
		         * C'est dans cette classe que l'algorithme <b>PSO</b> est lancé.
		         * </p>
		         * @author Baptiste
		         *
		         */
                class BoutonListener implements ActionListener{
                	
                        
			            /**
			             * Méthode se déclenchant lors d'un clic sur le bouton {@link Panneau#commencer}
			             * <p>
			             * Cette méthode déclenche l'algorithme <b>PSO</b>.<br/>
			             * Elle récupère les valeurs dans les champs et les affecte à  un essaim et un graphique.
			             * Puis elle affecte l'essaim à un graphique.
			             * Et enfin elle démarre les itérations à l'aide de {@link Graphique#setE(Essaim)}.
			             * </p>
			             * @see Essaim
			             * @see Graphique
			             * 
			             */
                	@Override
                        public void actionPerformed(ActionEvent action) {
                                Essaim e = new Essaim();
                                graphique = new Graphique(viewer);
                                
                        // on récupère les valeurs entrées
                                String s = particule.getText().replaceAll("\\p{Zs}", "") ;
                                int i = Integer.parseInt(s);
                                e.setNb_particules(i);                                
                                // on récupère la carte choisie
                                String nom_carte = menu_deroulant.getSelectedItem().toString();
                                Carte carte = Fichier.Rechercher_Carte(nom_carte);
                                e.setCarte(carte);
                                //on récupère le nombre d'itération
                                s = iteration.getText().replaceAll("\\p{Zs}", "");// on supprime les espaces
                                i = Integer.parseInt(s);
                                
                                //puis on démarre les itérations
                                graphique.set_iteration(i);
                                graphique.setE(e); 
                                graphique.demarrer();// les itération se font ici
                        }
                }
                
                
                /**
		         * Classe implémentant ActionListener.
                 * <p>
                 * Elle permet d'écouter le menu déroulant {@link Panneau#menu_deroulant} .<br/>
                 * C'est dans cette classe que l'on change l'essaim étudié.
                 * </p>
                 * @see Graphique#e
                 * @author Baptiste
                 *
                 */
                class ComboBoxListener implements ActionListener{

                	public ComboBoxListener(){
						String chaine_carte =(String)menu_deroulant.getSelectedItem();
						Carte carte = Fichier.Rechercher_Carte(chaine_carte);
						graphique.getE().setCarte(carte);
						graphique.setE(graphique.getE()); 	//afin de d'initialiser les tableaux de positions et de noms
						graphique.mise_a_jour();
						graphique.dessiner_graphique();
                	}
                	
                	
                	/**
                	 *Déclenché lors d'un changement de selection
                	 *
                	 */
                	@Override
					public void actionPerformed(ActionEvent arg0) {
						String chaine_carte =(String)menu_deroulant.getSelectedItem();
						Carte carte = Fichier.Rechercher_Carte(chaine_carte);
						graphique.getE().setCarte(carte);
						graphique.setE(graphique.getE()); 	//afin de d'initialiser les tableaux de positions et de noms
						graphique.mise_a_jour();
						graphique.dessiner_graphique();
					}
                	
                }
                
                public double getBorne_inferieur() {
                        return borne_inferieur;
                }
                public Graphique getGraphique(){
                        return graphique;
                }
                
                public void setBorne_inferieur(double borne_inferieur) {
                        this.borne_inferieur = borne_inferieur;
                }
                public double getBorne_superieur() {
                        return borne_superieur;
                }
                public void setBorne_superieur(double borne_superieur) {
                        this.borne_superieur = borne_superieur;
                }
                public ChartViewer getViewer() {
                        return viewer;
                }
                public void setViewer(ChartViewer viewer) {
                        this.viewer = viewer;
                }
}
