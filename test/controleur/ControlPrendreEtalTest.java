package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlPrendreEtalTest {

	private Village village;
	private ControlVerifierIdentite controlVerifierIdentite;
	private ControlPrendreEtal controlPrendreEtal;
	private Chef chef;
	
	@BeforeEach
	public void initialiserSituation(){
		village=new Village("mon village",10,10);
		chef=new Chef("abraracourcix",20,village);
		village.setChef(chef);
		controlVerifierIdentite=new ControlVerifierIdentite(village);
		controlPrendreEtal=new ControlPrendreEtal(controlVerifierIdentite,village);
		
	}
	
	@Test
	void testControlPrendreEtal() {
		assertNotNull(controlPrendreEtal);
	}
	
	@Test
	void testResteEtals() {
		assertTrue(controlPrendreEtal.resteEtals());
		for (int i = 0; i < 10; i++) {
			Gaulois gauloi=new Gaulois("bonemine"+i,10);
			village.installerVendeur(gauloi, "fleurs", 3);
		}
		assertFalse(controlPrendreEtal.resteEtals());
	}
	
	@Test
	void testPrendreEtal() {
		int numeroEtal=controlPrendreEtal.prendreEtal("vercingetorix", "fleurs", 10);
		assertEquals(numeroEtal,0);
		for (int i = 0; i < 10; i++) {
			numeroEtal=controlPrendreEtal.prendreEtal("vercingetorix", "epee", 4);
		}
		assertEquals(numeroEtal,-1);
		
	}
	
	@Test
	void testVerifierIdentite() {
		assertFalse(controlPrendreEtal.verifierIdentite("vercingetorix"));
		Gaulois gauloi=new Gaulois("vercingetorix",10);
		village.ajouterHabitant(gauloi);
		assertTrue(controlPrendreEtal.verifierIdentite("vercingetorix"));
		
	}
	

}
