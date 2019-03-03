
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author juliam8
 * @author abbym1
 * @version 2019-02-14
 *
 * This object parses a file and interprets the contents according to
 * CS3114 Project 1 requirements
 */
public class Parser {
    /**
     * Parameterized constructor for the Parser class Sets the private member
     * variables mBST and mScan
     * 
     * @param inputFile     Path to the input file containing the commands
     * @param rectBST       Binary Search tree associated with the parser object
     *                      and input file upon which the commands will be run
     */
    Parser(File inputFile, Tree<char[]> dnaTree) {
        try {
            mTree = dnaTree;
            mScan = new Scanner(inputFile);
        } 
        catch (FileNotFoundException e) {
            //Auto-generated catch block
            e.printStackTrace();
        }
    }
    

    /**
     * Parses each command from the input file using a Scanner 
     * calls the appropriate helper function(s) to execute each command
     */
    public void execute() {

        while (mScan.hasNext()) {
            // command holds the command string in the file
            //      which dictates the next action to take
            String command = mScan.next();

            if (command.equals("insert")) {
                insert();
            } 
            else if (command.equals("remove")) {
                remove();
            } 
            else if (command.equals("search")) {
                RectKey nodeKey = new RectKey(mScan.next());
                mTree.search(nodeKey);
            } 
            else if (command.equals("print")) {
                mTree.print();
            }
        }
        mScan.close();
    }
    
    /**
     * Method to execute the BST insert command 
     * Accepts or rejects the input rectangle based on 0,0 1024,1024 bounds
     */
    private void insert() {
        // name is the key of the inserted rectangle
        String dna = mScan.next();
        // data is an array that holds the rectangle coordinates
        char[] sequence = dna.toCharArray();
        
        DNATreeNode<String> newNode;
        newNode = new BSTNode<RectKey, RectData>(nodeKey, nodeData);
        
        if (validData(data) && validKey(name)) {
            mTree.insert(newNode);
            System.out.println("Rectangle accepted: " + newNode);
        } 
        else {
            System.out.println("Rectangle rejected: " + newNode);
        }
    }


    /**
     * Remove the DNA sequence that is read in from the tree
     */
    private void remove() {
        // name is the key of the inserted rectangle
        String dna = mScan.next();
        // data is an array that holds the rectangle coordinates
        char[] sequence = dna.toCharArray();
        
        BSTNode<RectKey, RectData> temp = mTree.remove(sequence);
        if (temp == null) {
            System.out.print("sequence " + sequence.toString() );
            System.out.print(" does not exist");
        }
        else {
            System.out.print("sequence " + sequence.toString() );
            System.out.print(" removed");
        }
    }

    /**
     * This holds the scanner for the input file
     */
    private Scanner mScan;
    
    /**
     * This holds the tree commands are executed upon
     * made protected for testing purposes
     */
    protected Tree<char[]> mTree;
}

