/**
 * 
 */
package DNAtree;

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
            else if (command.equals("regionsearch")) {
                regionSearch();
            } 
            else if (command.equals("search")) {
                RectKey nodeKey = new RectKey(mScan.next());
                mBST.search(nodeKey);
            } 
            else if (command.equals("intersections")) {
                intersections();
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
     * Check if the given x y w h represents a valid region
     * Call the BST regionSearch method if so
     */
    private void regionSearch() {
        // data is an array that holds the region coordinates
        int[] data = new int[4];
        for (int i = 0; i < 4; i++) {
            data[i] = Integer.parseInt(mScan.next());
        }
        // regionData holds the data for region search
        RectData regionData = new RectData(data);
        // command rejected if width/height is <= 0
        if (data[2] <= 0 || data[3] <= 0) { 
            System.out.println("Rectangle rejected " + regionData);
        }
        else {
            System.out.println("Rectangles intersecting region (" 
                                            + regionData + "):");
            mBST.regionSearch(mBST.root(), regionData);
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
     * Removes a node with the given Data value
     */
    private void removeData() {
        // valid will hold the first data value
        String invalidData = "";
        // data holds the coordinates of rectangle to remove
        int[] data = new int[4];
        
        for (int i = 0; i < 4; i++) {
            if (mScan.hasNextInt()) {
                invalidData = mScan.next();
                data[i] = Integer.parseInt(invalidData);
            }
            else {
                System.out.println("Rectangle rejected " + invalidData);
                return;
            }       
        }
        // removeData is the data of the node to remove
        RectData removeData = new RectData(data);
        mBST.remove(removeData);
         
    }
    
    /**
     * Calls the BST method to report all intersecting
     * rectangles
     */
    private void intersections() {
        System.out.println("Intersection pairs:");
        mBST.intersection();
    }

    /**
     * This holds the scanner for the input file
     */
    private Scanner mScan;
    
    /**
     * This holds the tree commands are executed upon
     * made protected for testing purposes
     */
    protected BSTRectangle<RectKey, RectData> mBST;
}

