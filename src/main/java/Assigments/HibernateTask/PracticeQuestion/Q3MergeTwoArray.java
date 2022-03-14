package Assigments.HibernateTask.PracticeQuestion;

import java.util.Arrays;

public class Q3MergeTwoArray {

    public static void main(String[] args) {
        int [] arr =new int[]{10,40,60,30,50,20,60};
        int [] arr2 =new int[]{20,40,10,50,30,100};
        int [] mergeArray=new int[arr.length+ arr2.length];
        Arrays.sort(arr);
        Arrays.sort(arr2);
        System.arraycopy(arr,0,mergeArray,0,arr.length);
        System.arraycopy(arr2,0,mergeArray,arr.length,arr2.length);
        Arrays.sort(mergeArray);
        System.out.println("Merge and Sorted Array :");
        for (int i:mergeArray)
            System.out.print(i+" ");
    }
}