package tsm;

import javax.swing.JFrame;

/**
 * La classe fenetre représente le cadre dans lequel est contenu le programme.
 * Il contient un objet de type Panneau
 * @see Panneau
 * @author baptiste
 *@version 1.0
 */
public class Fenetre extends JFrame {
	
	/**
	 * le Panneau de la fenetre
	 * @see Panneau
	 */
	private Panneau pan = new Panneau();

	/**
	 * Le constructeur fenetre fixe le titre, la visibilité, la position et ajoute un objet de type Panneau
	 * @see Panneau
	 */
	public Fenetre(){
	this.setTitle("PSO");
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setVisible(true);
	this.add(pan);
	this.pack();
	this.setLocationRelativeTo(null);
	}
}
