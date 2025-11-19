package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Druide;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherVillageTest {

	private Village village;
	private Chef abraracourcix;
	private ControlAfficherVillage controlAfficherVillage;

	@BeforeEach
	public void initialiserSituation() {
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlAfficherVillage = new ControlAfficherVillage(village);
	}

	@Test
	public void testControlAfficherVillage() {
		assertNotNull(controlAfficherVillage);
	}

	@Test
	public void testDonnerNomVillageois() {
		Druide druide = new Druide("panoramix", 3, 2, 10);
		Gaulois gaulois = new Gaulois("asterix", 5);
		village.ajouterHabitant(druide);
		village.ajouterHabitant(gaulois);
		String[] noms = { "Abraracourcix", "le druide panoramix", "asterix" };
		assertArrayEquals(controlAfficherVillage.donnerNomsVillageois(), noms);

	}

	@Test
	public void testDonnerNomVillage() {
		assertEquals(controlAfficherVillage.donnerNomVillage(), "le village des irréductibles");
	}

	@Test
	public void testDonnerNbEtals() {
		assertEquals(controlAfficherVillage.donnerNbEtals(), 5);
	}

}
