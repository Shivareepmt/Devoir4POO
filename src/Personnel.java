import java.util.*;

public class Personnel {
	
	private enum Jours_semaine {Lundi, Mardi, Mercredi, Jeudi, Vendredi, Samedi, Dimanche};
	
	private String nom;
	private String prenom;
	private double salaire;
	private String ville;
	private boolean dispos[]=new boolean[7];
	private Chalet chalet[]=new Chalet[4];
	private Jours_semaine Jours ;
	
	public Personnel(String nom, String prenom, double salaire,String ville,boolean dispos[]) {
		
		this.nom=nom;
		this.prenom=prenom;
		this.salaire=salaire;
		this.ville=ville;
		this.dispos=dispos;
	}
	
	// Accesseurs :
	
	public String getNom() {
		return nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
    public double getSalaire() {
		return salaire;
	}
	
    public String getVille() {
		return ville;
	}
	
	// Mutateurs :
	
	public void setNom(String nom) {
		this.nom=nom;
	}
	
    public void setPrenom(String prenom) {
		this.prenom=prenom;
	}
	
    public void setSalaire(Double salaire) {
		this.salaire=salaire;
	}
	
    public void setVille(String ville) {
		this.ville=ville;
		
	}
	
	// Méthodes :
	
	public void voirDispos () {
        System.out.println("Disponibilités de l'employé : \t");
		
		for ( int i = 0 ; i < dispos.length; i++) {
			for (Jours_semaine Jours: Jours_semaine.values()) {
				System.out.println(Jours + " : ");
			}
			System.out.println(dispos[i] + "\t");
		}
	}
	
	public void modifierDispo (int jour) {
		//Chaque employé peut modifier sa disponibilité pour une journée en rentrant l'indice
		//du jour de travail à modifier 
		
		//Chaque jour a un integer associé que l'on va inverser
		
		System.out.println("Vous avez sélectionné le jour : " + Jours.valueOf(arg[jour]));
		
		if (dispos[jour] == true) {
			dispos[jour] = false;
		}
		else {
			dispos[jour] = true;
		}
			
		
	}
	
	public void consulterChalet () {
		//affiche la liste des chalets dont s'occupe l'employé
		System.out.println("Voici la liste des chalets dont vous vous occupez :");
		
		for ( int i = 0 ; i < Chalet.sizeof() ; i++) {
			System.out.println(Chalet[i]);
		}
		
	} 
	
	public String voirSalaire () {
		//affiche le salaire de l'employé
		
		return "Voici votre salaire actuel" + salaire + " euros.";
	}
	
	public boolean compareTo (Personnel employe) {
		//peut être améliorer pour traiter le cas de 2 salaires égaux;
		
		if (this.salaire > employe.getSalaire) {
			return true;	
		}
		
		else {
			return false;
		}
			
	}
	
	public void supprimerChalet (int numIdChalet) {
		//supprime le chalet de la liste de l'employé 
	}
	
	public void ajouterChalet (int numIdChalet) {
		//ajouter le chalet (existant) dans la liste des chalets de l'employé 
	}
}