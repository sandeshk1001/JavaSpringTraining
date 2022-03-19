package Assigments.HibernateTask.PracticeQuestion.Q4_Queue;

public class QueueDriver {
    public static void main(String[] args) {
        GenericQueue<Integer> queue = new GenericQueue<>();
        for (int i=0;i<10;i++)
            queue.enqueue(i);

        System.out.println(queue);
        System.out.println(queue.dequeue());
        System.out.println(queue);
        System.out.println(queue.dequeue());
        System.out.println(queue);

    }
}
