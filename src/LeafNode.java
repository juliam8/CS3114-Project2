
/**
 * @author juliam8
 * @author abbym1
 * @version 2019-03-02
 * @param 
 * @param 
 *
 * Leaf Node Object
 * *description*
 */
public class LeafNode extends DNATreeNode{
    
    /**
     * Constructor for LeafNode class
     * @param sequence the DNA sequence for this leaf node
     */
    LeafNode(char[] sequence){
        DNASequence = sequence;
    }
    
    /**
     * Returns the DNA sequence for this leaf node
     * @return the DNA sequence
     */
    public char[] dna() {
        return DNASequence;
    }
    
    
    /**
     * Member variable that holds the DNA sequence of the node
     */
    private char[] DNASequence;

}
