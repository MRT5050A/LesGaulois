package personnages;

import java.util.Random;

public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion = 1;

	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;

		parler("Bonjour, je suis le druide " + nom + " Et ma potion peut aller d'une force " + effetPotionMin + " à "
				+ effetPotionMax + ".");
	}

	public int getForcePotion() {
		return forcePotion;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");

	}

	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}

	public void preparerPotion() {
		Random random = new Random();

		int forcePotionPrepare = random.nextInt(effetPotionMax);

		if (forcePotionPrepare >= 7) {
			parler("J'ai préparé une super potion de force :" + forcePotionPrepare);
		} else if (forcePotionPrepare < effetPotionMin) {
			forcePotionPrepare = effetPotionMin;
			parler("Je n'ai pas trouvé tous les ingrédients, ma potion est seulement de force : " + forcePotionPrepare);
		} else {
			parler("Je n'ai pas trouvé tous les ingrédients, ma potion est seulement de force : " + forcePotionPrepare);
		}

		forcePotion = forcePotionPrepare;
	}

	public void booster(Gaulois gaulois) {

		if (!"Obelix".equals(gaulois.getNom())) {
			gaulois.boirePotion(forcePotion);
		} else {
			parler("Non, Obélix !... Tu n’auras pas de potion magique ! ");
		}
	}

	public static void main(String[] args) {
		Druide panoramix = new Druide("Panoramix", 5, 10);

		panoramix.preparerPotion();
	}

}
