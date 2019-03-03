

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
public class FlyweightNode extends DNATreeNode {
    
    /**
     * Constructor for FlyweightNode class
     */
    FlyweightNode(){
    }
    
    /**
     * Get the flyweight node pointer
     * @return the flyweight node
     */
    public FlyweightNode getFlyweight() {
        return emptyFly;
    }
    
    /**
     * Private member variable for Flyweight node
     */
    private static final FlyweightNode emptyFly = new FlyweightNode();




}
