import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HuffmanTree {

    private class Node implements Comparable<Node>{
        Character c;
        int freq;

        public Node (int freq, char c) {
            this.freq = freq;
            this.c = c;
        }

        public Node (int freq) {
            this.freq = freq;
            this.c = null;
        }

        @Override
        public int compareTo(Node o) {
            return freq - o.freq;
        }
    }

    private Node[] arr;
/**
    public HuffmanTree(Map<Character, Integer> m) {
        arr = new Node[m.size()];
        Set<Character> entries = m.keySet();
        Iterator<Character> iterator = entries.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            arr[i++] = new Node(iterator.next());
        }
        for (int i = 0; i < arr.length; i++) {
            entries.
        }
    }

*/



}
