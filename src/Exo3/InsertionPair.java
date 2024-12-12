package Exo3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * @author Zlanca-Nto ELisée MIHAN<zlanca-nto.mihan@etudiant.univ-rennes.fr>
 * @author Ines Gaetan NOUBI-SI KUISSEU
 *         <ines-gaetan.noubi@etudiant.univ-rennes.fr>
 * @version 5.0
 * @since 2022-09-23
 * 
 *        Partie II
 *
 *        Lecture, au clavier, d'une suite de doublets d'entiers terminée par -1
 *
 *        Cette suite peut comporter des doublets identiques.
 * 
 *        Construction et affichage d'un tableau contenant les doublets
 *        distincts triés selon l'ordre croissant des doublets, à savoir : (x1,
 *        y1) < (x2, y2) <==> (x1<x2) ou (x1==x2 et y1<y2)
 * 
 *        En entrée : 3 8 1 4 3 8 1 3 -1 ==> En sortie : [1 3] [1 4] [3 8]
 */

public class InsertionPair {

	private static final int SIZE_MAX = 10;
	private static final int END_MARKER = -1;
	/**
	 * nombre de doublets présents dans t, 0 <= size <= SIZE_MAX
	 */
	private int size;
	private Pair[] array;

	public InsertionPair() {
		size = 0;
		array = new Pair[SIZE_MAX];
	}

	/**
	 * @return copie de la partie remplie du tableau
	 */
	public Pair[] toArray() {
		return Arrays.copyOf(array, size);
	}

	/**
	 * array est rempli, par ordre croissant, en utilisant la fonction insert, avec
	 * les valeurs lues par scanner.
	 * 
	 * @param scanner
	 */
	public void createArray(Scanner scanner) {
		while (scanner.hasNextInt()) {
			int valueX = scanner.nextInt();
			if (valueX == END_MARKER) {
				break;
			}
			int valueY = scanner.nextInt();
			if (valueY == END_MARKER) {
				break;
			}
			/**
			 * On insère la pair dans le tableau uniquement
			 * quand ses deux valeurs sont différentes de -1
			 * 
			 * Si x != -1 && y == -1, on ne tient pas compte dans notre
			 * tableau de la valeur x saisie par l'utilisateur à afficher
			 */
			insert(new Pair(valueX, valueY));
		}
	}

	/**
	 * Si pair n'appartient pas à array[0..size-1] et size < SIZE_MAX, size est
	 * incrémenté de 1, pair est inséré dans array et les entiers array[0..size]
	 * sont triés par ordre croissant. Sinon array est inchangé.
	 * 
	 * @param pair doublet à insérer
	 * 
	 * @pre les doublets de array[0..size-1] sont triés par ordre croissant
	 * 
	 * @return false si pair appartient à array[0..size-1] ou si array est
	 *         complètement rempli; true si pair n’appartient pas à array[0..size-1]
	 */
	public boolean insert(Pair pair) {
		if (size >= SIZE_MAX ||
				Arrays.binarySearch(array, 0, size, pair) >= 0) {
			return false;
		}
		int i = size - 1;
		while (i >= 0 && array[i].compareTo(pair) == 1) {
			array[i + 1] = array[i];
			i--;
		}
		array[i + 1] = pair;
		size++;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder insertionPairInString = new StringBuilder();
		for (int i = 0; i < size; i++) {
			insertionPairInString.append(array[i].toString()).append(" ");
		}
		return insertionPairInString.toString().trim();
	}
}