import java.util.*;

public class Main {

	public static void employe(Proprietaire proprietaire) {
		//Sous-menu employé

		//Variables
		boolean arret = false;

		//Scanners
		Scanner scanInt = new Scanner(System.in);
		Scanner scanString = new Scanner(System.in);

		//Récupération de son profil employé
		if (proprietaire.nbrPersonnel() != 0) {
			proprietaire.affichePersonnels();
			System.out.println("Bienvenue dans le sous-menu employé.\nRentrez votre identifiant personnel");
			int numId = scanInt.nextInt();
			Personnel personnel = proprietaire.recupProfil(numId);

			if (personnel != null) {

				while (!arret) {
					System.out.println("Que souhaitez-vous faire : \n1 : Voir vos disponibilités\n2 : Modifier vos disponibilités\n3 : Consulter les chalets dont vous vous occupez\n4 : Voir votre salaire\n5 : Retour");
					int reponseMenu = scanInt.nextInt();
					switch(reponseMenu) {

					//Sous-menu VOIR DISPONIBILITES
					case 1 : 
						personnel.voirDispos();
						break;

					//Sous-menu MODIFIER DISPONIBILITES
					case 2 :
						personnel.menuModifierDispo();					
						break;
					
					//Sous-menu CHALETS
					case 3 :
						personnel.consulterChalet();
						break;

					//Sous-menu SALAIRE
					case 4 :
						personnel.voirSalaire();
						break;

					//Sous-menu RETOUR
					case 5 :
						System.out.println("Retour en cours... Veuillez patienter");
						arret = true;
						break;
					default :
						System.out.println("Ceci n'est pas une option valable. Veuillez réessayer");
				}
				}
				
			}
		}
		else {
			System.out.println("Il n'y aucun employé");
		}

	}

	public static void proprietaire(Proprietaire proprietaire) {
		//Sous-menu proprietaire

		//Variables
		boolean arret = false;

		//Scanners
		Scanner scanInt = new Scanner(System.in);
		Scanner scanString = new Scanner(System.in);

		//Vérification du mot de passe
		System.out.println("Bienvenue dans le sous-menu proprietaire.\nVeuillez saisir le mot de passe pour accéder au menu.");
		String motDePasse = scanString.nextLine();
		//UPDATE : Gérer le mot de passe ca marche pas
		if (motDePasse.equals("chaletsProprio21")) {

			while (!arret) {
				System.out.println("Que souhaitez-vous faire : \n1 : Afficher la liste des employés\n2 : Afficher la liste des chalets\n3 : Afficher le nombre d'employés\n4 : Afficher le nombre de chalets\n5 : Gérer les employés\n6 : Gérer les chalets\n7 : Modifier le salaire d'un employé\n8 : Comparer le salaire de deux employés\n9 : Afficher les disponibilités d'un employé\n10 : Afficher les chalets associés à un employé\n11 : Gérer les chalets associé à un employé\n12 : Gérer la location d'un chalet\n13 : Retour");
				int reponseMenu = scanInt.nextInt();
				switch(reponseMenu) {

				//Sous-menu LISTE EMPLOYES
				case 1 : 
					proprietaire.affichePersonnels();
					break;

				//Sous-menu LISTE CHALETS
				case 2 :				
					proprietaire.afficheChalets();
					break;
				
				//Sous-menu NOMBRE EMPLOYES
				case 3 :
					System.out.println("Vous avez " + proprietaire.nbrPersonnel() + " employé(s)");
					break;

				//Sous-menu NOMBRE CHALETS
				case 4 :
					System.out.println("Vous avez " + proprietaire.nbrChalet() + " chalet(s)");
					break;

				//Sous-menu GESTION EMPLOYES
				case 5 :
					proprietaire.gestionPersonnel();
					break;

				//Sous-menu GESTION CHALETS
				case 6 :
					proprietaire.gestionChalet();
					break;

				//Sous-menu MODIFIER SALAIRE
				case 7 :
					proprietaire.menuModifierSalaire();
					break;

				//Sous-menu COMPARER SALAIRES
				case 8 :
					proprietaire.menuCompareEmployes();
					break;

				//Sous-menu DISPONIBILITES EMPLOYE
				case 9 :
					proprietaire.menuAfficherDispos();
					break;

				//Sous-menu CHALETS EMPLOYE
				case 10 :
					proprietaire.menuConsulterChaletsEmploye();
					break;

				//Sous-menu GESTION CHALETS EMPLOYE
				case 11 :
					proprietaire.menuGestionChaletEmploye();
					break;

				//Sous-menu GESTION LOCATION CHALET
				case 12 :
					proprietaire.menuGestionLocation();
					break;

				//Sous-menu RETOUR
				case 13 :
					System.out.println("Retour en cours... Veuillez patienter");
					arret = true;
					break;
				default :
					System.out.println("Ceci n'est pas une option valable. Veuillez réessayer");
			}
		
			}
			
		}
		else {
			System.out.println("Mot de passe incorrect");
		}
	

	}

	public static Proprietaire initProprietaire() {
		Proprietaire proprietaire = new Proprietaire();

		//Création d'un 1er personnel
		boolean dispos[]=new boolean[7];
		dispos[0] = true ;
		dispos[1] = true ;
		dispos[2] = true ;
		dispos[3] = false ;
		dispos[4] = true ;
		dispos[5] = false ;
		dispos[6] = false ;
		Personnel personnel1 = new Personnel("Shivaree", "Pimenta", 2999.0, "Bessan", dispos1);
		proprietaire.addPersonnel(personnel1);

		//Création d'un 2ème personnel
		boolean dispos2[]=new boolean[7];
		dispos2[0] = false ;
		dispos2[1] = false ;
		dispos2[2] = true ;
		dispos2[3] = true ;
		dispos2[4] = true ;
		dispos2[5] = true ;
		dispos2[6] = false ;
		Personnel personnel2 = new Personnel("Roman", "Loriot", 2000.0, "Noisy le Sec", dispos2);
		proprietaire.addPersonnel(personnel2);

		//Création d'un 3ème personnel
		boolean dispos3[]=new boolean[7];
		dispos3[0] = true ;
		dispos3[1] = false ;
		dispos3[2] = true ;
		dispos3[3] = false ;
		dispos3[4] = true ;
		dispos3[5] = true ;
		dispos3[6] = false ;
		Personnel personnel3 = new Personnel("Yoann", "Rolland", 1000.0, "La Rochelle", dispos3);
		proprietaire.addPersonnel(personnel3);

		//Création d'un 1er chalet
		Chalet chalet1 = new Chalet("Montagne", 50001, "Montreal", "3 avenue de Sherbrooke", 3, false, false);
		proprietaire.addChalet(chalet1);

		//Création d'un 2ème chalet
		Chalet chalet2 = new Chalet("Rivière", 50002, "Québec", "18 rue de la neige", 5, true, true);
		proprietaire.addChalet(chalet2);
		
		//Création d'un 3ème chalet
		Chalet chalet3 = new Chalet("Plage", 50003, "Agde", "18 rue du port", 10, false, true);
		proprietaire.addChalet(chalet3);

		return proprietaire;
	}

	public static void main(String[] args) {

		Proprietaire proprietaire = new Proprietaire();

		// Pour utiliser un proprietaire avec déjà plusieurs employés et plusieurs chalets
		proprietaire = initProprietaire();
	
		Scanner scanInt = new Scanner(System.in);
		boolean arret = false ;

		while (!arret){

			//Menu général
			System.out.println("Bienvenue dans le menu. Que souhaitez-vous faire : \n1 : Employé\n2 : Propriétaire\n3 : Quitter");
			int reponseMenu = scanInt.nextInt();

			switch(reponseMenu) {

				//Sous-menu EMPLOYE
				case 1 : 
					employe(proprietaire);
					break;

				//Sous-menu PROPRIETAIRE
				case 2 :
					proprietaire(proprietaire);
					break;
				
				//Sous-menu QUITTER
				case 3 :
					arret = true;
					break;
				default :
					System.out.println("Ceci n'est pas une option valable. Veuillez réessayer");
			}
		}
		System.out.println("Merci pour votre confiance. Nous espérons que votre expérience a été agréable. Au revoir.");
	}
}