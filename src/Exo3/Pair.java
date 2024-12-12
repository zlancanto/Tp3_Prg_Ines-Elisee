package Exo3;

/**
 * 
 * @author Zlanca-Nto ELisée MIHAN<zlanca-nto.mihan@etudiant.univ-rennes.fr>
 * @author Ines Gaetan NOUBI-SI KUISSEU
 *         <ines-gaetan.noubi@etudiant.univ-rennes.fr>
 * @version 5.0
 * @since 2022-09-23
 * 
 *        Classe représentant des doublets *non modifiables*
 */

public class Pair implements Comparable<Pair> {

    private final int x;
    private final int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pair d) {
        if (x < d.getX() || x == d.getX() && y < d.getY()) {
            /** this < d */
            return -1;
        } else if (x == d.getX() && y == d.getY()) {
            /** this == d */
            return 0;
        } else {
            /** this > d */
            return 1;
        }
    }

    public Pair copyOf() {
        return new Pair(this.x, this.y);
    }

    @Override
    public String toString() {
        return "[" + x + " " + y + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Pair)) {
            return false;
        }
        // DERNIER CAS TRATE AVEC SUCCES !
        Pair other = (Pair) obj;
        return this.x == other.getX() && this.y == other.getY();
    }

    public final int getX() {
        return x;
    }

    public final int getY() {
        return y;
    }
}