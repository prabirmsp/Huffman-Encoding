import org.junit.Test;

import static org.junit.Assert.*;


public class GrinDecoderTest {

    @Test
    public void testDecode() throws Exception {
        //GrinEncoder.encode("huffman-example.txt", "huffman-example.grin");
        //GrinDecoder.decode("huffman-example.grin", "test1.txt");
        //GrinEncoder.encode("wikipedia-huffman-coding.txt", "wiki-example1.grin");
        //GrinDecoder.decode("wiki-example1.grin", "test3.txt");
        GrinEncoder.encode("pg2600.txt", "pg.grin");
        GrinDecoder.decode("pg.grin", "test3.txt");
    }
}