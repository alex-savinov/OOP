package presenter;

import java.time.LocalDateTime;

public class Log implements Logger {

    @Override
    public void writeLog(String string) {
        System.out.println(LocalDateTime.now() + " --> " + string);
    }
}
