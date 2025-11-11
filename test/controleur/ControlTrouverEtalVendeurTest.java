package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlTrouverEtalVendeurTest {

	private Village village;
	private Chef chef;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	
	
	@BeforeEach
	public void initialiserSituation() {
		village=new Village("mon village",10,10);
		chef=new Chef("abraracourcix",20,village);
		village.setChef(chef);
		controlTrouverEtalVendeur=new ControlTrouverEtalVendeur(village);
		
	}
	
	@Test
	void testControlTrouverEtalVendeur() {
		assertNotNull(controlTrouverEtalVendeur);
	}
	
	@Test
	void testTrouverEtalVenduer() {
		
		assertNull(controlTrouverEtalVendeur.trouverEtalVendeur("bonemine"));
		Gaulois gaulois=new Gaulois("bonemine",5);
		village.ajouterHabitant(gaulois);
		assertNull(controlTrouverEtalVendeur.trouverEtalVendeur("bonemine"));
		village.installerVendeur(gaulois, "fleurs", 10);
		assertEquals(controlTrouverEtalVendeur.trouverEtalVendeur("bonemine"),village.rechercherEtal(gaulois));
		
		
	}

}
