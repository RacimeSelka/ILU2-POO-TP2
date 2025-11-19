package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherMarcheTest {

	private Village village;
	private Chef abraracourcix;
	private ControlAfficherMarche controlAfficherMarche;

	@BeforeEach
	public void initialiserSituation() {
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlAfficherMarche = new ControlAfficherMarche(village);
	}

	@Test
	void testControlAfficherMarche() {
		assertNotNull(controlAfficherMarche);
	}

	@Test
	void testDonnerInfosMarche(){
		Gaulois vendeur=new Gaulois("obelix",10);
		village.installerVendeur(vendeur, "menhir", 5);
		String[] etatMarche={"obelix","5","menhir"};
		assertArrayEquals(controlAfficherMarche.donnerInfosMarche(),etatMarche);
	}


}
