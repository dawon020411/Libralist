package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Represents a log of alarm system events.
 * We use the Singleton Design Pattern to ensure that there is only
 * one EventLog in the system and that the system has global access
 * to the single instance of the EventLog.
 */
public class EventLog implements Iterable<Event> {
    /** the only EventLog in the system (Singleton Design Pattern) */
    private static EventLog theLog;
    private Collection<Event> events;

    /**
     * Prevent external construction.
     * (Singleton Design Pattern).
     */
    private EventLog() {
        events = new ArrayList<Event>();
    }

    /**
     * Gets instance of EventLog - creates it
     * if it doesn't already exist.
     * (Singleton Design Pattern)
     * @return  instance of EventLog
     */
    //EFFECTS: Returns the single instance of EventLog. If the instance does not exist, creates it.
    public static EventLog getInstance() {
        if (theLog == null) {
            theLog = new EventLog();
        }
        return theLog;
    }

    /**
     * Adds an event to the event log.
     * @param e the event to be added
     */
    //EFFECTS: Adds the given event to the event log.
    public void logEvent(Event e) {
        events.add(e);
    }

    /**
     * Clears the event log and logs the event.
     */
    //EFFECTS: Clears the event log and adds a new event indicating the log was cleared.
    public void clear() {
        events.clear();
        logEvent(new Event("Event log cleared."));
    }

    //EFFECTS: Returns an iterator over the elements in the event log.
    @Override
    public Iterator<Event> iterator() {
        return events.iterator();
    }
}
