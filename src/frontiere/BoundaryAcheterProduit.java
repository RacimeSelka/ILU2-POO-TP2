package frontiere;

import controleur.ControlAcheterProduit;


public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;
	

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;

	}

	public void acheterProduit(String nomAcheteur) {
		boolean isHabitant = controlAcheterProduit.verifierIdentite(nomAcheteur);
		if (!isHabitant) {
			System.out.println("Je suis désolée " + nomAcheteur
					+ " mais il faut être un habitant de notre village pour commercer ici.");
		} else {
			String produit = Clavier.entrerChaine("Quel produit voulez vous acheter?");
			String[] vendeurs = controlAcheterProduit.rechercherVendeursProduit(produit);
			if (vendeurs.length == 0) {
				System.out.println("Désolé, personne ne vend ce produit au marché.");

			} else {
				StringBuilder message = new StringBuilder();
				message.append("chez quel commercant souhaitez vous acheter des " + produit + " ?\n");
				for (int i = 0; i < vendeurs.length; i++) {
					message.append(i + 1 + "-" + vendeurs[i] + "\n");
				}
				int choix = Clavier.entrerEntier(message.toString()) - 1;
				String vendeur = vendeurs[choix];
				System.out.println(nomAcheteur + " se déplace jusqu'à l'étal du vendeur " + vendeur + "\n");
				int quantiteAcheter = Clavier
						.entrerEntier("bonjour " + nomAcheteur + "Combien de " + produit + " voulez vous acheter ?\n");
				int quantiteVendu = controlAcheterProduit.acheterProduit(nomAcheteur, vendeur, quantiteAcheter);
				if (quantiteVendu == 0) {
					System.out.println(nomAcheteur + " veut acheter " + quantiteAcheter + " " + produit
							+ ",malheureusement il n'y en a plus.\n");
				} else if (quantiteAcheter > quantiteVendu) {
					System.out.println(nomAcheteur + " veut acheter " + quantiteAcheter + " " + produit
							+ ",malheureusement bonemine n'en a que " + quantiteVendu + ".\n");
				} else {
					System.out.println(
							nomAcheteur + " achete " + quantiteAcheter + " de " + produit + " à " + vendeur + "\n");
				}
			}
		}
	}
}