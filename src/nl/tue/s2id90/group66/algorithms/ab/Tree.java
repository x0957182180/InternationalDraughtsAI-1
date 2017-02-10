package nl.tue.s2id90.group66.algorithms.ab;

import java.util.Collection;

/**
 * This class is used as a generic tree, but without the need for storing the full tree.
 * This is done by the ability to move through the tree and only have the information of the current node
 * and how to go to the parent and child nodes. It can be extended for problem-specific implementations.
 * The Tree is used by the DryAbAlgorithm
 * as a search tree.
 * 
 * @author Wim Reddingius
 * @param <EdgeType> The the class that is used as an edge of the tree
 */
public abstract class Tree<EdgeType> {
    
    /**
     * Returns the edges to child nodes
     * 
     * @return a collection of EdgeType objects
     */
    protected abstract Collection<EdgeType> getEdges();
    
    /**
     * Determines if the current node is terminal.
     * 
     * @return true if the current node is a leaf, false otherwise
     */
    boolean isAtTerminalNode() {
        return getEdges().isEmpty();
    }

    /**
     * Returns the heuristic of the current node.
     * 
     * @return the heuristic value of the current node
     */
    protected abstract int getHeuristicValue();
    
    /**
     * Set the current node to the child node of the current node via an edge
     * 
     * @param edge the edge to take
     */
    protected abstract void toChildNode(EdgeType edge);

    /**
     * Set the current node to the parent node of the current node via an edge
     * 
     * @param edge the edge to the parent
     */
    protected abstract void toParentNode(EdgeType edge);

}
