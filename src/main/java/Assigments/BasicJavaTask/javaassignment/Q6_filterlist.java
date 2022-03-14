package Assigments.BasicJavaTask.javaassignment;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q6_filterlist {
    public static void main(String[] args) {
        System.out.println(filterEvenList(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15)));
    }
    private static List<Integer> filterEvenList(List<Integer> list) {
        return list.stream().filter(integer -> integer % 2 == 0).collect(Collectors.toList());
    }
}
