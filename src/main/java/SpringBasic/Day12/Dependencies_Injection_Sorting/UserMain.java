package SpringBasic.Day12.Dependencies_Injection_Sorting;

import java.util.Arrays;

/*
This class depends upon a concrete sorting object
And the user can provide the sorting method as per choice
(i) User of this class can provide what sorting algorithm to use.
(ii) Minimal changes to previous approach
sorting attribute object is provided by the user.
USers class dependends upon the concrete implmentation
of sorting interface.
This is called dependency Injection
You inject or provide a dependency from outside
 */
public class UserMain {
    public static void main(String[] args) {
        //Users users1 =new Users(Arrays.asList(1,5,3,9,5,4,3,9,1),new BubbleSort());
        //users1.userSort();
        Users users =new Users(Arrays.asList(1,5,3,9,5,4,3,9,1));
        users.addSortingMethode(new BubbleSort());
        users.sort();
        System.out.println(users.getUserId());
    }
}