

/**
 * @author juliam8
 * @author abbym1
 * @version 2019-03-02
 * @param 
 * @param 
 *
 * Flyweight Node Object
 * *description*
 */
public class FlyweightNode implements DNATreeNode {
    
    /**
     * Constructor for FlyweightNode class
     */
    FlyweightNode(){
    }
    
    /**
     * Replaces empty node with a leaf node
     * @param sequence
     * @return the new node 
     */
    public LeafNode insert(char[] sequence) {
        return new LeafNode(sequence);
    }
    
    /**
     * Get the flyweight node pointer
     * @return the flyweight node
     */
    public FlyweightNode getFlyweight() {
        return emptyFly;
    }
    
    /** 
     * Return false because it is not a leaf
     * @return boolean 
     */
    public boolean isLeaf() {
        return false;
    }
    
    /**
     * Returns true because this is a flyweight node
     * @return boolean
     */
    public boolean isFlyweight() {
        return true;
    }
    
    /**
     * Private member variable for Flyweight node
     */
    private static final FlyweightNode emptyFly = new FlyweightNode();




}
