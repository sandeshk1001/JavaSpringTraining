package Assigments.BasicJavaTask.javaassignment;

import java.util.Arrays;
import java.util.List;

public class Q2 {
    public static void main(String[] args) {
        System.out.println(checksum(Arrays.asList( 1, 10, 17, 20 , 50),31));

    }
    public static boolean checksum(List<Integer> l,Integer sum){
        for(int i=0;i<l.size()-1;i++){
            for (int j=1;j< l.size();j++){
                if((l.get(i)) + (l.get(j)) == sum){
                    return true;
                }
            }
        }
        return false;
    }
}
