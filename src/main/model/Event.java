package model;

import java.util.Calendar;
import java.util.Date;



// EFFECTS: Represents an alarm system event.
public class Event {
    private static final int HASH_CONSTANT = 13;
    private Date dateLogged;
    private String description;

    /**
     * Creates an event with the given description
     * and the current date/time stamp.
     * @param description  a description of the event
     */
    // EFFECTS: Constructs an Event object with the provided description
    // and sets the dateLogged to the current date/time
    public Event(String description) {
        dateLogged = Calendar.getInstance().getTime();
        this.description = description;
    }

    /**
     * Gets the date of this event (includes time).
     * @return  the date of the event
     */
    //EFFECTS: Returns the date and time when this event occurred.
    public Date getDate() {
        return dateLogged;
    }

    /**
     * Gets the description of this event.
     * @return  the description of the event
     */
    //EFFECTS: Returns the description of this event.
    public String getDescription() {
        return description;
    }

    //EFFECTS: Returns true if and only if the given object is an Event object
    // and has the same dateLogged and description as this event.
    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }

        if (other.getClass() != this.getClass()) {
            return false;
        }

        Event otherEvent = (Event) other;

        return (this.dateLogged.equals(otherEvent.dateLogged)
                && this.description.equals(otherEvent.description));
    }

    //EFFECTS: Returns a hash code value for this event based on its dateLogged and description.
    @Override
    public int hashCode() {
        return (HASH_CONSTANT * dateLogged.hashCode() + description.hashCode());
    }

    //EFFECTS: Returns a string representation of this event, including its dateLogged and description.
    @Override
    public String toString() {
        return dateLogged.toString() + "\n" + description;
    }
}
