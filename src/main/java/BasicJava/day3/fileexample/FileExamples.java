package BasicJava.day3.fileexample;

import com.company.day3.Student;

import java.io.IOException;
import java.util.Arrays;

public class FileExamples {
    public static void main(String[] args) throws IOException {
//        File file2 = new File("test2.txt");
//        PrintWriter printWriter = new PrintWriter(file2);
//        printWriter.println("This is for demo");
        //printWriter.print("This is the second line");

//        try (Scanner scanner = new Scanner(file2)) {
//            while (scanner.hasNext()) {
//                String expression = scanner.nextLine();
//                String[] s = expression.split(" ");
//                int a = Integer.parseInt(s[0]);
//                int b = Integer.parseInt(s[2]);
//                if (s[1].equals("+")) {
//                    System.out.println(a + b);
//                } else {
//                    System.out.println(a - b);
//                }
//            }
//        }

//        URL url = new URL("http://www.google.com/");
//        Scanner input = new Scanner(url.openStream());
//        while (input.hasNext()) {
//            System.out.println(input.nextLine());
//        }

//        int[] numbers = {1,2,3,4,5};
//        String[] strings = {"string-1","string-2","string-3"};
//        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("array.dat"));){
//            objectOutputStream.writeObject(numbers);
//            objectOutputStream.writeObject(strings);
//        }

//        try(ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream("array.dat"));){
//            int[] numbers2=(int[])objectInputStream.readObject();
//            String[] strings2 = (String[])objectInputStream.readObject();
//            for(int number:numbers2)
//                System.out.println(number);
//            for(String str:strings2)
//                System.out.println(str);
//
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }


        //System.out.println("etrative: "+printfabonici(20));
        //System.out.println("Recursive :"+printfabonici_recursive(20));

//        System.out.println("E : "+sumdigit(1234567890));
//        System.out.println("R :"+sumdigit_recursive(1234567891));
        Student[] students = {new Student("tim", 100), new Student("aim", 200), new Student("durk", 150),
                new Student("ceaser", 1)};
        Arrays.sort(students);
        for (Student student : students)
            System.out.println(student.getName() + ", " + student.getRollNumber());
    }
}


//    static int printfabonici(int n){
//        int a=0,b=1,c;
//        for(int i=1;i<n;i++){
//            c=a+b;
//            a=b;
//            b=c;
//        }
//        return b;
//    }
//
//    static int printfabonici_recursive(int n){
//        if(n<=1){
//            return n;
//        }
//        return printfabonici_recursive(n-1)+printfabonici_recursive(n-2);
//    }
//
//    static long sumdigit(long num){
//        long sum=0;
//        while (num!=0){
//            sum += num % 10;
//
//            num=num/10;
//        }
//        return sum;
//        //Arrays.sort();
//    }
//
//    static long sumdigit_recursive(long n){
//        if (n ==0)
//            return 0;
//        return ((n%10))+sumdigit_recursive(n/10);
//    }
