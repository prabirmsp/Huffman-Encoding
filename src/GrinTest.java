import org.junit.Test;


public class GrinTest {

    @Test
    public void testEncodeDecode() throws Exception {

        GrinEncoder.encode("huffman-example.txt", "huffman-example.grin");
        GrinDecoder.decode("huffman-example.grin", "test1.txt");
        /*
         $ diff huffman-example.txt test1.txt
         > [No difference between the files!]
          */

        GrinEncoder.encode("wikipedia-huffman-coding.txt", "wiki-example.grin");
        GrinDecoder.decode("wiki-example.grin", "test2.txt");
        /*
        $ diff wikipedia-huffman-coding.txt test2.txt
         > [No difference between the files!]
         The compressed file size is exactly the same as the example provided by Professor Osera.
         */

        GrinEncoder.encode("pg2600.txt", "pg.grin");
        GrinDecoder.decode("pg.grin", "test3.txt");
        /*
        $ diff pg2600.txt test3.txt
         > [No difference between the files!]
         The compressed file size is exactly the same as the example provided by Professor Osera.
         */
    }
}