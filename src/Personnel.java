import java.util.*;

public class Personnel {
	
	public enum Jours_semaine {Lundi, Mardi, Mercredi, Jeudi, Vendredi, Samedi, Dimanche};
	
	private String nom;
	private String prenom;
	private double salaire;
	private String ville;
	private boolean dispos[]= new boolean[7];
    private Chalet chalet[] = new Chalet[4];
	
	public Personnel(String nom, String prenom, double salaire,String ville,boolean dispos[]) {
		
		this.nom=nom;
		this.prenom=prenom;
		this.salaire=salaire;
		this.ville=ville;
		this.dispos=dispos;
		for (int i = 0; i < chalet.length; i++) {
			chalet[i] = null;
		}

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
        System.out.println("Disponibilités de l'employé : \n");
		
		int i = 0;
		for (Jours_semaine Jours: Jours_semaine.values()) {
			System.out.println(Jours + " : " + ((dispos[i] == true) ? "Disponible" : "Pas disponible"));
			i++;
		}
		System.out.println("\n");
		
	}
	
	private void modifierDispo (String jour) {
		System.out.println("Vous avez bien modifié la disponibilité pour le jour : " + jour + "\n");
        dispos[Jours_semaine.valueOf(jour).ordinal()] = !dispos[Jours_semaine.valueOf(jour).ordinal()] ;		
	}

	public void menuModifierDispo(){
		Scanner scanString = new Scanner(System.in);
		System.out.println("Pour quel jour souhaitez vous modifier votre disponibilité ?");
		String jour = scanString.nextLine();
		if ((jour.equals("Lundi")) || (jour.equals("Mardi")) ||(jour.equals("Mercredi")) ||(jour.equals("Jeudi")) ||(jour.equals("Vendredi")) ||(jour.equals("Samedi")) ||(jour.equals("Dimanche"))) {
			this.modifierDispo(jour);
		}
		else {
			System.out.println("Ce jour n'est pas valide. Veuillez rentrer en entier votre jour (Exemple : Lundi)");
		}	
	}
	
	private int nbrChalet() {
		int compteur = 0;
		for (int i = 0; i < chalet.length; i++) {
			if (chalet[i] != null) {
				compteur++;
			}
		}
		return compteur;
	}

	public void consulterChalet () {
		if (nbrChalet() != 0) {
			System.out.println("Voici la liste des chalets dont vous vous occupez :\n");
			for (int i = 0 ; i < nbrChalet() ; i++) {
				System.out.println(chalet[i].toString() + "\n");
			}
		}
		else {
			System.out.println("Vous ne vous occupez d'aucun chalet\n");
		}
		
	} 
	
	public void voirSalaire () {		
		System.out.println("Voici votre salaire actuel : " + salaire + " $CA.");
	}
	
	public int compareTo (Personnel employe) {		
		if (this.salaire > employe.getSalaire()) {
			return 1;	
		}
		else if (this.salaire == employe.getSalaire()){
			return 0;
		}
        else {
            return -1;
        }
	}
	
	public void supprimerChalet (Chalet chaletASupprimer) {

		//Je cherche si mon chalet est dans ma liste
		//Si c'est le cas, je l'écrase et je décale tous les suivants dans la liste pour libérer la place en fin de tableau
		boolean trouve = false;
		for (int i = 0; i < nbrChalet(); i++) {
			if (chalet[i] == chaletASupprimer) {
				trouve = true;
			}
			if (trouve && (i != (nbrChalet() - 1))) {
				chalet[i] = chalet[i+1];
			} 
		}
		if (trouve) {
			chalet[nbrChalet() - 1] = null;
		}
		else {
            System.out.println("Cet employé ne s'occupe pas de ce chalet.") ;
        }
	}
	
	public void ajouterChalet (Chalet nouveauChalet) {
		int nbrChalet = nbrChalet();
        if (nbrChalet == 4) {
            System.out.println("Cet employé s'occupe déjà de 4 chalets. Il ne peut en prendre plus \n");
        }
        else {
            chalet[nbrChalet] = nouveauChalet;
        }
	}

	public String toString() {
        return (this.getNom() + " " + this.getPrenom());
    }

}