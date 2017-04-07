/**
 * 
 */
package presentation;

/**
 * Classe Lanceur contenant la méthode principale "main"
 * @author ME VLG
 *
 */
public class Lanceur {

	
	public static void main(String[] args) {
		
		
		
		
		
		
	/*	int x;
		int i=0;
		int idGerant;
		int telephoneGerant;
		String nomGerant;
		String prenomGerant;
		String adresseGerant;
		int codePostalGerant;
		String villeGerant;
		String leMotDePasse;
		String prenomConseiller;
		String nomConseiller;
		int telephoneConseiller;
		int idConseiller;
		String adresseConseiller;
		int codePostalConseiller;
		String villeConseiller;
		IGerant ge = new ServiceGerant();
		
		System.out.println("Qui êtes vous?");
		System.out.println("1. Un gérant");
		System.out.println("2. Un conseiller");
		Scanner clavier = new Scanner(System.in);
		
		x = clavier.nextInt();
		
		if (x==1){
			System.out.println("Entrez votre prenom");
			prenomGerant = clavier.next();
			System.out.println("Entrer votre nom");
			nomGerant = clavier.next();
			System.out.println("Entrez votre telephone");
			telephoneGerant = clavier.nextInt();
			System.out.println("entrez votre adresse");
			adresseGerant = clavier.next();
			System.out.println("Entrez votre code postal");
			codePostalGerant = clavier.nextInt();
			System.out.println("Entrez votre ville");
			villeGerant = clavier.next();
			System.out.println("Entrez votre ID");
			idGerant = clavier.nextInt();
			System.out.println("Entrez votre mot de passe");
			leMotDePasse = clavier.next();
			Adresse a = new Adresse (adresseGerant, codePostalGerant, villeGerant);
			Gerant g1 = new Gerant(nomGerant, prenomGerant, telephoneGerant, idGerant, a);
			while(i<1 || i>5){
			System.out.println("Que voulez vous faire ?");
			System.out.println("1. Ajouter un Conseiller");
			System.out.println("2. Modifier un Conseiller");
			System.out.println("3. Supprimer un Conseiller");
			System.out.println("4. Effectuer l'Audit de l'agence");
			System.out.println("5. Quitter l'application");
			i = clavier.nextInt();
			}
			
			switch(i)
			{
			case 1:
			System.out.println("Nom du Conseiller");
			nomConseiller = clavier.next();
			System.out.println("Prenom du Conseiller");
			prenomConseiller = clavier.next();
			System.out.println("telephone du Conseiller");
			telephoneConseiller = clavier.nextInt();
			System.out.println("Identifiant du Conseiller");
			idConseiller = clavier.nextInt();
			System.out.println("Adresse du Conseiller");
			adresseConseiller = clavier.next();
			System.out.println("Code postal du Conseiller");
			codePostalConseiller = clavier.nextInt();
			System.out.println("Ville du Conseiller");
			villeConseiller = clavier.next();
			
			
			Adresse a1 = new Adresse(villeConseiller, codePostalConseiller, villeConseiller);
			Conseiller c1 = new Conseiller(nomConseiller, prenomConseiller, telephoneConseiller, idConseiller, a1);
			ge.AjouterConseiller(g1,c1);
				
				
			case 2 :
				
				System.out.println(" nouveau telephone du Conseiller");
				telephoneConseiller = clavier.nextInt();
				System.out.println("Adresse du Conseiller");
				adresseConseiller = clavier.next();
				System.out.println("Code postal du Conseiller");
				codePostalConseiller = clavier.nextInt();
				System.out.println("Ville du Conseiller");
				villeConseiller = clavier.next();
				Conseiller c2 = new Conseiller ();
				Adresse a2 = new Adresse(villeConseiller, codePostalConseiller, villeConseiller);
				ge.ModifierConseiller(c2,a2,telephoneConseiller);
				
			case 3 : 
				
				
				
			
			}
			
		}
		else 
		{
			if (x==2){
				
			}
		}
		
	*/
		
		
		/*System.out.println("Un Gerant peut modifier l'adresse et le telphone d'un conseiller");
		System.out.println("Conseiller initial " +g1);
		Adresse a2 = new Adresse("rue B",69001,"Villeurbanne");
		int telephone2 = 0707070707;
		ge.ModifierConseiller(c1,a2,telephone2);
		System.out.println("Conseiller modifié" +g1);
		
		System.out.println("-----------------");
	
		System.out.println("Un Gerant peut supprimer un conseiller");
		ge.SupprimerConseiller(c1, g1);
		System.out.println(g1);
		
		
		System.out.println("-----------------");
		
		System.out.println("Un conseiller peut ajouter un client particulier");
		IConseillerClient gc1 = new ServiceConseiller();
		Conseiller conseiller1 = new Conseiller("Toto","Titi",0606060606,001,a1);
		Client client1 = new Client("Le Gal", "Vincent", 0606060604,002,a2,1);
		gc1.AjouterClient(conseiller1, client1);
		System.out.println(conseiller1.getMesClientsParticuliers());
		
		System.out.println("-----------------");
		
		System.out.println("Un conseiller peut ajouter un client entreprise");
		
		Adresse a3 = new Adresse("rue massena",69003,"Lyon");
		Client client2 = new Client("GTM","Eddy",06060052203,004,a3,2);
		gc1.AjouterClient(conseiller1, client2);
		System.out.println(conseiller1.getMesClientsEntreprises());
		
		System.out.println("-----------------");
		
		System.out.println("Un Conseiller peut modifier l'adresse et le telphone d'un client");
		System.out.println("client initial" + client1);
		Adresse a4 = new Adresse("rue descartes",69100,"Villeurbanne");
		int telephone4 = 032013000;
		gc1.ModifierClient(client1,a4,telephone4);
		System.out.println("client modifié " + client1);
		System.out.println("-----------------");
		
		
		System.out.println("Un conseiller ne peut pas ajouter plus de 10 clients");
		
		Client client3 = new Client("GTM","C",06060052203,004,a3,1);
		Client client4 = new Client("GTM","D",06060052203,004,a3,2);
		Client client5 = new Client("GTM","E",06060052203,004,a3,1);
		Client client6 = new Client("GTM","F",06060052203,004,a3,1);
		Client client7 = new Client("GTM","G",06060052203,004,a3,2);
		Client client8 = new Client("GTM","H",06060052203,004,a3,2);
		Client client9 = new Client("GTM","I",06060052203,004,a3,1);
		Client client10 = new Client("GTM","J",06060052203,004,a3,2);
		gc1.AjouterClient(conseiller1, client3);
		gc1.AjouterClient(conseiller1, client4);
		gc1.AjouterClient(conseiller1, client5);
		gc1.AjouterClient(conseiller1, client6);
		gc1.AjouterClient(conseiller1, client7);
		gc1.AjouterClient(conseiller1, client8);
		gc1.AjouterClient(conseiller1, client9);
		gc1.AjouterClient(conseiller1, client10);
		System.out.println("le conseiller a " + conseiller1.getTousMesClients().size() + "clients");
		System.out.println("essaie d'ajout d'un client supplémentaire");
		Client client11 = new Client("GTM","K",06060052203,004,a3,2);
		gc1.AjouterClient(conseiller1, client11);
		System.out.println("le conseiller a " + conseiller1.getTousMesClients().size() + "clients");
		
	
		System.out.println("-----------------");
		
		System.out.println("Un Conseiller peut supprimer un client");
		gc1.SupprimerClient(client9, conseiller1);
		System.out.println("le conseiller a " + conseiller1.getTousMesClients().size() + "clients");
		
		System.out.println("-----------------");
		System.out.println("Un Conseiller peut ajouter un compte courant a un client");
		IConseillerCompte ccc = new ServiceConseiller();
		Compte compte1 = new Compte(1234, 30000, "20 janvier 2016",1000);
		System.out.println("le client " + client8);
		System.out.println("le compte" + compte1);
		ccc.AjouterCompteClient(client8, compte1);
		System.out.println(client8.getMonCompteCourant());
		
		System.out.println("-----------------");
		System.out.println("Un Conseiller ne peut pas ajouter un compte courant a un client qui possède deja un compte courant");
		Compte compte3 = new Compte(1456, 5000, "20 fevrier 2017",1000);
		System.out.println("le client " + client8 + "possède deja ce compte courant " + compte1);
		System.out.println("le conseilleur veut lui ajouter le compte courant " + compte3);
		ccc.AjouterCompteClient(client8, compte3);
		
		
		
		System.out.println("-----------------");
		System.out.println("Un Conseiller peut ajouter un compte epargne a un client");
		Compte compte2 = new Compte(4567, 1000, "10 janvier 2017",3);
		System.out.println("le client " + client8);
		System.out.println("le compte" + compte2);
		ccc.AjouterCompteClient(client8, compte2);
		System.out.println(client8.getMonCompteEpargne());
		
		System.out.println("-----------------");
		System.out.println("Un Conseiller ne peut pas ajouter un compte epargne a un client qui en possède deja un");
		Compte compte4 = new Compte(8563, 500, "20 janvier 2017",3);
		System.out.println("le client " + client8 + "possède deja ce compte epargne " + compte2);
		System.out.println("le conseilleur veut lui ajouter le compte courant " + compte4);
		ccc.AjouterCompteClient(client8, compte4);
		
		
		
		System.out.println("-----------------");
		System.out.println("Un Conseiller peut associee une carte visa a un compte client");
		IConseillerCarteVisa ccv = new ServiceConseiller();
		CarteVisa cv = new CarteVisa(1230, "electron");
		ccv.ActivationCarteVisa(compte1, cv);
		System.out.println("la carte " + compte1.getMaCarteVisa() + " a été associée au compte " +compte1);
		
		System.out.println("-----------------");
		System.out.println("Un Conseiller peut désassociee une carte visa d'un compte client");
		ccv.DesactivationCarteVisa(compte1, cv);
		System.out.println("le compte "+compte1 + " a pour carte visa " +compte1.getMaCarteVisa());
		
		
		System.out.println("-----------------");
		System.out.println("Un Conseiller peut supprimer un compte  a un client");
		System.out.println("le client "+ client8 + "possède l compte epargne "+client8.getMonCompteEpargne());
		System.out.println("Supression du compte epargne :");
		ccc.SupprimerCompteClient(compte4, client8);
		
		System.out.println("-----------------");
		System.out.println("Un Conseiller peut faire une simulation de Credit");
		System.out.println("pour un motant de 50000 euros, avec un taux de 3% et une durée de remboursement de 36 mois, le remboursement mensuel sera de :");
		IConseillerSimulation ccs = new ServiceConseiller();
		System.out.println(ccs.EffectuerSimulationCredit(50000, 3, 36));
		
		System.out.println("-----------------");
		System.out.println("Un Conseiller peut effectuer un virement entre d'un compte courant à un autre compte si le solde ne descend pas en dessous de son découvert (-1000)");
		IConseillerVirement conv = new ServiceConseiller();
		System.out.println("le compte courant débiteur est le suivant " + compte3);
		System.out.println("le compte rceveur est le suivant " + compte2);
		System.out.println("Essaie de virement de 80000 euros (qui dépasse le découvert autorisé)");
		conv.EffectuerVirement(compte3, compte2, 80000);
		System.out.println("le compte courant débiteur devient suivant " + compte3);
		System.out.println("le compte receveur devient le suivant " + compte2);
		System.out.println("Essaie de virement de 600 euros (qui est normalement autorisé)");
		conv.EffectuerVirement(compte3, compte2, 600);
		System.out.println("le compte courant débiteur devient suivant " + compte3);
		System.out.println("le compte receveur devient le suivant " + compte2);
		
		
		System.out.println("-----------------");
		System.out.println("Un Conseiller peut effectuer un Audit de son agence");
		IGerantAgence ga1= new ServiceGerant();
		ge.AjouterConseiller(g1, conseiller1);
		
		if(conseiller1.getTousMesClients()!=null)
		{
			ga1.AuditerAgence(conseiller1.getTousMesClients());
		}
		*/
		
	}
}



