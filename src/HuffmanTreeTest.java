import org.testng.annotations.Test;

import java.util.HashMap;


public class HuffmanTreeTest {


    @Test
    public void testAdd() throws Exception {
        HashMap<Integer, Integer> m = new HashMap<>();
        m.put((int) 'a', 3);
        m.put((int) '_', 2);
        m.put((int) 'b', 2);
        m.put((int) 'z', 1);
        m.put(256, 1); // eof character
        HuffmanTree h = new HuffmanTree(m);
        System.out.println();
    }

}