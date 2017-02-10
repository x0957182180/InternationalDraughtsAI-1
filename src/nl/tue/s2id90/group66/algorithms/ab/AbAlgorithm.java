package nl.tue.s2id90.group66.algorithms.ab;

import nl.tue.s2id90.group66.algorithms.Algorithm;

/**
 * An interface to the alpha-beta algorithm. 
 * 
 * @author Wim Reddingius
 * @param <EdgeType> The the class that is used as an edge of the tree
 */
public interface AbAlgorithm<EdgeType> extends Algorithm {
    
    /**
     * Returns the best solution that is found so far. A solution is defined
     * by an edge from the root of the tree.
     * 
     * @return the best solution found so far
     */
    public EdgeType getBestSolution();
    
}
