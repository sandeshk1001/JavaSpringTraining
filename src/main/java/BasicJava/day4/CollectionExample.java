package BasicJava.day4;

import java.util.*;

public class CollectionExample {
    public static void main(String[] args) {
//        List<Integer> integerList = new ArrayList<>();
//        for(int i=0;i<1000;i++){
//            integerList.add(i);
//        }
//
//        for(int i=0;i<integerList.size();i++){
//            System.out.print(integerList.get(i));
//        }
//        System.out.println();
//
//        for(int i:integerList){
//            System.out.print(i);
//        }
//

//        LinkedList<Integer> linkedList = new LinkedList<>();
//        for(int i=0;i<1000;i++){
//            linkedList.add(i);
//        }
//
//        for(int i=0;i<linkedList.size();i++){
//            System.out.print(linkedList.get(i));
//        }
//        System.out.println();
//
//        for(int i:linkedList){
//            System.out.print(i);
//        }
//        System.out.println();
//
//        List<String> list = new ArrayList<>();
//        list.add("the");
//        list.add(" is");
//        list.add(" a");
//        list.add(" sentence");
//        System.out.println(Collections.frequency(list,"the"));

//        PriorityQueue<String> strings = new PriorityQueue<>((s,s2)->s2.compareTo(s));
//        strings.add("a");
//        strings.add("b");
//        strings.add("c");
//        strings.add("d");
//
//        while (strings.size()>0)
//            System.out.println(strings.remove());
//        System.out.println(strings.size());

        /*----------------------------------------
                    max Find
        ------------------------------------------*/
//        List<Integer> integerList = new ArrayList<>();
//        integerList.add(10);
//        integerList.add(40);
//        integerList.add(20);
//        integerList.add(30);
//        integerList.add(60);
//        System.out.println("First Max"+findMax(integerList));
//        System.out.println("Second max:"+findsecondMax(integerList));
//        System.out.println("Third K max"+findkMax(integerList,3));

//        Set<Integer> set = new HashSet<>();
//        System.out.println(set.add(10));
//        System.out.println(set.add(10));

        /*-------------------------------------
                set remove dublicate
         ------------------------------------*/
        List<Integer> integerList = new ArrayList<>();
        integerList.add(10);
        integerList.add(40);
        integerList.add(20);
        integerList.add(30);
        integerList.add(60);
        integerList.add(60);
        integerList.add(20);
        integerList.add(30);
        System.out.println(remmovedublicate(integerList));
        String str="this is a sample text is a";
        System.out.println(charnumber(str));
    }
    public static int findMax(List<Integer> l){
        Collections.sort(l);
        System.out.println(l);
        return l.get(l.size()-1);
    }
    public static int findsecondMax(List<Integer> l){
        Collections.sort(l);
        //int a=l.size()-2;
        return l.get(l.size()-2);
    }
    public static List<Integer> findkMax(List<Integer> l,int num){
        Collections.sort(l);
        List<Integer> k =new ArrayList<>();
        for (int i=l.size()-1;i>=(l.size()-num);i--){
            k.add(l.get(i));
        }
        return k;
    }
    public static List<Integer> remmovedublicate(List<Integer> l){
        Set<Integer> set = new HashSet<>();
        set.addAll(l);
        return new ArrayList<>(set);
    }

    public static Map<String,Integer> charnumber(String s){
        Map<String, Integer> map = new HashMap<>();
        String[] s1 = s.split(" ");
        for (int i = 0; i < s1.length; i++) {
            if (map.containsKey(s1[i])) map.put(s1[i], map.get(s1[i]) + 1);
            else map.put(s1[i], 1);
        }
        return map;
    }
}
