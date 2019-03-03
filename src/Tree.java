
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
public class Tree<DNATreeNode> {
    
    Tree(){
        root1 = new FlyweightNode();
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
     */
    public void insert(DNATreeNode node) {
        root.insert(node);
        nodeCount++;
    }

    /**
     * Returns the root of the BST
     * @return the root of the BST
     */
    public DNATreeNode root() {
        return root;
    }

    /**
     * Returns the node count of the BST
     * @return the number of nodes in the BST
     */
    public int nodeCount() {
        return nodeCount;
    }

    /**
     * The root of the BST
     */
    protected FlyweightNode root1;
    protected LeafNode root2;
    protected InternalNode root3;
    protected int indicator = 1;
    
    /**
     * The number of nodes in the BST
     */
    protected int nodeCount;   
    
    /**
     * The DNA sequence in the node
     */
    protected char[] DNAsequence;   
    

}
