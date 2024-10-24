package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;

	public Village(String nom, int nbVillageoisMaximum) {
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMaximum];
	}

	public void setChef(Chef chef) {
		this.chef = chef;
		;
	}

	public String getNom() {
		return nom;
	}

	public void ajouterHabitant(Gaulois gaulois) {
		if (nbVillageois < villageois.length) {
			villageois[nbVillageois] = gaulois;
			nbVillageois++;
		}
	}

	public Gaulois trouverHabitant(int nb) {
		return villageois[nb];
	}

	public void afficherVillageois() {
		System.out.println("Dans le village " + nom + "vivent les légendaires gaulois :");
		if (chef != null) {
			System.out.println("- " + chef.getNom());
		}
		int i = 0;
		while (villageois[i] != null) {
			System.out.println("- " + villageois[i].getNom());
			i++;
		}
	}

	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles", 30);
//		Gaulois gaulois = village.trouverHabitant(30);
//		Car le tableau va de l'indice 0 à 30
		Chef abraracourcix = new Chef("Abraracourcix", 6, village);
		village.setChef(abraracourcix);

		Gaulois asterix = new Gaulois("Asterix", 8, 0);
		village.ajouterHabitant(asterix);
		
		Gaulois obelix = new Gaulois("Obelix", 25, 0);
		village.ajouterHabitant(obelix);
		
		village.afficherVillageois();

//		Gaulois gaulois = village.trouverHabitant(1);
//		System.out.println(gaulois);
//		Car Asterix est à l'indice 0
	}
}
