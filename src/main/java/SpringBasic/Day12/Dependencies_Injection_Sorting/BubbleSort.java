package SpringBasic.Day12.Dependencies_Injection_Sorting;

import java.util.Collections;
import java.util.List;

public class BubbleSort implements Sorting{
    public BubbleSort() {
        System.out.println("Bubble");
    }

    @Override
    public List<Integer> sort(List<Integer> integerList) {
       System.out.println("This is the Bubble Sort :");
       Collections.sort(integerList);
       return integerList;
    }
}