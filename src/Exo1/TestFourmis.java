package Exo1;

import org.junit.Test;

//import fr.istic.prg1.tp3.Fourmis;

import static org.junit.Assert.assertTrue;

/**
 * @author Zlanca-Nto ELisée MIHAN<zlanca-nto.mihan@etudiant.univ-rennes.fr>
 * @author Ines Gaetan NOUBI-SI KUISSEU
 *         <ines-gaetan.noubi@etudiant.univ-rennes.fr>
 * @version 2.0
 * @since 2015-06-15
 * 
 *        Classe contenant les tests unitaires pour la classe Fourmis.
 */

public class TestFourmis {

	@Test
	public void testNextTerm1() {
		String s0 = "1";
		String result = Fourmis.next(s0);
		String trueResult = "11";
		assertTrue(result.equals(trueResult));
	}

	@Test
	public void testNextTerm2() {
		String u8 = "31131211131221";
		String u9 = "13211311123113112211";
		String trueU9 = Fourmis.next(u8);
		assertTrue(u9.equals(trueU9));
	}

}
