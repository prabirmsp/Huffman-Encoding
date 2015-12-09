import org.junit.Test;

import static org.junit.Assert.*;


public class GrinDecoderTest {

    @Test
    public void testDecode() throws Exception {
        //GrinEncoder.encode("huffman-example.txt", "huffman-example.grin");
        //GrinDecoder.decode("huffman-example.grin", "test1.txt");
        GrinEncoder.encode("wikipedia-huffman-coding.txt", "wiki-example.grin");
        GrinDecoder.decode("wiki-example.grin", "test2.txt");
    }
}