package hibernateBasic.Homework_4.PracticeQuestion.Q4_Queue;

import java.util.ArrayList;
import java.util.List;

public class GenericQueue<E> {

    private List<E> queue= new ArrayList<E>();

    public E dequeue(){
        if (queue.isEmpty())
            return null;
        return queue.remove(0);
    }

    public void enqueue(E element){
        queue.add(element);
    }

    public E headElement(){
        return queue.get(0);
    }

    public E tailElement(){
        return queue.get(queue.size()-1);
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
