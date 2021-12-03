import java.util.*;

public class Personnel {
	
	public enum Jours_semaine {Lundi, Mardi, Mercredi, Jeudi, Vendredi, Samedi, Dimanche};
	
	private String nom;
	private String prenom;
	private double salaire;
	private String ville;
	private boolean dispos[]=new boolean[7];
    private List<Chalet> chalet = new ArrayList<Chalet>();
	
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
        System.out.println("Disponibilités de l'employé : \n");
		
		int i = 0;
		for (Jours_semaine Jours: Jours_semaine.values()) {
			System.out.println(Jours + " : " + ((dispos[i] == true) ? "Disponible" : "Pas disponible"));
			i++;
		}
		System.out.println("\n");
		
	}
	
	private void modifierDispo (String jour) {
        // UPDATE : Prendre la valeur booléenne en argument
		System.out.println("Vous avez sélectionné le jour : " + jour + "\n");
        dispos[Jours_semaine.valueOf(jour).ordinal()] = !dispos[Jours_semaine.valueOf(jour).ordinal()] ;		
	}

	public void menuModifierDispo(){
		System.out.println("Pour quel jour souhaitez vous modifier votre disponibilité ?");
		String jour = scanString.next();
		if ((jour == "Lundi") || (jour == "Mardi") ||(jour == "Mercredi") ||(jour == "Jeudi") ||(jour == "Vendredi") ||(jour == "Samedi") ||(jour == "Dimanche")) {
			this.modifierDispo(jour);
		}
		else {
			System.out.println("Ce jour n'est pas valide. Veuillez rentrer en entier votre jour (Exemple : Lundi)");
		}	
	}
	
	public void consulterChalet () {
		if (this.chalet.size() != 0) {
			System.out.println("Voici la liste des chalets dont vous vous occupez :\n");
			for (int i = 0 ; i < this.chalet.size() ; i++) {
				System.out.println(chalet.get(i).toString() + "\n");
			}
		}
		else {
			System.out.println("Vous ne vous occupez d'aucun chalet\n");
		}
		
	} 
	
	public String voirSalaire () {		
		return "Voici votre salaire actuel : " + salaire + " $CA.";
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
		if (chalet.contains(chaletASupprimer)) {
            chalet.remove(chaletASupprimer) ;
        }
        else {
            System.out.println("Cet employé ne s'occupe pas de ce chalet.") ;
        }
	}
	
	public void ajouterChalet (Chalet nouveauChalet) {
        if (chalet.size() == 4) {
            System.out.println("Cet employé s'occupe déjà de 4 chalets. Il ne peut en prendre plus \n");
        }
        else {
            chalet.add(nouveauChalet) ;
        }
	}

	public String toString() {
        return (this.getNom() + " " + this.getPrenom());
    }

}