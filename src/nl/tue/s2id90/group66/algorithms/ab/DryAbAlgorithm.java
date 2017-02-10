package nl.tue.s2id90.group66.algorithms.ab;

import nl.tue.s2id90.group66.algorithms.AlgorithmStoppedException;

/**
 * DryAbAlgorithm is a generic alpha-beta algorithm implementation that can be used
 * for various problems. DRY stands for Don't Repeat Yourself. This class can be extended
 * for problem-specific implementations.
 * 
 * @author Wim Reddingius
 * @param <EdgeType> The the class that is used as an edge of the tree
 */
public abstract class DryAbAlgorithm<EdgeType> implements AbAlgorithm<EdgeType> {
    
    // Depth limit
    private final int depthLimit;
    // The search tree
    private final Tree<EdgeType> tree;
    
    // The best solution that is found so far or null if no solution was found so far
    private EdgeType bestSolution = null;
    // Whether the algorithm is stopped by the user of this class
    private boolean stopped = false;
    
    /**
     * Constructs an instance of an alpha-beta algorithm with a given search tree
     * and depth limit. The pointer of tree must not be at a leaf and the depth
     * limit must be greater than 0.
     * 
     * @param tree search tree
     * @param depthLimit depth limit
     */
    public DryAbAlgorithm(Tree<EdgeType> tree, int depthLimit) {
        assert depthLimit > 0;
        assert !tree.isAtTerminalNode();
        
        this.depthLimit = depthLimit;
        this.tree = tree;
    }
    
    /**
     * Runs the algorithm.
     * 
     * @throws AlgorithmStoppedException if the algorithm is stopped before termination
     */
    @Override
    public final void run() throws AlgorithmStoppedException {
        // throw an exception if the algorithm is already stopped
        checkStop();
        // The alpha of the alpha-beta algorithm
        int bestValue = Integer.MIN_VALUE;
        // Loop over the edges from the current node
        for (EdgeType edge : tree.getEdges()) {
            assert edge != null;
            // Move to the child node via edge
            tree.toChildNode(edge);
            try {
                // call alphaBeta() and recurse
                int value = alphaBeta(depthLimit, bestValue, Integer.MAX_VALUE, false);
                if (value > bestValue) {
                    // best solution found so far
                    bestValue = value;
                    bestSolution = edge;
                }
            // no catch here: throw the exception to the caller but always execute this finally 
            } finally {
                // Move to back to the root
                tree.toParentNode(edge);
            }
        }
    }
    
    /**
     * Stops the algorithm.
     */
    @Override
    public final void stop() {
        synchronized (this) {
            stopped = true;
        }
    }
    
    /**
     * Gives the best solution found.
     * 
     * @return the best solution or null if no solution was found yet.
     */
    @Override
    public final EdgeType getBestSolution() {
        return bestSolution;
    }
    
    /**
     * The recursive part of the alpha-beta algorithm. We have one method for both
     * the maximizing and the minimizing step, and a boolean defines whether this
     * is a maximizing or a minimizing step.
     * 
     * @param depth depth limit, the maximum number of steps to a leaf from here
     * @param alpha alpha
     * @param beta beta
     * @param max whether this is a maximizing step
     * @return the value of the current state of the tree
     * @throws AlgorithmStoppedException 
     */
    private int alphaBeta(int depth, int alpha, int beta, boolean max) throws AlgorithmStoppedException {
        // throw an exception if the algorithm is stopped
        checkStop();
        if (depth == 1 || tree.isAtTerminalNode()) {
            // Stop recursing, because the depth limit is reached or we are in a leaf node
            return tree.getHeuristicValue();
        }
        
        // Loop over the edges from the current node
        for (EdgeType edge : tree.getEdges()) {
            // Move to the child node via edge
            tree.toChildNode(edge);
            try {
                // call alphaBeta() and recurse
                if (max) {
                    alpha = Math.max(alpha, alphaBeta(depth - 1, alpha, beta, false));
                } else {
                    beta = Math.min(beta, alphaBeta(depth - 1, alpha, beta, true));
                }
                if (beta <= alpha) {
                    // Prune
                    break;
                }
            // no catch here: throw the exception to the caller but always execute this finally 
            } finally {
                // Move to back to the root
                tree.toParentNode(edge);
            }
        }
        
        if (max) {
            return alpha;
        } else {
            return beta;
        }
    }
    
    /**
     * Throws an AlgorithmStoppedException when the algorithm is stopped.
     * 
     * @throws AlgorithmStoppedException if the algorithm is stopped
     */
    private void checkStop() throws AlgorithmStoppedException {
        synchronized (this) {
            if (stopped) {
                throw new AlgorithmStoppedException();
            }
        }
    }

}
