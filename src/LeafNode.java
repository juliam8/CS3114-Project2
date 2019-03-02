
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
        length = sequence.length;
        
        char[] letters = "ACGT".toCharArray();
        int[] count = new int[4];
        
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < 4; j++) {
                if (sequence[i] == letters[j]) {
                    count[j]++;
                }
            }
        }
        percentA = count[0] / length;
        percentC = count[1] / length;
        percentG = count[2] / length;
        percentT = count[3] / length;
    }
    
    /**
     * Sets the DNA sequence to a new value
     * @param sequence
     */
    public void setDNA(char[] sequence) {
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
     * Returns the percentage of A in the leaf node
     * @return the percentage of A
     */
    public double percentA() {
        return percentA;
    }
    
    /**
     * Returns the percentage of C in the leaf node
     * @return the percentage of C
     */
    public double percentC() {
        return percentC;
    }
    
    /**
     * Returns the percentage of G in the leaf node
     * @return the percentage of G
     */
    public double percentG() {
        return percentG;
    }
    
    /**
     * Returns the percentage of A in the leaf node
     * @return the percentage of A
     */
    public double percentT() {
        return percentT;
    }
    
    /**
     * Member variable that holds the DNA sequence of the node
     */
    private char[] DNASequence;
    
    private double length;
    private double percentA;
    private double percentC;
    private double percentG;
    private double percentT;

}
