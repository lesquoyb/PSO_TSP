package tsm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import ChartDirector.Chart;
import ChartDirector.ChartViewer;
import ChartDirector.LineLayer;
import ChartDirector.ScatterLayer;
import ChartDirector.TextBox;
import ChartDirector.XYChart;

/**
 * <b>Graphique est la classe servant � la repr�sentation graphique de l'essaim </b>
 * <p>
 * Elle contient :
 * <ul>
 * <li> Le graphique en lui m�me o� chaque point repr�sente une ville</li>
 * <li> Les axes et leur graduation</li>
 * <li> Les l�gendes/titres et autres annotations</li>
 * </ul>
 * </p>
 * @see Essaim
 * @see Fenetre
 * @author Baptiste
 * @version 2.0
 *
 */
public class Graphique extends JFrame  {
		
		/**
		 * l'interval de temps(en ms) entre chaque mise � jour du graphique
		 */
		private int interval = 10;
		
		/**
		 * Le layer du graphique
		 * @see ChartDirector.ScatterLayer
		 */
		private ScatterLayer layer;
		/**
		 * L'�l�ment logique repr�sentant le graphique
		 */
		private XYChart chart ;

		/**
		 * le viewer de notre graphique
		 * @see ChartDirector.ChartViewer
		 */
		private ChartViewer viewer;	
		
		/**
		 * l'essaim affich�
		 * @see Essaim
		 */
		private Essaim e;					
		
		/**
		 * <p>
		 * Tableau contenant tout les chemins qui seront trac�s sur le graphique. <br/>
		 * Un chemin correspond � une particules.
		 * </p>
		 */
		private ArrayList<LineLayer> chemins_graphique;
		
		
		/**
		 * un compteur
		 * @see javax.swing.Timer
		 */
		private javax.swing.Timer timer;
		
		/**
		 * l'heure de la prochaine mise � jour du graphique
		 * @see Date
		 */
		private Date prochaineDate;	
		
		/**
		 * tableau des positions des villes en ordonn�e

		 */
		private  double[] positionX ;
		
		/**
		 * tableau des positions des villes en abscisse
		 */
	    private double[] positionY ;		
	    
	    /**
	     * tableau des noms des villes
	     */
	    private String[] nom_villes;		
	    
	    /**
	     * compteur du nombre d'it�rations r�alis�es, initialis� � 1 car le graphique est cr�� lors de la premi�re it�ration
	     */
	    private int compteur = 1;			
	    
	    /**
	     * nombre d'it�rations � r�aliser
	     */
	    private long nb_iteration;			
		
	    
	    
	    /**
	     * <p><b>Constructeur Graphique</b></p>
	     * <p>
	     * 	on cr�� un XYChart vide, on place les axes et le titre .
	     * </p>
	     * @param v
	     * 			il s'agit du viewer
	     * @see ChartDirector.ChartViewer
	     * @see ChartDirector.XYChart
	     */
		public Graphique (ChartViewer v){
			e = new Essaim();
			chart = new XYChart(1000, 500);
			prochaineDate = new Date();
			chemins_graphique = new ArrayList<LineLayer>();
			chart.setPlotArea(55, 65,900, 400, -1, -1, 0xc0c0c0, 0xc0c0c0, -1);

		        // place le titre et d�fini la police et la taille
		        chart.addLegend(50, 30, false, "Times New Roman Bold Italic", 12).setBackground(Chart.Transparent);
		        // le titre en question
		        chart.addTitle("Chemin le plus rapide passant par toutes les villes", "Times New Roman Bold Italic", 18);

		        //titre de l'axe y
		        chart.yAxis().setTitle("y", "Arial Bold Italic", 12);

		        // titre de l'axe x
		        chart.xAxis().setTitle("x", "Arial Bold Italic", 12);
		        

		        chart.xAxis().setWidth(2);
		        chart.yAxis().setWidth(2);
		        
		        viewer = new ChartViewer();
		        viewer = v;
				viewer.setChart(chart);
		}
		

		/**
		 * Fonction execut�e lorsque l'on d�marre
		 * <p>
		 * Elle d�finie permet de mettre � jour le graphique chaque fois que l'interval de temps d�fini est �coul�
		 * </p>
		 * <p>
		 * Elle est d�clench� par le timer et un fois toutes les it�ration effectu�es elle affiche une fenetre avec le meilleur r�sultat trouv� et arrete le timer
		 * </p>
		 * 
		 * @see Graphique#demarrer()
		 * @see Graphique#interval
		 * @see Graphique#mise_a_jour()
		 * 
		 */
		private void chartUpdateTimer_Tick(){
			Date maintenant = new Date();

				do{
					// on patiente 
					prochaineDate = new Date(prochaineDate.getTime() +  interval);
				}
				while(prochaineDate.before(maintenant));
				
				if (compteur < nb_iteration){
					// on effectue une mise � jour
					e.algo_PSO();
					dessiner_graphique();
					compteur++;
				}
				else {

					
					// on affiche le meilleurs r�sultat
					String chemin_parc = e.getMeilleur_trouve()[0].getNom();
					for(int i = 1 ; i <= e.getCarte().getnb_ville() ; i ++){
						chemin_parc += " - " + e.getMeilleur_trouve()[i].getNom();
					}
					String res = "La plus petite distance trouv�e est: " + String.valueOf(e.getMeilleur_dist()) + "\nObtenu en parcourant le chemin : " + chemin_parc  ;
					JOptionPane.showMessageDialog(null, res,"R�sultat obtenu",JOptionPane.INFORMATION_MESSAGE ) ;
					
					// c'est termin�, on empeche l'evenement de se redeclencer
					timer.stop();
			}
		}
		
		

		
		/**
		 * D�clenche les mise � jour du graphique
		 * <p>
		 * Cette m�thode active le timer.
		 * </p>
		 * @see Graphique#chartUpdateTimer_Tick()
		 */
		public void demarrer(){			
			
			timer = new javax.swing.Timer(interval,new ActionListener() {
						public void actionPerformed(ActionEvent evt) {chartUpdateTimer_Tick();} 
            	});
			timer.setInitialDelay(interval);
			timer.start();
		}



		/**
		 * Ajout de l'essaim au graphique
		 * <p>
		 * On met � jour l'essaim et on alloue aussi les tableaux de positions et de noms avec la taille necessaire.
		 * </p>
		 * <p>
		 * Le fait d'ajouter l'essaim au graphique d�clenchera les mises � jour de celui-ci
		 * </p>
		 * @param e
		 * @see Graphique#mise_a_jour()
		 */
		public void setE(Essaim e) {
			this.e = e;
			viewer.setChart(chart);
			positionX =  new double[e.getCarte().getnb_ville()];//chaque ville a une position en x et en y ainsi qu'un nom, on initialise donc les tableau avec la tailles necessaire
			positionY =  new double[e.getCarte().getnb_ville()];	
			nom_villes = new String[e.getCarte().getnb_ville()]; 
			dessiner_graphique();
		}

		/**
		 * <p>
		 * Dessine le meilleur chemin connu sur le graphique.
		 * </p>
		 */
		private void dessiner_meilleur_chemin(){
			int i = 0;
			int nb_villes = e.getCarte().getnb_ville();
			double[] posX = new double[nb_villes +1];
			double[] posY = new double[nb_villes +1];
				for(Ville ville_courrante : e.getCarte().getMeilleur_chemin()){
					posX[i] = ville_courrante.getX();
					posY[i] = ville_courrante.getY();
					i++;
				}

				// on fini par cr�er un chemin constitu� de ces coordonn�es
				chemins_graphique.add(chart.addLineLayer(posY, 0xff3333, "Meilleur chemin connu"));
				int derniere_pos = chemins_graphique.size() - 1;
				chemins_graphique.get(derniere_pos ).setXData(posX);
				chemins_graphique.get(derniere_pos).setLineWidth(2);
				chemins_graphique.get(derniere_pos).addCustomDataLabel(0,0, "D�part / Arriv�", "Arial Bold");
		}
		
		/**
		 * <p>
		 * Dessine les chemins de chaque particules pr�sente dans l'essaim.
		 * </p>
		 * @deprecated
		 */
		private void dessiner_chemins(){
			
			// on supprime tout les chemins de notre liste
			chemins_graphique.clear();
			
			// puis pour chaque particule on cr�� un tableau 
			//contenant les coordonn�es des villes

			int j = 0;
			for(Particule p : e.getParticules()){
				int nb_villes =  p.getCarte().getnb_ville();
				double posX[] = new double[nb_villes +1];
				double posY[] = new double[nb_villes +1];
				
				for(int i = 0; i < nb_villes +1 ; i++){
					Ville ville_courrante = p.data(i);
					posX[i] = ville_courrante.getX();
					posY[i] = ville_courrante.getY();
				}

				// on fini par cr�er un chemin constitu� de ces coordonn�es
				chemins_graphique.add(chart.addLineLayer(posY, 0x000000, "Chemin de chaque particule"));
				chemins_graphique.get(j).setXData(posX);
				chemins_graphique.get(j).setLineWidth(3);
				chemins_graphique.get(j).addCustomDataLabel(0,0, "D�part / Arriv�", "Arial Bold");
				j++;
			}
		}
		
		/**
		 * Mise � jour du graphique
		 * <p>
		 * On parcour l'essaim  afin mettre � jour nos tableaux de positions et de noms.<br/>
		 * Appell� par la m�thode {@link Panneau.ComboBoxListener#actionPerformed(ActionEvent)}.
		 * </p>
		 */
		public void mise_a_jour(){		
			
	        int nb_villes = e.getCarte().getnb_ville();
				for( int i = 0 ; i < nb_villes ; i ++ ){
					Ville v = e.getCarte().getville(i);
					positionX[i] = v.getX();
					positionY[i] = v.getY();
					nom_villes[i] = v.getNom();
				}	
		}
		
		
		/**
		 * Permet de dessiner le graphique
		 */
		public void dessiner_graphique(){
			mise_a_jour();
			chart = new XYChart(1000,500);
			chart.setPlotArea(55, 65,900, 400, -1, -1, 0xc0c0c0, 0xc0c0c0, -1);
		    chart.addLegend(50, 30, false, "Times New Roman Bold Italic", 12).setBackground(Chart.Transparent);
		    chart.addTitle("Chemin le plus rapide passant par toutes les villes", "Times New Roman Bold Italic", 18);
		    chart.yAxis().setTitle("y", "Arial Bold Italic", 12);
		    chart.xAxis().setTitle("x", "Arial Bold Italic", 12);
		    chart.xAxis().setWidth(2);
		    chart.yAxis().setWidth(2);
		    
		    // on repr�sente les villes par des cercles rouge
		    layer = chart.addScatterLayer(positionX, positionY, "Villes",Chart.CircleSymbol, 13, 0xfe3007);
	        layer.addExtraField(nom_villes);
	        layer.setDataLabelFormat("{field0}");
	        TextBox textbox = layer.setDataLabelStyle("Aria Bold",8);
	        textbox.setBackground(0xcc99ff, Chart.Transparent, 1);
	        textbox.setAlignment(Chart.Bottom);
	        textbox.setPos(4, 0);
	        
	        if (! e.isPremiere_iteration()){
				dessiner_meilleur_essaim();
	        }
	        dessiner_meilleur_chemin();

			viewer.setChart(chart);
			
		}
		
		/**
		 * <p>
		 * Dessine le meilleur chemin trouv� dans l'essaim.
		 * </p>
		 */
		private void dessiner_meilleur_essaim(){
			chemins_graphique.clear();
			int nb_villes = e.getCarte().getnb_ville() + 1;
			double posX[] = new double[nb_villes];
			double posY[] = new double[nb_villes];
			for(int i = 0; i < nb_villes ; i++){
				Ville ville_courrante = e.getMeilleur_trouve()[i];
				posX[i] = ville_courrante.getX();
				posY[i] = ville_courrante.getY();
			}
			// on fini par cr�er un chemin constitu� de ces coordonn�es
			chemins_graphique.add(chart.addLineLayer(posY, 0x000000, "Meilleur chemin trouv�"));
			int derniere_pos = chemins_graphique.size() - 1;
			chemins_graphique.get(derniere_pos).setXData(posX);
			chemins_graphique.get(derniere_pos).setLineWidth(3);
		}
		
		public ChartViewer get_viewer(){
			return viewer;
		}
		
		public void set_viewer(ChartViewer v){
			viewer = v;
		}

		public void set_iteration(long i){
	        nb_iteration = i;
		}
		
		public Essaim getE() {
			return e;
		}
}
