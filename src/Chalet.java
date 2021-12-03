import java.util.*;

public class Chalet {
	
	private String nom;
	private int numId;
	private String ville;
	private String adresse;
	private int nbrChambre;
	private boolean location;
	private boolean affectationEmploye;
	
	public Chalet(String nom, int numId, String ville, String adresse, int nbrChambre,boolean location, boolean affectationEmploye) {
		
		this.nom=nom;
		this.numId=numId; // upgrade : ajouter un if pour vérifier que le numId est bien à 5 chiffres + unique 
		this.ville=ville;
		this.adresse=adresse;
		this.nbrChambre=nbrChambre;
		this.location=location;	
		this.affectationEmploye=affectationEmploye;
		
		}
	// Accesseurs :
	
	public String getNom() {
		return nom;
	}
	
	public int getNumId() {
		return numId;
	}
	
	public String getVille() {
		return ville;
	}
	
	public String getAdresse() {
		return adresse;
	}
	
	public int getNbrChambre() {
		return nbrChambre;
	}
	
	public boolean getLocation() {
		return location;
	}
	
	public boolean getAffectationEmploye() {
		return affectationEmploye;
	}
	
	// Mutateurs :
	
	public void setNom(String nom) {
		this.nom=nom;
	}
	
	public void setNumId(int numId) {
		this.numId=numId;
	}

	public void setVille(String ville) {
		this.ville=ville;
	}
	
    public void setAdresse(String adresse) {
		this.adresse=adresse;
	}
	
    public void setNbrChambre(int nbrChambre) {
		this.nbrChambre=nbrChambre;
	}
	
    public void setLocation(boolean location) {
		this.location=location;
	}
	
	public void setAffectationEmploye(boolean affectationEmploye) {
		this.affectationEmploye=affectationEmploye;
	}
	
	// Méthodes:
	
	public String toString() {
		return ("Chalet n°" + this.getNumId() + " : \"" + this.getNom() + "\" au " + this.getAdresse() + ", " + this.getVille() + ".\t");
	}

}