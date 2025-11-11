package controleur;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {

	private Village village;
	private ControlVerifierIdentite controlVerifierIdentite;
	
	@BeforeEach
	public void initialiserSituation(){
		village=new Village("mon village",10,10);
		Chef chef=new Chef("abraracourcix",20,village);
		village.setChef(chef);
		controlVerifierIdentite=new ControlVerifierIdentite(village);
		
	}
	
	@Test
	void testControlVerifierIdentite() {
		
		assertNotNull(controlVerifierIdentite,"echec de creation controlVerifierIdentite");
	}
	
	@Test
	void testVerifierIdentite() {
		assertFalse(controlVerifierIdentite.verifierIdentite("bonemine"));
		Gaulois gaulois=new Gaulois("bonemine",5);
		village.ajouterHabitant(gaulois);
		assertTrue(controlVerifierIdentite.verifierIdentite("bonemine"));
		
		
	}
	
	
	
	

}
