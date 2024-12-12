package Exo1;

/**
 * @author Zlanca-Nto ELisée MIHAN<zlanca-nto.mihan@etudiant.univ-rennes.fr>
 * @author Ines Gaetan NOUBI-SI KUISSEU
 *         <ines-gaetan.noubi@etudiant.univ-rennes.fr>
 * @version 5.0
 * @since 2022-09-23
 * 
 */

public class Fourmis {

	/**
	 * @param s un terme de la suite des fourmis
	 * @pre s.length() > 0
	 * @return le terme suivant de la suite des fourmis
	 */
	public static String next(String s) {
		StringBuilder u = new StringBuilder();
		int count = 1;
		char charActuel = '\0';
		int tailleDeS = s.length();
		for (int i = 0; i < tailleDeS; ++i) {
			charActuel = s.charAt(i);
			if (i + 1 < tailleDeS && charActuel == s.charAt(i + 1)) {
				count++;
			} else {
				u.append(count).append(charActuel);
				count = 1;
			}
		}
		return u.toString();
	}
}