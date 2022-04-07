package _11_stack_queue.exercise.deploy_queue_by_circular_linked_list;

public class CircularQueueTest {
    public static void main(String[] args) {
        Queue q = new Queue();
        q.front = q.rear = null;
        Solution.enQueue(q, 10);
        Solution.enQueue(q, 12);
        Solution.enQueue(q, 15);
        Solution.deQueue(q);

        Solution.displayQueue(q);
        System.out.println();

        Solution.enQueue(q, 19);
        Solution.enQueue(q, 20);

        Solution.displayQueue(q);
    }
}
