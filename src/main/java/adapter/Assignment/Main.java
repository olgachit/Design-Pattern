package adapter.Assignment;

import java.util.Calendar;

public class Main {
    public static void main(String[] args) {

        NewDateInterface date = new CalendarToNewDateAdapter();

        date.setDay(25);
        date.setMonth(3);
        date.setYear(2026);

        System.out.println("Original Date: " +
                date.getDay() + "/" +
                date.getMonth() + "/" +
                date.getYear());
        date.advanceDays(10);

        System.out.println("After advancing 10 days: " +
                date.getDay() + "/" +
                date.getMonth() + "/" +
                date.getYear());
    }
}
