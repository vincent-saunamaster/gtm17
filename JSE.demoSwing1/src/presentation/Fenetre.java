package presentation;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Fenetre extends JFrame {

	/**
	 * Constructeur qui instancie un JFrame, c'est ce JFrame qu'on appele dans
	 * le main
	 * 
	 * @param nom
	 */
	public Fenetre(String nom) {
		super(nom);
		setSize(800, 600);
	}

}
