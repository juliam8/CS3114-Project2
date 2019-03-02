
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
    Parser(File inputFile, BSTRectangle<RectKey, RectData> rectBST) {
        try {
            mBST = rectBST;
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
                mBST.search(nodeKey);
            } 
            else if (command.equals("print")) {
                mBST.print();
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
        int[] data = new int[4];
        for (int i = 0; i < 4; i++) {
            data[i] = Integer.parseInt(mScan.next());
        }
        // nodeKey and nodeData are the elements of the new node, newNode
        
        DNATreeNode<String> newNode;
        newNode = new BSTNode<RectKey, RectData>(nodeKey, nodeData);
        
        if (validData(data) && validKey(name)) {
            mBST.insert(newNode);
            System.out.println("Rectangle accepted: " + newNode);
        } 
        else {
            System.out.println("Rectangle rejected: " + newNode);
        }
    }


    /**
     * Determines whether remove by key or remove
     * by data is appropriate
     */
    private void remove() {
        if (mScan.hasNextInt()) {
            removeData();
        } 
        else {
            removeKey();
        }
    }

    /**
     * Removes a node with the given Key value
     */
    private void removeKey() {
        // removeKey is the key of the node to remove
        RectKey removeKey = new RectKey(mScan.next());
        // temp is used to check if the specified node exists
        BSTNode<RectKey, RectData> temp = mBST.remove(removeKey);
        if (temp == null) {
            System.out.println("Rectangle rejected " + removeKey);
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
    protected Tree<char[]> mBST;
}

