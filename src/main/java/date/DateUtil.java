package date;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static final String PREIOD_WEEK = "week";
    public static final String PERIOD_MONTH = "month";

    /**
     * 获取上一个周期的第一天
     */
    public static Date getFirstDayOfPreviousPeriod(Date originTime, String period) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(originTime);
        if (PREIOD_WEEK.equalsIgnoreCase(period)) {
            cal.add(Calendar.WEEK_OF_YEAR, -1);
            cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
        } else if (PERIOD_MONTH.equalsIgnoreCase(period)) {
            cal.add(Calendar.MONTH, -1);
            cal.set(Calendar.DAY_OF_MONTH, 0);
        } else {
            return null;
        }
        return cal.getTime();
    }

    /**
     * 获取上一个周期的最后一天
     */
    public static Date getLastDayOfPreviousPeriod(Date originTime, String period) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(originTime);
        if (PREIOD_WEEK.equalsIgnoreCase(period)) {
            cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
            cal.add(Calendar.DAY_OF_MONTH, -1);
        } else if (PERIOD_MONTH.equalsIgnoreCase(period)) {
            cal.add(Calendar.MONTH, -1);
            cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        } else {
            return null;
        }
        return cal.getTime();
    }
}
