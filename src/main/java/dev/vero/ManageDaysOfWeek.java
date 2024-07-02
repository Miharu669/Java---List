package dev.vero;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ManageDaysOfWeek {
    private List<String> daysWeek;

    public ManageDaysOfWeek() {
        daysWeek = new ArrayList<>();
    }

    public void createDaysOfWeek() {
        daysWeek.add("Monday");
        daysWeek.add("Tuesday");
        daysWeek.add("Wednesday");
        daysWeek.add("Thursday");
        daysWeek.add("Friday");
        daysWeek.add("Saturday");
        daysWeek.add("Sunday");
    }

    public List<String> getDaysOfWeek() {
        return new ArrayList<>(daysWeek);
    }

    public int getLength() {
        return daysWeek.size();
    }

    public void removeDay(String day) {
        daysWeek.remove(day);
    }

    public String getDay(int index) {
        if (index < 0 || index >= daysWeek.size()) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        return daysWeek.get(index);
    }

    public boolean dayExists(String day) {
        return daysWeek.contains(day);
    }

    public void sortDaysAlphabetically() {
        Collections.sort(daysWeek);
    }

    public void clearDaysOfWeek() {
        daysWeek.clear();
    }
}
