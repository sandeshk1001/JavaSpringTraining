package BasicJava.day3;

public class Myexception extends Exception {

    String msg;
    Myexception(String _msg){
        msg =_msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
