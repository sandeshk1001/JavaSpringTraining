package SpringBasic.Day12.Dependencies_Injection_Sorting;

import java.util.List;

public class MergeSort implements Sorting{
    public MergeSort() {
        System.out.println("Merge");
    }

    @Override
    public List<Integer> sort(List<Integer> integerList) {
        System.out.println("This is Merge sort");
        return null;
    }
}
