package SpringBasic.Day12.Dependencies_Injection_Sorting;

import java.util.List;

public class InsertionSort implements Sorting {
    @Override
    public List<Integer> sort(List<Integer> integerList) {
        System.out.println("This is Insertion Sort");
        return null;
    }
}
