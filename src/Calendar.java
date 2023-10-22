import java.text.SimpleDateFormat;
import java.util.Date;

public class Calendar implements Runnable {
    private Date today;
    private Thread calendarThread;
    private static Calendar calendar;

    public Calendar() {
        this.today = new Date();
        calendar = this;
        this.calendarThread = new Thread(this);
        this.calendarThread.setDaemon(true);
        this.start();
    }

    public static String getToday() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(calendar.today);
    }

    private void start() {
        calendarThread.start();
    }

    private void advanceDate() {
        today = new Date(today.getTime() + 24 * 60 * 60 * 1000);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            advanceDate();
        }
    }
}