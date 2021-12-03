import java.util.*;
import java.util.Scanner;

public class Proprietaire {
	
    private List<Personnel> personnels = new ArrayList<Personnel>();
    private List<Chalet> chalets = new ArrayList<Chalet>();
	
	public Proprietaire() {
		// Ici, le constructeur ne fait rien. Il laisse les listes vides
		// Si l'utilisateur souhaite ajouter du personnel ou des chalets il devra faire appel aux méthodes 
		// C'est plus simple d'utilisation pour le propriétaire
	}
	
    // Méthodes pour le personnel :
	
	public Personnel recupProfil (int numId) {
        //S'il existe un personnel avec cet ID (i.e. l'id est un index possible de la liste personnels), 
        //on retourne le personnel associé à l'id
        if (numId < personnels.size()) {
            return personnels.get(numId);
        }
        System.out.println("Il n'y a pas d'employé avec cet ID.");
        return null;
	}

    public void affichePersonnels() {
        if (personnels.size() != 0) {
            System.out.println("Voici la liste des employés :");
            for (int i = 0; i < personnels.size(); i++) {
                System.out.println("Employé n°" + i + " : " + personnels.get(i).toString());
            }
        }
        else {
            System.out.println("Vous n'avez aucun employé");
        }
	}

    public int nbrPersonnel() {
        return personnels.size();
	}
    
	public void gestionPersonnel () {  

        //Récupération de l'action que souhaite effectuer l'utilisateur
        System.out.println("Souhaitez vous ajouter ou supprimer un employé ? \n1 : Ajouter\n2 : Supprimer");
        Scanner scanner = new Scanner(System.in);
        int reponse = scanner.nextInt();

        //Traitement de la demande
        if (reponse == 1) {
            this.ajoutPersonnel();
        }
        else if(reponse == 2) {

            //Récupération du personnel à supprimer
            this.affichePersonnels();
            System.out.println("Quel employé souhaitez-vous supprimer ? Rentrez son ID");
            int numId = scanner.nextInt();
            Personnel personnel = this.recupProfil(numId);

            if (personnel != null) {
                this.suppressionPersonnel(personnel);
            }
        }
        else {
            System.out.println("Cette option n'est pas disponible, veuillez rééssayer.") ;
        }
	}
	
	private void ajoutPersonnel () {

        Scanner scanString = new Scanner(System.in);
        Scanner scanInt = new Scanner(System.in);
        Scanner scanDouble = new Scanner(System.in);

        //Récupération des informations nécessaires à la création d'un nouveau personnel
        System.out.println("");
        System.out.println("Veuillez saisir les informations suivantes pour ajouter un nouvel employé.");
        System.out.println("Nom :");
        String nom = scanString.next();
        System.out.println("Prénom :");
        String prenom = scanString.next(); 
        System.out.println("Salaire (en $CA) :");
        double salaire = scanDouble.nextDouble();
        System.out.println("Ville :");
        String ville = scanString.next();
        System.out.println("Veuillez rentrer les disponibilités de cet employé :\n1 : Disponible\n2 : Pas disponible");
        boolean dispos[] = new boolean[7]; 
        for (Personnel.Jours_semaine Jours: Personnel.Jours_semaine.values()) {
            System.out.println("Êtes-vous disponible le " + Jours + " : ");
            int dispo = scanInt.nextInt();          
            if (dispo == 1) {
                dispos[Jours.ordinal()] = true;
            }
            else {
                dispos[Jours.ordinal()] = false;
            } 
        }

        //Création de personnel et ajout à la liste
        Personnel personnel = new Personnel(nom, prenom, salaire, ville, dispos);
        personnels.add(personnel);
        System.out.println("Ajout de l'employé avec succès");
	}

	private void suppressionPersonnel(Personnel personnel) {
		personnels.remove(personnel) ;
        System.out.println("Suppression de l'employé avec succès");
	}
	
	private void modifierSalaire(Personnel personnel, double salaire) {
		personnel.setSalaire(salaire);
	}	

    public void menuModifierSalaire() {
        Scanner scanInt = new Scanner(System.in);
        Scanner scanDouble = new Scanner(System.in);
        System.out.println("De quel employé souhaitez vous modifier le salaire ? Choississez en rentrant son ID");
        this.affichePersonnels();
        int numId = scanInt.nextInt();
        Personnel personnel = this.recupProfil(numId);
        if (personnel != null) {
            System.out.println("Quel salaire souhaitez vous lui donner ?");
            double salaire = scanDouble.nextDouble();
            this.modifierSalaire(personnel, salaire);
        }
    }
	
	private void compareEmployes (int numId1, int numId2) {

        //Récupération des employés associés à l'ID
        Personnel employe1 = this.recupProfil(numId1);
        Personnel employe2 = this.recupProfil(numId2);

        //Comparaison de leurs salaires si les deux personnels existent
        if ((employe1 != null) && (employe2 != null)) {
            int compare = employe1.compareTo(employe2);

            if (compare == -1) {
                System.out.println(employe1.toString() + " à un salaire plus bas que " + employe2.toString());
            }		
            else if (compare == 0) {
                System.out.println(employe1.toString() + " à un salaire égal à " + employe2.toString());
            }
            else {
                System.out.println(employe1.toString() + " à un salaire plus élevé que " + employe2.toString());
            }
        }
	}
	
    public void menuCompareEmployes () {
        Scanner scanInt = new Scanner(System.in);
        System.out.println("Choississez le premier employé à comparer en rentrant son ID");
        this.affichePersonnels();
        int numId1 = scanInt.nextInt();
        System.out.println("Choississez le second employé à comparer en rentrant son ID");
        int numId2 = scanInt.nextInt();
        this.compareEmployes(numId1, numId2);
    }

	private void afficherDispos(int numId) {
        //Récupération du personnel associé à l'ID
        Personnel personnel = this.recupProfil(numId);

        //Affichage des disponibilités si le personnel existe
        if (personnel != null) {
            personnel.voirDispos();	
        }   	
	}
	
    public void menuAfficherDispos() {
        System.out.println("Choississez l'employé dont vous souhaitez voir les disponibilités en rentrant son ID");
        this.affichePersonnels();
        int numId = scanInt.nextInt();
        this.afficherDispos(numId);
    }
    
    // Méthodes pour les chalets :

    public Chalet recupChalet (int numId) {
        //On parcourt tous les chalets et lorsque les IDs correspondent, on retourne le chalet
        for (int i = 0; i < chalets.size(); i++) {
            if (chalets.get(i).getNumId() == numId) {
                return chalets.get(i);
            }
        }
        //Si on parcouru tous les chalets dans en trouvé, on affiche un message d'erreur et on retourne un Chalet null
        System.out.println("Il n'y a pas de chalet avec ce numéro");
        return null;
    }

	public void afficheChalets() {
		System.out.println("Voici la liste des chalets :");
		for (int i = 0; i < chalets.size(); i++) {
            System.out.println(chalets.get(i).toString());
        }
	}
	
	public int nbrChalet() {
        return chalets.size();
	}
	
	public void gestionChalet ( ) {

        Scanner scanInt = new Scanner(System.in);

        //Récupération de l'action que souhaite faire l'utilisateur 
        System.out.println("Souhaitez vous ajouter ou supprimer un chalet ? \n1 : Ajouter\n2 : Supprimer");
        int reponse = scanInt.nextInt();

        //Traitement de la demande
        if (reponse == 1) {
            this.ajoutChalet();
        }
        else if(reponse == 2) {

            //Récupération du chalet à supprimer
            System.out.println("Quel chalet souhaitez-vous supprimer ? Rentrez son ID");
            this.afficheChalets();
            int numId = scanInt.nextInt(); 
            Chalet chalet = this.recupChalet(numId);

            if (chalet != null) {
                this.suppressionChalet(chalet);
            }
        }
        else {
            System.out.println("Cette option n'est pas disponible, veuillez rééssayer.") ;
        }
	}
	
	private void ajoutChalet () {

        Scanner scanString = new Scanner(System.in);
        Scanner scanInt = new Scanner(System.in);

        //Récupération des informations nécessaires à la création du chalet
        System.out.println("Veuillez saisir les informations suivantes pour ajouter un nouveau chalet.");
        System.out.println("Nom :");
        String nom = scanString.next();
        System.out.println("ID :");
        int numId = scanInt.nextInt();
        System.out.println("Ville :");
        String ville = scanString.next();
        System.out.println("Adresse :");
	    String adresse = scanString.next();
        System.out.println("Nombre de chambre(s) :");
	    int nbrChambre = scanInt.nextInt();
        System.out.println("Location : \n1: oui\n2: non");
	    boolean location;
        int reponseLocation = scanInt.nextInt();
        if (reponseLocation == 1) {
            location = true;
        }
        else {
            location = false;
        }
	    boolean affectationEmploye = false; //Aucun employé n'est affecté par défaut. On utilisera la méthode adéquate pour en affecter un.
        
        // Création du chalet et ajout à la liste
        Chalet chalet = new Chalet(nom, numId, ville, adresse, nbrChambre, location, affectationEmploye);
        chalets.add(chalet);
        System.out.println("Ajout du chalet avec succès");
	}

	private void suppressionChalet (Chalet chalet) {
		chalets.remove(chalet) ;
        System.out.println("Suppression du chalet avec succès");
	}
	
	public void afficheChalet(int numId) {
        //Récupération du chalet à afficher
        Chalet chalet = this.recupChalet(numId);

        //Affichage du chalet
        if (chalet != null) {
            System.out.println(chalet.toString());
        }		
	}
	
    public void menuConsulterChaletsEmploye() {
		Scanner scanInt = new Scanner(System.in);
        System.out.println("Choississez l'employé dont vous souhaitez voir les chalets associés en rentrant son ID");
        this.affichePersonnels();
        int numId = scanInt.nextInt();
        Personnel personnel = this.recupProfil(numId);
        personnel.consulterChalet();
    }

	public void menuGestionChaletEmploye () {

        Scanner scanInt = new Scanner(System.in);

        //Récupération de l'employé concerné
        System.out.println("Choississez l'employé dont vous souhaitez gérer les chalets associés en rentrant son ID");
        this.affichePersonnels();
        int numIdEmploye = scanInt.nextInt();

        //Récupération du chalet à traiter
        System.out.println("Veuillez sélectionner le chalet à ajouter ou supprimer en rentrant son ID");
        this.afficheChalets();
        int numId = scanInt.nextInt();
        Chalet chalet = this.recupChalet(numId);

        if (chalet != null) {
            //Récupération de l'employé associé au numéro
            Personnel personnel = this.recupProfil(numIdEmploye);

            if (personnel != null) {
                //Récupération de l'action que souhaite faire l'utilisateur
                System.out.println("Souhaitez vous ajouter ou supprimer un chalet ? \n1 : Ajouter\n2 : Supprimer");
                int reponse = scanInt.nextInt();

                //Traitement de la demande
                if (reponse == 1) {
                    this.ajoutChaletEmploye(personnel, chalet);
                }
                else if(reponse == 2) {
                    this.suppressionChaletEmploye(personnel, chalet);
                }
                else {
                    System.out.println("Cette option n'est pas disponible, veuillez rééssayer.") ;
                }

            }
        }
	}

    private void ajoutChaletEmploye(Personnel personnel, Chalet chalet) {
        //Ajout du chalet dans la liste d'affection de l'employé
        personnel.ajouterChalet(chalet);

        //Le chalet devient alors affecté
        chalet.setAffectationEmploye(true);
        System.out.println("Ajout de l'affectation du chalet à " + personnel.toString() + " avec succès");
    }

    private void suppressionChaletEmploye(Personnel personnel, Chalet chalet) {
        //Suppression du chalet dans la liste d'affection de l'employé
        personnel.supprimerChalet(chalet);

        //Le chalet devient alors non-affecté
        chalet.setAffectationEmploye(false);
        System.out.println("Suppression de l'affectation du chalet à " + personnel.toString() + " avec succès");
    }
	
	public void menuGestionLocation () {

        Scanner scanInt = new Scanner(System.in);

        //Récupération du chalet à gérer
        System.out.println("Choississez le chalet dont vous voulez vous occuper en rentrant son ID");
        this.afficheChalets();
        numIdChalet = scanInt.nextInt();
        Chalet chalet = this.recupChalet(numIdChalet);
        if (chalet != null) {

            //Récupération de l'action que souhaite faire l'utilisateur
            System.out.println("Souhaitez vous mettre en location ou terminer la location du chalet ? \n1 : Mettre\n2 : Terminer");
            int reponse = scanInt.nextInt(); 

            //Traitement de la demande
            if (reponse == 1) {
                chalet.setLocation(true);
            }
            else if(reponse == 2) {
                chalet.setLocation(false);
            }
            else {
                System.out.println("Cette option n'est pas disponible, veuillez rééssayer.") ;
            }

        }

	}

}