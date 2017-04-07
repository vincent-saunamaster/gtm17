package presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import metier.Client;
import service.ClientService;
import service.IClientService;

public class Fenetre extends JFrame {

	private IClientService cs = new ClientService();
	private Client c = new Client();

	// liste des composants de l'onglet1 (ajout client)
	private JLabel jl1 = new JLabel("nom");
	private JLabel jl2 = new JLabel("prenom");
	private JLabel jl3 = new JLabel("yeux");
	private JTextField jtf1 = new JTextField(12); // param 50 = nb de caractères
	private JTextField jtf2 = new JTextField(12); // param 50 = nb de caractères
	private JTextField jtf3 = new JTextField(10); // param 10 = nb de caractères
	private JButton jb1 = new JButton("ajouter");

	// liste des composants de l'onglet2 (supprimer client)
	private JLabel jl4 = new JLabel("ID");
	private JTextField jtf4 = new JTextField(12); // param 50 = nb de caractères
	private JButton jb2 = new JButton("supprimer");

	// liste des composants de l'onglet3 (modifier client)
	private JLabel jl5 = new JLabel("ID");
	private JLabel jl6 = new JLabel("nom");
	private JLabel jl7 = new JLabel("prenom");
	private JLabel jl8 = new JLabel("yeux");
	private JTextField jtf5 = new JTextField(12); // param 50 = nb de caractères
	private JTextField jtf6 = new JTextField(12); // param 50 = nb de caractères
	private JTextField jtf7 = new JTextField(12); // param 50 = nb de caractères
	private JTextField jtf8 = new JTextField(10); // param 10 = nb de caractères
	private JButton jb3 = new JButton("modifier");

	// liste des composants de l'onglet4 (lister client)
	private JScrollPane jsp;
	private JLabel jLMC = new JLabel("mot clé");
	private JTextField jtfMC = new JTextField(12);
	private JButton jbValider = new JButton("valider");
	private JTable jTableClients;
	private JPanel jPN = new JPanel();
	private ClientModel model;

	/**
	 * Constructeur qui instancie un JFrame, c'est ce JFrame qu'on appele dans
	 * le main
	 * 
	 * @param nom
	 */
	public Fenetre(String nom) {
		super(nom);
		setSize(800, 600);

		// disposition de la fenetre principale
		this.setLayout(new BorderLayout()); // ligne par ligne
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.getContentPane().setBackground(Color.LIGHT_GRAY);

		// création du container des onglets (les onglets étant des Jpanel)
		JTabbedPane onglets = new JTabbedPane(SwingConstants.TOP);

		// création du premier onglet (ajout client)
		JPanel onglet1 = new JPanel();
		onglet1.setLayout(new FlowLayout());
		onglet1.setBackground(Color.blue);

		// création du premier Container
		JPanel jp1 = new JPanel();
		jp1.setLayout(new FlowLayout()); // les uns à la suite des autres
		jp1.add(jl1);
		jp1.add(jtf1);

		// création du second Container
		JPanel jp2 = new JPanel();
		jp2.setLayout(new FlowLayout());
		jp2.add(jl2);
		jp2.add(jtf2);

		// création du troisième Container
		JPanel jp3 = new JPanel();
		jp3.setLayout(new FlowLayout());
		jp3.add(jl3);
		jp3.add(jtf3);

		// création du quatrième Container
		JPanel jp4 = new JPanel();
		jp4.setLayout(new FlowLayout());
		jp4.add(jb1);

		// création du container qui contient les 4 précédents container
		JPanel jp5 = new JPanel();
		jp5.setLayout(new BoxLayout(jp5, BoxLayout.PAGE_AXIS));
		jp5.add(jp1);
		jp5.add(jp2);
		jp5.add(jp3);
		jp5.add(jp4);

		// ajout du container (qui contient les 4 containers) à l'onglet1
		onglet1.add(jp5, BorderLayout.NORTH);

		// ajout de l'onglet1 au container des onglets
		onglets.addTab("ajout clients", onglet1);

		// ajout du container des onglets à la fenêtre
		this.add(onglets);

		// rendre le bouton de l'onglet1 actif en lui donnant une action à
		// réaliser
		jb1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				// on récupère les valeurs, Attention : tout est String ici,
				// faudra caster les int
				String nom = jtf1.getText();
				String prenom = jtf2.getText();
				String yeux = jtf3.getText();

				c.setNom(nom);
				c.setPrenom(prenom);
				c.setCouleurYeux(yeux);

				cs.ajouterClient(c);

				// vider les champs après appui sur le bouton
				jtf1.setText("");
				jtf2.setText("");
				jtf3.setText("");

			}
		});

		// création du deuxième onglet (supprimer client)
		JPanel onglet2 = new JPanel();
		onglet2.setLayout(new FlowLayout());
		onglet2.setBackground(Color.black);

		// création du premier Container
		JPanel jpOnglet2_1 = new JPanel();
		jpOnglet2_1.setLayout(new FlowLayout()); // les uns à la suite des
													// autres
		jpOnglet2_1.add(jl4);
		jpOnglet2_1.add(jtf4);

		JPanel jpOnglet2_2 = new JPanel();
		jpOnglet2_2.setLayout(new FlowLayout());
		jpOnglet2_2.add(jb2);

		// création du container qui contient les 4 précédents container
		JPanel jpOnglet2_All = new JPanel();
		jpOnglet2_All.setLayout(new BoxLayout(jpOnglet2_All, BoxLayout.PAGE_AXIS));
		jpOnglet2_All.add(jpOnglet2_1);
		jpOnglet2_All.add(jpOnglet2_2);

		// ajout du container (qui contient les 2 containers) à l'onglet2
		onglet2.add(jpOnglet2_All, BorderLayout.NORTH);

		// ajout de l'onglet1 au container des onglets
		onglets.addTab("supprimer clients", onglet2);

		// rendre le bouton de l'onglet1 actif en lui donnant une action à
		// réaliser
		jb2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// on récupère les valeurs, Attention : tout est String ici,
				// faudra caster les int
				int id = Integer.parseInt(jtf4.getText());

				cs.supprimerClient(id);

				jtf4.setText("");
			}
		});

		// création du troisième onglet (modifier client)
		JPanel onglet3 = new JPanel();
		onglet3.setLayout(new FlowLayout());
		onglet3.setBackground(Color.orange);

		// création du premier Container
		JPanel jpOnglet3_1 = new JPanel();
		jpOnglet3_1.setLayout(new FlowLayout()); // les uns à la suite des
													// autres
		jpOnglet3_1.add(jl5);
		jpOnglet3_1.add(jtf5);

		// création du second Container
		JPanel jpOnglet3_2 = new JPanel();
		jpOnglet3_2.setLayout(new FlowLayout()); // les uns à la suite des
													// autres
		jpOnglet3_2.add(jl6);
		jpOnglet3_2.add(jtf6);

		// création du troisième Container
		JPanel jpOnglet3_3 = new JPanel();
		jpOnglet3_3.setLayout(new FlowLayout()); // les uns à la suite des
													// autres
		jpOnglet3_3.add(jl7);
		jpOnglet3_3.add(jtf7);

		// création du quatrième Container
		JPanel jpOnglet3_4 = new JPanel();
		jpOnglet3_4.setLayout(new FlowLayout()); // les uns à la suite des
													// autres
		jpOnglet3_4.add(jl8);
		jpOnglet3_4.add(jtf8);

		// création du cinquième Container
		JPanel jpOnglet3_5 = new JPanel();
		jpOnglet3_5.setLayout(new FlowLayout());
		jpOnglet3_5.add(jb3);

		// création du container qui contient les 4 précédents container
		JPanel jpOnglet3_All = new JPanel();
		jpOnglet3_All.setLayout(new BoxLayout(jpOnglet3_All, BoxLayout.PAGE_AXIS));
		jpOnglet3_All.add(jpOnglet3_1);
		jpOnglet3_All.add(jpOnglet3_2);
		jpOnglet3_All.add(jpOnglet3_3);
		jpOnglet3_All.add(jpOnglet3_4);
		jpOnglet3_All.add(jpOnglet3_5);

		// ajout du container (qui contient les 5 containers) à l'onglet3
		onglet3.add(jpOnglet3_All, BorderLayout.NORTH);

		// ajout de l'onglet3 au container des onglets
		onglets.addTab("modifier clients", onglet3);

		jb3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				// on récupère les valeurs, Attention : tout est String ici,
				// faudra caster les int
				int id = Integer.parseInt(jtf5.getText());
				String nom = jtf6.getText();
				String prenom = jtf7.getText();
				String yeux = jtf8.getText();

				cs.modifierClient(id, nom, prenom, yeux);

				// vider les champs après appui sur le bouton
				jtf5.setText("");
				jtf6.setText("");
				jtf7.setText("");
				jtf8.setText("");
			}
		});

		// création du quatrième onglet (lister client)
		JPanel onglet4 = new JPanel();
		onglet4.setLayout(new BoxLayout(onglet4, BoxLayout.PAGE_AXIS));
		onglet4.setBackground(Color.cyan);
		jPN.setLayout(new FlowLayout());
		jPN.add(jLMC);
		jPN.add(jtfMC);
		jPN.add(jbValider);
		onglet4.add(jPN, BorderLayout.NORTH);
		// 1 créer un modèle d'affichage (nécessite un classe extends
		// AbstractTableModel)
		// attributs ligne et colonnes du tableau
		// méthodes héritées + setData()

		// 2 passer le modèle d'affichage au tableau
		// définir objet JScrollPane (gère défilement) qu'on met dans dans un
		// JTable (associe le model aux données)
		// attribut Model de notre classe model
		model = new ClientModel();
		jTableClients = new JTable(model);
		jsp = new JScrollPane(jTableClients);
		onglet4.add(jsp, BorderLayout.CENTER);
		onglets.addTab("Lister", onglet4);

		// 3 passer les données à afficher
		jbValider.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String mc = jtfMC.getText();
				model.setData((List<Client>) cs.chercherParcMC(mc));
			}
		});
	}

}
