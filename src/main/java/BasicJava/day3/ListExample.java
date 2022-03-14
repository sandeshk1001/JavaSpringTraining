package BasicJava.day3;

import java.util.ArrayList;
import java.util.List;

public class ListExample {
    public static void main(String[] args) throws Myexception {
        List <Integer> a=new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        try{
            System.out.println(printlist(a,4));
        }catch (Myexception ex){
            System.out.println(ex.getMsg());
        }

    }
    public static Integer printlist(List <Integer> a,int index) throws Myexception{
        if(a.size() < index || index <0)
            throw new Myexception("index value should be lie in size of list");
        else
            return a.get(index);
        //System.out.println(a);
//        for(l:a){
//
//        }
    }

}
