package Assigments.HibernateTask.PracticeQuestion;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q1_Stream {
    public static void main(String[] args) {
        filterEvenList(Arrays.asList(1,2,5,8,4,0,10,50,30,60));

    }
    private static List<Integer> filterEvenList(List<Integer> list) {
        return list.stream().filter(integer -> integer % 2 == 0).collect(Collectors.toList());
    }
}
