package nl.tue.s2id90.group66.draughts.raters.concrete;

/**
 * A symmetric king rater that counts the safe pawns. Safe means at a position
 * that is adjacent to an edge of the board.
 * 
 * @author Wim Reddingius
 */
public class SafePawnRater extends SymmetricPawnRater {
    
    /**
     * Rate a pawn as if it is mine.
     * 
     * @param position position
     * @return pawn's score
     */
    @Override
    public int rateMyPawn(int position) {
        if (isPieceAdjacentToEdge(position)) {
            return rateMySafePawn(position);
        }
        return 0;
    }

    /**
     * Rate a safe pawn as if it is mine. The default implementation returns 1,
     * which means that it simply counts the safe pawn.
     * 
     * @param position position
     * @return 1
     */
    protected int rateMySafePawn(int position) {
        return 1;
    }
    
}
