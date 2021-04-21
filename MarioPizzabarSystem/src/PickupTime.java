import java.util.Date;

public class PickupTime {

    private final int hour;
    private final int minute;

    PickupTime(String timeString){
        String[] temp = timeString.split(":",2);
        this.hour = Integer.parseInt(temp[0]);
        this.minute = Integer.parseInt(temp[1]);
    }

    public int getHour(){
        return hour;
    }

    public int getMinute(){
        return minute;
    }

    public int timeToMinutes(){
        return hour * 60 + minute;
    }

    @Override
    public String toString(){
        return hour + ":" + minute;
    }
}
