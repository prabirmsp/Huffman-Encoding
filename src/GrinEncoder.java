import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GrinEncoder {

    public static void encode(String infile, String outfile) throws IOException {
        ArrayList<Integer> characters = new ArrayList<>();
        Map<Integer, Integer> freq = createFrequencyMap(infile, characters);
        BitOutputStream output = new BitOutputStream(outfile);

        output.writeBits(1846, 32); // write magic number

        output.writeBits(freq.size(), 32); // write number of unique characters

        // write frequency map
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            output.writeBits(e.getKey(), 32);
            output.writeBits(e.getValue(), 32);
        }

        HuffmanTree huffmanTree = new HuffmanTree(freq);
        huffmanTree.print();
        huffmanTree.encode(characters, output);

        output.close();
    }

    private static Map<Integer, Integer> createFrequencyMap(String file, List<Integer> characters) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int c;
        while ((c = reader.read()) > 0) {
            characters.add(c);
            if (frequencyMap.containsKey(c))
                frequencyMap.put(c, frequencyMap.get(c) + 1);
            else
                frequencyMap.put(c, 1);
        }
        reader.close();
        return frequencyMap;
    }
}
