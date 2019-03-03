import student.TestCase;

import java.io.FileNotFoundException;

/**
 * @author abbym1
 * @author juliam8
 * @version 2019-03-02
 */

public class DNAtreeTest extends TestCase {
    
    /**
     * Test method for {@link DNAtree#main(java.lang.String[])}.
     */
    public void test() throws FileNotFoundException {
        String[] in1 = {"src//P2sampleinput.txt"};
        //assertNotNull(in1);
        try {
            DNAtree.main(in1);
        } 
        catch (FileNotFoundException e) {
            // Auto-generated catch block
            e.printStackTrace();
        }
    }

}
