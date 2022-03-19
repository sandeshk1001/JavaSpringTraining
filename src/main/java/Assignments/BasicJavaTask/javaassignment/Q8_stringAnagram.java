package Assigments.BasicJavaTask.javaassignment;

import java.util.Arrays;

public class Q8_stringAnagram {
    public static void main(String[] args) {
        System.out.println(stringAnagram("abc","cba"));
    }

static boolean stringAnagram(String str1,String str2){
    str1 = str1.toLowerCase();
    str2 = str2.toLowerCase();
    char[] charArray1 = str1.toCharArray();
    char[] charArray2 = str2.toCharArray();

    Arrays.sort(charArray1);
    Arrays.sort(charArray2);
    return Arrays.equals(charArray1, charArray2);
}
}
