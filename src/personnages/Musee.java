package personnages;

public class Musee {
	private Trophee[] trophees = new Trophee[200];
	private int nbTrophee = 0;
	
	public void donnerTrophee(Gaulois gaulois, Equipement equipement) {
		Trophee trophee = new Trophee(gaulois, equipement);
		this.trophees[this.nbTrophee] = trophee;
		nbTrophee++;
	}
	
	public String extraireInstructionsOCaml() {
	    String texte = "let musee = [";
	    for(int i = 0; i < nbTrophee; i++) {
	        Trophee trophee = trophees[i];
	        texte += "\n\t(" + trophee.gaulois.getNom() + ", " + trophee.equipement.toString() + ");";
	    }
	    texte += "\n]";
	    return texte;
	}

}
