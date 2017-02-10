package nl.tue.s2id90.group66.draughts.raters.concrete;

/**
 * A symmetric king rater that counts the safe kings. Safe means at a position
 * that is adjacent to an edge of the board.
 * 
 * @author Wim Reddingius
 */
public class SafeKingRater extends SymmetricKingRater {

    /**
     * Rate a king as if it is mine.
     * 
     * @param position position
     * @return king's score
     */
    @Override
    protected final int rateMyKing(int position) {
        if (isPieceAdjacentToEdge(position)) {
            return rateMySafeKing(position);
        }
        return 0;
    }
    
    /**
     * Rate a safe king as if it is mine. The default implementation returns 1,
     * which means that it simply counts the safe kings.
     * 
     * @param position position
     * @return 1
     */
    protected int rateMySafeKing(int position) {
        return 1;
    }
    
}
