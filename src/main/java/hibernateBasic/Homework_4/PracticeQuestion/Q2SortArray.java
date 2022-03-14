package hibernateBasic.Homework_4.PracticeQuestion;

public class Q2SortArray {
    public static void main(String[] args) {
        int [] arr =new int[]{10,40,60,30,50,20,60};
        int key,j;
        for (int i=1;i<arr.length;++i){
            key=arr[i];
            j=i-1;
            while (j>=0 && arr[j]>key){
                arr[j+1]=arr[j];
                j=j-1;
            }
            arr[j+1]=key;
        }
        System.out.println();
        for (int a:arr){
            System.out.print(a+" ");
        }
    }
}
