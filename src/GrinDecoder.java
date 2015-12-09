import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GrinDecoder {

    public static void decode(String infile, String outfile) throws IOException {
        BitInputStream input = new BitInputStream(infile);
        int magicNumber = input.readBits(32);
        if (magicNumber != 1846)
            throw new IllegalArgumentException("File not supported: " + infile);

        int numChars = input.readBits(32);
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int i = 0; i < numChars; i++)
            frequencyMap.put(input.readBits(32), input.readBits(32));

        HuffmanTree huffmanTree = new HuffmanTree(frequencyMap);
        List<Integer> characters = huffmanTree.decode(input);
        input.close();

        BitOutputStream output = new BitOutputStream(outfile);
        for (Integer c : characters)
            output.writeBits(c, 8); // write the lower 8 bits (as chars)

    }
}
