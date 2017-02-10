package nl.tue.s2id90.group66.draughts.raters.concrete;

/**
 * Gives score based on the number of empty places on the promotion line.
 * 
 * @author Wim Reddingius
 */
public class PromotionLineRater extends EmptyPositionRater {

    // Rater's name
    private static final String RATER_NAME = "PromotionLine";
    
    /**
     * Rate an empty position. A empty position on the promotion line gives score 1,
     * and 0 otherwise.
     * 
     * @param position position
     * @return score for an empty position
     */
    protected int rateEmptyPosition(int position) {
        if (isAtMyPromotionLine(position)) {
            return 1;
        }
        return 0;
    }
    
    /**
     * Returns the rater's name.
     * 
     * @return the rater's name
     */
    public String getName() {
        return RATER_NAME;
    }
    
}
