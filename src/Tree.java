
import java.util.Iterator;

/**
 * @author juliam8
 * @author abbym1
 * @version 2019-03-02
 * @param 
 * @param 
 *
 * Tree Object
 * *description*
 */
public class Tree<N> {
    
    /**
     * Constructor for the Tree class 
     * Sets the root as a flyweight node
     */
    Tree(){
        root = new FlyweightNode();
    }
    
    /**
     * Constructor for the Tree class 
     * Sets the private member variables
     */
    Tree(char[] sequence) {
        DNAsequence = sequence;
        nodeCount = 0;
    }

    /**
     * Clears the elements of the DNA Tree
     */
    public void clear() {
        root = null;
        nodeCount = 0;
    }

    /**
     * Calls insert helper and to increment node count 
     * @param node the node to insert
     * @return the level at which the node is inserted
     */
    public int insert(DNATreeNode node) {
        root = root.insert(node, 0);
        nodeCount++;
        return 1;
    }
    
    /**
     * @param sequence
     * @return
     */
    public DNATreeNode remove(char[] sequence) {
        root.remove(sequence);
        
        // TODO Auto-generated method stub
        return null;
    }   
    
    /**
     * Prints out the sequences in the tree in pre-order
     */
    public void print() {
        // TODO Auto-generated method stub
        
    }
    
    /**
     * Searches for occurences of a sequence within the tree
     * @param sequence the sequence to find within the tree
     * @return returns true if found
     */
    public boolean search(char[] sequence) {
               
        return false;
    }

    /**
     * Returns the root of the DNA Tree
     * @return the root of the DNA Tree
     */
    public DNATreeNode root() {
        switch(indicator) {
            case 1: return (DNATreeNode)root1;
            case 2: return (DNATreeNode)root2;
            case 3: return (DNATreeNode)root3;
            default: return null;
        }
    }

    /**
     * Returns the node count of the DNA Tree
     * @return the number of nodes in the DNA Tree
     */
    public int nodeCount() {
        return nodeCount;
    }

    /**
     * The root of the DNATree
     */
    protected DNATreeNode root;
    protected FlyweightNode root1;
    protected LeafNode root2;
    protected InternalNode root3;
    protected int indicator = 1;
    
    /**
     * The number of nodes in the DNA Tree
     */
    protected int nodeCount;   
    
    /**
     * The DNA sequence in the node
     */
    protected char[] DNAsequence;
 

}
