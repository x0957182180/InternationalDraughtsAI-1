package nl.tue.s2id90.group66.draughts.algorithms;

import nl.tue.s2id90.draughts.DraughtsState;
import nl.tue.s2id90.group66.algorithms.ab.DryAbAlgorithm;
import nl.tue.s2id90.group66.raters.Rater;
import org10x10.dam.game.Move;

/**
 * This class is the implementation of the alpha-beta algorithm, specifically
 * for the draughts computer problem. It uses a Move as edge type of the search tree.
 * 
 * @author Wim Reddingius
 */
public class DraughtsAbAlgorithm extends DryAbAlgorithm<Move> {
    
    /**
     * Constructs an instance of the alpha-beta algorithm for a draughts search tree.
     * It creates a DraughtsTree with the initialState and rater.
     * 
     * @param initialState root state of the search tree
     * @param rater rater used to compute heuristics
     * @param depthLimit depth limit
     */
    public DraughtsAbAlgorithm(DraughtsState initialState, Rater rater, int depthLimit) {
        super(new DraughtsTree(initialState, rater), depthLimit);
    }
    
}
