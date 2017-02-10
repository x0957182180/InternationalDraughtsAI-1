package nl.tue.s2id90.group66.draughts.raters.concrete;

import nl.tue.s2id90.group66.draughts.raters.KingRater;

/**
 * A king rater that is symmetric, which means that we rate my pieces in the same
 * way as the opponent's pieces, but negative. The default implementation simply
 * counts the number of my kings and subtracts the number of the opponent's kings.
 * 
 * @author Wim Reddingius
 */
public class SymmetricKingRater extends KingRater {
    
    // Rater's name
    private static final String RATER_NAME = "Kings";
    
    /**
     * Returns the score for a king.
     * 
     * @param position position
     * @param isMine whether the king is mine
     * @return king's score
     */
    @Override
    protected final int rateKing(int position, boolean isMine) {
        int score = rateMyKing(position);
        if (isMine) {
            return score;
        } else {
            return -score;
        }
    }
    
    /**
     * Rate a king as if it is mine. The default implementation returns 1,
     * which means that it simply counts the kings.
     * 
     * @param position position
     * @return 1
     */
    protected int rateMyKing(int position) {
        return 1;
    }
    
    /**
     * Returns the rater's name.
     * 
     * @return the rater's name
     */
    @Override
    public String getName() {
        return RATER_NAME;
    }
    
}
