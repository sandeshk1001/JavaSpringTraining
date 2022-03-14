package BasicJava.day3.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericStack<E> {
    private List<E> stack =new ArrayList<E>();

    public E pop(){
        if(stack.isEmpty()){
            return null;
        }
        return stack.remove(stack.size()-1);
    }
    public void push(E element){
        stack.add(element);
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public int getSize(){
        return stack.size();
    }
    @Override
    public String toString() {
        return stack.toString();
    }
}
