import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by pradhanp on 12/8/15.
 */
public class GrinDecoderTest {

    @Test
    public void testDecode() throws Exception {
        GrinDecoder.decode("huffman-example.grin", "out.txt");
    }
}