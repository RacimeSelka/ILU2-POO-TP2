package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		if (!(controlLibererEtal.isVendeur(nomVendeur))) {
			System.out.println("mais vous n'etes as inscritsur notre marché aujourd'hui");
		} else {
			String[] donneEtal= controlLibererEtal.libererEtal(nomVendeur);
			System.out.println("vous avez vendu "+donneEtal[4]+" sur "+donneEtal[3]+" "+donneEtal[2]+".\n Au revoir "+nomVendeur+" passez une bonne journée.\n");
		}
	}

}
