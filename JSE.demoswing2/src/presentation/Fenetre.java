package presentation;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Fenetre extends JFrame {

	// liste des composant de la fenetre
	private JLabel jl = new JLabel("Récepteur");
	private JTextField jtf = new JTextField(12); // param 12 = nb de caractères
	private JButton jb1 = new JButton("ajouter");
	private JButton jb2 = new JButton("déplacer");
	private JButton jb3 = new JButton("vider");
	
	private List liste1 = new List();
	private List liste2 = new List();

	
	/**
	 * Constructeur qui instancie un JFrame, c'est ce JFrame qu'on appele dans
	 * le main
	 * 
	 * @param nom
	 */
	public Fenetre(String nom) {
		super(nom);
		setSize(800, 600);
		
		//disposition de la fenetre principale
		this.setLayout(new BorderLayout());
		
		// ajout du premier Container
		JPanel jp1 = new JPanel();
		jp1.setLayout(new FlowLayout());
		jp1.add(jl);
		jp1.add(jtf);
		jp1.add(jb1);
		jp1.add(jb2);
		jp1.add(jb3);
		this.add(jp1,BorderLayout.NORTH);
		
		// ajout du second container
		JPanel jp2 = new JPanel();
		jp2.setLayout(new GridLayout());
		jp2.add(liste1);
		jp2.add(liste2);
		this.add(jp2,BorderLayout.CENTER);
	
		
		
	}

}
