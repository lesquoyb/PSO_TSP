package tsm;

/**
 * <b>Classe principale depuis laquelle on lance le programme.</b>
 * <p>
 * Elle créé le fichier xml ainsi qu'une instance de Fenetre.
 * </p>
 * @author Baptiste
 *
 */
public class main {
	
	private static Fenetre f;
	
	public static void main(String[] args) {
		Fichier.creer();
		f = new Fenetre();
	}
	
}

