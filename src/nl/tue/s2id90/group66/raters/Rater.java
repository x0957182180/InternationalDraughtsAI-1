package nl.tue.s2id90.group66.raters;

/**
 * A generic rater.
 * 
 * @author Wim Reddingius
 */
public abstract class Rater<T> {
    
    /**
     * Rates a given state.
     * 
     * @param state state
     * @return score
     */
    public abstract int rate(T state);
    
}
