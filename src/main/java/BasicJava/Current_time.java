package BasicJava;

public class Current_time {
    public static void main(String[] args) {
        long millisecs=System.currentTimeMillis();
        // The number of milliseconds elapsed since Jan 1, 1970
        // GMT timezone
        long totalSeconds = millisecs/1000;
        long currentSecond = totalSeconds%60;
        long totalMinutes = totalSeconds/60;
        long currentMinute = totalMinutes%60;
        long totalHours = totalMinutes/60;
        // Total number of hours elapsed till now since Jan 1 , 1970
        // There are 24 hours in a day %24
        long currentHour = totalHours%24;
        System.out.println("Current time = "+(currentHour+5)%24+":"+(currentMinute+30)%60+":"+currentSecond);
        // 12:31 pm  , 7:01 am 41 seconds
        // IST = GMT + 5:30
        // 7:02:29 = 12:32:29
    }
}
