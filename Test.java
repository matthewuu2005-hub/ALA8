import java.util.ArrayList;

public class Test {
    final static int SIZE = 1_000_000;//reability
    public static void main(String[] args){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            int randomNum = (int)(Math.random() * SIZE);
            al.add(randomNum);
        }

        //testing offer
        int total = 0;
        for(int i = 0; i < al.size(); i++){
            pq.offer(al.get(i));
            total += PriorityQueue.offerIteration;
            if(i % SIZE/20 == 0){
                System.out.printf("%-10d\t%-10d\n", al.get(i), PriorityQueue.offerIteration);
            }
        }
        System.out.printf("%-10s\t%-10d\n", "Average", total/SIZE);

        //dispaly the properties of heap
        System.out.println("The height of the heap: " + pq.height());
        System.out.println("The heap is balanced? " + pq.isBalanced());

        
        //testing poll
        total = 0;
        for(int i = 0; i < SIZE; i++){
            int number = pq.poll();
            total += PriorityQueue.pollIteration;
            if(i % SIZE/20 == 0){
                System.out.printf("%-10d\t%-10d\n", number, PriorityQueue.pollIteration);
            }
        }
        System.out.printf("%-10s\t%-10d\n", "Average", total/SIZE);
    }

    public static void testPriorityQueue(ArrayList<Integer> al, PriorityQueue<Integer> pq){
        for (Integer num : al) {
            pq.offer(num);
        }
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}
