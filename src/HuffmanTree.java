import java.util.*;

public class HuffmanTree {

    private class Node implements Comparable<Node> {
        Integer c;
        Integer freq;
        Node left;
        Node right;


        public Node(int c, int freq) {
            this.freq = freq;
            this.c = c;
        }

        public Node(int freq, Node left, Node right) {
            this.freq = freq;
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Node o) {
            return freq - o.freq;
        }
    }

    Node root;
    private int size;

    public HuffmanTree(Map<Integer, Integer> m) {
        Set<Map.Entry<Integer, Integer>> entries = m.entrySet();
        size = m.size();
        PriorityQueue<Node> pq = new PriorityQueue<>(size);
        for (Map.Entry<Integer, Integer> e : entries)
            pq.add(new Node(e.getKey(), e.getValue()));
        pq.add(new Node(256, 1)); // add EOF character

        while (pq.size > 1) {
            Node n1 = pq.poll();
            Node n2 = pq.poll();
            pq.add(new Node(n1.freq + n2.freq, n1, n2));
            System.out.println("Changing: " + (n1.c == null ? "X" : ((char) n1.c.intValue())) + " | " +
                    (n2.c == null ? "X" : ((char) n2.c.intValue())));
        }

        root = pq.poll();
    }

    public void encode(List<Integer> characters, BitOutputStream stream) {
        Map<Integer, List<Integer>> huffCodes = new HashMap<>(size);
        getHuffmanCodes(root, huffCodes, new ArrayList<>());
        for (Integer c : characters)
            huffCodes.get(c).forEach(stream::writeBit);
    }

    public List<Integer> decode(BitInputStream stream) {
        ArrayList<Integer> list = new ArrayList<>();
        Integer c = -1;
        while (c != 256) { // until we see the EOF character
            Node cur = root;
            while (cur.c == null) {
                int nextBit = stream.readBit();
                if (nextBit == 0)
                    cur = cur.left;
                else if (nextBit == 1)
                    cur = cur.right;
                else
                    throw new IllegalArgumentException("BitInputStream returned value that is not 1 or 0.");
            }
            c = cur.c;
            if (c != 256) // do not add EOF character
                list.add(c);
        }
        return list;
    }

    void getHuffmanCodes(Node cur, Map<Integer, List<Integer>> huffCodes, ArrayList<Integer> bits) {
        if (cur.c != null)
            huffCodes.put(cur.c, bits);
        else {
            ArrayList<Integer> bitsCopy = new ArrayList<>(bits);
            bits.add(0); // for the left subtree
            getHuffmanCodes(cur.left, huffCodes, bits);
            if (cur.right != null) {
                bitsCopy.add(1); // for the right subtree
                getHuffmanCodes(cur.right, huffCodes, bitsCopy);
            }
        }
    }
}
