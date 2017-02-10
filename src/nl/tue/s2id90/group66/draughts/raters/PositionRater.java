package nl.tue.s2id90.group66.draughts.raters;

import nl.tue.s2id90.draughts.DraughtsState;

/**
 * A rater that only rates each position individually and add the scores together.
 *
 * @author Wim Reddingius
 */
public abstract class PositionRater extends DraughtsRater {
    
    /**
     * Rates a draughts state.
     * 
     * @param state state
     * @return score
     */
    @Override
    public final int rate(DraughtsState state) {
        int score = 0;
        final int[] pieces = state.getPieces();
        for (int index = INDEX_START; index <= INDEX_END; index++) {
            score += ratePosition(index, pieces[index]);
        }
        return score;
    }
    
    /**
     * Returns the score for a given position.
     * 
     * @param index position
     * @param contentType piece type
     * @return position's score
     */
    protected abstract int ratePosition(int index, int contentType);
    
}
