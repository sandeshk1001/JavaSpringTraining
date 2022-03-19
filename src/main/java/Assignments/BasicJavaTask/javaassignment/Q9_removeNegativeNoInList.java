package Assigments.BasicJavaTask.javaassignment;

import java.util.ArrayList;
import java.util.List;

public class Q9_removeNegativeNoInList {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(-10);
        l.add(30);
        l.add(-20);
        l.add(40);
        System.out.println(removeNeagativeNumber(l));
    }

    static List<Integer> removeNeagativeNumber(List<Integer> list){
        for(int i=0;i<list.size();i++){
            if(list.get(i)<0){
                list.remove(i);
            }
        }
        return list;
    }
}
