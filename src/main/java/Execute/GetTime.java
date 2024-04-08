package Execute;

import java.time.LocalDateTime;

public class GetTime {
    String time = "";
    public GetTime(){
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        int hour = now.getHour();
        int minute = now.getMinute();
        time = "[" + year + '/' + month + '/' + day + "][" + hour + ':' + minute + ']';
    }

    public String getTime() {
        return time;
    }
}
