package nl.tue.s2id90.group66.draughts.raters.concrete;

import nl.tue.s2id90.group66.draughts.raters.PositionRater;

/**
 * Gives score 1 to each empty position and 0 to each non-empty position.
 * 
 * @author Wim Reddingius
 */
public class EmptyPositionRater extends PositionRater {
    
    /**
     * Returns the score for a given position.
     * 
     * @param position position
     * @param contentType piece type
     * @return position's score
     */
    @Override
    protected final int ratePosition(int position, int contentType) {
        if (isEmpty(contentType)) {
            return rateEmptyPosition();
        }
        return 0;
    }
    
    /**
     * Returns the score for an empty position.
     * 
     * @return 1
     */
    protected int rateEmptyPosition() {
        return 1;
    }
    
    /**
     * Returns the name of the rater.
     * 
     * @return null
     */
    @Override
    public String getName() {
        return null;
    }
    
}
