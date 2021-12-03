import java.util.*;

public class Main {

	public static void employe(Proprietaire proprietaire) {
		//Sous-menu employé

		//Scanners
		Scanner scanInt = new Scanner(System.in);
		Scanner scanString = new Scanner(System.in);

		//Récupération de son profil employé
		proprietaire.affichePersonnels();
		System.out.println("Bienvenue dans le sous-menu employé.\nRentrez votre identifiant personnel");
		int numId = scanInt.nextInt();
		Personnel personnel = proprietaire.recupProfil(numId);

		if (personnel != null) {

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
					break;
				default :
					System.out.println("Ceci n'est pas une option valable. Veuillez réessayer");
			}

		}

	}

	public static void proprietaire(Proprietaire proprietaire) {
		//Sous-menu proprietaire

		//Variables

		//Scanners
		Scanner scanInt = new Scanner(System.in);
		Scanner scanString = new Scanner(System.in);

		//Vérification du mot de passe
		System.out.println("Bienvenue dans le sous-menu proprietaire.\nVeuillez saisir le mot de passe pour accéder au menu.");
		String motDePasse = scanString.next();
		if (motDePasse == "chaletsProprio21") {

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
					break;
				default :
					System.out.println("Ceci n'est pas une option valable. Veuillez réessayer");
			}
		
		}
	
	}

	public static void main(String[] args) {

		Proprietaire proprietaire = new Proprietaire();
	
		Scanner scanInt = new Scanner(System.in);
		boolean arret = false ;

		while (!arret) {

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