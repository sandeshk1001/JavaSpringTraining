package BasicJava.day4;
public class CustomThread extends Thread{
    private int num;
    public CustomThread(int _num){
        num=_num;
    }
    public void run(){
        for(int i=1;i<=100;i++)
            System.out.println(num);
    }
}
