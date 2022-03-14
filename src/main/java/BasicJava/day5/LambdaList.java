package BasicJava.day5;

import java.util.Arrays;
import java.util.List;

public class LambdaList {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);

    }

}
interface OperationList{
    public Boolean operate(List<Integer> lint ,int a);
}
class filter implements OperationList{

    @Override
    public Boolean operate(List<Integer> list, int a) {
        for(int i=0;i< list.size();i++){
            if(list.get(i)%a==0){

            }
        }
        return true;
    }
}