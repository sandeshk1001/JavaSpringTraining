package Assigments.BasicJavaTask.javaassignment;

import java.util.Arrays;
import java.util.List;

public class Q5_TopElement {
    public static void main(String[] args) {
        System.out.println(topelement(Arrays.asList(10,30,20,40)));
    }
    static int topelement(List<Integer> list){
        int max=list.get(0);
        for(int i=1;i<list.size();i++){
            if(max < list.get(i)){
                max= list.get(i);
            }
        }
       return max;
    }
}
