package nl.tue.s2id90.group66.draughts.raters.concrete;

/**
 * A compound rater that uses 6 raters that seems to work nice.
 * 
 * @author Wim Reddingius
 */
public class OverallRater extends CompoundRater {

    // The rater's name
    private final String raterName;
    
    /**
     * 1: Number of pawns
     * 2: Number of kings
     * 3: Number of safe pawns
     * 4: Number of safe kings
     * 5: Aggregated distance of the pawns to promotion line
     * 6: Number of unoccupied fields on promotion line
     */
    
    /**
     * Creates an overall rater with the 6 default raters.
     * 
     * @param w1 weight for the rater that counts number of pawns
     * @param w2 weight for the rater that counts number of kings
     * @param w3 weight for the rater that counts number of safe pawns
     * @param w4 weight for the rater that counts number of safe kings
     * @param w5 weight for the distance rater
     * @param w6 weight for the promotion line rater
     */
    public OverallRater(int w1, int w2, int w3, int w4, int w5, int w6) {
        addRater(new SymmetricPawnRater(), w1);
        addRater(new SymmetricKingRater(), w2);
        addRater(new SafePawnRater(), w3);
        addRater(new SafeKingRater(), w4);
        addRater(new DistanceRater(), w5);
        addRater(new PromotionLineRater(), w6);
        raterName = w1 + " " + w2 + " " + w3 + " " + w4 + " " + w5 + " " + w6;
    }
    
    /**
     * Returns the rater's name.
     * 
     * @return 
     */
    @Override
    public String getName() {
        return raterName;
    }
    
}
