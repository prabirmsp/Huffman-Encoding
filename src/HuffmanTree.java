import java.util.Map;
import java.util.Set;

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

    private Node root;

    public HuffmanTree(Map<Integer, Integer> m) {
        Set<Map.Entry<Integer, Integer>> entries = m.entrySet();

        PriorityQueue<Node> pq = new PriorityQueue<>(m.size());
        for (Map.Entry<Integer, Integer> e : entries)
            pq.add(new Node(e.getKey(), e.getValue()));

        while (pq.size > 1) {
            Node n1 = pq.poll();
            Node n2 = pq.poll();
            pq.add(new Node(n1.freq + n2.freq, n1, n2));
            System.out.println("Changing: " + (n1.c == null? "X":((char) n1.c.intValue())) + " | " +
                    (n2.c == null ? "X" : ((char) n2.c.intValue())));
        }

        root = pq.poll();
    }


}
