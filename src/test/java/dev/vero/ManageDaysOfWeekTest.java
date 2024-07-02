package dev.vero;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ManageDaysOfWeekTest {
    private ManageDaysOfWeek manager;

    @BeforeEach
    public void setUp() {
        manager = new ManageDaysOfWeek();
        manager.createDaysOfWeek();
    }

    @Test
    public void testCreateDaysOfWeek() {
        assertEquals(7, manager.getLength(), "The list should contain 7 days.");
    }

    @Test
    public void testGetDaysOfWeek() {
        List<String> days = manager.getDaysOfWeek();
        assertEquals(7, days.size(), "The list should contain 7 days.");
        assertEquals("Monday", days.get(0), "The first day should be Monday.");
        assertEquals("Sunday", days.get(6), "The last day should be Sunday.");
    }

    @Test
    public void testGetLength() {
        assertEquals(7, manager.getLength(), "The list should contain 7 days.");
    }

    @Test
    public void testRemoveDay() {
        manager.removeDay("Monday");
        assertEquals(6, manager.getLength(), "The list should contain 6 days after removing Monday.");
        assertFalse(manager.dayExists("Monday"), "Monday should not exist in the list after removal.");
    }

    @Test
    public void testGetDay() {
        assertEquals("Monday", manager.getDay(0), "The first day should be Monday.");
        assertEquals("Sunday", manager.getDay(6), "The last day should be Sunday.");

        assertThrows(IndexOutOfBoundsException.class, () -> manager.getDay(-1),
                "Should throw IndexOutOfBoundsException for invalid index -1.");
        assertThrows(IndexOutOfBoundsException.class, () -> manager.getDay(7),
                "Should throw IndexOutOfBoundsException for invalid index 7.");
    }

    @Test
    public void testDayExists() {
        assertTrue(manager.dayExists("Monday"), "Monday should exist in the list.");
        assertFalse(manager.dayExists("Funday"), "Funday should not exist in the list.");
    }

    @Test
    public void testSortDaysAlphabetically() {
        manager.sortDaysAlphabetically();
        List<String> sortedDays = manager.getDaysOfWeek();
        assertEquals("Friday", sortedDays.get(0), "The first day after sorting should be Friday.");
        assertEquals("Monday", sortedDays.get(1), "The second day after sorting should be Monday.");
        assertEquals("Saturday", sortedDays.get(2), "The third day after sorting should be Saturday.");
        assertEquals("Sunday", sortedDays.get(3), "The fourth day after sorting should be Sunday.");
        assertEquals("Thursday", sortedDays.get(4), "The fifth day after sorting should be Thursday.");
        assertEquals("Tuesday", sortedDays.get(5), "The sixth day after sorting should be Tuesday.");
        assertEquals("Wednesday", sortedDays.get(6), "The last day after sorting should be Wednesday.");
    }

    @Test
    public void testClearDaysOfWeek() {
        manager.clearDaysOfWeek();
        assertEquals(0, manager.getLength(), "The list should be empty after clearing.");
    }
}
