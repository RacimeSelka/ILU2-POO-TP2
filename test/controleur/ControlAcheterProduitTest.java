package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAcheterProduitTest {

	private Village village;
	private Chef abraracourcix;
	private ControlAcheterProduit controlAcheterProduit;
	private ControlVerifierIdentite controlVerifierIdentite;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;

	@BeforeEach
	public void initialiserSituation() {
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		Gaulois vendeur = new Gaulois("bonemine", 3);
		village.installerVendeur(vendeur, "fleurs", 5);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		controlAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
	}

	@Test
	public void testControlAcheterProduit() {
		assertNotNull(controlAcheterProduit);
	}

	@Test
	public void testRechercherVendeurProduit() {
		
		String[] noms = { "bonemine" };
		assertArrayEquals(controlAcheterProduit.rechercherVendeursProduit("fleurs"), noms);

	}

	@Test
	public void testAcheterProduit() {
		assertEquals(controlAcheterProduit.acheterProduit("bonemine", 5),5);
		assertEquals(controlAcheterProduit.acheterProduit("bonemine", 8),5);
		Gaulois vendeur2 = new Gaulois("obelix", 3);
		village.installerVendeur(vendeur2, "fleurs", 0);
		assertEquals(controlAcheterProduit.acheterProduit("obelix", 5),0);




	}

}
