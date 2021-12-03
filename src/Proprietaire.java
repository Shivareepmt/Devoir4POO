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
        System.out.println("Il n'y a pas d'employé avec cet ID.\t");
        return null;
	}

    public void affichePersonnels() {
        System.out.println("Voici la liste des employés : \t");
		for (int i = 0; i < personnels.size(); i++) {
            System.out.println("Employé n°" + i + " : " + personnels.get(i).toString() + "\t");
        }
	}

    public int nbrPersonnel() {
        return personnels.size();
	}
    
	public void gestionPersonnel () {  

        //Récupération de l'action que souhaite effectuer l'utilisateur
        System.out.println("Souhaitez vous ajouter ou supprimer un employé ? \t1 : Ajouter\t2 : Supprimer\t");
        int reponse = 2 ; // Faire un scanner (je sais pas faire encore)

        //Traitement de la demande
        if (reponse == 1) {
            this.ajoutPersonnel();
        }
        else if(reponse == 2) {

            //Récupération du personnel à supprimer
            this.affichePersonnels();
            numId = 0; // Faire un scanner (je sais pas faire encore)
            Personnel personnel = this.recupProfil(numId);

            if (personnel != null) {
                this.suppressionPersonnel(personnel);
            }
        }
        else {
            System.out.println("Cette option n'est pas disponible, veuillez rééssayer.\t") ;
        }
	}
	
	private void ajoutPersonnel () {

        //Récupération des informations nécessaires à la création d'un nouveau personnel
        System.out.println("");
        System.out.println("Veuillez saisir les informations suivantes pour ajouter un nouvel employé.\t");
        System.out.println("Nom : \t");
        String nom; // Faire des scanners
        System.out.println("Prénom : \t");
        String prenom; // Faire des scanners
        System.out.println("Salaire (en $CA) : \t");
        double salaire; // Faire des scanners
        System.out.println("Ville : \t");
        String ville; // Faire des scanners
        System.out.println("Veuillez rentrer les disponibilités de cet employé : ");
        boolean dispos[]; 
        for ( int i = 0 ; i < 7; i++) {
			for (Jours_semaine Jours: Jours_semaine.values()) {
				System.out.println("\t" + Jours + " : ");
			}
			dispos[i] = true; // Faire des scanners
		}

        //Création de personnel et ajout à la liste
        Personnel personnel = new Personnel(nom, prenom, salaire, ville, dispos);
        personnels.add(personnel);
        System.out.println("Ajout de l'employé avec succès\t");
	}

	private void suppressionPersonnel(Personnel personnel) {
		personnels.remove(personnel) ;
        System.out.println("Suppression de l'employé avec succès\t");
	}
	
	public void modifierSalaire(Personnel personnel, double salaire) {
		personnel.setSalaire(salaire);
	}	
	
	public void compareEmployes (int numId1, int numId2) {

        //Récupération des employés associés à l'ID
        Personnel employe1 = this.recupProfil(NumId1);
        Personnel employe2 = this.recupProfil(NumId2);

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
	
	public void afficherDispos(int numId) {
        //Récupération du personnel associé à l'ID
        Personnel personnel = this.recupProfil(numId);

        //Affichage des disponibilités si le personnel existe
        if (personnel != null) {
            personnel.voirDispos();	
        }   	
	}
	
    // Méthodes pour les chalets :

    public Chalet recupChalet (int numId) {
        //On parcourt tous les chalets et lorsque les IDs correspondent, on retourne le chalet
        for (int i = 0; i < chalets.size(); i++) {
            if (chalets.get(i).getId() == numId) {
                return chalets.get(i);
            }
        }
        //Si on parcouru tous les chalets dans en trouvé, on affiche un message d'erreur et on retourne un Chalet null
        System.out.println("Il n'y a pas de chalet avec ce numéro");
        return null;
    }

	public void afficheChalets() {
		System.out.println("Voici la liste des chalets : \t");
		for (int i = 0; i < chalets.size(); i++) {
            System.out.println(chalets.get(i).toString() + "\t");
        }
	}
	
	public int nbrChalet() {
        return chalets.size();
	}
	
	public void gestionChalet ( ) {
        //Récupération de l'action que souhaite faire l'utilisateur 
        System.out.println("Souhaitez vous ajouter ou supprimer un chalet ? \t1 : Ajouter\t2 : Supprimer\t");
        int reponse = 2 ; // Faire un scanner (je sais pas faire encore)

        //Traitement de la demande
        if (reponse == 1) {
            this.ajoutChalet();
        }
        else if(reponse == 2) {

            //Récupération du chalet à supprimer
            this.afficheChalets();
            numId = 0; // Faire un scanner (je sais pas faire encore)
            Chalet chalet = this.recupChalet(numId);

            if (chalet != null) {
                this.suppressionChalet(chalet);
            }
        }
        else {
            System.out.println("Cette option n'est pas disponible, veuillez rééssayer.\t") ;
        }
	}
	
	private void ajoutChalet () {

        //Récupération des informations nécessaires à la création du chalet
        System.out.println("Veuillez saisir les informations suivantes pour ajouter un nouvel employé.\t");
        System.out.println("Nom : \t");
        String nom; // Faire des scanners
        System.out.println("ID : \t");
        String numId; // Faire des scanners
        System.out.println("Ville : \t");
        String ville; // Faire des scanners
        System.out.println("Adresse : \t");
	    String adresse; // Faire des scanners
        System.out.println("Adresse : \t");
	    int nbrChambre; // Faire des scanners
        System.out.println("Location : \t1: oui\t2: non\t");
	    boolean location;
        int reponseLocation = 1; // Faire des scanners
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
        System.out.println("Ajout du chalet avec succès\t");
	}

	private void suppressionChalet (Chalet chalet) {
		chalets.remove(chalet) ;
        System.out.println("Suppression du chalet avec succès\t");
	}
	
	public void afficheChalet(int numId) {
        //Récupération du chalet à afficher
        Chalet chalet = this.recupChalet(numId);

        //Affichage du chalet
        if (chalet != null) {
            System.out.println(chalet.toString());
        }		
	}
	
	public void gestionChaletEmploye (int numIdEmploye) {

        //Récupération du chalet à traiter
        System.out.println("Veuillez sélectionner le chalet à ajouter ou supprimer\t");
        this.afficheChalets();
        numId = 0; // Faire un scanner (je sais pas faire encore)
        Chalet chalet = this.recupChalet(numId);

        if (chalet != null) {
            //Récupération de l'employé associé au numéro
            Personnel personnel = this.recupProfil(numIdEmploye);

            if (personnel != null) {
                //Récupération de l'action que souhaite faire l'utilisateur
                System.out.println("Souhaitez vous ajouter ou supprimer un chalet ? \t1 : Ajouter\t2 : Supprimer\t");
                int reponse = 2 ; // Faire un scanner (je sais pas faire encore)

                //Traitement de la demande
                if (reponse == 1) {
                    this.ajoutChaletEmploye(chalet);
                }
                else if(reponse == 2) {
                    this.suppressionChaletEmploye(chalet);
                }
                else {
                    System.out.println("Cette option n'est pas disponible, veuillez rééssayer.\t") ;
                }

            }
        }
	}

    private void ajoutChaletEmploye(Personnel personnel, Chalet chalet) {
        //Ajout du chalet dans la liste d'affection de l'employé
        personnel.ajouterChalet(chalet);

        //Le chalet devient alors affecté
        chalet.setAffectationEmploye(true);
        System.out.println("Ajout de l'affectation du chalet à " + personnel.toString() + " avec succès\t");
    }

    private void suppressionChaletEmploye(Personnel personnel, Chalet chalet) {
        //Suppression du chalet dans la liste d'affection de l'employé
        personnel.supprimerChalet(chalet);

        //Le chalet devient alors non-affecté
        chalet.setAffectationEmploye(false);
        System.out.println("Suppression de l'affectation du chalet à " + personnel.toString() + " avec succès\t");
    }
	
	public void gestionLocation (int numIdChalet) {
        //Récupération du chalet à gérer
        Chalet chalet = this.recupChalet(numIdChalet);
        if (chalet != null) {

            //Récupération de l'action que souhaite faire l'utilisateur
            System.out.println("Souhaitez vous mettre en location ou terminer la location du chalet ? \t1 : Mettre\t2 : Terminer\t");
            int reponse = 2 ; // Faire un scanner (je sais pas faire encore)

            //Traitement de la demande
            if (reponse == 1) {
                chalet.setLocation(true);
            }
            else if(reponse == 2) {
                chalet.setLocation(false);
            }
            else {
                System.out.println("Cette option n'est pas disponible, veuillez rééssayer.\t") ;
            }

        }

	}
	
}