package nl.tue.s2id90.group66.draughts.algorithms;

import java.util.Collection;
import nl.tue.s2id90.group66.raters.Rater;
import nl.tue.s2id90.draughts.DraughtsState;
import nl.tue.s2id90.game.GameState;
import nl.tue.s2id90.group66.algorithms.ab.Tree;
import org10x10.dam.game.Move;

/**
 * Draughts specific implementation for a search tree.
 * 
 * @author Wim Reddingius
 */
class DraughtsTree extends Tree<Move> {
    
    // The current state, used as node in the tree; we only store what is the current node
    private final GameState currentState;
    // The rater to get the heuristic of a state
    private final Rater rater;
    
    /**
     * Constructs a DraughtsTree with an initialState and a rater.
     * 
     * @param initialState root of the tree
     * @param rater rater for te search tree
     */
    DraughtsTree(DraughtsState initialState, Rater rater) {
        this.currentState = initialState;
        this.rater = rater;
    }
    
    /**
     * Returns a collection of possible moves from the current state.
     * 
     * @return a collection of possible moves from the current state
     */
    @Override
    protected Collection<Move> getEdges() {
        return currentState.getMoves();
    }
    
    /**
     * Returns the heuristic value of the current state
     * 
     * @return the heuristic value of the current state
     */
    @Override
    protected int getHeuristicValue() {
        return rater.rate(currentState);
    }
    
    /**
     * Apply a move to the current state and move to corresponding child node
     * 
     * @param move move to take
     */
    @Override
    protected void toChildNode(Move move) {
        currentState.doMove(move);
    }
    
    /**
     * Undo a move in the current state and move to the corresponding parent node.
     * 
     * @param move move to undo
     */
    @Override
    protected void toParentNode(Move move) {
        currentState.undoMove(move);
    }
    
}
