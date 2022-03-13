package SpringBasic.Day12.Dependencies_Injection_Sorting;

import java.util.List;

public class Users {
    private List<Integer> userId;
    private Sorting sorting;

    public Users(List<Integer> _userId) {
        userId = _userId;
    }

    /*
            This is previous flow in that flow if we want to sort using different sotring for example
            merge sort then we have to create object of a merge sort class bubble sort ki jagah

            but in new flow we create a object of a sorting interface
            (Parent class can hold the child class object)

            this all  called depencies injection
     */

    //private BubbleSort bubbleSort;

//    public Users(List<Integer> userId, BubbleSort bubbleSort) {
//        this.userId = userId;
//        this.bubbleSort = bubbleSort;
//    }
//    public Users() {
//        this.userId = new ArrayList<>();
//        this.bubbleSort =new BubbleSort();
//    }

    public void addUser(Integer _userId){
        userId.add(_userId);
    }
    // User of this class has full control
    // over which sorting method to user.
    public void addSortingMethode(Sorting _sorting){
        sorting=_sorting;
    }
//    public void userSort(){
//        bubbleSort.sort(userId);
//    }

    public  void sort(){
        userId=sorting.sort(userId);
    }

    public List<Integer> getUserId() {
        return userId;
    }

    public void setUserId(List<Integer> userId) {
        this.userId = userId;
    }
}
