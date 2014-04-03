package tsm;


/**
 * La classe particule repr�sente une seule particule de l'essaim.
 * <p>
 * Dans ce cas pr�cis, une particule repr�sente un chemin entre toutes les villes de la carte.
 * Une particule est caract�ris� par sa taille ainsi que l'ordre de passage dans chacune des villes.
 * Les autres caract�ristiques propres aux particules sont 
 * </p>
 * @author Pierre & Baptiste
 * @version 2.0
 */
public class Particule
{
	/**
	 * liste des villes.
	 */
    private Ville mData[] ;
    
    /**
     * taille du chemin. Initialis� � 0.
     */
    private double mpBest;
    
    /**
     * la vitesse de la particule. Initialis� � 0.
     */
    private double mVitesse;
    
    /**
     * La carte correspondant � la particule.
     */
    private Carte carte;
    
    /**
     * Initialise un objet de type particule.
     * @param c
     * 			la carte li�e � cette particule.
     */
    public Particule(Carte c)
    {
        this.carte = c;
        this.mpBest = 0;
        this.mVitesse = 0.0;
        this.mData = new Ville[carte.getnb_ville() + 1];
    }
    
    /**
     * Permet de comparer le meilleur r�sultat obtenus par la particule courrante avec celui d'une autre.
     * @param p_comp
     * 		  La seconde particule
     * @return
     * 		Renvoie -1 si {@link Particule#pBest} de <b>p_comp</b> est sup�rieur.<br/>
     * 		Renvoie 1 si {@link Particule#pBest} de <b>p_comp</b> est inf�rieur.<br/>
     * 		Sinon renvoie 0 (�galit�).
     */
    public int comparer(Particule p_comp)
    {
    	if(this.pBest() < p_comp.pBest()){
    		return -1;
    	}
    	else if(this.pBest() > p_comp.pBest()){
    		return 1;
    	}
    	else{
    		return 0;
    	}
    }

    /**
     * Retourne la ville pr�sente � l'indice <b>index</b> de {@link Particule#mData} .
     * @param index
     * 		L'indice o� se trouve la valeur recherch�e.
     * @return
     * 		La ville pr�sente � l'index demand�.
     */
    public Ville data(final int index)
    {
    	return this.mData[index];
    }
    
    /**
     * Assigne la ville <b>value</b> � {@link Particule#mData} d'index <b>index</b>.
     * @param index
     * 		 La position � laquelle on place <b>value</b>.
     * @param value
     * 		La ville � placer.
     * @see Ville
     */
    public void data(final int index, final Ville value)
    {
        this.mData[index] = value;
        return;
    }

    public Ville[] getmData() {
		return mData;
	}

	public void setmData(Ville[] mData) {
		this.mData = mData;
	}

	public double getMpBest() {
		return mpBest;
	}

	public void setMpBest(double mpBest) {
		this.mpBest = mpBest;
	}

	public double getmVitesse() {
		return mVitesse;
	}

	public void setmVitesse(double mVitesse) {
		this.mVitesse = mVitesse;
	}

	public Carte getCarte() {
		return carte;
	}

	public void setCarte(Carte carte) {
		this.carte = carte;
	}

	/**
     * Renvoie le meilleur r�sultat de la particule.
     * @return
     * 		{@link Particule#pBest}
     */
    public double pBest()
    {
    	return this.mpBest;
    }

    /**
     * met � jour le meilleur r�sultat de la particule.
     * @param value
     * 		Valeur � affecter � {@link Particule#pBest}
     */
    public void pBest(final double value)
    {
    	this.mpBest = value;
    	return;
    }

    public double vitesse()
    {
    	return this.mVitesse;
    }
    
    public void vitesse(final double val_vitesse)
    {
       this.mVitesse = val_vitesse;
       return;
    }
}