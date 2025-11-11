package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

class ControlLibererEtalTest {

	private Village village;
	private Chef abraracourcix;
	private ControlLibererEtal controlLibererEtal ;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	

	@BeforeEach
	public void initialiserSituation() {
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		
		
	}
	
	@Test
	void testControlLibererEtal() {
		assertNotNull(controlLibererEtal);
	}
	
	@Test
	void testIsVendeur() {
		assertNull(controlLibererEtal.isVendeur("bonemine"));
		Gaulois gaulois=new Gaulois("bonemine",5);
		village.ajouterHabitant(gaulois);
		assertNull(controlLibererEtal.isVendeur("bonemine"));
		village.installerVendeur(gaulois, "fleurs", 10);
		assertEquals(controlLibererEtal.isVendeur("bonemine"),village.rechercherEtal(gaulois));
	}
	
	@Test
	void testLibererEtal() {
		Gaulois gaulois=new Gaulois("bonemine",5);
		village.ajouterHabitant(gaulois);
		village.installerVendeur(gaulois, "fleurs", 10);
		Etal etal=controlLibererEtal.isVendeur("bonemine");
		String[] etatEtal=etal.etatEtal();
		String[] donneEtal=controlLibererEtal.libererEtal("bonemine");
		assertFalse(etal.isEtalOccupe());
		assertArrayEquals(donneEtal,etatEtal);
		
		
	}
	
	
	
	
	
	
}
