package tsm;

import java.util.ArrayList;
import java.util.Random;

/**
 * La classe essaim contient un ensemble de particules, c'est dans cette classe que l'on
 * @author Pierre & Baptiste
 * @version 2.0
 */
public class Essaim
{
	/**
	 * Indique le nombre de particules pr�sentes dans l'essaim.
	 * @see Particule
	 * @see Panneau#particule
	 */
	private int nb_particules;

	
	/**
	 * <p>
	 * Indique s'il sagit de la premi�re it�ration de l'algo PSO ou non.
	 * </p>
	 * @return
	 * 			true : c'est la premi�re it�ration.<br/>
	 * 			false : ce n'est pas la premi�re.
	 */
	public boolean isPremiere_iteration() {
		return premiere_iteration;
	}

	/**
	 * 
	 * Meilleur chemin trouv� dans l'essaim.<br/>
	 * Initialis� dans {@link Essaim#init()}, puis mis � jour d�s que necessaire � la fin de chaque it�ration dans {@link Essaim#algo_PSO()}.
	 */
	private Ville[] meilleur_trouve;
	
	/**
	 * Distance du meilleur chemin trouv� dans l'essaim.
	 */
	private double meilleur_dist;
	
	/**
	 * la carte sur laquelle se fait l'�tude.
	 * @see Carte
	 */
	private Carte carte;
	
	/**
	 * bool�en indiquant si il s'agit de la premi�re it�ration de l'algorithme PSO ou non.
	 */
	private boolean premiere_iteration;
	
	/**
	 * Indique la vitesse maximal au sein de l'essaim. Elle est mise en dur dans le code dans {@link Essaim#Essaim()} .
	 * @see Fichier
	 * @see Carte
	 */
	private int v_max; // plage: 0 <= v_max < carte.getnb_ville()



	/**
	 * Tableau non contraint contenant les particules.
	 */
	private  ArrayList<Particule> particules;
	
	/**
	 * <p>
	 * <b>Le constructeur initialise les variables {@link Essaim#premiere_iteration},  {@link Essaim#particules},  {@link Essaim#nb_particules} et {@link Essaim#v_max}.</b>
	 * </p>
	 */
	public Essaim(){
		premiere_iteration = true;
		particules = new ArrayList<Particule>();
		nb_particules = 0 ;
		v_max = 4; // mis "en dur" dans le code � ajuster selon les cartes et l'effet voulu.
	}
	
	/**
	 * <p>
	 * Cette m�thode d�clenche une it�ration de l'algorithme PSO.<br/>
	 * Elle doit �tre appel� lors du clique sur le bouton {@link Graphique#demarrer}.
	 * </p>
	 */
	public void algo_PSO()
	{
		//s'il s'agit de la premi�re it�ration on lance la fonction init
		if (premiere_iteration){
			init();
			tri_a_bulle();
			premiere_iteration = false;
		}
		
		int nb_villes = carte.getnb_ville();
	            for(int i = 0; i < nb_particules; i++)
	            {
	        		Particule chemin = particules.get(i);
	                for(int j = 0; j < nb_villes; j++)
	                {
	                } // j

	                getDistTot(i);
	            } // i
	            
	            tri_a_bulle(); // tri des particules pas leur qualit�, de la meilleure � la moins bonne.
	            getvitesse();
	            maj_particules();      
	}
	
	
	/**
	 * <p>
	 * Initialise les particules de l'essaim en leur allouant les villes de la carte {@link Essaim#carte} et en cr�ant des chemins al�atoire.<br/>
	 * Cette m�thode est appell�e dans {@link Essaim#algo_PSO()}.
	 * </p>
	 */
	public void init()
	{
		int nb_villes = carte.getnb_ville();

		//on cr�� autant de particules que demand�
		for(int i = 0; i < nb_particules; i++){
			
	        Particule newParticule = new Particule(carte);
	        
	        //pour chaque particule on initialise ses villes
	        for(int j = 0; j < nb_villes; j++){
	            newParticule.data(j,carte.getville(j));
	        } 
	        //comme un chemin doit revenir au point de d�part on ajoute � la fin la premi�re ville
	        newParticule.data(nb_villes, carte.getville(0));
	        
	        //puis on ajouter la particule dans notre liste de particules
	        particules.add(newParticule);
	        
	        
	        // et on cr�� un chemin de mani�re al�atoire
	        for(int j = 0; j < 10; j++){
	        	tri_alea(particules.indexOf(newParticule));
	        }
	        getDistTot(particules.indexOf(newParticule));
	    } 
	}
	
	
	/**
	 * <p>
	 * Cr�� un chemin al�atoire dans une particule de {@link Essaim#particules} d'index <b>index</b> pass� en param�tre.
	 * </p>
	 * @param index
	 * 		 l'index de {@link Essaim#particules} auquel on acc�de pour selectionner une ville.
	 * 
	 */
	private void tri_alea(final int index)
	{
		int nb_villes = carte.getnb_ville();
		int villeA = (new Random().nextInt(nb_villes - 1)) +1; // on empeche de d�placer le premier et le dernier
		int villeB = 0;
		boolean fin = false;
		while(!fin)
		{
			villeB = (new Random().nextInt(nb_villes - 1)) + 1;
			if(villeB != villeA){
				fin = true;
			}
		}
		
		Ville temp = particules.get(index).data(villeA);
		particules.get(index).data(villeA, particules.get(index).data(villeB));
		particules.get(index).data(villeB, temp);
	}
	
	
	/**
	 * <p>
	 * Met � jour les vitesses de toutes les particules en prenant garde � ce qu'elles ne d�passent pas la vitesse maximale autoris�e.
	 * </p>
	 */
	private void getvitesse()
	{
		double pire_r�sultats = 0;
		double Valeur_v = 0.0;
		
		// apr�s le tri, le pire r�sulat sera le dernier dans la liste
	    pire_r�sultats = particules.get(nb_particules - 1).pBest();

	    for(int i = 0; i < nb_particules; i++)
	    {
	        Valeur_v = (v_max * particules.get(i).pBest()) / pire_r�sultats;

	        if(Valeur_v > v_max){
	        	particules.get(i).vitesse(v_max);
	        }
	        else if(Valeur_v < 0.0){
	        	particules.get(i).vitesse(0.0);
	        }
	        else{
	        	particules.get(i).vitesse(Valeur_v);
	        }
	    }
	}
	
	
	/**
	 * <p>met � jour chaque particule de l'essaim. Cette m�thode est appel�e � chaque it�ration dans {@link Essaim#algo_PSO()}.  </p>
	 */
	public void maj_particules()
	{
		int i;
		// on parcour toutes les particules
		if(premiere_iteration){
			i = 0;
		}
		else {
			i = 1;
		}
		for(; i < nb_particules; i++)
	    {
    		// Plus la vitesse est �lev�e, plus le changement n�cessaire sera important.
	    	int changements = (int)Math.floor(Math.abs(particules.get(i).vitesse()));
        	for(int j = 0; j < changements; j++){
        		if(new Random().nextBoolean()){
        			tri_alea(i);
        		}
        		// Rapproche la particule de son meilleur voisin.
        		if(i > 0){
            		copie_particule(i - 1, i);
        		}
        		
        	} // j
	        
	        // Mise � jour de la valeur pbest.
	        getDistTot(i);
	    } // i
	    
	    return;
	}
	
	/**
	 * <p>
	 * Permet � une particule <b>destination</b> d'imiter partiellement une particule <b>source</b>.<br>
	 * La particule <b>destination</b> copie le succ�sseur d'une ville prise au hasard dans <b>source</b> et le positionne � la place de son succ�sseur de cette m�me ville.
	 * </p>
	 * @param source
	 * 		 Particule � imiter.
	 * @param destination
	 * 		 Particule imitant.
	 */
	private void copie_particule(final int source, final int destination)
	{

		int nb_villes = carte.getnb_ville();
		
		// On approche les points de la destination des points de la source.
		Particule best = particules.get(source);
		
		Ville cibleA = best.data( (new Random().nextInt(nb_villes-1)) +1 );
		Ville cibleB = null;
		
		int indexA = 1;
		int indexB = 1;
		int tempIndex = 1;
		
		// on initialise cibleB avec le successeur de cibleA dans la particule best
		for(int i = 1; i < (nb_villes) ; i++)
		{
			if(best.data(i) == cibleA){
				
				if( i == (nb_villes -1) ){
					cibleB = best.data(1); // Si fin du tableau on reprend du d�but
				}
				else{
					cibleB = best.data(i + 1);
				}
				break;
			}
		}
		
		// D�placer la cibleB pr�s de la cible en �changeant des valeurs.
		for(int j = 1 ; j < ( nb_villes) ; j++)
		{
			if(particules.get(destination).data(j) == cibleA){
				indexA = j;
			}
			if(particules.get(destination).data(j) == cibleB){
				indexB = j;
			}
		}
		// tempIndex prend le suivant d'indexA 
		if(indexA == (nb_villes - 1)){
			tempIndex = 1;
		}
		else{
			tempIndex = indexA + 1;
		}
		
		// Echanger la valeur d'IndexB avec la valeur de tempIndex.
		Ville temp = particules.get(destination).data(tempIndex);
		particules.get(destination).data(tempIndex, particules.get(destination).data(indexB));
		particules.get(destination).data(indexB, temp);
		getDistTot(destination);
	}
	
	
	/**
	 * <p>
	 * Calcule la distance du chemin de la particule d'index <b>index</b> donn� en param�tre.
	 * </p>
	 * @param index
	 * 		 L'index de la particule dans {@link Essaim#particules}.
	 */
	private void getDistTot(final int index)
	{
		int nb_villes = carte.getnb_ville() + 1;
		
		Particule actu_part = particules.get(index);
	    actu_part.pBest(0.0);
	    
	    for(int i = 0; i < nb_villes; i++)
	    {
	        if(i == nb_villes - 1){
	        	actu_part.pBest(	actu_part.pBest() 
	        					+ 	getDistance(actu_part.data(nb_villes - 1) , 
	        					actu_part.data(0))); // voyage complet.
	        }
	        else{
	        	actu_part.pBest(	actu_part.pBest() 
	        					+ 	getDistance(actu_part.data(i) , 
	        					actu_part.data(i + 1)));
	        }
	    }
	    particules.get(index).setMpBest(actu_part.pBest());
	}

	
	/**
	 * Sert � �valuer la distance entre deux villes.
	 * @param premi�re_ville
	 * 			La premi�re ville
	 * @param deuxi�me_ville
	 * 			La deuxi�me ville
	 * @return
	 * 			La distance entre les deux villes
	 */
	private double getDistance(final Ville premi�re_ville, final Ville deuxi�me_ville)
	{
		// utilisation de la formule de calcul de distance entre deux vecteurs
		double a2 = Math.pow(Math.abs(premi�re_ville.getX() - deuxi�me_ville.getX()), 2);
		double b2 = Math.pow(Math.abs(premi�re_ville.getY() - deuxi�me_ville.getY()), 2);
	    return Math.sqrt(a2 + b2);
	}
	
	/**
	 * <p>
	 * Permet de trier {@link Essaim#particules}, la particule ayant le {@link Particule#pBest} le plus petit �tant la premi�re.<br/>
	 * </p>
	 */
	private void tri_a_bulle()
	{
		boolean fin = false;
		while(!fin)
		{
			//changements repr�sente le nombre de changements effectu�es
			int changements = 0;
			
			for(int i = 0; i < nb_particules - 1; i++)
			{
				// si le meilleur r�sultat de la particule n�i est sup�rieur � celui
				// de la particule suivante, on les inverse dans le tableau
				// et on incr�mente changements
				if(particules.get(i).comparer(particules.get(i + 1)) == 1){
					Particule temp = particules.get(i);
					particules.set(i, particules.get(i + 1));
					particules.set(i + 1, temp);
					changements++;
				}
				
			}
			// si il n'y a pas eu de changements, le tableau est tri�
			if(changements == 0){
				fin = true;
			}
		}
		//on met eventuellement � jour le meilleur trouv�
		if((particules.get(0).getMpBest() < meilleur_dist) || (premiere_iteration)){
			Ville[] liste_temp = particules.get(0).getmData();
			double dist_temp = particules.get(0).getMpBest();
			setMeilleur_trouve(liste_temp);
			setMeilleur_dist(dist_temp);
		}
	}
	
	/**
	 * Met � jour le tableau de particules ainsi que {@link Essaim#nb_particules}.
	 * @param particules
	 * 		un tableau de particules
	 */
	public void setParticules(ArrayList<Particule> particules) {
		this.particules = particules;
		this.nb_particules = particules.size();
	}
	
	public int getNb_particules() {
		return nb_particules;
	}

	public void setNb_particules(int nb_particules) {
		this.nb_particules = nb_particules;
	}

	public int getV_max() {
		return v_max;
	}

	public void setV_max(int v_max) {
		this.v_max = v_max;
	}
	
	public ArrayList<Particule> getParticules() {
		return particules;
	}

	public Carte getCarte() {
		return carte;
	}

	public void setCarte(Carte carte) {
		this.carte = carte;
	}

	public Ville[] getMeilleur_trouve() {
		return meilleur_trouve;
	}

	public void setMeilleur_trouve(Ville[] meilleur_trouve) {
		this.meilleur_trouve = meilleur_trouve;
	}

	public double getMeilleur_dist() {
		return meilleur_dist;
	}

	public void setMeilleur_dist(double meilleur_dist) {
		this.meilleur_dist = meilleur_dist;
	}

}