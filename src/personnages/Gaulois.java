package personnages;

public class Gaulois {

	private String nom;
	private int effetPotion = 1;
	private int force;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];

	public Gaulois(String nom, int force, int nbTrophee) {
		this.nom = nom;
		this.force = force;
		this.nbTrophees = nbTrophee;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\" " + texte + "\"");
	}

//	public String prendreParole() {
//		return "Le Gaulois " + nom + " : ";
//	}
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la mâchoir de " + romain.getNom());
//		romain.recevoirCoup(force / 3 * force);
//	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] trophee = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; trophee != null && i < trophee.length; i++, nbTrophees++) {
			this.trophees[nbTrophees] = trophee[i];
		}

	}
	
	public void faireUneDonnation(Musee musee) {
		parler("Je donne au musee tous mes trophees :");
		for(int i=0; i<nbTrophees; i++) {
			Equipement equipement = trophees[i];
			System.out.println("- " + equipement.toString());
			musee.donnerTrophee(this, equipement);
		}
	}


	public void boirePotion(int forcePotion) {
		force = forcePotion;
		parler("Merci Druide, je sens que ma force est " + forcePotion + " fois décuplée");
	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}

//	public static void main(String[] args) {
//		Gaulois asterix = new Gaulois("Asterix", 8, 8);
//		Romain rdm = new Romain("Rdm1", 2);
//
//		asterix.frapper(rdm);
//		asterix.parler("Bonjour à tous");
//	
//	}

}
