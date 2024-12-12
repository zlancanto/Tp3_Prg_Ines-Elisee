package Exo2;

import java.util.Scanner;
import java.util.Arrays;

/**
 * @author Zlanca-Nto ELisée MIHAN<zlanca-nto.mihan@etudiant.univ-rennes.fr>
 * @author Ines Gaetan NOUBI-SI KUISSEU
 *         <ines-gaetan.noubi@etudiant.univ-rennes.fr>
 * @version 5.0
 * @since 2022-09-23
 * 
 *        Partie I
 * 
 *        Lecture, au clavier, d'une suite d'entiers terminée par -1
 * 
 *        Cette suite peut comporter des valeurs doubles.
 * 
 *        Construction et affichage d'un tableau contenant les entiers distincts
 *        triés par valeur croissante.
 * 
 *        Exemple. En entrée : 3 8 1 4 3 2 1 3 -1 ==> En sortie : 1 2 3 4 8
 */

public class InsertionInteger {

    private static final int SIZE_MAX = 10;
    private static final int END_MARKER = -1;
    /**
     * nombre d’entiers présents dans t, 0 <= size <= SIZE_MAX
     */
    private int size;
    private int[] array;

    public InsertionInteger() {
        size = 0;
        array = new int[SIZE_MAX];
    }

    /**
     * @return copie de la partie remplie du tableau
     */
    public int[] toArray() {
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
            int value = scanner.nextInt();
            if (value == END_MARKER) {
                break;
            }
            insert(value);
        }
    }

    /**
     * Si value n'appartient pas à array[0..size-1] et size < SIZE_MAX, size est
     * incrémenté de 1, value est inséré dans array et les entiers array[0..size]
     * sont triés par ordre croissant. Sinon array est inchangé.
     * 
     * Exemple :
     * 
     * pour x = 5, size = 3, array[0] = 1, array[1] = 6, array[2] = 8
     * 
     * insertion délivre true, size = 4,
     * 
     * array[0] = 1, array[1] = 5, array[2] = 6, array[3] = 8
     * 
     * @param value valeur à insérer
     * 
     * @pre les valeurs de array[0..size-1] sont triées par ordre croissant
     * 
     * @return false si value appartient à array[0..size-1] ou si array est
     *         complètement rempli; true si value n’appartient pas à
     *         array[0..size-1]
     */
    public boolean insert(int value) {
        if ((size >= SIZE_MAX) ||
                Arrays.binarySearch(array, 0, size, value) >= 0) {
            return false;
        }
        int i = size - 1;
        while (i >= 0 && array[i] > value) {
            array[i + 1] = array[i];
            i--;
        }
        array[i + 1] = value;
        size++;
        return true;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray()).replaceAll("[\\[\\],]", "");
    }
}