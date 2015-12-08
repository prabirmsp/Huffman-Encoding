import org.testng.annotations.Test;


public class PriorityQueueTest {

    @Test
    public void testAdd() throws Exception {
        PriorityQueue<Integer> pq = new PriorityQueue<>(10);
        pq.add(1);
        pq.add(2);
        pq.add(3);
        pq.add(4);
        pq.add(5);
        pq.add(6);
        pq.add(10);
        pq.printTree();
        int i = pq.poll();
        pq.printTree();
         i = pq.poll();
        pq.printTree();
         i = pq.poll();
        pq.printTree();
         i = pq.poll();
        pq.printTree();
         i = pq.poll();
         i = pq.poll();



    }
}