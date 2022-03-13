package SpringBasic.Day12;

import SpringBasic.Day12.Dependencies_Injection_Sorting.BubbleSort;
import SpringBasic.Day12.Dependencies_Injection_Sorting.InsertionSort;
import SpringBasic.Day12.Dependencies_Injection_Sorting.Sorting;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;

public class SpringBasic {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MyConfiguration.class, args);
        InsertionSort insertionSort=context.getBean(InsertionSort.class);
        insertionSort.sort(new ArrayList<>());
        Sorting bubbleSort = context.getBean(BubbleSort.class);
        bubbleSort.sort(new ArrayList<>());
        System.out.println("Starter spring project");
    }
}
