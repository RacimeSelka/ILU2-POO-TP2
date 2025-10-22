package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if (!controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.println("je suis désole "+ nomVendeur +", mais il faut etre un habitant du village pour commercer ici");
		}else {
			System.out.println("Bonjour "+nomVendeur+" je vais regarder si je peux vous trouver un étal.");
			if (!controlPrendreEtal.resteEtals()) {
				System.out.println("Désolé "+ nomVendeur +" je n'ai plus d'étals qui ne soit pas déja occupé ");
			} else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		System.out.println("C'est parfait, il me reste un étal pour vous! \n il me faudrait quelques renseignements"); 
		String produit=Clavier.entrerChaine("Quel produit souhaitez vous vendre ?");
		int nbProduit=Clavier.entrerEntier("Combien souhaitez vous en vendre ?");
		int numeroEtal=controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if (numeroEtal!=-1) {
			System.out.println("Le vendeur "+ nomVendeur + " s'est installé à l'étal n°"+ numeroEtal +".");
		} 

	}
}
