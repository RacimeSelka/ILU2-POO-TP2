package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if (!(controlPrendreEtal.verifierIdentite(nomVendeur))) {
			System.out.println("Je suis désolé "+nomVendeur+" mais il faut etre un habitant pour commercer ici.");
		} else {
			System.out.println("Bonjour "+nomVendeur+" je vais regarder si je peux vous trouver une etale.");
			
			if (!(controlPrendreEtal.resteEtals())) {
				System.out.println("Desolée "+nomVendeur+" je n'ai plus d'etal qui ne soit pas deja occupée.");
			} else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		System.out.println("c'est parfait il me reste un etal pour vous!\n il me faudrait quelques renseignements:\n");
		String produit=Clavier.entrerChaine("Quelproduit souhaitez vous vendre?");
		int nbProduit=Clavier.entrerEntier("combiensouhaitez vous en vendre");
		int numeroEtal=controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if (numeroEtal!=-1) {
			System.out.println("Le vendeur "+nomVendeur+" s'est installéa l'étal n "+numeroEtal);
			
		}
		
	}
}
