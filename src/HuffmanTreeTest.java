import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class HuffmanTreeTest {

    @Test
    public void testAdd() throws Exception {
        HashMap<Integer, Integer> m = new HashMap<>();
        m.put((int) 'a', 3);
        m.put((int) ' ', 2);
        m.put((int) 'b', 2);
        m.put((int) 'z', 1);
        HuffmanTree h = new HuffmanTree(m);
        h.print();
    }

}