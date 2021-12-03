import java.util.*;
import java.util.Scanner;

public class Proprietaire {
	
	private Personnel[] Personnel = new Personnel[100];
	private Chalet[] Chalet = new Chalet[400];
	
	public Proprietaire() {
		
		//Ici, le constructeur définit par défaut une liste du personnel et des chalets vides
		//Si l'utilisateur souhaite ajouter du personnel ou des chalets il devra faire appel aux méthodes 
		// C'est plus simple d'utilisation pour le propriétaire
		
		this.Personnel = null;
		this.Chalet = null;

	}
	
	
	public Personnel recupProfil (int numId) {
		
		return Personnel[numId];
	}
	
	private Personnel selectionPersonnel () {
		//affiche la liste du personnel (ID + nom)
		//demande à l'utilisateur de sélectionner un employé par son ID 
		//retourne le personnel correspondant 
		

		for ( int i = 0 ; i < Personnel.length ; i++) {
			System.out.println("Numéro identifiant: " + i + ", " + Personnel[i] + "\t");
	
		}
		
		System.out.println("Veuillez choisir un employé parmi la liste en entrant son numéro identifiant:  \t");
		Scanner ID = new Scanner (System.in);
		
		return Personnel[ID];
		
	}
	
	public void affichePersonnel() {
		//Affiche tous les employés de la liste
		
	}
	
	public void afficheChalet() {
		//Affiche tous les chalets de la liste
	}
	
	public void nbrPersonnel() {
		// compte les employés de la liste et affiche le total
	}
	
	public void nbrChalet() {
		// compte les chalets de la liste et affiche le total
	}
	
	public void gestionPersonnel () {
		//on sélectionne un employe avec la fonction selectionPersonnel
		//Demander ajout ou suppression à l'utilisateur (menu)
		//appeler la fonction adéquate ci-dessous
        ajoutPersonnel();
        suppressionPersonnel(2);
	}
	
	private void ajoutPersonnel () {
		
		//Demander toutes les caractéristiques à l'utilisateur 
		//créer un nouveau personnel 
		//l'ajouter à la liste
	}

	private void suppressionPersonnel (int numId) {
		
		//supprimer de la liste cet employé
	}
	
	public void gestionChalet ( ) {
		//Demander ajout ou suppression à l'utilisateur (menu)
		//appeler la fonction adéquate ci-dessous
        ajoutChalet();
        suppressionChalet(2);
	}
	
	private void ajoutChalet () {
		
		//Demander toutes les caractéristiques à l'utilisateur
		//créer un nouveau chalet
		//l'ajouter à la liste
	}

	private void suppressionChalet (int numId) {
		//demander à l'utilisateur de rentrer un ID ou nom de chalet
		//supprimer de la liste ce chalet
	}
	
	public void modifierSalaire() {
		//on sélectionne un employe avec selectionPersonnel
		//on modifie son salaire avec setSalaire
	}
	
	
	public void compareEmployes ( int numId1, int numId2) {
		//peut être améliorer pour traiter le cas de 2 salaires égaux;
		
		if (Personnel[numId1].compareTo(Personnel[numId2])) {
			System.out.println(Personnel[numId1].getNom() + " " + Personnel[numId1].getPrenom() + " a un salaire plus élevé que " + Personnel[numId2].getNom() + " " + Personnel[numId2].getPrenom() );
		}
		
		else {
			
			System.out.println(Personnel[numId1].getNom() + " " + Personnel[numId1].getPrenom() + " a un salaire plus bas que " + Personnel[numId2].getNom() + " " + Personnel[numId2].getPrenom() );
			
		}
	}
	
	public void afficherDispos(int numId) {
		//on affiche les jours de la semaine et les disponibilités booléennes
		
	}
	
	public void afficherChalets(int numId) {
		// Chalet + num id du chalet à afficher
		
	}
	
	public void gestionChaletEmploye ( int numIdEmploye) {
		//demande ajout ou suppression ?
		//récupérer le numéro du chalet à supprimer ou ajouter
		//appel de la fonction adéquate
	}
	
	public void gestionLocation (int numIdChalet) {
		//Lui demander s'il veut le mettre en location ou libre 
		//appeler la fonction setLocation et lui donner la valeur adéquate
	}
	
}