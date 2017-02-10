package nl.tue.s2id90.group66.draughts.raters.concrete;

import nl.tue.s2id90.group66.draughts.raters.DraughtsRater;
import java.util.ArrayList;
import java.util.List;
import nl.tue.s2id90.draughts.DraughtsState;
import nl.tue.win.util.Pair;

/**
 * A rater that combines multiple rates.
 *
 * @author Wim Reddingius
 */
public class CompoundRater extends DraughtsRater {
    
    // the list of pairs of raters and weights
    private final List<Pair<DraughtsRater, Integer>> raters = new ArrayList<>();
    
    /**
     * Add a rater to the list of raters.
     * 
     * @param rater rater
     * @param weight weight of the rater
     */
    public void addRater(DraughtsRater rater, int weight) {
        if (weight != 0) {
            raters.add(new Pair(rater, weight));
        }
    }
    
    /**
     * Calls setWhiteMine() to all rater in the list.
     * 
     * @param isWhiteMine whether I am playing with white
     */
    @Override
    public void setWhiteMine(final boolean isWhiteMine) {
        for (Pair<DraughtsRater, Integer> pair : raters) {
            DraughtsRater rater = pair.first;
            rater.setWhiteMine(isWhiteMine);
        }
    }
    
    /**
     * Rates a draughts state by adding the scores of the raters in the list
     * and multiply each score with the weight of the rater.
     * 
     * @param state state
     * @return score
     */
    @Override
    public int rate(DraughtsState state) {
        int score = 0;
        for (Pair<DraughtsRater, Integer> pair : raters) {
            DraughtsRater rater = pair.first;
            int weight = pair.second;
            score += rater.rate(state) * weight;
        }
        return score;
    }
    
    /**
     * Returns the name of the rater, based on the weights and the rater's names.
     * 
     * @return the name of the rater
     */
    @Override
    public String getName() {
        String name = "";
        for (Pair<DraughtsRater, Integer> pair : raters) {
            DraughtsRater rater = pair.first;
            int weight = pair.second;
            name += "(" + weight + ")" + rater.getName() + " ";
        }
        return name;
    }
    
}
